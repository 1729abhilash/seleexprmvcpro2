package com.abhi.controllers;


import com.abhi.dto.CommunicationDto;
import com.abhi.dto.Phone;
import com.abhi.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String processUserReg(@ModelAttribute("userReg") UserRegistrationDto dto){
//save the dto object in database
        return "registration-success";
    }
    
    
}
