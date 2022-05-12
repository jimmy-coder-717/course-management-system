/*importing the libraries to run the program */

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * interface class for the courseAdministration class
 **/
interface CourseAdminInterface {
    void newCourse() throws IOException;

    void deleteCourse() throws IOException;

    void addModule() throws IOException;

    void removeInstructor() throws IOException;

    void updateModule() throws IOException;

    void updateCourse() throws IOException;

    void reportSlip() throws FileNotFoundException;


}

/*class administration that extends the user and implements the courseAdmin interface  */
class CourseAdministration extends User implements CourseAdminInterface {

    /* the super class inorder to login */
    public CourseAdministration() {
        super();
        this.adminId = "Jimmy";
        this.adminPass = "zero";

    }


    /**
     * the override method inorder to add new course
     **/
    @Override
    public void newCourse() throws IOException {
        /*to make a text file  */
        FileOutputStream File1 = new FileOutputStream("course.txt", true);

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the course name: ");
        this.courseName = in.nextLine();

        System.out.println("Enter the course ID: ");
        this.courseId = in.nextLine();


        /* the code enables to write in the text file */
        PrintWriter write1 = new PrintWriter(File1);


        write1.print(courseName + "\t\t");
        write1.print(courseId);
        write1.println();


        System.out.println("----------The Course has been Successfully Added-----------");
        write1.close();


    }

    /**
     * the override method inorder to delete the  courses
     **/
    @Override
    public void deleteCourse() {
        /*view the course from the course.txt */

        ArrayList<String> Course;
        try {
            Course = new ArrayList<>();
            System.out.println("----For course---- ");
            FileReader file1 = new FileReader("course.txt");
            Scanner scan = new Scanner(file1);

            while (scan.hasNextLine()) {


                String data = scan.nextLine();
                Course.add(data);
                String[] data1 = data.split("\t\t");
                System.out.println(data1[0]);
            }
            System.out.println(Course);
            System.out.println("----------Which course you would like to delete?-------");
            Scanner s1 = new Scanner(System.in);
            String s = s1.next();

            /* the condition for deleting the course contents from course.txt */
            for (int i = 0; i < Course.size(); i++) {

                String[] data1 = Course.get(i).split("\t\t");

                if (data1[0].equals(s)) {
                    Course.remove(i);
                    FileOutputStream File1 = new FileOutputStream("course.txt");
                    PrintWriter write1 = new PrintWriter(File1);
                    Iterator itr = Course.iterator();
                    while (itr.hasNext()) {
                        write1.println(itr.next());
                    }
                    System.out.println("------The course has been successfully deleted--------");
                    write1.close();
                }
            }


        } catch (FileNotFoundException x) {
            x.printStackTrace();

        }
    }


    /**
     * the override method inorder to add modules
     **/

    @Override
    public void addModule() throws IOException {
        ArrayList<String> Module = new ArrayList<>();
        /*view the course from the course.txt */
        System.out.println("-----Courses-----");
        FileReader f1 = new FileReader("course.txt");
        Scanner s2 = new Scanner(f1);
        String[] d1 = null;

        while (s2.hasNextLine()) {
            String d = s2.nextLine();
            d1 = d.split("\t");
            System.out.println(d1[0]);
            Module.add(d1[0]);
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
            /* condition to check the available course.If the course is not available the details cannot be added in the file */
            for (String m : Module) {
                if (m.equals(course)) {
                    if (!course.equals(d1[0])) {
                        this.courseName = course;

                        System.out.println("Enter your Instructor name: ");
                        this.instructorName = in.nextLine();


                        /*switch case for module in level 4,5 and 6*/
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
                                System.out.println("Enter the module name: ");
                                this.moduleName = in.nextLine();
                                System.out.println("Enter the module ID: ");
                                this.moduleId = in.nextLine();

                            case 2:
                                this.level = "5";
                                System.out.println("For level 5");
                                System.out.println("Enter the module name: ");
                                this.moduleName = in.nextLine();
                                System.out.println("Enter the module ID: ");
                                this.moduleId = in.nextLine();

                            case 3:
                                this.level = "6";
                                System.out.println("For level 6");
                                System.out.println("Enter the four module name you want to add:");
                                this.moduleName = in.nextLine();
                                System.out.println("Enter the module id");
                                this.moduleId = in.nextLine();
                        }
                    }

                /*  the code enables to write in the module1.text file */
                FileOutputStream File1 = new FileOutputStream("module1.txt", true);
                PrintWriter write1 = new PrintWriter(File1);

                write1.print("course name:" + courseName + "\t\t");
                write1.print("module name:" + moduleName + "\t\t");
                write1.print("module id:" + moduleId + "\t\t");
                write1.print("instructor name:" + instructorName + "\t\t");
                write1.print("level:" + level);
                write1.println();

                System.out.println("-------Module is successfully added to the database--------");
                write1.close();

            }
        }
            }


        else if (choice == 2) {
            /*scanner class inorder to take input from the keyboard */
            Scanner in = new Scanner(System.in);

            System.out.println("Enter the course name");
            String course = in.nextLine();
            /* condition to check the available course.If the course is not available the details cannot be added in the file */


            for (String m : Module) {
                if (m.equals(course)) {
                    if (!course.equals(d1[1])) {
                        this.courseName = course;

                        System.out.println("Enter your Instructor name: ");
                        this.instructorName = in.nextLine();


                        /*switch case for module in level 4,5 and 6*/
                        System.out.println("Enter your Level to add Module in  Course");
                        System.out.println("1.Level 4");
                        System.out.println("2.level 5");
                        System.out.println("3.level 6");
                        Scanner cs = new Scanner(System.in);
                        int l = cs.nextInt();

                        switch (l) {
                            case 1 :
                                this.level = "4";
                                System.out.println("For level 4 ");
                                System.out.println("Enter the module name: ");
                                this.moduleName = in.nextLine();
                                System.out.println("Enter the module ID: ");
                                this.moduleId = in.nextLine();

                            case 2 :
                                this.level = "5";
                                System.out.println("For level 5");
                                System.out.println("Enter the module name: ");
                                this.moduleName = in.nextLine();
                                System.out.println("Enter the module ID: ");
                                this.moduleId = in.nextLine();

                            case 3 :
                                this.level = "6";
                                System.out.println("For level 6");
                                System.out.println("Enter the four module name you want to add:");
                                this.moduleName = in.nextLine();
                                System.out.println("Enter the module id");
                                this.moduleId = in.nextLine();
                            }
                        }
                        /*
                        /*  the code enables to write in the module2.text file */
                        FileOutputStream File1 = new FileOutputStream("module2.txt", true);
                        PrintWriter write1 = new PrintWriter(File1);

                        write1.print("course name:" + courseName + "\t\t");
                        write1.print("module name:" + moduleName + "\t\t");
                        write1.print("module id:" + moduleId + "\t\t");
                        write1.print("instructor name:" + instructorName + "\t\t");
                        write1.print("level:" + level);
                        write1.println();

                        System.out.println("-------Module is successfully added to the database---------");
                        write1.close();

                    }
                }
            }

        }


    /* the override method to remove the instructor from the course*/
    @Override
    public void removeInstructor() {
        System.out.println("------choose the Course--------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");

        Scanner cs = new Scanner(System.in);
        int choose;
        choose = cs.nextInt();

        if (choose == 1) {
            ArrayList<String> Instructor;
            try {
                /* condition to view the Instructor from the module1.txt */
                Instructor = new ArrayList<>();
                System.out.println("------For instructor------ ");
                FileReader file1 = new FileReader("module1.txt");
                Scanner scan = new Scanner(file1);

                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    Instructor.add(data);
                    String[] data1 = data.split("\t\t");
                    System.out.println(data1[3]);
                }
                /*delete the Instructor by entering the instructor name from module1 .txt */
                System.out.println(Instructor);
                System.out.println("-----which module instructor you would like to delete?-------");
                Scanner s1 = new Scanner(System.in);
                String s = s1.nextLine();

                String v = "instructor name" + ":" + s;

                /*the delete method in the file  */
                FileOutputStream File1 = new FileOutputStream("module1.txt");
                PrintWriter write1 = new PrintWriter(File1);
                for (int i = 0; i < Instructor.size(); i++) {
                    String[] data1 = Instructor.get(i).split("\t\t");
                    if (!data1[3].equals(v)) {
                        write1.println(Instructor.get(i));


                    }

                }
                System.out.println("---------The Module Instructor has been successfully deleted---------");
                System.out.println(Instructor);

                write1.close();


            } catch (FileNotFoundException x) {
                x.printStackTrace();

            }
        } else if (choose == 2) {
            ArrayList<String> Instructor;
            try {
                /* condition to view the Instructor from the module2.txt */
                Instructor = new ArrayList<>();
                System.out.println("------For instructor------ ");
                FileReader file1 = new FileReader("module2.txt");
                Scanner scan = new Scanner(file1);

                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    Instructor.add(data);
                    String[] data1 = data.split("\t\t");
                    System.out.println(data1[3]);
                }
                /*Delete the Instructor by entering the instructor name from module2 .txt */
                System.out.println(Instructor);
                System.out.println("which module instructor you would like to delete");
                Scanner s1 = new Scanner(System.in);
                String s = s1.nextLine();
                String v = "instructor name" + ":" + s;

                /*the delete method in the file  */
                FileOutputStream File1 = new FileOutputStream("module2.txt");
                PrintWriter write1 = new PrintWriter(File1);
                for (int i = 0; i < Instructor.size(); i++) {
                    String[] data1 = Instructor.get(i).split("\t\t");
                    if (!data1[3].equals(v)) {
                        write1.println(Instructor.get(i));

                    }
                }
                System.out.println("-------The Module Instructor has been successfully deleted--------");
                System.out.println(Instructor);

                write1.close();
            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }
        }
    }


    /**
     * the override method inorder to update the module
     **/
    @Override
    public void updateModule() throws IOException {

        System.out.println("----choose the Course----");
        System.out.println("1.Course1");
        System.out.println("2.Course2");

        Scanner cs = new Scanner(System.in);
        int choose;
        choose = cs.nextInt();

        /*the module to update from the module1.txt */
        if (choose == 1) {
            /*view the module from module1.txt */
            ArrayList<String> Module = new ArrayList<>();
            System.out.println("-----Module Available-----");
            BufferedReader bufReader = new BufferedReader(new FileReader("module1.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                Module.add(line);
                line = bufReader.readLine();
            }
            System.out.println(Module);

            try {
                /* the condition to replace one with the other module from module1.txt */
                FileReader f1 = new FileReader("module1.txt");
                Scanner s1 = new Scanner(f1);
                StringBuffer buffer = new StringBuffer();
                while (s1.hasNextLine()) {
                    buffer.append(s1.nextLine() + System.lineSeparator());
                }
                String fileContents = buffer.toString();
                Scanner s = new Scanner(System.in);
                System.out.println("------Choose module to update-----");
                String oldcourse = s.nextLine();
                System.out.println("-----Enter the new module to update------");
                String newcourse = s.nextLine();
                String oldCourse = "module name:" + oldcourse;
                String newCourse = "module name:" + newcourse;

                FileOutputStream File1 = new FileOutputStream("module1.txt");
                PrintWriter write = new PrintWriter(File1);
                fileContents = fileContents.replaceAll(oldCourse, newCourse);

                //instantiating the FileWriter class
                FileWriter writer = new FileWriter("module1.txt");
                System.out.println();
                System.out.println(fileContents);
                writer.write(fileContents);
                writer.flush();
                System.out.println("-----The Module is updated--------");
                write.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            /*the module to update from the module2.txt */
        } else if (choose == 2) {
            ArrayList<String> Module = new ArrayList<>();
            /*view the module from module2.txt */
            System.out.println("------Module Available------");
            BufferedReader bufReader = new BufferedReader(new FileReader("module2.txt"));
            String line = bufReader.readLine();
            while (line != null) {
                Module.add(line);
                line = bufReader.readLine();
            }
            System.out.println(Module);

            try {
                /* the condition to replace one with the other module from module2.txt */
                FileReader f1 = new FileReader("module2.txt");
                Scanner s1 = new Scanner(f1);
                StringBuffer buffer = new StringBuffer();
                while (s1.hasNextLine()) {
                    buffer.append(s1.nextLine() + System.lineSeparator());
                }
                String fileContents = buffer.toString();
                Scanner s = new Scanner(System.in);
                System.out.println("choose Module to update");
                String oldcourse = s.nextLine();
                System.out.println("Enter the New Module to update");
                String newcourse = s.nextLine();
                String oldCourse = "module name:" + oldcourse;
                String newCourse = "module name:" + newcourse;

                FileOutputStream File1 = new FileOutputStream("module2.txt");
                PrintWriter write = new PrintWriter(File1);
                fileContents = fileContents.replaceAll(oldCourse, newCourse);
                //instantiating the FileWriter class
                FileWriter writer = new FileWriter("module2.txt");
                System.out.println("");
                System.out.println(fileContents);
                writer.write(fileContents);
                writer.flush();
                System.out.println("-------The Module is updated ---------");
                write.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
    }

    /* method to update the course*/
    @Override
    public void updateCourse() throws IOException {
        ArrayList<String> Course = new ArrayList<>();
        System.out.println("------Courses Available-------");
        /*view the module from course.txt */
        BufferedReader bufReader = new BufferedReader(new FileReader("course.txt"));
        String line = bufReader.readLine();
        while (line != null) {
            Course.add(line);
            line = bufReader.readLine();
        }
        System.out.println(Course);

        try {
            /* the condition to replace one with the other module from course.txt */
            FileReader f1 = new FileReader("course.txt");
            Scanner s1 = new Scanner(f1);
            StringBuilder buffer = new StringBuilder();
            while (s1.hasNextLine()) {
                buffer.append(s1.nextLine()).append(System.lineSeparator());
            }
            String fileContents = buffer.toString();
            Scanner s = new Scanner(System.in);
            System.out.println("-----Choose Course to update------");
            String oldcourse = s.nextLine();
            System.out.println("-------Enter the new Course to be  updated---------");
            String newcourse = s.nextLine();

            FileOutputStream File1 = new FileOutputStream("course.txt");
            PrintWriter write = new PrintWriter(File1);
            fileContents = fileContents.replaceAll(oldcourse, newcourse);
            //instantiating the FileWriter class
            FileWriter writer = new FileWriter("course.txt");
            System.out.println("");
            System.out.println(fileContents);
            writer.write(fileContents);
            writer.flush();
            System.out.println("-------The Course is updated ---------- ");
            write.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * the override method inorder to generate the report slip of the student looking from the marks.txt the instructor created
     * and display in the console
     **/
    @Override
    public void reportSlip() throws FileNotFoundException {
        System.out.println("-------choose the Course inorder to generate the Report slips--------");
        System.out.println("1.Course1");
        System.out.println("2.Course2");

        Scanner sn = new Scanner(System.in);
        int choice;
        choice = sn.nextInt();
        if (choice == 1) {
            try {
                /* view the marks from module1*/
                FileReader file1 = new FileReader("Marks1.txt");
                Scanner scan = new Scanner(file1);
                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    System.out.println(data);
                }

            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }

            /* insert the information that is needed to make the result slip*/

            int[] sub;
            int i;
            int total = 0;
            float per = 0.0f;
            Scanner in;
            sub = new int[4];
            in = new Scanner(System.in);
            System.out.println("Enter the student name");
            this.firstName = in.nextLine();

            System.out.println("Enter student id:");
            this.studentId = in.nextLine();

            System.out.println("Enter course name:");
            this.courseName = in.nextLine();

            System.out.println("Enter the level:");
            this.level = in.nextLine();
            /* for entering the marks of the module and calculate*/
            for (i = 0; i < 4; i++) {
                System.out.println("Enter marks of module:" + (i + 1));
                sub[i] = in.nextInt();
                total = total + sub[i];

            }
            /* for calculating the percent from the entered marks*/
            per = total * 100 / 400;
            /* for displaying the information you just entered before*/
            System.out.println("\n***** Details Of Student *****\n");
            System.out.println("student name:" + firstName);
            System.out.println("student id:" + studentId);
            System.out.println("course name:" + courseName);
            System.out.println("level:" + level);

            /* for displaying the total marks and percentage gained by the student*/
            System.out.println("Total Marks Gained Is :" + total);
            System.out.println("Percentage Gained Is :" + per);

            if (per > 90)
                System.out.println("Your Grade Is A+.Proceed to next Level");
            else if (per > 80 && per < 90)
                System.out.println("Your Grade Is A.Proceed to next Level");
            else if (per > 70 && per < 80)
                System.out.println("Your Grade Is B+.Proceed to next Level");
            else if (per > 60 && per < 70)
                System.out.println("Your Grade Is B.Proceed to next Level");
            else if (per > 50 && per < 60)
                System.out.println("Your Grade Is C+.Proceed to next Level");
            else if (per > 40 && per < 50)
                System.out.println("Your Grade Is C.Proceed to next Level");
            else
                System.out.println("You are Failed you cannot proceed to next level");

            /*for writing the data in the file  */
            FileOutputStream File = new FileOutputStream("ResultSlip.txt", true);
            PrintWriter write = new PrintWriter(File);
            write.println("-------Result Slip---------");
            write.println("student name:" + firstName);
            write.println("student id:" + studentId);
            write.println("course name:" + courseName);
            write.println("level:" + level);
            write.println("Total Marks Gained Is :" + total);
            write.println("Percentage Gained Is :" + per);
            if (per > 90)
                write.println("Your Grade Is A+.Proceed to next Level");
            else if (per > 80 && per < 90)
                write.println("Your Grade Is A.Proceed to next Level");
            else if (per > 70 && per < 80)
                write.println("Your Grade Is B+.Proceed to next Level");
            else if (per > 60 && per < 70)
                write.println("Your Grade Is B.Proceed to next Level");
            else if (per > 50 && per < 60)
                write.println("Your Grade Is C+.Proceed to next Level");
            else if (per > 40 && per < 50)
                write.println("Your Grade Is C.Proceed to next Level");
            else
                write.println("You are Failed you cannot proceed to next level");
            write.println();

            write.close();

            System.out.println("--------Report slip have been generated---------");
        } else if (choice == 2) {
            try {
                /*for generating the marks from module2.txt */
                FileReader file1 = new FileReader("Marks2.txt");
                Scanner scan = new Scanner(file1);
                while (scan.hasNextLine()) {
                    String data = scan.nextLine();
                    System.out.println(data);
                }

            } catch (FileNotFoundException x) {
                x.printStackTrace();
            }

            /* insert the information that is needed to make the result slip*/

            int[] sub;
            int i;
            int total = 0;
            float per = 0.0f;
            Scanner in;
            sub = new int[4];
            in = new Scanner(System.in);
            System.out.println("Enter the student name:");
            this.firstName = in.nextLine();

            System.out.println("Enter student id:");
            this.studentId = in.nextLine();

            System.out.println("Enter course name:");
            this.courseName = in.nextLine();

            System.out.println("Enter the level:");
            this.level = in.nextLine();
            /* for entering the marks of the module and calculate*/
            for (i = 0; i < 4; i++) {
                System.out.println("Enter marks of module:" + (i + 1));
                sub[i] = in.nextInt();
                total = total + sub[i];

            }
            /* for calculating the percent from the entered marks*/
            per = total * 100 / 400;
            /* for displaying the information you just entered before*/
            System.out.println("\n***** Details Of Student *****\n");
            System.out.println("student name:" + firstName);
            System.out.println("student id:" + studentId);
            System.out.println("course name:" + courseName);
            System.out.println("level:" + level);

            /* for displaying the total marks and percentage gained by the student*/
            System.out.println("Total Marks Gained Is :" + total);
            System.out.println("Percentage Gained Is :" + per);

            if (per > 90)
                System.out.println("Your Grade Is A+.Proceed to next Level");

            else if (per > 80 && per < 90)
                System.out.println("Your Grade Is A.Proceed to next Level");
            else if (per > 70 && per < 80)
                System.out.println("Your Grade Is B+.Proceed to next Level");
            else if (per > 60 && per < 70)
                System.out.println("Your Grade Is B.Proceed to next Level");
            else if (per > 50 && per < 60)
                System.out.println("Your Grade Is C+.Proceed to next Level");
            else if (per > 40 && per < 50)
                System.out.println("Your Grade Is C.Proceed to next Level");
            else
                System.out.println("You are Failed you cannot proceed to next level");

            /*for writing the data in the file  */
            FileOutputStream File = new FileOutputStream("ResultSlip.txt", true);
            PrintWriter write = new PrintWriter(File);
            write.println("-------Result Slip---------");
            write.println("student name:" + firstName);
            write.println("student id:" + studentId);
            write.println("course name:" + courseName);
            write.println("level:" + level);
            write.println("Total Marks Gained Is :" + total);
            write.println("Percentage Gained Is :" + per);
            if (per > 90)
                write.println("Your Grade Is A+.Proceed to next Level");
            else if (per > 80 && per < 90)
                write.println("Your Grade Is A.Proceed to next Level");
            else if (per > 70 && per < 80)
                write.println("Your Grade Is B+.Proceed to next Level");
            else if (per > 60 && per < 70)
                write.println("Your Grade Is B.Proceed to next Level");
            else if (per > 50 && per < 60)
                write.println("Your Grade Is C+.Proceed to next Level");
            else if (per > 40 && per < 50)
                write.println("Your Grade Is C.Proceed to next Level");
            else
                write.println("You are Failed you cannot proceed to next level");
            write.println();
            write.close();

            System.out.println(" ------Report slip have been generated--------");
        }
    }
}



