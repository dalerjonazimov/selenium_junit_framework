package com.techproed.tests;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {

    //We may need fake data for testing
    //JavaFaker is used to get fake data
    //We need java faker dependency in our
    @Test
    public void faker(){
        //1. Create faker object
        Faker faker = new Faker();
        //2. Generate fake data such : firstname, lastname, city, state, title

        //generating fake firstname
        String fName=faker.name().firstName();
        String lName=faker.name().lastName();
        String fullName=faker.name().fullName();
        System.out.println("First Name: "+ fName);
        System.out.println("Last Name: "+ lName);
        System.out.println("Full Name: "+ fullName);

        //generate title
        System.out.println(faker.name().title());

        //city
        System.out.println(faker.address().city());

        //state
        System.out.println(faker.address().state());

        //phone number
        System.out.println(faker.phoneNumber().cellPhone());

        //fake email
        System.out.println(faker.internet().emailAddress());

        //random 5 digit number
        System.out.println(faker.number().digits(5));



    }

}
