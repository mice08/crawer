package com.mk.crawer.base.cat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MkCatServiceInterceper {

	@Pointcut("execution(* com.mk..*.service.*.*(..))")
	public void servicePointcut() {
	}

	@Around("servicePointcut()")
	public Object around(ProceedingJoinPoint proceeding) throws Throwable {

		Object resultObj = null;
		String methodName = null;
		String className = null;

//		className = proceeding.getTarget().getClass().getSimpleName();
//		methodName = proceeding.getSignature().getName();
//
//		Transaction t = Cat.newTransaction("OtsService", className + "." + methodName);
//
//		try {
//			resultObj = proceeding.proceed();
//			t.setStatus(Transaction.SUCCESS);
//			return resultObj;
//		} catch (Exception ex) {
//			t.setStatus(ex);
//			throw ex;
//		} finally {
//			t.complete();
//		}
		return null;
	}
}
