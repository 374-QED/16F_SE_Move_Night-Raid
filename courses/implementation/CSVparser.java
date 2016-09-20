package implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVparser {

	public List<String> parseClass(String course) {
		
		String csvFile = "C:\\Users\\aldo_\\OneDrive\\Documents\\GitHub\\F16_CS374_Night-Raid\\courses\\resources\\courses.csv";
		BufferedReader br = null;
		String line = "";
		List<String> list = new ArrayList<String>();

		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(",");
                if(data[2].equals(course)) {
                	list.add(data[1]);
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

	// public String[] parseStudent(String studentID) {
	// 	// Will parse the csv file, using the "studentID" argument
	// 	// to get an array of strings that contains the classes
	// 	// taken by this student
	// }

	// public String[] parsePreReq(String class) {
	// 	// Will parse the csv file, using the "class" argument
	// 	// to get an array of strings that contains the prerequisites
	// 	// of the class
	// }

	
}