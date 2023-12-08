package org.example;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SendRequest implements Job {
    Connection conn = null;
    public void sendRequest() throws SQLException{

        Window ws = new Window();
        LoginParameters login = new LoginParameters();
        Url hola = new Url();
        String url;
        final String query = "SELECT * FROM dba_tables WHERE table_name = 'HELP'";
        if(login.ConfigExists()){
            try {
                url = hola.GetUrl();
                conn =  DriverManager.getConnection(url, login.getLoginParameters());
                System.out.println("Connected to database");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.println("Comando ejecutado con exito");
                }

            }
            catch(SQLException se) {
                se.printStackTrace();

            }

        }
        else{
            System.out.println("Escribe los datos de configuracion en la hoja");


        }
    }
    public Boolean IsConnected(){
        if (conn!= null){
            return true;
        }
        else {return false;}
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            sendRequest();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

