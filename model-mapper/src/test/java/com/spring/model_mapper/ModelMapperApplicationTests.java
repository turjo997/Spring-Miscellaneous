package com.spring.model_mapper;

import com.spring.model_mapper.dto.GameDTO;
import com.spring.model_mapper.model.Game;
import com.spring.model_mapper.model.GameMode;
import com.spring.model_mapper.model.GameSettings;
import com.spring.model_mapper.model.Player;
import org.junit.jupiter.api.Test;
import org.modelmapper.*;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ModelMapperApplicationTests {

	@Autowired
	private ModelMapper modelMapper;

	@Test
	void contextLoads() {

		Game game = new Game(1L , "Game 1");
		System.out.println("Game: " + game);

		GameDTO gameDTO = modelMapper.map(game , GameDTO.class);
		System.out.println("GameDTO: " + gameDTO);

		assertEquals(game.getId(), gameDTO.getId());
		assertEquals(game.getName(), gameDTO.getName());

	}

	@Test
	public void whenMapGameWithBasicPropertyMapping_thenConvertsToDTO() {
		TypeMap<Game , GameDTO> propertyMapper = modelMapper.createTypeMap(Game.class , GameDTO.class);
		propertyMapper.addMapping(Game::getTimeStamp , GameDTO::setCreationTime);

		Game game = new Game(1L, "Game 1");
		game.setTimeStamp(Instant.now().getEpochSecond());
		System.out.println("Game: " + game);

		GameDTO gameDTO = modelMapper.map(game , GameDTO.class);
		System.out.println("GameDTO: " + gameDTO);
		assertEquals(game.getId(), gameDTO.getId());
		assertEquals(game.getName(), gameDTO.getName());
		assertEquals(game.getTimeStamp() , gameDTO.getCreationTime());
	}

	@Test
	public void whenMapGameWithDeepMapping_thenConvertsToDTO() {
		TypeMap<Game , GameDTO> propertyMapper = modelMapper.createTypeMap(Game.class , GameDTO.class);
		propertyMapper.addMappings(mapper->mapper
				.map(src->src.getCreator().getName() , GameDTO::setCreator));

		Game game = new Game(1L, "Game 1");
		game.setCreator(new Player(1L, "John"));
		System.out.println("Game: " + game);

		GameDTO gameDTO = modelMapper.map(game, GameDTO.class);
		System.out.println("GameDTO: " + gameDTO);

		// then
		assertEquals(game.getCreator().getName(), gameDTO.getCreator());
	}

	@Test
	public void whenMapGameWithSkipIdProperty_thenConvertsToDTO() {
		TypeMap<Game, GameDTO> propertyMapper = modelMapper.createTypeMap(Game.class, GameDTO.class);

		propertyMapper.addMappings(
				mapper->mapper.skip(GameDTO::setId)
		);

		// when id is skipped
		Game game = new Game(1L, "Game 1");
		System.out.println("Game: " + game);

		GameDTO gameDTO = modelMapper.map(game, GameDTO.class);
		System.out.println("GameDTO: " + gameDTO);


		// then destination id is null
		assertNull(gameDTO.getId());
		assertEquals(game.getName(), gameDTO.getName());
	}

	@Test
	public void whenMapGameWithCustomConverter_thenConvertsToDTO() {

		TypeMap<Game , GameDTO> propertyMapper = modelMapper.createTypeMap(Game.class , GameDTO.class);
		Converter<Collection, Integer> collectionSize = c -> c.getSource().size();
		propertyMapper.addMappings(
		mapper->mapper.using(collectionSize).map(Game::getPlayers , GameDTO::setTotalPlayers)
		);

		Game game = new Game();
		game.addPlayer(new Player(1L ,"John"));
		game.addPlayer(new Player(2L ,"Bob"));

		System.out.println("Game: " + game);


		GameDTO gameDTO = modelMapper.map(game , GameDTO.class);

		System.out.println("GameDTO: " + gameDTO);


		assertEquals(2 , gameDTO.getTotalPlayers());
	}

	@Test
	public void whenUsingLooseMappingStrategy_thenConvertsToDomainAndDTO() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		// when dto has flat fields for GameSetting

		GameDTO gameDTO = new GameDTO();
		gameDTO.setMode(GameMode.Turbo);
		gameDTO.setMaxPlayers(8);

		System.out.println("GameDTO: " + gameDTO);

		Game game = modelMapper.map(gameDTO , Game.class);

		System.out.println("Game: " + game);
		// then it converts to inner objects without property mapper

		assertEquals(gameDTO.getMode() , game.getGameSettings().getGameMode());
		assertEquals(gameDTO.getMaxPlayers() , game.getGameSettings().getMaxPlayers());


		game = new Game();
		game.setGameSettings(new GameSettings(GameMode.Normal , 6));
		System.out.println("Game: " + game);

		gameDTO = modelMapper.map(game , GameDTO.class);
		System.out.println("GameDTO: " + gameDTO);

		// then it flattens the fields on dto
		assertEquals(game.getGameSettings().getGameMode(), gameDTO.getMode());
		assertEquals(game.getGameSettings().getMaxPlayers(), gameDTO.getMaxPlayers());
	}




	@Test
	public void whenUsingCustomConditional_thenConvertsDTOSkipsZeroTimestamp() {
		// setup
		TypeMap<Game, GameDTO> propertyMapper = modelMapper.createTypeMap(Game.class, GameDTO.class);
		Condition<Long, Long> hasTimestamp = ctx -> ctx.getSource() != null && ctx.getSource() > 0;
		propertyMapper.addMappings(
				mapper -> mapper.when(hasTimestamp).map(Game::getTimeStamp, GameDTO::setCreationTime)
		);

		// when game has zero timestamp
		Game game = new Game(1L, "Game 1");
		game.setTimeStamp(0L);
		GameDTO gameDTO = modelMapper.map(game, GameDTO.class);

		// then timestamp field is not mapped
		assertEquals(game.getId(), gameDTO.getId());
		assertEquals(game.getName(), gameDTO.getName());
		assertNotEquals(0L ,gameDTO.getCreationTime());

		// when game has timestamp greater than zero
		game.setTimeStamp(Instant.now().getEpochSecond());
		gameDTO = modelMapper.map(game, GameDTO.class);

		// then timestamp field is mapped
		assertEquals(game.getId(), gameDTO.getId());
		assertEquals(game.getName(), gameDTO.getName());
		assertEquals(game.getTimeStamp() ,gameDTO.getCreationTime());
	}
}
