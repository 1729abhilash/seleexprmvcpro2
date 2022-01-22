package com.abhi.controllers;


import com.abhi.dto.UserInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LCAppController {

//    @RequestMapping("/")
//    public String showHomePage(Model model){
//        //read the existing property by fetching it from the dto
//        UserInfoDto userInfo=new UserInfoDto();
//         model.addAttribute("userInfo",userInfo);
//
//        return "home-page";
//    }
//
    //other way of above

    @RequestMapping("/")
    public String showHomePage(@ModelAttribute("userInfo") UserInfoDto userInfoDto){
        //will use spring mvc tag in home-page.jsp
        //read the existing property by fetching it from the dto
       //UserInfoDto userInfo=new UserInfoDto();
        //model.addAttribute("userInfo",userInfo);

        return "home-page";
    }


    //fetching query parameter with the help of using
    //requestpparam  before it wew were using
    //httpservletrequest object and with the help
    //of that object we were fetching the parameter requuest.getParameter()

//    @RequestMapping("/process-homepage")
//    public String showResultPage(@RequestParam("userName") String userName, @RequestParam("crushName") String crushName
//    , Model model){
//        model.addAttribute("userName",userName);
//        model.addAttribute("crushName",crushName);
//        return "result-page";
//    }


    //fetching query parameter using Dto object//this is data binding
//    @RequestMapping("/process-homepage")
//    public String showResultPage(UserInfoDto userInfoDto
//            , Model model){
//
//        //writing the value to the properties by fetching from the url
////        model.addAttribute("userName",userInfoDto.getUserName());
////        model.addAttribute("crushName",userInfoDto.getCrushName());
////        or we can do this
//       model.addAttribute("userInfo",userInfoDto);
//
//        return "result-page";
//    }

    //other way of above method of doing this


    @RequestMapping("/process-homepage")
    public String showResultPage(@Valid @ModelAttribute("userInfo")UserInfoDto userInfoDt, BindingResult result){
//@valid annotation help to trigeer bean validation
       //once alll query paramter goes to dto
        //then it validated whether it is meating criteria
if(result.hasErrors()){
    List<ObjectError> allErrors=result.getAllErrors();
     for(ObjectError temp:allErrors){
         System.out.println(temp);
     }

    return "home-page";
}

        return "result-page";
    }

}
