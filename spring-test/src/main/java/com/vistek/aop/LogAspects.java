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
		System.out.println(methodName+"���У������ǣ�{"+Arrays.asList(args)+"}");
	}
	
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName()+"ִ�н���");
	}
	
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(JoinPoint joinPoint,Object result) {
		System.out.println(joinPoint.getSignature().getName()+"�������أ�����ǣ�"+result);
	}
	
	@AfterThrowing(value="pointCut()",throwing = "exception")
	public void logException(JoinPoint joinPoint,Exception exception) {
		System.out.println(joinPoint.getSignature().getName()+"�����쳣���쳣��Ϣ��"+exception.getMessage());
	}
}
