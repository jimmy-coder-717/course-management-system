/*
 * abstract-> process of hiding the certain details and showing only essential info to the user
 * it must be inherited from another class
 */


/**
 * the abstract class user which extends the Main class
 **/
abstract class User extends Main {


    /**
     * encapsulation for the administration
     **/
    public User() {
    }

    public String adminId;
    public String adminPass;

    /**
     * encapsulation for the student class
     **/
    public String firstName;
    public String lastName;
    public String level;
    public String emailAddress;
    public String contact;
    public String InstructorName;

    /**
     * for the instructor
     **/
    public User(String InstructorName, String level) {
        this.InstructorName = InstructorName;

        this.level = level;

    }

    /**
     * for the student class
     **/
    public User(String firstName, String lastName, String level, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.level = level;
        this.studentId = studentId;


    }

    public String courseName;
    public String courseId;
    public String moduleId;
    public String moduleName;
    public String instructorName;
    public String studentId;


    /* getter and setter method*/
    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }
}

