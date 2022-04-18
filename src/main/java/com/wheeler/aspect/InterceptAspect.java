package com.wheeler.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class InterceptAspect {

    @Around("@annotation(com.wheeler.annotation.Intercept)")
    public Object aroundIntercept(final ProceedingJoinPoint pjp) throws Throwable {

        log.info("aroundIntercept before {}", pjp.getSignature());
        final Object result = pjp.proceed();

        log.info("aroundIntercept after {}", pjp.getSignature());
        return result;
    }
}
