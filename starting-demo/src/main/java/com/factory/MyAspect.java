package com.factory;


import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final String Class_Name = MyAspect.class.getName();
	private static Logger logger = Logger.getLogger(Class_Name);
	
	@Before("execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public void welcome() {
		logger.entering(Class_Name, "entering sell shoe method...");
		System.out.println("Welcom to shoe shop.....");
	}
	
	@AfterReturning("execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public void thankyou() {
		logger.info("sell shoe method finished and now it will exit...");
		System.out.println("Thankyou....For purchase....come again...");
	}
	
	@Around("execution(* com.factory.RamuShoeShop.sellShoe(..))")
	public Object duringPurchase(ProceedingJoinPoint jointPoint) throws Throwable{
		logger.info("now the sell shoe method will get executed...");
		System.out.println("during the execution of sell shoe method...");
		Shoe shoe = (Shoe)jointPoint.proceed();
		logger.info("the return value of sell shoe logic is...:"+shoe);
		return shoe;
	}
}