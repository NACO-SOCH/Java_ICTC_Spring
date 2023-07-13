package gov.naco.soch.aop.logging;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.google.common.base.Strings;





@Aspect
@Configuration
@EnableAspectJAutoProxy
public class MeasuredAspect {
	
	private Logger logger(JoinPoint joinPoint) {
	        return LoggerFactory.getLogger(MeasuredAspect.class);
	}
	
    @Around("@annotation(gov.naco.soch.aop.logging.Measured)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    	Logger log = logger(joinPoint);
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Measured measured = method.getAnnotation(Measured.class);
        String message = measured.message();
        if (Strings.isNullOrEmpty(message))
            log.info("Method {} execution: {} ms", joinPoint.getSignature().toShortString(), executionTime);
        else
            log.info("{}: {} ms", message, executionTime);
        return proceed;
    }
}