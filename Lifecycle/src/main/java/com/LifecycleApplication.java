package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.controller.MyComponent;

@SpringBootApplication
@ComponentScan("com")
public class LifecycleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LifecycleApplication.class, args);

		MyComponent myc = ctx.getBean(MyComponent.class);

		myc = ctx.getBean(MyComponent.class);

		myc.met();
	}

}
