package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("bc1")
public class BasicController {
	
	// http://localhost:8080/bc1/hello
	@RequestMapping(method = RequestMethod.GET, value="/hello")
	public void sayHello() {
		System.out.println("Say hello Method...");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/hello2")
	public void sayHello2(@RequestParam("name")String uname, @RequestParam("pass")String upass) {
		System.out.println("Say hello method " + uname + " " +upass); 
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/hello3/{myp}")
	public void sayHello3(@PathVariable("myp")String mypath) {
		System.out.println("Say hello method 3 " + mypath);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="hello4/{myp}/{myw}")
	public void sayHello4(@PathVariable("myp")String mypath, @PathVariable("myw")String mywife) {
		System.out.println("Say hello method 4 " + mypath + " " + mywife);
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/example")
	public void hello(@RequestParam("name")String uname, @RequestParam("pass")String upass) {
		System.out.println(uname + " alalalla "  + upass);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/example2/{myp}/{myf}")
	public void heelllooo(@PathVariable("myp")String mypath, @PathVariable("myf")String mypath2) {
		System.out.println("alallalalala " + mypath + " " + mypath2 );
	}
	
}
