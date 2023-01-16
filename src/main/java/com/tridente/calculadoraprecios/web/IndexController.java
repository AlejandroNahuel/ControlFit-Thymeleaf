package com.tridente.calculadoraprecios.web;

import com.tridente.calculadoraprecios.model.Customer;
import com.tridente.calculadoraprecios.service.EmailService;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    
    @Autowired
    EmailService mailSender;
    
    @GetMapping("/")
    public String index(){
        return "index";
    }
    
    @PostMapping("/form-data")
    public String sendData(Customer customer) throws MessagingException, UnsupportedEncodingException{
        
        mailSender.mailToCustomer(customer);
        mailSender.mailToOwner(customer);
        
        return "control-fit-logo";
    }
}
