package org.example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;


import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {
        LoginParameters log = new LoginParameters();
        Establecer n = new Establecer();
        Window ws = new Window();
        SendRequest sr = new SendRequest();
        if (log.ConfigExists()) {
            ws.InProcess();
            n.Establecer();


        }
        else {
            ws.FileWriter();
        }

    }
}


            // Grab the Scheduler instance from the Factory

