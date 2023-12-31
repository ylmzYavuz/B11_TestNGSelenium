package com.eurotech.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    //key/value formatinda veri saklayan java util package dan gelen class
    private static Properties properties;//OOP

    static {
        try {
            //which file to read
            String path = "configuration.properties";
            //read file into java, finds the file using the string path
            //dosyayı java'ya okur, dosyayı dize yolunu kullanarak bulur
            FileInputStream input = new FileInputStream(path);
            // properties--> class that store properties in key/value format
            properties = new Properties();
            // the values from the file input is loaded/ fed in to the properties object
            //Dosyadan gelen değerler, properties nesnesine yüklenir.
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}