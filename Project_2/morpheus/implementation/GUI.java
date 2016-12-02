package implementation;

import java.io.*;
import java.util.*;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//10234 can't move at all
//10902 can move
//10300 not senior
//10235 prioritize senior
public class GUI{
    private static nrLib test = new nrLib();
    private static GUI2 next = new GUI2();
    private JTextField nameTxt;
    private String crn;
    private String days;
    private String senior;
    private JFrame frame;
    private JPanel panel;
    private JButton madLibButton;
    private JLabel title;
    private JLabel nameLabel;
    private JLabel verbLabel1;
    private JLabel adjLabel;
    private GridBagConstraints left;
    private GridBagConstraints right;
    JComboBox<String> list1; 
    JComboBox<String> list2;
    List<String> all;

    public void start() throws SQLException{
        all = test.crn_Exit();
        nameTxt = new JTextField(5);
        frame = new JFrame();
        panel = new JPanel();
        madLibButton = new JButton("RUN");
        madLibButton.addActionListener(new ConvertBtnListener()); //Note 5

        title = new JLabel(" Please Enter in the following to see if this CRN can move to other time. ");
        nameLabel = new JLabel("CRN: ");
        verbLabel1 = new JLabel("Days \"MWF\" or \"TR\": ");
        adjLabel = new JLabel("Prioritize Senior \"YES\" or \"NO\": ");


        String[] day_select = { "MWF", "TR" };
        String[] senior_select = { "YES", "NO" };

        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        list1 = new JComboBox<>(day_select);
        list1.setSelectedIndex(0);
        list1.setEditable(false);

        list2 = new JComboBox<>(senior_select);
        list2.setSelectedIndex(0);
        list2.setEditable(false);


        frame.getContentPane().add(BorderLayout.SOUTH, madLibButton);
        frame.getContentPane().add(BorderLayout.NORTH, title);

        panel.setLayout(new GridBagLayout());
        Color purple = new Color(238, 130, 238);
        //purple.getHSBColor(0.20f, 1f, 1f);
        panel.setBackground(purple);
        frame.getContentPane().add(panel);
        left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(nameLabel, left);
        panel.add(nameTxt, right);
        panel.add(verbLabel1, left);
        panel.add(list1, right);
        panel.add(adjLabel, left);
        panel.add(list2, right);
   
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Move Class Project");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);          // Center window.
    }
    class ConvertBtnListener implements ActionListener {         //Note 6
        public void actionPerformed(ActionEvent e) {
            int count = 0;
            crn = nameTxt.getText();
            crn = crn.toUpperCase();
            days = (String)list1.getSelectedItem();
            senior = (String)list2.getSelectedItem();
            
            
            System.out.print("\033[2J\033[1;1H");
            if(crn.length() == 5 && all.contains(crn))
            {
                nameTxt.setBackground(Color.white); 
                frame.dispose();
                next.start2(crn,days,senior);
                
            }
            else
            {
                nameTxt.setBackground(Color.red);
                if(all.contains(crn)==false)
                    System.out.println("ERROR! This CRN does not exist.");
                else
                    System.out.println("ERROR! please retype or type your CRN on the first box.");
            }       
            //System.out.println(crn+" "+days+" "+senior);

        }
    }

    public static void main(String[] args) throws SQLException{
        System.out.print("\033[2J\033[1;1H");
        GUI main = new GUI();
        main.start();
    }

}
