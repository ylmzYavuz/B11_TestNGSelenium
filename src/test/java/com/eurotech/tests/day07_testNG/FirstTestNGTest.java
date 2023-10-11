package com.eurotech.tests.day07_testNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class FirstTestNGTest {
    @Test //testleri kosturma imkani taniyor
     public void Atest1(){
        System.out.println("My First Test Case");
    }
    @Test @Ignore // @Ignore den dolayi bu test calismayacak // bu da ayni isi görür
    public void btest2(){
        System.out.println("My second Test Case");
    }

    @Test
    public void Ctest3() {
        System.out.println("My Third Test Case");
    }
}
