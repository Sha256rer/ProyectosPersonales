package org.example;

import oracle.ucp.logging.annotations.Log;

import java.io.File;
import java.util.Scanner;

public class Url {
    Scanner scanner = new Scanner(System.in);
    private final String inicial = "jdbc:oracle:thin:@";
    private String connect;
    private String path;
    String retorno;
    LoginParameters filepath = new LoginParameters();

    File file = new File(filepath.getFilePath());


    public String GetUrl(){


            try {
                String test = filepath.getFilePath();
                Scanner scanner = new Scanner(file);
                connect = scanner.nextLine();
                String connectdef[] = connect.split("=", 2);
                connectdef[1] = connectdef[1].trim();
                retorno = inicial + connectdef[1];

            } catch (Exception s) {
                s.printStackTrace();
            }
        return retorno;
        }

}
