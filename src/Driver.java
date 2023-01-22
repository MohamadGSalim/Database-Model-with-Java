package src;

public class Driver {
    public static void main(String[] args) {
        Students[] studentsArray = new Students[3];
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
        coursesEnrolledArray[4] = new CoursesEnrolled(222, "Comp353", "A-");

        queryQ(studentsArray, coursesArray, coursesEnrolledArray);
    }

    public static void queryQ(Students[] studentsArray, Courses[] coursesArray, CoursesEnrolled[] coursesEnrolledArray) {
        for (int i = 0; i < coursesEnrolledArray.length; i++) {
            for (int j = 0; j < coursesArray.length; j++) {
                if (coursesEnrolledArray[i].CID.equals(coursesArray[j].CID) && coursesArray[j].Name.equals("Databases")
                        && (coursesEnrolledArray[i].Grade.equals("B+") || coursesEnrolledArray[i].Grade.equals("A-")
                || coursesEnrolledArray[i].Grade.equals("A") || coursesEnrolledArray[i].Grade.equals("A+"))) {
                    for (int k = 0; k < studentsArray.length; k++) {
                        if (studentsArray[k].SID == coursesEnrolledArray[i].SID) {
                            System.out.println(studentsArray[k]);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
