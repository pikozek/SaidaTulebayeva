import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatabaseLogginAspect {
    private final Logger logger = LoggerFactory.getLogger(DatabaseLogginAspect.class);

    @Before("execution(* org.example.repository.UserRepository.findById(..))")
    public void logDatabaseSelect() {
        logger.info("Executing database select operation...");
    }

}