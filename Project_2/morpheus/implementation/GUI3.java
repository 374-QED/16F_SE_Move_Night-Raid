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

public class GUI3{
	private static nrLib test = new nrLib();
	private static GUI4 screen = new GUI4();
	private JTextField list3;
	private JComboBox<String> list2;
	private JComboBox<String> list1;
	private String[] senior_select;
	List<String> room_solve1;
	private String hold_crn;
	private String temp_crn;
	private GridBagConstraints right;
	private String hold_days;
	private JPanel panel;
	private String hold_time;
	JFrame frame;
	public void start3(String crn, String days)
	{
		try{
			if(test.error_term(crn,days,"YES"))
			{
				temp_crn = crn;
				hold_days = days;
				List<String> all = test.getAllStartTime(days);
				frame = new JFrame();
				panel = new JPanel();
				JButton madLibButton = new JButton("Enter");
				madLibButton.addActionListener(new ConvertBtnListener()); //Note 5

				JLabel title = new JLabel(" Please select time and room for this CRN: \""+crn+"\" on \""+days+"\". ");
				JLabel verbLabel1 = new JLabel("Time(senior priority): ");
				JLabel adjLabel = new JLabel("Room: ");

				List<String> day_select = new ArrayList<String>();
				for(int x = 0; x < all.size();x++)
				{
					if((test.number_of_psenior(crn,all.get(x),days) == test.number_of_senior(crn)))
					{
		
						if(test.number_of_pstudent(crn,all.get(x),days) > 0)
							day_select.add(all.get(x) + "  ["+test.number_of_pstudent(crn,all.get(x),days)+" out of "+test.number_of_student(crn)+" students]");
					}
				}
				String[] day_select1 = new String[day_select.size()];
				for(int x = 0; x < day_select.size();x++)
				{
					day_select1[x] = day_select.get(x);
				}
				//System.out.println(select_time);
				list1 = new JComboBox<>(day_select1);
				list1.setEditable(false);
				list1.addActionListener(new ConvertActListener());
				room_solve1 = test.comparingRoom(test.allRoom(),test.notavailableRoom(test.get_first(day_select1[0]),days));
				for(int x = 0; x < room_solve1.size();x++)
		       	{
		       		if(test.compare_room(room_solve1.get(x),crn) == false)
		       			room_solve1.remove(x);
		       	}


				//System.out.println(room_solve1);
				if(room_solve1.size() == 0)
		       	{
		       		list3 = new JTextField(20);
		       		list3.setEditable(false);
		       		list3.setText("NO ROOM AVAILABLE");
		       	}
		       	else
		       	{
					senior_select = new String[room_solve1.size()];
			        for(int x = 0; x < room_solve1.size();x++)
			        {
			        	String temp = "MBB"+room_solve1.get(x);
			        	senior_select[x] = temp;
			        }
			        list2 = new JComboBox<>(senior_select);
			        list2.setEditable(false);
			        //list2.addActionListener(new ConvertSecListener());
		       	}
				frame.getContentPane().add(BorderLayout.SOUTH, madLibButton);
				frame.getContentPane().add(BorderLayout.NORTH, title);

				panel.setLayout(new GridBagLayout());
				Color purple = new Color(238, 130, 238);
        		//purple.getHSBColor(0.20f, 1f, 1f);
        		panel.setBackground(purple);
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
				if(room_solve1.size() == 0)
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
		}
		catch(SQLException e) {

		}

	}
	 class ConvertActListener implements ActionListener {         //Note 6
        public void actionPerformed(ActionEvent e) {

        	try{
 			hold_crn = (String)list1.getSelectedItem();
 			hold_crn = test.get_first(hold_crn);
 			room_solve1 = test.comparingRoom(test.allRoom(),test.notavailableRoom(hold_crn,hold_days));
		    for(int x = 0; x < room_solve1.size();x++)
		    {
		       	if(test.compare_room(room_solve1.get(x),hold_crn) == false)
		       		room_solve1.remove(x);
		     }
		    //System.out.println(room_solve1);
		    	list2.removeAllItems();
		    	panel.remove(list2);
		       	if(room_solve1.size() == 0)
		       	{
		       		list3 = new JTextField(20);
		       		list3.setEditable(false);
		       		list3.setText("NO ROOM AVAILABLE");
		       	}
		       	else
		       	{
		       		//System.out.println(room_solve1);
					senior_select = new String[room_solve1.size()];
			        for(int x = 0; x < room_solve1.size();x++)
			        {
			        	String temp = "MBB"+room_solve1.get(x);
			        	senior_select[x] = temp;
			        }
			        list2 = new JComboBox<>(senior_select);
			        list2.setEditable(false);
			        //list2.addActionListener(new ConvertSecListener());
		       	}
		       	if(room_solve1.size() == 0)
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
        	try{
	        	String t = (String)list1.getSelectedItem();
	        	String r = (String)list2.getSelectedItem();
	        	t = test.get_first(t);
	        	//System.out.println(t+" "+r);
	        	frame.dispose();
	        	screen.start4(temp_crn, t, r, "YES",hold_days);

        	}
        	catch(SQLException ex)
        	{

        	}
        }
    }
}