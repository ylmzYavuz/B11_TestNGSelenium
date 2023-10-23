package com.eurotech.tests.day14_properties_singleton;

public class Singleton {

    private Singleton(){
    }
    private static String str;

    public static String getInstance(){
        if(str==null){
            System.out.println("str is null, assigning a value to it");
            str="some value";
        }else{
            System.out.println("it has a value, just return it");
        }
        return str;
    }
}
