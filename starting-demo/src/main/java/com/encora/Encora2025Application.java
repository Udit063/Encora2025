package com.encora;

import com.encora.controller.MyController;
import com.encora.controller.UserController;
import com.encora.service.bank.AccountServiceImpl;
import com.encora.service.compkey.CompKeyService;
import com.encora.service.manytomany.ManyToManyService;
import com.encora.service.onetomany.OneToManyService;
import com.encora.service.onetoone.OneToOneService;
import com.factory.Customer;
import com.factory.Seller;
import com.factory.Shoe;
import com.factory.ShoeFactory;

import jakarta.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan("com")
//public class Encora2025Application implements CommandLineRunner {
//	@Autowired
//	@Singleton
//	private ShoeFactory factory;
//
//	public Encora2025Application(ShoeFactory factory) {
//		this.factory = factory;
//	}
//
//	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx = SpringApplication.run(Encora2025Application.class, args);
//
//		Seller seller = ctx.getBean("rsshop", Seller.class);
//
//		Customer c = new Customer("ramesh");
//		Shoe shoe = seller.sellShoe(c);
//
//		System.out.println(shoe);
////		System.out.println("..................***********"+factory);
//	}
//
//	public void run(String... args) {
//		System.out.println(".................." + factory);
//	}
//		 getBean is also used to access the other class outside the class while Autowired is to access other class within the class
//		 MyController obj = ctx.getBean(MyController.class);
//		 System.out.println(obj);
//		 obj.Test();
//	}

@SpringBootApplication
public class Encora2025Application {

    private final AccountServiceImpl accountServiceImpl;

    private final ManyToManyService manyToManyService;

    private final OneToManyService oneToManyService;

    private final UserController userController;

    Encora2025Application(UserController userController, OneToManyService oneToManyService, ManyToManyService manyToManyService, AccountServiceImpl accountServiceImpl) {
        this.userController = userController;
        this.oneToManyService = oneToManyService;
        this.manyToManyService = manyToManyService;
        this.accountServiceImpl = accountServiceImpl;
    }
	public static void main(String[] args) {
//		try {
//			ConfigurableApplicationContext ctx = SpringApplication.run(Encora2025Application.class, args);
//			
//			UserController uc = ctx.getBean(UserController.class);
//			System.out.println(uc.login("ramu", "secret"));
//			System.out.println(uc.login("ramu", "secret"));
//			System.out.println(uc.login("rohan", "secrets"));
//			System.out.println(uc.login("rohit", "malhotra"));
//			uc.logout("ramu");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
//			ConfigurableApplicationContext ctx= 
//					SpringApplication.run(Encora2025Application.class, args);			
//			
//			OneToOneService onetoone=ctx.getBean(OneToOneService.class);
//			onetoone.insert();
//			
//			OneToManyService onetomany = ctx.getBean(OneToManyService.class);
//			onetomany.create();
			
			ConfigurableApplicationContext ctx = SpringApplication.run(Encora2025Application.class, args);
//			OneToOneService onetoone = ctx.getBean(OneToOneService.class);
//			onetoone.insert();
//			
//			OneToManyService onetomany = ctx.getBean(OneToManyService.class);
//			onetomany.create();
//			
//			ManyToManyService manytomany = ctx.getBean(ManyToManyService.class);
//			manytomany.insert();
//			
//			CompKeyService cks = ctx.getBean(CompKeyService.class);
//			cks.insert();
			
			AccountServiceImpl asi = ctx.getBean(AccountServiceImpl.class);
			try {
				asi.doTransaction(100, 200, 10000);
			} catch(Throwable e) {
				e.printStackTrace();
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
