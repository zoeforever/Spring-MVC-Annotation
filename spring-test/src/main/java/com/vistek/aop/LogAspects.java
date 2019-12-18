package com.vistek.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {
	@Pointcut("execution(public int com.vistek.aop.MathCalculator.*(..))")
	public void pointCut() {
		
	}
	
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(methodName+"运行，参数是：{"+Arrays.asList(args)+"}");
	}
	
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName()+"执行结束");
	}
	
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result) {
		System.out.println(joinPoint.getSignature().getName()+"正常返回，结果是："+result);
	}
	
	@AfterThrowing(value="pointCut()",throwing = "exception")
	public void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println(joinPoint.getSignature().getName()+"运行异常，异常信息："+exception.getMessage());
	}
}
