package com.klef.jfsd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public ModelAndView demo()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("demo");//demo is view name or jsp file name
		return mv;
	}
	
	@GetMapping(path = "/demo1")//path means uri 
	public ModelAndView demo1()
	{
		ModelAndView mv= new ModelAndView("demo1");
		return mv;
	}
	
	@GetMapping("demo2")
	public ModelAndView demo2()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("demo2");
		return mv;
	}
	
	@GetMapping("demo3")
	@ResponseBody //return message instead of returning jsp file
	public String demo3()
	{
		return "Spring Web MVC";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public String add(@RequestParam("x")  int a,@RequestParam("y")  int b)//with parameters
	{
		int c=a+b;
		return Integer.toString(c);
	}
	
	@GetMapping("/displayname")
	@ResponseBody
	public String displayname(@RequestParam("fname")  String a ,@RequestParam("lname") String b)
	{
		return a+" "+b;
	}
	
	@GetMapping("displayid")
	@ResponseBody
	public String displayid(@RequestParam("id") int eid)
	{
		return Integer.toString(eid);
	}
	//post mapping for crud operations
	//for pathvariable we have to parameters should be in getmapping-it is without parameters 
	@GetMapping("viewname/{fname}/{lname}")
	@ResponseBody
	public String viewname(@PathVariable("fname") String x,@PathVariable("lname") String y)
	{
		return x+" "+y;
	}
	
	@GetMapping("/viewid/{eid}")// can be removed also
	@ResponseBody
	public String viewid(@PathVariable("eid") int id)
	{
		return Integer.toString(id);
	}
	
	@GetMapping("mul/{a}/{b}")//without parameters
	@ResponseBody
	public String mull(@PathVariable("a") int x, @PathVariable("b") int y)
	{
		int z = x*y;
		return Integer.toString(z);
	}
	@GetMapping("display")
	public ModelAndView display()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("display");
		mv.addObject("name","KLU");
		return mv;
	}
	
	@GetMapping("sub")
	public ModelAndView sub(@RequestParam("a")int x, @RequestParam("b") int y)
	{
		int z=x-y;
		ModelAndView mv= new ModelAndView("output");
		mv.addObject("result", z);
		return mv;
	}
	
	@GetMapping("show/{fname}/{lname}")
	public ModelAndView show(@PathVariable("fname") String x, @PathVariable("lname") String y )
	{
		String z=x+" "+y;
		ModelAndView mv= new ModelAndView();
		mv.setViewName("show");
		mv.addObject("fname", x.toUpperCase());
		mv.addObject("lname", y.toUpperCase());
		mv.addObject("name", z.toUpperCase());
		return mv;
	}
	
	

}
