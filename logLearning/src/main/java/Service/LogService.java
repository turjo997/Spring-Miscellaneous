package Service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService {

    private static final Logger log = LoggerFactory.getLogger(LogService.class);

    public void performLogAction(){
        log.info("Performing log action-------");

        try{
            int x = 133/0;
            System.out.println(x);
            log.debug("Action completed successfully.");
        }catch (Exception e){
            log.error("Error while performing the action", e);
        }
    }

}
