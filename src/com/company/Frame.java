package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.io.FileInputStream;

/* FrameDemo.java requires no other files. */
public class Frame {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() throws FileNotFoundException {
        //Create and set up the window.
        JFrame frame = new JFrame("Game of the YEAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton javaButton = new JButton("Start game");
        javaButton.isDefaultButton();
        frame.getContentPane().add(javaButton, BorderLayout.BEFORE_FIRST_LINE);
        javaButton.setPreferredSize(new Dimension(10, 10));
        javaButton.setVisible(true);

        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    java.awt.Desktop.getDesktop().browse(URI.create("http://store.steampowered.com/news/?feed=steam_updates&appids=730"));
                } catch (java.io.IOException a) {
//                     openWebPage("http://www.mywebsite.com/forum/");
                    System.out.println("ne sudba");
                }
            }
        });


        JButton startButton = new JButton("Run");
        startButton.isDefaultButton();
        frame.getContentPane().add(startButton, BorderLayout.BEFORE_LINE_BEGINS);
        startButton.setPreferredSize(new Dimension(20, 1));
        startButton.setVisible(true);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)/Notepad++/notepad++.exe");
                    //C:\Program Files (x86)/Notepad++/notepad++.exe
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
//                Process process = Runtime.getRuntime().exec("cmd.exe /C start C:\\Program Files (x86)\Notepad++\\notepad++.exe" );
            }
        });

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        JLabel secondLabel = new JLabel("");
        secondLabel.setPreferredSize(new Dimension(200, 200));
        frame.getContentPane().add(secondLabel, BorderLayout.AFTER_LAST_LINE);
        frame.setIconImage(new ImageIcon("./csgoicon.png").getImage());
        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondLabel.setText("Game is started. Loading...");
                secondLabel.setHorizontalTextPosition(SwingConstants.CENTER);

            }
        });
        JButton ListButton = new JButton("Wiki");
        ListButton.isDefaultButton();
        frame.getContentPane().add(ListButton, BorderLayout.LINE_END);
        ListButton.setPreferredSize(new Dimension(20, 1));
        ListButton.setVisible(true);
        JLabel ListLabel = new JLabel("");
        frame.getContentPane().add(ListLabel, BorderLayout.AFTER_LAST_LINE);

        int character;
        StringBuffer buffer = new StringBuffer("");
        FileInputStream inputStream = new FileInputStream(new File("E:\\Adrian/FrameTest/out/production/FrameTest/info.txt"));

        try {
            while ((character = inputStream.read()) != -1)
                buffer.append((char) character);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(buffer);

        ListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                ListLabel.setText(("<html>"+String.valueOf(buffer)+"</html>"));
                System.out.println(String.valueOf(buffer));

            }
        });
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.add(new JLabel(new ImageIcon("./giphy.gif")));
        //frame.add(new JLabel(new Button));
    }
    //Button add


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}