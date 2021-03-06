package com.abhi.config;


import com.abhi.converters.CreditCardConverter;
import com.abhi.converters.CreditConverterObjectToString;
import com.abhi.formatter.CreditCardFormatter;
import com.abhi.formatter.PhoneNumberFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages= "com.abhi")
public class LoveCalculatorConfig implements WebMvcConfigurer {

    //set up my view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
      viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    MessageSource messageSource(){
         ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
         messageSource.setBasename("messages");
         return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator(){

        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setValidationMessageSource(messageSource());
    return localValidatorFactoryBean;
    }

    @Override
   public Validator getValidator(){
        return validator();
   }


    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addFormatter(new PhoneNumberFormatter());
     //   registry.addFormatter(new CreditCardFormatter());
       // registry.addConverter(new CreditCardConverter());
    //  registry.addConverter(new CreditConverterObjectToString());
    }

//    @Bean
//    public JavaMailSender getJavaMailSender(){
//    JavaMailSenderImpl jsm = new JavaMailSenderImpl();
//      jsm.setHost("smtp.gmail.com");
//      jsm.setUsername("harlabhi729@gmail.com");
//      jsm.setPassword("Conjecturehi8@");
//      jsm.setPort(567);
//
//        Properties mailProperties=new Properties();
//        mailProperties.put("mail.smtp.starttls.enable",true);
//        mailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com");
//
//        jsm.setJavaMailProperties(mailProperties);
//      return jsm;
//
//    }

}
