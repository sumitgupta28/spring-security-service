package com.security.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    // Define a pointcut for methods within a specific package or with a custom annotation
    @Pointcut("execution(* com.security.spring.controller.*.*(..))") // Adjust package as needed
    public void controllerMethods() {
    }

    // Advice executed before a method call
    @Before("controllerMethods()")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Entering method: {}.{} with arguments: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
    }

    // Advice executed after a method returns successfully
    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        log.info("Exiting method: {}.{} with result: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result);
    }

    // Alternatively, use @Around for more control (e.g., logging execution time)
    @Around("controllerMethods()")
    public Object logMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        log.info("Around - Entering method: {}.{} with arguments: {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());
        stopWatch.start();
        Object result = joinPoint.proceed(); // Execute the actual method
        stopWatch.stop();

        log.info("Around - Exiting method: {}.{} with result: {} (execution time: {}ms)",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                result,
                stopWatch.getTotalTimeMillis());
        return result;
    }
}
