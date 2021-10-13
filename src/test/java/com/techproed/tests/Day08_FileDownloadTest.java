package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {
    @Test
    public void fileDownloadTest() throws InterruptedException {
//create a class: FileDownloadTest
//fileDownloadTest()
//Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
//download flower.png file
        driver.findElement(By.linkText("flower.jpeg")).click();


//Then verify the file downloaded successfully
        //We must put hard wait since file download takes a little bit time
        //Implicit or explicit wait cannot fix the problem, download folder is windows based application
        Thread.sleep(2000);

// Getting the PATH of the HOME directory with JAVA
        String homePath = System.getProperty("user.home");
        //This will be the file name that is downloaded
        String pathOfFlower = homePath + "/Downloads/flower.jpeg";

        boolean isDownloaded = Files.exists(Paths.get(pathOfFlower));
//Asserting if file download is successful
        Assert.assertTrue(isDownloaded);

    }

}
