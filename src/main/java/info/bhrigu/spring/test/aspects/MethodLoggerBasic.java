package info.bhrigu.spring.test.aspects;

import info.bhrigu.spring.test.MainApp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

/**
 * The simply
 */
@Aspect
public class MethodLoggerBasic {

    @Pointcut("execution(* *.work(..))")
    void around_work() { };

    /**
     * Simple time profiling method
     * @param joinPoint
     * @throws Throwable // Method can throw out an anything
     */
    @Around("around_work()")
    public void logMethodName(ProceedingJoinPoint joinPoint) throws Throwable {

        long starttime = System.currentTimeMillis();

        joinPoint.proceed();

        long endtime = System.currentTimeMillis();

        long time = endtime - starttime;

        MainApp.time += time;

    } //END: logMethodName()

} // ENDC
