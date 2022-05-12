/* importing the libraries to run the program */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interface of the class
 **/

interface StudentInterface {

    void enrollCourses() throws IOException;

    void viewInstructor() throws IOException;


}

/**
 * the class that inherits the User class and implements the student interface
 **/
class Student extends User implements StudentInterface {


    public Student(String firstName, String lastName, String level, String studentId) {

        super(firstName, lastName, level, studentId);
    }

    /**
     * the override method inorder to enroll courses for the student
     **/
    @Override
    public void enrollCourses() throws FileNotFoundException {

        ArrayList<String> Course = new ArrayList<>();
        /*view the course from the course.txt */
        System.out.println("-----Courses-----");
        FileReader f1 = new FileReader("course.txt");
        Scanner s2 = new Scanner(f1);
        String[] d1 = null;

        while (s2.hasNextLine()) {
            String d = s2.nextLine();
            d1 = d.split("\t");
            System.out.println(d1[0]);
            Course.add(d1[0]);
        }

        /* message on which to choose at first */
        System.out.println("-------Choose to Add to the Course-------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");

        /*scanner class inorder to take input from the user */
        Scanner sc = new Scanner(System.in);
        int choice;
        choice = sc.nextInt();
        if (choice == 1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the course name");
            String course = in.nextLine();

            for (String m : Course) {
                if (m.equals(course)) {
                    if (!course.equals(d1[0])) {
                        this.courseName = course;

                        System.out.println("Enter your first name: ");
                        this.firstName = in.nextLine();

                        System.out.println("Enter your last name: ");
                        this.lastName = in.nextLine();

                        System.out.println("Enter the student id");
                        this.studentId = in.nextLine();

                        System.out.println("Enter the email address");
                        this.emailAddress = in.nextLine();

                        System.out.println("Enter the contact number");
                        this.contact = in.nextLine();


                        //for module in level 4,5 and 6
                        System.out.println("Enter your Level to add Module in  Course");
                        System.out.println("1.Level 4");
                        System.out.println("2.level 5");
                        System.out.println("3.level 6");
                        Scanner cs = new Scanner(System.in);
                        int l = cs.nextInt();
                        switch (l) {
                            case 1:
                                this.level = "4";
                                System.out.println("For level 4 ");
                                break;

                            case 2:
                                this.level = "5";
                                System.out.println("For level 5");

                                break;

                            case 3:
                                this.level = "6";
                                /* try catch method for reading the module from module1.txt  */
                                try {
                                    System.out.println("------ Module 1---------");
                                    FileReader file1 = new FileReader("module1.txt");
                                    Scanner scan = new Scanner(file1);
                                    while (scan.hasNextLine()) {
                                        String data = scan.nextLine();
                                        System.out.println(data);
                                    }

                                } catch (FileNotFoundException x) {
                                    x.printStackTrace();
                                }
                                /*condition to choose from 4 modules assigned by the course administration to choose two optional modules from module1.txt */
                                System.out.println("enter the two  optional modules you want to read:");
                                this.moduleName = in.nextLine();

                                System.out.println("enter the module id");
                                this.moduleId = in.nextLine();
                        }
                        /*inorder to write the information in the java */
                        FileOutputStream File1 = new FileOutputStream("student1.txt", true);
                        PrintWriter write1 = new PrintWriter(File1);

                        write1.print("course name:" + courseName + "\t\t");
                        write1.print("student id:" + studentId + "\t\t");
                        write1.print("first name:" + firstName + "\t\t");
                        write1.print("last name:" + lastName + "\t\t");
                        write1.print("email:" + emailAddress + "\t\t");
                        write1.print("contact:" + contact + "\t\t");
                        write1.print("level:" + level + "\t\t");
                        write1.print("module name:" + moduleName + "\t\t");
                        write1.print("module id:" + moduleId);
                        write1.println();
                        System.out.println("successfully added to the file");
                        write1.close();

                    }

                }
            }
            /* else if condition so that  you will be register in the course2 which will be added in student2.txt*/
        } else if (choice == 2) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the course name");
            String course = in.nextLine();


            for (String m : Course) {
                if (m.equals(course)) {
                    if (!course.equals(d1[1])) {
                        this.courseName = course;


                        System.out.println("Enter your first name: ");
                        this.firstName = in.nextLine();

                        System.out.println("Enter your last name: ");
                        this.lastName = in.nextLine();

                        System.out.println("Enter the student id");
                        this.studentId = in.nextLine();

                        System.out.println("Enter the email address");
                        this.emailAddress = in.nextLine();

                        System.out.println("Enter the contact number");
                        this.contact = in.nextLine();


                        System.out.println("Enter your Level to add Module in  Course");
                        System.out.println("1.Level 4");
                        System.out.println("2.level 5");
                        System.out.println("3.level 6");
                        Scanner cs = new Scanner(System.in);
                        int l = cs.nextInt();

                        switch (l) {
                            case 1 -> {
                                this.level = "4";
                                System.out.println("For level 4 ");
                            }
                            case 2 -> {
                                this.level = "5";
                                System.out.println("For level 5");

                            }
                            case 3 -> {
                                this.level = "6";
                                try {
                                    System.out.println("------ Module 2---------");
                                    FileReader file1 = new FileReader("module2.txt");
                                    Scanner scan = new Scanner(file1);
                                    while (scan.hasNextLine()) {
                                        String data = scan.nextLine();
                                        System.out.println(data);
                                    }

                                } catch (FileNotFoundException x) {
                                    x.printStackTrace();
                                }

                                /*condition to choose from 4 modules assigned by the course administration to choose two optional modules from module2.txt */
                                System.out.println("enter the two  optional modules you want to read:");
                                this.moduleName = in.nextLine();
                                System.out.println("enter the module id");
                                this.moduleId = in.nextLine();
                            }
                        }
                        /*inorder to write the information in the file  */
                        FileOutputStream File1 = new FileOutputStream("student2.txt", true);
                        PrintWriter write1 = new PrintWriter(File1);

                        write1.print("course name:" + courseName + "\t\t");
                        write1.print("student id:" + studentId + "\t\t");
                        write1.print("first name:" + firstName + "\t\t");
                        write1.print("last name:" + lastName + "\t\t");
                        write1.print("email:" + emailAddress + "\t\t");
                        write1.print("contact:" + contact + "\t\t");
                        write1.print("level:" + level + "\t\t");
                        write1.print("module name:" + moduleName + "\t\t");
                        write1.print("module id:" + moduleId);
                        write1.println();
                        System.out.println("------Successfully added to the file---------");
                        write1.close();


                    }
                }
            }
        }
    }

    /**
     * the override method inorder to view the instructor for the student
     **/
    @Override
    public void viewInstructor() {

        System.out.println("-------choose instructor on which the Course they are teaching---------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");
        /* if you choose 1 you will view the instructor from the module1.txt */
        Scanner sc = new Scanner(System.in);
        int choice;
        choice = sc.nextInt();
        if (choice == 1) {
            try {
                ArrayList<String> Instructor;
                Instructor = new ArrayList<>();
                System.out.println("------Instructor  and Module-----");
                FileReader file1 = new FileReader("module1.txt");
                Scanner scan = new Scanner(file1);

                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    Instructor.add(data);
                    String[] data1 = data.split("\t\t");
                    System.out.println(data1[1]);
                    System.out.println(data1[3]);
                    System.out.println(data1[4]);
                    System.out.println();
                }

            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }

            /* if you choose 2 you will view the instructor from the module2.txt */
        } else if (choice == 2) {
            try {
                ArrayList<String> Instructor;
                Instructor = new ArrayList<>();
                System.out.println("------Instructor  and Module-----");
                FileReader file1 = new FileReader("module2.txt");
                Scanner scan = new Scanner(file1);

                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    Instructor.add(data);
                    String[] data1 = data.split("\t\t");
                    System.out.println(data1[1]);
                    System.out.println(data1[3]);
                    System.out.println(data1[4]);
                    System.out.println();
                }

            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }
        }
    }
}















