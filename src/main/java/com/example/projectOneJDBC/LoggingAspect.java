package com.example.projectOneJDBC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.projectOneJDBC.AppService.*(..))")
    public void beforeDatabaseOperation(JoinPoint joinPoint) {
        logger.info("Before " + joinPoint.getSignature().getName() + " method execution...");
    }
    @After("execution(* com.example.projectOneJDBC.AppService.*(..))")
    public void afterDatabaseOperation(JoinPoint joinPoint) {
        logger.info("After " + joinPoint.getSignature().getName() + " method execution...");
    }

    @AfterReturning(pointcut = ("execution(* com.example.projectOneJDBC.AppService.*(..))"), returning = "result")
    public void afterReturningDatabaseOperation(JoinPoint joinPoint, Object result) {
        logger.info("After " + joinPoint.getSignature().getName() + " method execution. Returned: " + result);
    }

    @AfterThrowing(pointcut = ("execution(* com.example.projectOneJDBC.AppService.*(..))"), throwing = "exception")
    public void afterThrowingDatabaseOperation(JoinPoint joinPoint, Exception exception) {
        logger.error("After " + joinPoint.getSignature().getName() + " method execution. Exception: " + exception.getMessage());
    }

    @Around(("execution(* com.example.projectOneJDBC.AppService.*(..))"))
    public Object aroundDatabaseOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before " + joinPoint.getSignature().getName() + " method execution...");
        Object result = joinPoint.proceed();
        logger.info("After " + joinPoint.getSignature().getName() + " method execution. Returned: " + result);
        return result;
    }
}
