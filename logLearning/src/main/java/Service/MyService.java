package Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);


    public void performAction(){
        logger.info("Performing an action");
        logger.debug("After completed successfully");
    }
}
