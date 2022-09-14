package com.francescomalagrino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.francescomalagrino.factory.AtmFactory;
import com.francescomalagrino.views.AtmView;

/**
 * ATM APP!
 *
 */
@SpringBootApplication
public class AtmApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(AtmApp.class, args);
        AtmView view = AtmFactory.getAtmView();
        view.startMenu();
    }
}
