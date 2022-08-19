package com.tridente.calculadoraprecios.service;

import com.tridente.calculadoraprecios.model.Customer;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Currency;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    
    @Autowired
    private JavaMailSender mailSender;
    
    
    public void mailToCustomer(Customer customer, double finalPrice) throws MessagingException, UnsupportedEncodingException{
        
        String subject = "Este mail es para el cliente";
        String senderName = "Control Fit";
        String mailContent = "<img src=\"https://www.controlfitsoftware.com/images/logo.png\" alt=\"Control Fit Logo\" style=\"background-color: black;\"/>";
        mailContent+="<h2>Hola, "+ customer.getName() + "!</h2>";
        mailContent+="<p>Gracias por detallarnos los datos de tu plan</p>";
        mailContent+="<p>Te dejamos acá el listado de lo que elegiste:</p>";
        mailContent+="<ul>"
                + "<li>Nombre del gimnasio: "+customer.getGymName()+"</li>"
                + "<li>Cupo de socios activos: " + customer.getNumberOfMembers() + "</li>";
        if (customer.isNotiWhatsapp()) mailContent+="<li>Notificaciones por Whatsapp: Si</li>";
        else mailContent+="<li>Notificaciones por Whatsapp: No</li>";
        
        if (customer.isMembersApp()) mailContent+="<li>App móvil para socios: Si</li>";
        else mailContent+="<li>App móvil para socios: No</li>";
        
        if (customer.isOwnersApp()) mailContent+="<li>App móvil para dueños: Si</li>";
        else mailContent+="<li>App móvil para dueños: No</li>";
        
        if (customer.isExtraComputer()) mailContent+="<li>Computadora extra: Si</li>";
        else mailContent+="<li>Computadora extra: No</li>";
        
        mailContent+="</ul>";
        
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setCurrency(Currency.getInstance("ARS"));
        formatter.setMinimumFractionDigits(2);
        String finalPriceStr = formatter.format(finalPrice);
        
        mailContent+= "<p>Precio final del plan: AR$"+ finalPriceStr +"</p>";
        
        mailContent+="<p>Próximamente nos pondremos en contacto!</p>";
        mailContent+="<p>Saludos, <strong>"+senderName+"</strong></p>";
        
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setFrom("democontrolfit@gmail.com",senderName);
        helper.setTo(customer.getEmail());
        helper.setSubject(subject);
        helper.setText(mailContent, true);
        
        mailSender.send(message);
    }
    
    
    public void mailToOwner(Customer customer) throws MessagingException, UnsupportedEncodingException{
        
        String [] to = new String[2];
        to[0] = "alejandro.nahue.15817@gmail.com";
        to[1] = "robertodipeterson@gmail.com";
        
        String subject = "Este mail es para el product owner";
        String senderName = "Control Fit";
        String mailContent = "<h2>Hola, "+customer.getName()+" ha solicitado el siguiente plan de servicios: </h2>";
        mailContent += "<p><strong>Detalles:</strong></p>";
        mailContent += "<ul>"
                + "<li>Nombre: "+ customer.getName() + "</li>"
                + "<li>Apellido: "+ customer.getLastName() + "</li>"
                + "<li>Telefono de contacto: "+ customer.getPhone() + "</li>"
                + "<li>Email de contacto: "+ customer.getEmail() + "</li>"
                + "<li>Nombre del gimnasio: " + customer.getGymName() + "</li>"
                + "<li>Cupo de socios activos:" + customer.getNumberOfMembers() + "</li>";
        if (customer.isNotiWhatsapp()) mailContent+="<li>Notificaciones por Whatsapp: Si</li>";
        else mailContent+="<li>Notificaciones por Whatsapp: No</li>";
        
        if (customer.isMembersApp()) mailContent+="<li>App móvil para socios: Si</li>";
        else mailContent+="<li>App móvil para socios: No</li>";
        
        if (customer.isOwnersApp()) mailContent+="<li>App móvil para dueños: Si</li>";
        else mailContent+="<li>App móvil para dueños: No</li>";
        
        if (customer.isExtraComputer()) mailContent+="<li>Computadora extra: Si</li>";
        else mailContent+="<li>Computadora extra: No</li>";
        
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        helper.setFrom("democontrolfit@gmail.com", senderName);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(mailContent, true);
        
        mailSender.send(message);
    }
    
}
