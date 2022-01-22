package com.abhi.controllers;


import com.abhi.dto.CommunicationDto;
import com.abhi.dto.Phone;
import com.abhi.dto.UserRegistrationDto;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @RequestMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDto dto){
 dto.setName("abhilash");

 //load the saved user data from the database
        Phone phone=new Phone();
        phone.setCountryCode("91");
        phone.setUserNumber("2343242");
        CommunicationDto communicationDto=new CommunicationDto();
       dto.setCommunicationDto(communicationDto);
        dto.getCommunicationDto().setPhone(phone);
       return "user-registration-page";

    }
    
    @RequestMapping("/registration-success")
    public String processUserReg(@Valid @ModelAttribute("userReg") UserRegistrationDto dto, BindingResult result){
//save the dto object in database
        if(result.hasErrors()) {
         List<ObjectError> allErrors=result.getAllErrors();
         for(ObjectError error : allErrors)
         {
             System.out.println(error);
         }

         return "user-registration-page";
        }
        return "registration-success";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder){//befire tge flow go to the/register it comes here first
        //before flow to to handler mehtods it comes here initbinder
        System.out.println("inside the initbinder emthod  ");
//binder.setDisallowedFields("name");//the name field of userregistrationDto will be null
        //we do not want this property to be binded
     //it will make the value of name of the query null


        //introducing property editor
        StringTrimmerEditor  tr = new StringTrimmerEditor(true);//if we make it false it will make the string empty
        // but not null
        binder.registerCustomEditor(String.class,"name",tr);//trimiteditor converting whitespaces to null
//with the help of propertyeditor we can convert string query parameter object into Integer or
        //in any object before mapping
//spring uses property editors to convert strings
        //to object type and object type to string type
      //example saing operation or pageload operation

        //webbinder  that is responsible of setting
        //property values on to a target object
        //setting from fields into beans
        //an init method initialises WebDataBinder



    }
    
    
}
