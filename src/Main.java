/*importing the libraries which is required to run the program */

import java.io.*;
import java.util.Scanner;


public class Main {


    /*the main class to be run from here  */
    public static void main(String[] args) throws IOException {
        CourseAdministration courseAdministration = new CourseAdministration();

        /*the first to be inputted after the program is run/ to chose which you want to login */
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Course Management System!");
        System.out.println("'1' to login as Course Administration");
        System.out.println("'2' to login as Instructor");
        System.out.println("'3' to login as Student");
        System.out.println("'4' to Exit");
        String option = in.nextLine();

        while (!option.contentEquals("1") && !option.contentEquals("2") && !option.contentEquals("3") && !option.contentEquals("4")) {
            System.out.println("Incorrect!!");
            System.out.println("'1' to login as Course Administration");
            System.out.println("'2' to login as Instructor");
            System.out.println("'3' to login as Student");
            System.out.println("'4' to Exit");
            option = in.nextLine();
        }

        /*inorder to enter the username and password of the admin */
        if (option.contentEquals("1")) {

            System.out.println("Enter Course Administration username:");
            String userInput = in.nextLine();
            System.out.println("Enter Course Administration password:");
            String passInput = in.nextLine();

            /* the error message if the user name and password becomes incorrect  */
            while (!userInput.contentEquals("Jimmy") || !passInput.contentEquals("zero")) {
                if (!userInput.contentEquals("Jimmy")) {
                    System.out.println("Incorrect username! Try again.");
                    System.out.println("Enter Course Administration username:");
                    userInput = in.nextLine();
                    System.out.println("Enter Course Administration password:");
                    passInput = in.nextLine();
                } else if (!passInput.contentEquals("zero")) {
                    System.out.println("Incorrect password! Try again.");


                    System.out.println("Enter the Course Administration username:");
                    userInput = in.nextLine();
                    System.out.println("Enter the Course Administration password:");
                    passInput = in.nextLine();
                }
            }

            System.out.println(" You have been  logged in as an Course Administration!");
            boolean logout = false;
            while (!logout) {


                /*when you enter 1 you will be able to do the following */
                System.out.println("What would you like to do today?");
                System.out.println("'1' to Create a New course");
                System.out.println("'2' to Delete a course");
                System.out.println("'3' to Add a Module");
                System.out.println("'4' to Update module");
                System.out.println("'5' to Remove instructor");
                System.out.println("'6' to update course");
                System.out.println("'7' to Generate Report");
                System.out.println("'8' to Exit");

                String option3 = in.nextLine();

                /*from the override method that we made inside the  courseAdministration class the function if  you press 1,2 and 3 respectively  */
                if (option3.contentEquals("1")) {
                    courseAdministration.newCourse();

                } else if (option3.contentEquals("2")) {
                    courseAdministration.deleteCourse();

                } else if (option3.contentEquals("3")) {
                    courseAdministration.addModule();

                } else if (option3.contentEquals("4")) {
                    courseAdministration.updateModule();

                } else if (option3.contentEquals("5")) {
                    courseAdministration.removeInstructor();

                } else if (option3.contentEquals("6")) {
                    courseAdministration.updateCourse();
                } else if (option3.contentEquals("7")) {
                    courseAdministration.reportSlip();
                } else {
                    System.out.println("Thank you");
                    logout = true;

                }
            }
        }


        /* for instructor class */
        else if (option.contentEquals("2")) {
            /* at first you need to enter the  name,level of the instructor  */
            System.out.println("Please Enter your name:");
            String InstructorName = in.nextLine();

            System.out.println("Please Enter your Level:");
            String level = in.nextLine();

            Instructor instructor = new Instructor(InstructorName, level);

            Instructor Instructor = new Instructor("Instructor", "level");
            System.out.println(" You have been successfully logged in as Instructor !");

            boolean logout = false;
            while (!logout) {
                /*when you enter 2 for the instructor  you will be able to do the following */
                System.out.println("What would you like to do today?");
                System.out.println("'1' to View modules");
                System.out.println("'2' to View student");
                System.out.println("'3' to Add marks ");
                System.out.println("'4' to Exit");
                String option3 = in.nextLine();

                /*from the override method that we made inside the  instructor  class if you press 1,2 and 3 respectively  */
                if (option3.contentEquals("1")) {
                    Instructor.viewModule();

                } else if (option3.contentEquals("2")) {
                    Instructor.viewStudents();


                } else if (option3.contentEquals("3")) {
                    Instructor.addMarks();
                } else {
                    System.out.println("Thank you ");
                    logout = true;

                }
            }
        }


        /*for the student class */
        /* at first you need to enter the first name, last name, level,email address and contact of the student  */
        else if (option.contentEquals("3")) {

            System.out.println("Please Enter your First name:");
            String firstName = in.nextLine();

            System.out.println("Please Enter your Last name:");
            String lastName = in.nextLine();

            System.out.println("Please Enter your Level:");
            String level = in.nextLine();

            System.out.println("Please Enter your Id:");
            String studentId = in.nextLine();



            /* inorder to receive the information which we inherit from the student and user class */
            Student Student = new Student(firstName, lastName, level, studentId);

            Student student = new Student("firstName", "lastName", "level", "studentId");

            boolean logout = false;
            while (!logout) {
                /*when you enter 3 for the student  you will be able to do the following */
                System.out.println(" You have been successfully logged in as student !");
                System.out.println("What would you like to do today?");
                System.out.println("'1' to View Instructor");
                System.out.println("'2' to Enroll courses");
                System.out.println("'3' to Exit");

                String option3 = in.nextLine();
                /*from the override method that we made inside the  student class it will function accordingly if you press 1,2 and 3 respectively  */
                if (option3.contentEquals("1")) {
                    student.viewInstructor();

                } else if (option3.contentEquals("2")) {
                    student.enrollCourses();

                } else {
                    System.out.println("Thank you");
                    logout = true;
                }
            }
        }
    }
}




