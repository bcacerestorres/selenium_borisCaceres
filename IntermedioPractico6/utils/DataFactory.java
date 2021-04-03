package IntermedioPractico6.utils;

import com.github.javafaker.Faker;


public class DataFactory {
    public static String randomEmail = "emiliano" + Math.random() +"test"+ "@gmail.com";

    public static Faker fake = new Faker();

    public static String getFakeFirstName(){
        return fake.name().firstName();
    }

    public static String getFakeLastName(){
        return fake.name().lastName();
    }


}
