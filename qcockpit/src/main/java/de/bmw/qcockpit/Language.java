/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bmw.qcockpit;

import java.io.Serializable;
import java.util.Locale;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

/**
 *
 * @author dominic
 */
@Named
@SessionScoped
public class Language implements  Serializable{
    
    String language = "de";
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    public void changeLanguage(String lang){
        System.out.println("change Language " + lang);
        this.language = lang;
        this.locale = new Locale(lang);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    public void changeLanguageListener(ValueChangeEvent  event){
       System.out.println("Test Listener " + event.getNewValue().toString()); 
       changeLanguage(event.getNewValue().toString());
    }
    
}
