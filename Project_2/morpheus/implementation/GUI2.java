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

public class GUI2{
	private static nrLib test = new nrLib();
	private static GUI main = new GUI();
	private static GUI3 main2 = new GUI3();
	private static GUI4 screen = new GUI4();
	private List<String> room_solve;
	private JTextField list3;
	private JComboBox<String> list2;
	private JComboBox<String> list1;
	private String[] senior_select;
	private JPanel panel;
	private String hold_crn;
	private GridBagConstraints right;
	private String hold_days;
	private String hold_time;
	private String temp_crn;
	private JFrame frame;
	public void start2(String crn, String days, String senior)
	{
		try{
			/*
			List<String> not_all = test.findTime(crn,days,0);
			List<String> all = test.getAllStartTime(days);
			List<String> single = test.crn_day(crn);
			System.out.println("Student: "+ not_all);
			System.out.println("Time: "+ all);
			System.out.println("Time1: "+ single);
			
			System.out.println("T or F: "+test.error_term(crn,days));
			*/

			/*
			List<String> room = test.allRoom();
			List<String> room1 = test.notavailableRoom("1630",days);
			System.out.println("All: "+room);
			System.out.println("Some: "+room1);
			System.out.println("Compare: "+test.comparingRoom(room,room1));
			*/
			if(test.error_term(crn,days) && senior == "NO")
			{
				hold_days = days;
				temp_crn = crn;
				List<String> solution = test.comparing(test.findTime(crn,days,0),test.getAllStartTime(days));
		        System.out.println(solution);
		        frame = new JFrame();
		        panel = new JPanel();
		        JButton madLibButton = new JButton("Enter");
		        madLibButton.addActionListener(new ConvertBtnListener()); //Note 5

		        JLabel title = new JLabel(" Please select time and room for this CRN: \""+crn+"\" on \""+days+"\". ");
		   		JLabel verbLabel1 = new JLabel("Time: ");
		        JLabel adjLabel = new JLabel("Room: ");


		        String[] day_select = new String[solution.size()];
		        for(int x = 0; x < solution.size();x++)
		        {
		        	String temp = solution.get(x);
		        	day_select[x] = temp;
		        }
		        //Create the combo box, select item at index 4.
		        //Indices start at 0, so 4 specifies the pig.
		        list1 = new JComboBox<>(day_select);
		        list1.setEditable(false);
		        list1.addActionListener(new ConvertActListener());
		        room_solve = test.comparingRoom(test.allRoom(),test.notavailableRoom(solution.get(0),days));
		       	
		       	if(room_solve.size() == 0)
		       	{
		       		list3 = new JTextField(20);
		       		list3.setEditable(false);
		       		list3.setText("NO ROOM AVAILABLE");
		       	}
		       	else
		       	{
					senior_select = new String[room_solve.size()];
			        for(int x = 0; x < room_solve.size();x++)
			        {
			        	String temp = "MBB"+room_solve.get(x);
			        	senior_select[x] = temp;
			        }
			        list2 = new JComboBox<>(senior_select);
			        list2.setEditable(false);
		       	}



		        frame.getContentPane().add(BorderLayout.SOUTH, madLibButton);
		        frame.getContentPane().add(BorderLayout.NORTH, title);

		        panel.setLayout(new GridBagLayout());
		        panel.setBackground(Color.white);
		        frame.getContentPane().add(panel);
		        
		        GridBagConstraints left = new GridBagConstraints();
		        left.anchor = GridBagConstraints.EAST;
		        
		        right = new GridBagConstraints();
		        right.weightx = 2.0;
		        right.fill = GridBagConstraints.HORIZONTAL;
		        right.gridwidth = GridBagConstraints.REMAINDER;
		  
		        panel.add(verbLabel1, left);
		        panel.add(list1, right);
		        panel.add(adjLabel, left);
		        if(room_solve.size() == 0)
		        	panel.add(list3, right);
		        else
		        	panel.add(list2,right);
		   
		        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		        frame.pack();
		        frame.setVisible(true);
		        frame.setTitle("Move Class Project");
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.setResizable(false);
		        frame.setLocationRelativeTo(null);          // Center window.
		    }
		    else if(test.error_term(crn,days) && senior == "YES")
		    {
		    	main2.start3(crn,days);
		    }
		    else{
		    	System.out.println("There are no available time on \""+days+"\" for this CRN = "+crn+". ");
        		main.start();
		    }
        }    
        catch(SQLException e) {

        }   
			
		
	}
	 class ConvertActListener implements ActionListener {         //Note 6
        public void actionPerformed(ActionEvent e) {

        	try{
 			hold_crn = (String)list1.getSelectedItem();
 			
 			room_solve = test.comparingRoom(test.allRoom(),test.notavailableRoom(hold_crn,hold_days));
		       	list2.removeAllItems();
		    	panel.remove(list2);
		       	if(room_solve.size() == 0)
		       	{
		       		list3 = new JTextField(20);
		       		list3.setEditable(false);
		       		list3.setText("NO ROOM AVAILABLE");
		       	}
		       	else
		       	{
					senior_select = new String[room_solve.size()];
			        for(int x = 0; x < room_solve.size();x++)
			        {
			        	String temp = "MBB"+room_solve.get(x);
			        	senior_select[x] = temp;
			        }
			        list2 = new JComboBox<>(senior_select);
			        list2.setEditable(false);
		       	}
		       	hold_time = (String)list2.getSelectedItem();
		       	if(room_solve.size() == 0)
		        	panel.add(list3, right);
		        else
		        	panel.add(list2,right);
		       }
		       catch(SQLException ex) {

        	}   
        }
    }
    class ConvertBtnListener implements ActionListener {         //Note 6
        public void actionPerformed(ActionEvent e) {
        	String t = (String)list1.getSelectedItem();
        	String r = (String)list2.getSelectedItem();
        	System.out.println(t+" "+r);
        	frame.dispose();
	        screen.start4(temp_crn, t, r, "YES",hold_days);

        }
    }
}
