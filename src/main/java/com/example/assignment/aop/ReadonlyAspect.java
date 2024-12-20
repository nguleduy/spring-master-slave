package com.example.assignment.aop;

import com.example.assignment.util.DatabaseType;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transaction Readonly Aspect.
 */
@Aspect
@Component
@Order(0)
public class ReadonlyAspect {

    /**
     * Proceed Aspect.
     *
     * @param proceedingJoinPoint
     * @param transactional
     * @return Object
     * @throws Throwable
     */
    @Around("@annotation(transactional)")
    public Object proceed(
            ProceedingJoinPoint proceedingJoinPoint,
            Transactional transactional) throws Throwable {
        try {
            if (transactional.readOnly()) {
                DatabaseContext.set(DatabaseType.READONLY);
            }
            return proceedingJoinPoint.proceed();
        } finally {
            DatabaseContext.reset();
        }
    }
}
