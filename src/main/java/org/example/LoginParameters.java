package org.example;

import java.io.*;
import java.util.Locale;
import java.util.Properties;

public class LoginParameters{


    public static final String CONFIG_PROPERTIES = "config.properties";
    public static final String PASSWORD = "password";
    public static final String USER = "user";
    public static final String FILEPATH = "filepath";
    Properties info = new Properties();
    Properties info2 = new Properties();
    Properties inforeturn = new Properties();
   OutputStream output;

    {
        try {
            output = new FileOutputStream(CONFIG_PROPERTIES, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    OutputStream output2;

    {
        try {
            output2 = new FileOutputStream(CONFIG_PROPERTIES, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    InputStream input;

    {
        try {
            input = new FileInputStream(CONFIG_PROPERTIES);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean ConfigExists(){
        info.clear();
        try{info.load(input);
            if (info.containsKey(USER)&&info.containsKey(PASSWORD)&&info.containsKey(FILEPATH)){
                return true;
            }
        else{
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }
   public void SetLoginParameters(String usuario, String pass)  {
        try {
            info.clear();
            this.info.put(USER, usuario);
            this.info.put(PASSWORD, pass);
            this.info.store(output, "primerset");
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void SetFilePath(String filepath)  {
        try {
            info.clear();
            this.info.put(FILEPATH, filepath);
            this.info.store(output2, "test");
            output2.close(); //solucion guarrera para problemas con los outputs clsed
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
    public Properties getLoginParameters()  {
        try {

            info.load(input);
            String test1, test2;
            test1 =  info.getProperty(USER);
            test2 =  info.getProperty(PASSWORD);
            inforeturn.put(USER,test1 );
            inforeturn.put(PASSWORD, test2);
        }
        catch (Exception e){
            System.out.println("Error en cargar");
        }

        return inforeturn;

    } //getter arreglado
    public String getFilePath()  {
        try {
            info.load(input);
            if (!info.containsKey(FILEPATH)){
                return "aa";
            }
            else {
                return info.getProperty(FILEPATH);
            }
        }
        catch (Exception e){
            System.out.println("Error en cargar");
            return "Error";
        }



    }
}
