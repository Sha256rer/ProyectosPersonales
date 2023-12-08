package org.example;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.net.URL;
import java.sql.SQLException;

import static org.example.LoginParameters.*;

public class Window implements ActionListener {
    JFrame window = new JFrame();
    JLabel user = new JLabel(USER);
    JLabel password = new JLabel(PASSWORD);
    JLabel filepath = new JLabel(FILEPATH);
    JTextField usertext = new JTextField();
    JTextField passtext = new JTextField();
    JTextField filetext = new JTextField();
    JButton button = new JButton("Submit");
    JButton button2 = new JButton("Test");
    PopupMenu pop = new PopupMenu();
    MenuItem exit = new MenuItem("Exit");
    JLabel text = new JLabel("En proceso");
    SystemTray tray = SystemTray.getSystemTray();
    TrayIcon tr = new TrayIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
    Establecer est = new Establecer();

    public void  InProcess(){
      //sin la barra no va
        window = new JFrame();
        if(SystemTray.isSupported()){
            window.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        }
        window.setSize(600,300);
        window.setVisible(true);
        window.add(text);
        pop.add(exit);
        tr.setPopupMenu(pop);
        window.add(pop);
        exit.addActionListener(this);

        try {
            tray.add(tr);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void FileWriter (){
        GridLayout g1 = new GridLayout();
        JPanel j = new JPanel();
        j.setBackground(Color.CYAN);
        j.setPreferredSize(new Dimension(600,50));
        g1.setColumns(2);
        g1.setRows(3);
        j.setLayout(g1);
        j.add(user);
        j.add(usertext);
        j.add(password);
        j.add(passtext);
        j.add(filepath);
        j.add(filetext);

        window.setSize(600,300);
        window.add(j);
        window.setLayout(new FlowLayout(0));
        window.setTitle("Introducir");
        window.add(button);
        window.add(button2);
        button.addActionListener(this);
        button2.addActionListener(this);
        window.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(button.getActionCommand())){
            LoginParameters setter = new LoginParameters();
            setter.SetLoginParameters(usertext.getText(), passtext.getText());
            setter.SetFilePath(filetext.getText());
            JOptionPane.showMessageDialog(null,"Written succesfuly");
        }
        if(e.getActionCommand().equals(exit.getActionCommand())){
          System.exit(0);
        }
        if(e.getActionCommand().equals(button2.getActionCommand())){
            SendRequest sr = new SendRequest();
            try {
                sr.sendRequest();
                if (sr.IsConnected()){
                    JOptionPane.showMessageDialog(null,"Exito");
                    window.dispose();
                    InProcess();
                    est.Establecer();

                }

            }
          catch (SQLException ex){
                ex.printStackTrace();
          }
        }


    }
    private void setDefaultCloseOperation(int exitOnClose) {
    }
}
