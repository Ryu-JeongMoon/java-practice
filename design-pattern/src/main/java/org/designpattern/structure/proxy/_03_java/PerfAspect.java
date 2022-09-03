package org.designpattern.structure.proxy._03_java;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfAspect {

    @Around("bean(gameService)")
    public Object timestamp(ProceedingJoinPoint point) throws Throwable {
        long before = System.nanoTime();
        Object result = point.proceed();
        System.out.println(System.nanoTime() - before);
        return result;
    }
}
