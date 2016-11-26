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
	public void start3(String crn, String days)
	{
		try{
			List<String> all = test.getAllStartTime(days);
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			//JButton madLibButton = new JButton("Enter");
			//madLibButton.addActionListener(new ConvertBtnListener()); //Note 5

			JLabel title = new JLabel(" Please select time and room for this CRN: \""+crn+"\" on \""+days+"\". ");
			JLabel verbLabel1 = new JLabel("Time(senior priority): ");
			JLabel adjLabel = new JLabel("Room: ");

			List<String> day_select = new ArrayList<String>();
			for(int x = 0; x < all.size();x++)
			{
				if(test.number_of_psenior(crn,all.get(x),days) != 0)
				{
					day_select.add(all.get(x) + "  ["+test.number_of_psenior(crn,all.get(x),days)+" out of "+test.number_of_senior(crn)+" senior]");
				}
			}
			String[] day_select1 = new String[select_time.size()];
			for(int x = 0; x < day_select.size();x++)
			{
				day_select1[x] = day_select.get(x);
			}
			System.out.println(select_time);
			JComboBox<String> list1 = new JComboBox<>(day_select1);
			list1.setSelectedIndex(0);
			list1.setEditable(false);

			JComboBox<String> list2 = new JComboBox<>(day_select1);
			list2.setSelectedIndex(0);
		 	list2.setEditable(false);
			//frame.getContentPane().add(BorderLayout.SOUTH, madLibButton);
			frame.getContentPane().add(BorderLayout.NORTH, title);

			panel.setLayout(new GridBagLayout());
			panel.setBackground(Color.white);
			frame.getContentPane().add(panel);

			GridBagConstraints left = new GridBagConstraints();
			left.anchor = GridBagConstraints.EAST;
			        
			GridBagConstraints right = new GridBagConstraints();
			right.weightx = 2.0;
			right.fill = GridBagConstraints.HORIZONTAL;
			right.gridwidth = GridBagConstraints.REMAINDER;

			panel.add(verbLabel1, left);
			panel.add(list1, right);
			panel.add(adjLabel, left);
			panel.add(list2,right);

			panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			frame.pack();
			frame.setVisible(true);
			frame.setTitle("Move Class Project");
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);          // Center window.
		}
		catch(SQLException e) {

		}

	}
}