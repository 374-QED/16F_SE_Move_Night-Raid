package implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVparser {

	public List<String> parseClass(String course, String semester) {
		
		String csvFile = new File("resources\\course_name.csv").getAbsolutePath();
		BufferedReader br = null;
		String line = "";
		List<String> list = new ArrayList<String>();

		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(",");
                if((data[5]+data[6]).equals(course) && data[0].equals(semester))
                	list.add(data[2]+ " " + data[4]+ " " + data[3]);
        
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

	public List<String> parseStudent(String studentName) {
	// 	// Will parse the csv file, using the "studentID" argument
	// 	// to get an array of strings that contains the classes
	// 	// taken by this student
        String csvFile = new File("resources\\course_name.csv").getAbsolutePath();
        BufferedReader br = null;
        String line = "";
        List<String> list = new ArrayList<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String hold = "";
                // use comma as separator
                String[] data = line.split(",");
                if((data[2]+ " " + data[4]+ " " + data[3]).equals(studentName))
                	list.add(data[5]+data[6]);
            }
            list.remove(0);

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

	public List<String> parsePreReq(String preq) {
	// 	// Will parse the csv file, using the "class" argument
	// 	// to get an array of strings that contains the prerequisites
	// 	// of the class
    String csvFile = new File("resources\\prerequisites.csv").getAbsolutePath();
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
                    hold = data[1].replace("\"", "");
                    hold = hold.replaceAll("^\"|\"$", "");
                    list.add(hold);
            }
            list.remove(0);

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
    public List<String> parseSemester(String semester) {
    //  // Will parse the csv file, using the "class" argument
    //  // to get an array of strings that contains the prerequisites
    //  // of the class
    String csvFile = new File("resources\\prerequisites.csv").getAbsolutePath();
        BufferedReader br = null;
        String line = "";
        List<String> list = new ArrayList<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String hold = "";
                String[] data = line.split(",");
                if(data[0].replace("\"", "").equals(semester)) 
                    hold = data[2].replace("\"", "");
                    hold = hold.replaceAll("^\"|\"$", "");
                    list.add(hold);
            }
            list.remove(0);

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
     public List<String> parseUnique(int x, int y) {
    //  // Will parse the csv file, using the "class" argument
    //  // to get an array of strings that contains the prerequisites
    //  // of the class
    String csvFile = new File("resources\\course_name.csv").getAbsolutePath();
        BufferedReader br = null;
        String line = "";
        List<String> list = new ArrayList<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String course = "";
                String coursenum = "";
                String com = "";
                String[] data = line.split(",");
                course = data[x];
                coursenum = data[y];
                course = course.replaceAll("^\"|\"$", "");
                coursenum = coursenum.replaceAll("^\"|\"$", "");
                com = course+coursenum;
                if(list.contains(com) == false)
                    list.add(com);

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