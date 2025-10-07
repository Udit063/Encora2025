package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;

import com.shopping.controller.ActionServlet;

@SpringBootApplication(scanBasePackages = "com.shopping")
@ServletComponentScan
public class WebProjectApplication {

	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext ctx = SpringApplication.run(WebProjectApplication.class, args);
			
			ServletRegistrationBean<ActionServlet> srb = (ServletRegistrationBean<ActionServlet>)ctx.getBean("getActionServlet");
			
			ActionServlet as = srb.getServlet();
			as.setCtx(ctx);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
