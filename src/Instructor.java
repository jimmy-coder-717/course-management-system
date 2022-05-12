/* importing the libraries to run the program */

import java.io.*;
import java.util.*;

/**
 * interface class for the instructor class
 **/
interface InstructorInterface {
    void viewModule() throws IOException;

    void viewStudents() throws IOException;

    void addMarks() throws IOException;

}

/**
 * class instructor that extends the user and implements the instructor interface
 **/
class Instructor extends User implements InstructorInterface {


    public Instructor(String InstructorName, String level) {

        super(InstructorName, level);
    }

    /**
     * the method that helps the instructor to view the module
     **/
    @Override
    public void viewModule() throws IOException {


        System.out.println("------Choose the module--------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");

        /*the scanner class inorder to choose the course from 1 or 2   */
        Scanner sc = new Scanner(System.in);

        int choice;
        choice = sc.nextInt();
        if (choice == 1) {
            ArrayList<String> Module = new ArrayList<>();
            /*to find those modules which they teach from module1.txt*/
            Scanner j = new Scanner(System.in);

            System.out.println(" Enter the Instructor Name");

            String name = j.nextLine();
            String v = "instructor name" + ":" + name;

            BufferedReader bufReader = new BufferedReader(new FileReader("module1.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                Module.add(line);
                line = bufReader.readLine();
            }

            for (int i = 0; i < Module.size(); i++) {
                String[] data1 = Module.get(i).split("\t\t");


                if (data1[3].equals(v)) {
                    System.out.println(Module.get(i));

                    System.out.println("------Instructor has been showed-------");

                }
            }
        }


        /*to find  those modules which they teach from module2.txt*/
        else if (choice == 2) {

            try {
                ArrayList<String> Module = new ArrayList<>();


                Scanner j = new Scanner(System.in);

                System.out.println(" Enter the Instructor Name");
                /* the condition to search the instructor for the module*/
                String name = j.nextLine();
                String v = "instructor name" + ":" + name;
                BufferedReader bufReader = new BufferedReader(new FileReader("module2.txt"));
                String line = bufReader.readLine();
                while (line != null) {
                    Module.add(line);
                    line = bufReader.readLine();
                }

                for (int i = 0; i < Module.size(); i++) {
                    String[] data1 = Module.get(i).split("\t\t");


                    if (data1[3].equals(v)) {
                        System.out.println(Module.get(i));

                        System.out.println("-----Instructor has been showed-----");

                    }
                }


            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }
        }
    }


    /**
     * the method that helps the instructor to view the student
     **/
    @Override
    public void viewStudents() throws IOException {

        System.out.println("------Choose your Course--------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");

        /*the scanner class inorder to choose the module from 1 or 2   */
        Scanner sc = new Scanner(System.in);
        int choice;
        choice = sc.nextInt();
        if (choice == 1) {
            /* to search the student who have been enroll in student1.txt */
            ArrayList<String> Student = new ArrayList<>();
            Scanner kb = new Scanner(System.in);

            System.out.println(" -----Enter the Student Name-------");

            /* the condition to search the student */
            String name = kb.nextLine();
            String v = "first name" + ":" + name;

            BufferedReader bufReader = new BufferedReader(new FileReader("student1.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                Student.add(line);
                line = bufReader.readLine();
            }

            for (int i = 0; i < Student.size(); i++) {
                String[] data1 = Student.get(i).split("\t\t");


                if (data1[2].equals(v)) {
                    System.out.println(Student.get(i));

                    System.out.println("-----Student has been showed-------");

                }
            }


        } else if (choice == 2) {
            /*  to search the student who have been enroll in student2.txt*/
            ArrayList<String> Student = new ArrayList<>();
            Scanner kb = new Scanner(System.in);

            /* the condition to search the student */
            System.out.println(" -----Enter the Student Name-------");

            String name = kb.nextLine();
            String v = "first name" + ":" + name;

            BufferedReader bufReader = new BufferedReader(new FileReader("student2.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                Student.add(line);
                line = bufReader.readLine();
            }

            for (int i = 0; i < Student.size(); i++) {
                String[] data1 = Student.get(i).split("\t\t");


                if (data1[2].equals(v)) {
                    System.out.println(Student.get(i));

                    System.out.println("-----Student has been showed-------");

                }
            }

        }
    }

    /**
     * the method that helps the instructor to add the marks of the module
     **/
    @Override
    public void addMarks() throws IOException {
        ArrayList<String> Marks = new ArrayList<>();
        /*view the course from the course.txt */
        System.out.println("-----Courses-----");
        FileReader f1 = new FileReader("course.txt");
        Scanner s2 = new Scanner(f1);
        String[] d1 = null;

        while (s2.hasNextLine()) {
            String d = s2.nextLine();
            d1 = d.split("\t");
            System.out.println(d1[0]);

            Marks.add(d1[0]);
        }

        System.out.println("-----Choose your Student from course-------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");
        /*the scanner class inorder to write  the marks  in marks1.txt and marks2.txt  */
        Scanner sc = new Scanner(System.in);
        int chose;
        chose = sc.nextInt();
        if (chose == 1) {

            try {
                FileReader file1 = new FileReader("student1.txt");
                Scanner scan = new Scanner(file1);
                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    System.out.println(data);
                }

            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }
            /*inorder to write the marks in Marks1.txt who have been enroll in module1*/
            FileOutputStream File = new FileOutputStream("Marks1.txt", true);
            PrintWriter write = new PrintWriter(File);

            Scanner in = new Scanner(System.in);

            System.out.println("Enter the course name: ");
            String course = in.nextLine();

            /* condition to check the available course.If the course is not available the details cannot be added in the file */

            for (String m : Marks) {
                if (m.equals(course)) {
                    if (!course.equals(d1[0])) {
                        this.courseName = course;

                        System.out.println("Enter the name of the student id:");
                        this.studentId = in.nextLine();

                        System.out.println("Enter the name of the student:");
                        this.firstName = in.nextLine();

                        System.out.println("Enter the level:");
                        this.level = in.nextLine();

                        Scanner Module1 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 1:");
                        int m1 = Module1.nextInt();

                        Scanner Module2 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 2:");
                        int m2 = Module2.nextInt();

                        Scanner Module3 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 3:");
                        int m3 = Module3.nextInt();

                        Scanner Module4 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 4:");
                        int m4 = Module4.nextInt();

                        /* the code enables to write in the text file */
                        write.println("****Marks Obtained***");
                        write.println("course name:" + courseName);
                        write.println("Student Id :" + studentId);
                        write.println("student name:" + firstName);
                        write.println("level:" + level);
                        write.println("Module 1 :" + m1);
                        write.println("Module 2 :" + m2);
                        write.println("Module 3 :" + m3);
                        write.println("Module 4 :" + m4);
                        write.println();
                        System.out.println("----- Marks is added----");
                        write.close();
                    }
                }
            }
        } else if (chose == 2) {
            /*view students from student2.txt file*/
            try {
                FileReader file1 = new FileReader("student2.txt");
                Scanner scan = new Scanner(file1);
                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    System.out.println(data);
                }

            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }
            /*inorder to write the marks in marks2.txt who have been enroll in module2*/
            FileOutputStream File = new FileOutputStream("Marks2.txt", true);
            PrintWriter write = new PrintWriter(File);

            /*scanner class inorder to take the input from the instructor */
            Scanner in = new Scanner(System.in);

            System.out.println("Enter the course name:");
            String course = in.nextLine();

            /* condition to check the available course.If the course is not available the details cannot be added in the file */

            for (String m : Marks) {
                if (m.equals(course)) {
                    if (!course.equals(d1[1])) {
                        this.courseName = course;

                        System.out.println("Enter the name of the student id:");
                        this.studentId = in.nextLine();

                        System.out.println("Enter the name of the student:");
                        this.firstName = in.nextLine();

                        System.out.println("Enter the level:");
                        this.level = in.nextLine();


                        Scanner Module1 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 1:");
                        int m1 = Module1.nextInt();

                        Scanner module2 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 2:");
                        int m2 = module2.nextInt();

                        Scanner module3 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 3:");
                        int m3 = module3.nextInt();

                        Scanner module4 = new Scanner(System.in);
                        System.out.println("Enter the marks obtained in module 4:");
                        int m4 = module4.nextInt();
                        /* the code enables to write in the text file */
                        write.println("****Marks Obtained***");
                        write.println("course name:" + courseName);
                        write.println("Student Id :" + studentId);
                        write.println("student name:" + firstName);
                        write.println("level:" + level);
                        write.println("Module 1:" + m1);
                        write.println("Module 2:" + m2);
                        write.println("Module 3:" + m3);
                        write.println("Module 4:" + m4);
                        write.println();
                        System.out.println("----Marks is added------");
                        write.close();
                    }

                }
            }
        }
    }
}




