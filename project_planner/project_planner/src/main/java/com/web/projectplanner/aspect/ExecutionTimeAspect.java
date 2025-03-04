package com.web.projectplanner.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {


	@Around("execution(* com.web.projectplanner.a01_controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();

        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();


        //log.info("{}.{} execution time : {} ms", className, methodName, (end - start));
        return proceed;
    }
}
