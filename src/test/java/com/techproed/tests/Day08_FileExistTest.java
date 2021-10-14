package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest   {

    @Test
    public void isExist(){

      /*
      Selenium has limitation with desktop application
      With Java we check if a file exist in our local computer
       */

        //Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home"); // \Users\Dalerjon\Desktop\flower.jpeg
        String pathOfImage = homePath+"\\Desktop\\flower.jpeg";
        System.out.println(pathOfImage);

        ////this code will check if pathOfImage is exist or not.
        //If it exists, it returns true, if not then false
        boolean isExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isExist);


    }
}
