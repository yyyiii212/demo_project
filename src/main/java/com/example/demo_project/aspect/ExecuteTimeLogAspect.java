package com.example.demo_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecuteTimeLogAspect {
	// ���J�I�A�w�qcontroller�U�Ҧ��{�����|�]�t
//	@Pointcut("execution (* com.example.demo_project.contorller.*.*(..))")
	@Pointcut("execution (* com.example.demo_project.service.impl.*.*(..))")
	public void pointcut() {

	}

	// before�̦W�٩��k(�]�t�A��)
	@Before("pointcut()")
	public void before() {
		System.out.println("==== before advice ====");
	}

	@After("pointcut()")
	public void after() {
		System.out.println("==== after advice ====");
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("==== around advice start ====");

		MethodSignature signature = (MethodSignature) pjp.getSignature();
		//���o��k�W��
		System.out.println("���檺��k�W�� : " + signature.getName());

		long startTime = System.currentTimeMillis();
		Object result = pjp.proceed();
		long spentTime = System.currentTimeMillis() - startTime;
		System.out.println("result : " + result);
		System.out.println("Time spent : " + spentTime);
		System.out.println("==== around advice end ====");
		return result;
	}

	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("==== afterReturning advice ====");
	}

	@AfterThrowing(pointcut = "pointcut()", throwing = "throwable")
	public void afterThrowing(JoinPoint joinpoint, Throwable throwable) {
		MethodSignature signature = (MethodSignature) joinpoint.getSignature();
		//���o��k�W��
		System.out.println("���檺��k�W�� : " + signature.getName());
		//�I�sproceed() �~�|�}�l������k
		System.out.println("���~�T�� : " + throwable.getMessage());
		System.out.println("==== afterThrowing advice ====");
	}
}
