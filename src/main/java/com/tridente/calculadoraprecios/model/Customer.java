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
    
    public double calculateFinalPrice(Customer customer){
        //Calculating price
        double initialPrice = 2700;
        double addedPrice = 0;
        double finalPrice = 0;

        switch(numberOfMembers){
            case "100":
                addedPrice = 0;
                break;
            case "200":
                addedPrice = 400;
                break;
            case "300":
                addedPrice = 800;
                break;
            case "400":
                addedPrice = 1200;
                break;
            case "500":
                addedPrice = 1600;
                break;
            case "600":
                addedPrice = 2000;
                break;
            case "700":
                addedPrice = 2400;
                break;
            case "800":
                addedPrice = 2800;
                break;
            case "900":
                addedPrice = 3200;
                break;
            case "1000":
                addedPrice = 3600;
                break;
        }
    
        if (notiWhatsapp) {
            addedPrice += 1500;
        }

        if (membersApp) {
            addedPrice += 1900;
        }

        if (ownersApp) {
            addedPrice += 1200;
        }

        if (extraComputer) {
            addedPrice += 700;
        }

        finalPrice = initialPrice + addedPrice;
        
        return finalPrice;
    }
    
}
