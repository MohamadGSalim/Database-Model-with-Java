package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Students> studentsArray = new ArrayList<Students>();
        ArrayList<Courses> coursesArray = new ArrayList<Courses>();
        ArrayList<CoursesEnrolled> coursesEnrolledArray = new ArrayList<CoursesEnrolled>();
        String studentsFile = "students.txt";
        String coursesFile = "courses.txt";
        String coursesEnrolledFile = "coursesEnrolled.txt";

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(studentsFile));
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                Students obj1 = new Students(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                studentsArray.add(obj1);
            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader(coursesFile));
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                Courses obj2 = new Courses(data[0], data[1], Double.parseDouble(data[2]));
                coursesArray.add(obj2);
            }
            br2.close();

            BufferedReader br3 = new BufferedReader(new FileReader(coursesEnrolledFile));
            while ((line = br3.readLine()) != null) {
                String[] data = line.split(",");
                CoursesEnrolled obj3 = new CoursesEnrolled(Integer.parseInt(data[0]), data[1], data[2]);
                coursesEnrolledArray.add(obj3);
            }
            br3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*Students[] studentsArray = new Students[3];
        studentsArray[0] = new Students(111, "Joe", "CS", "45 Pine av.");
        studentsArray[1] = new Students(222, "Sue", "SE", "71 Main st.");
        studentsArray[2] = new Students(333, "Ann", "CE", "39 Bay st.");

        Courses[] coursesArray = new Courses[3];
        coursesArray[0] = new Courses("Comp352", "Data structures", 3);
        coursesArray[1] = new Courses("Soen390", "Mini capstone", 3.5);
        coursesArray[2] = new Courses("Comp353", "Databases", 4);

        CoursesEnrolled[] coursesEnrolledArray = new CoursesEnrolled[5];
        coursesEnrolledArray[0] = new CoursesEnrolled(111, "Comp352", "C+");
        coursesEnrolledArray[1] = new CoursesEnrolled(222, "Soen390", "A+");
        coursesEnrolledArray[2] = new CoursesEnrolled(333, "Comp353", "B+");
        coursesEnrolledArray[3] = new CoursesEnrolled(111, "Comp353", "B");
        coursesEnrolledArray[4] = new CoursesEnrolled(222, "Comp353", "A-");*/

        queryQ(studentsArray, coursesArray, coursesEnrolledArray);
    }

    public static void queryQ(ArrayList<Students> studentsArray, ArrayList<Courses> coursesArray,
                              ArrayList<CoursesEnrolled> coursesEnrolledArray) {
        for (int i = 0; i < coursesEnrolledArray.size(); i++) {
            for (int j = 0; j < coursesArray.size(); j++) {
                if (coursesEnrolledArray.get(i).CID.equals(coursesArray.get(j).CID) && coursesArray.get(j).Name.equals("Databases")
                        && (coursesEnrolledArray.get(i).Grade.equals("B+") || coursesEnrolledArray.get(i).Grade.equals("A-")
                || coursesEnrolledArray.get(i).Grade.equals("A") || coursesEnrolledArray.get(i).Grade.equals("A+"))) {
                    for (int k = 0; k < studentsArray.size(); k++) {
                        if (studentsArray.get(k).SID == coursesEnrolledArray.get(i).SID) {
                            System.out.println(studentsArray.get(k));
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
