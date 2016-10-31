package implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVparser {
    public String[] parseCourse(String name)
    {
        int t = 0;
        for(int x = 0; x < name.length();x++)
        {
            int hold = name.charAt(x);
            if(hold >= 48 && hold <= 58 && t==0)
            {
                t = x;
            }
        }
        String[] parts = {name.substring(0,t),name.substring(t)};
        return parts;
    }

	public List<String> parsePreReq(String preq) {
	// 	// Will parse the csv file, using the "class" argument
	// 	// to get an array of strings that contains the prerequisites
	// 	// of the class
    String csvFile = new File("resources/prereq.csv").getAbsolutePath();
        BufferedReader br = null;
        String line = "";
        List<String> list = new ArrayList<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String hold = "";
                String[] data = line.split(",");
                if(data[0].replace("\"", "").equals(preq))
                { 
                    hold = data[1].replace("\"", "");
                    hold = hold.replaceAll("^\"|\"$", "");
                    list.add(hold);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
	}
	
}