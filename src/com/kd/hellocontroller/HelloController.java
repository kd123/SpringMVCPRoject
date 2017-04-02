package com.kd.hellocontroller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

///////////////////simple web controller class//////////////////////

/*public class HelloController extends AbstractController{

	protected ModelAndView handleRequestInternal(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","welcom to my spring mvc web project");
		return modelandview;
	}
}
*/

////////////////////////////// annotation based controller class @Controller, @RequestMapping and multiAction Controller/////////////////////////////////

/*@Controller
//@RequestMapping("/greet")
public class HelloController{
	
	@RequestMapping("/welcome")
	
	public ModelAndView helloWorld(){
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "this is annotation based controller class");
		return model;
	}
	@RequestMapping("/hi")
	public ModelAndView hiWorld(){
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "this is annotation based controller class and multiAction controller");
		return model;
	}
}
*/

////////////////////////PathVariable annotation///////////////////////////////////
//////we can use @PathVariable map<String , String> pathVars to pass the many user name in url///////////////
///i.e if we want @RequestMapping("/welcome/{countryName}/{userName}")
/////////then we use String  country = pathVars.get("countryName)"
////////String name = pathVars.get(userName)"///////////////////////////////////////////////

/*@Controller
public class HelloController{
	
	@RequestMapping("/welcome/{userName}")
	
	public ModelAndView helloWorld(@PathVariable("userName") String name){
		
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "this is PathVariable annotation based controller class using this<br> we can pass the user name in url request:  "+name);
		return model;
	}
}
*/

///////////////////////////handling html form submission using @RequestParam annotation///////////////////////////////

@Controller
public class HelloController{
	
	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm(){
		
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	/*public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name, @RequestParam("college") String college){
		// we can use setter getter class given below
		Student student1=new Student();
		student1.setStudentName(name);
		student1.setCollege(college);
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Student details:");
		model.addObject("student1",student1);
		return model;
	}*/
	          //or we can use @ModelAttribute Annotation concept
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1, BindingResult result){
		//or we can use setter getter class given below
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Student details:");
		return model;
	} 
	//////// if there is common object or message for all method in a controller then
	/////////we use @modelAttribute Annotation to use the object in every method of controller
	@ModelAttribute
	public void addingCommonObjects(Model model){
		model.addAttribute("hedderMessage", "IIT Roorkee, India");
	}
	
	///////customize data binding feature by @InitBinder and WebDataBinder//////
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.setDisallowedFields(new String[] {"mobile"});
		/// customize property editor///////
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
	}
	
	
}
