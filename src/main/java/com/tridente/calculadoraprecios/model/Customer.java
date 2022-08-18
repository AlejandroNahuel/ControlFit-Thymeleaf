package com.tridente.calculadoraprecios.model;

import lombok.Data;

@Data
public class Customer {
    
    private String name;
    
    private String lastName;
    
    private String gymName;
    
    private String email;
    
    private String phone;
    
    private String numberOfMembers;
    
    private boolean notiWhatsapp;
    
    private boolean membersApp;
    
    private boolean ownersApp;
    
    private boolean extraComputer;
    
}
