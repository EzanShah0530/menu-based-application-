package Lab06;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Student
{
    private int studentID;
    private String studentName;
    private double studentCGPA;
    Student() {
         super();
     }
    Student(int studentID, String studentName,double studentCGPA) {
        super();
        this.studentID=studentID;
        this.studentName=studentName;
        this.studentCGPA=studentCGPA;
    }
    public String toString() {
        String text = "Student ID:"+this.studentID+" , Student Name:"+this.studentName+" , Student CGPA:"+this.studentCGPA;
        return text;
    }
    public int getstudentId() {
        return studentID;
    }
    public void setstudentId(int studentID) {
        this.studentID=studentID;
    }
    public String getstudentName() {
        return studentName;
    }
    public void setstudentName(String studentName) {
        this.studentName=studentName;
    }
    public double getstudentCGPA() {
        return studentCGPA;
    }
    public void setstudentCGPA(double studentCGPA) {
        this.studentCGPA=studentCGPA;
    }
}
class Course
{
    String courseID;
    String courseTitle;
    double Credit;
    private Student[] studentList;
    private int numberofstudent;
    private Faculty faculty ;
    Course(){
        super();
        numberofstudent=0;
    }
    Course(String courseID, String courseTitle,double Credit) {
        this.courseID=courseID;
        this.courseTitle=courseTitle;
        this.Credit=Credit;
    }
    public String getCourseId(){
        return courseID;
    }
    public void setCourseId(String courseID) {
        this.courseID = courseID;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public double getCredit() {
        return Credit;
    }
    public void setCredit(double Credit) {
        this.Credit = Credit;
    }
    public Student[] getStudentList() {
        return studentList;
    }
    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }
    public int getNumberOfStudents() {
        return numberofstudent;
    }
    public void setNumberOfStudent(int numberofstudent) {
        this.numberofstudent = numberofstudent;
    }

    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    public String toString() {
    String text = "Course Id:"+courseID+" , Course Title:"+courseTitle+" , Course Credit:"+Credit;
    return text;
    }
    public void addStudent(Student student) {
        numberofstudent += 1;
        studentList[numberofstudent] = student;
        System.out.println("Student added!!");
    }
    public void dropStudent(int studentID) {
        boolean dropped = false;

        for (int i = 0; i < numberofstudent; i++) {
            if (studentList[i].getstudentId() == studentID) {
                Student [] temp = new Student[numberofstudent - 1];

                for (int y = 0; y < numberofstudent; y++) {
                    if (y == i) {
                        continue;
                    }

                    else
                        temp[y] = studentList[y];
                }
                this.studentList = temp;

                System.out.println("Student with ID " + studentID + " successfully dropped!!");
                dropped = true;

                numberofstudent = numberofstudent - 1;

                break;
            }
        }

        if (dropped == false) {
            System.out.println("Sorry! This student either does not exist or has already been deleted!");
        }
    }
    public void addFaculty(Faculty faculty) {
    }
    public void dropFaculty() {
        this.faculty = null;
    }
    public void printStudentList() {
        for (int i = 0; i < numberofstudent; i++) {
            System.out.println(studentList[i].toString());
            System.out.println();
        }
    }
}
class Faculty
{
    int facultyID;
    String facultyName;
    String facultyPosition;
    Faculty() {
    super();
    }
    Faculty(int facultyId,String facultyName,String facultyPosition) {
        super();
        this.facultyID=facultyId;
        this.facultyName=facultyName;
        this.facultyPosition=facultyPosition;
    }
    public int getFacultyId() {
        return facultyID;
    }
    public void setFacultyID(int facultyId) {
        this.facultyID = facultyId;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getFacultyPosition() {
        return facultyPosition;
    }
    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }
    public String toString() {
        String text="facultyId:" + facultyID + ", facultyName:" + facultyName + ", facultyPosition: "+ facultyPosition ;
        return  text;
    }
}
public class menu_based_application {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        String firstChoice = "", secondChoice = "";

        int studentID, facultyID;
        String studentName, facultyName;
        double studentCGPA;
        String facultyPosition;
        String courseID, courseTitle;
        double courseCredit;
        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Faculty> faculty = new ArrayList<>();
        while(true) {
            System.out.println("a. Add");
            System.out.println("b. Delete");
            System.out.println("c. Update");
            System.out.println("d. Print");
            System.out.println("e. Search");

            System.out.println("Enter your choice: ");
            firstChoice = input.nextLine();

            switch(firstChoice) {
                case "a":
                    System.out.println("a. Add a student");
                    System.out.println("b. Add a course");
                    System.out.println("c. Add a faculty");

                    System.out.println("Enter your choice: ");
                    secondChoice = input.nextLine();

                    switch(secondChoice) {
                        case "a":
                            if (courses.size() == 0) {
                            System.out.println("You must add a course first!!");
                        }
                        else {
                            System.out.println("Enter student ID: ");
                            studentID = Integer.parseInt(input.nextLine());

                            System.out.println("Enter student name: ");
                            studentName = input.nextLine();

                            System.out.println("Enter student CGPA: ");
                            studentCGPA = Double.parseDouble(input.nextLine());

                            Student temp = new Student(studentID, studentName, studentCGPA);

                            students.add(temp);

                            System.out.println("Enter course ID to add the student to: ");
                            courseID = input.nextLine();

                            for (int i = 0; i < courses.size(); i++) {
                                if (courses.get(i).getCourseId() == courseID) {
                                    courses.get(i).addStudent(temp);
                                    System.out.println("Student added to course!");
                                    break;
                                }
                            }
                        }
                            break;

                        case "b":
                            System.out.println("Enter course ID: ");
                            courseID = input.nextLine();

                            System.out.println("Enter course title: ");
                            courseTitle = input.nextLine();

                            System.out.println("Enter course credits: ");
                            courseCredit = Double.parseDouble(input.nextLine());

                            courses.add(new Course(courseID, courseTitle, courseCredit));

                            break;

                        case "c":
                            if (courses.size() == 0) {
                            System.out.println("You must add a course first!!");
                            }
                        else {
                            System.out.println("Enter faculty ID: ");
                            facultyID = Integer.parseInt(input.nextLine());

                            System.out.println("Enter faculty name: ");
                            facultyName = input.nextLine();

                            System.out.println("Enter faculty position: ");
                            facultyPosition = input.nextLine();

                            Faculty temp = new Faculty(facultyID, facultyName, facultyPosition);

                            faculty.add(temp);

                            System.out.println("Enter course ID to assign the faculty to: ");
                            courseID = input.nextLine();

                            for (int i = 0; i < courses.size(); i++) {
                                if (courses.get(i).getCourseId() == courseID) {
                                    courses.get(i).addFaculty(temp);
                                    System.out.println("Faculty assigned to course!");
                                    break;
                                }
                            }
                        }

                            break;

                        default:
                            System.out.println("Please enter a valid choice!!");
                    }
                    break;

                case "d":
                    System.out.println("a. Print all students");
                    System.out.println("b. Print all courses");
                    System.out.println("c. Print all faculties");
                    System.out.println("d. Print information of a student");
                    System.out.println("e. Print information of a course");
                    System.out.println("f. Print information of a faculty");
                    System.out.println("g. Print student list and faculty information of a course");
                    System.out.println("h. Print courses taken by a student");

                    System.out.println("Enter your choice: ");
                    secondChoice = input.nextLine();
                    switch(secondChoice) {
                        case "a":
                            for (int i = 0; i < students.size(); i++) {
                            System.out.println(students.get(i).toString());
                             }
                            break;

                        case "b":
                            for (int i = 0; i < courses.size(); i++) {
                            System.out.println(courses.get(i).toString());
                            System.out.println();
                             }
                            break;

                        case "c":
                            for (int i = 0; i < faculty.size(); i++) {
                            System.out.println(faculty.get(i).toString());
                            System.out.println();
                            }
                            break;

                        case "d":
                            System.out.println("Enter student ID: ");
                            studentID = Integer.parseInt(input.nextLine());

                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getstudentId() == studentID) {
                                    System.out.println(students.get(i).toString());
                                }
                            }
                            break;

                        case "e": System.out.println("Enter course ID: ");
                            courseID = input.nextLine();

                            for (int i = 0; i < courses.size(); i++) {
                                if (courses.get(i).getCourseId().equals(courseID)) {
                                    System.out.println(courses.get(i).toString());
                                }
                            }
                            break;

                        case "f": System.out.println("Enter faculty ID: ");
                            facultyID = Integer.parseInt(input.nextLine());

                            for (int i = 0; i < faculty.size(); i++) {
                                if (faculty.get(i).getFacultyId() == facultyID) {
                                    System.out.println(faculty.get(i).toString());
                                }
                            }
                            break;
                    }
                    break;

                case "e":
                    System.out.println("a. Search a student");
                    System.out.println("b. Search a course");
                    System.out.println("c. Search a faculty");
                    System.out.println("d. Search whether a student takes a course");
                    System.out.println("e. Search whether a faculty teaches a course");
                    System.out.println("f. Search courses taken by a student");
                    System.out.println("g. Search courses taught by a faculty");

                    System.out.println("Enter your choice: ");
                    secondChoice = input.nextLine();

                    switch(secondChoice) {
                        case "a":
                            System.out.println("Enter student ID: ");
                            studentID = Integer.parseInt(input.nextLine());

                            for (int i = 0; i < students.size(); i++) {
                                if (students.get(i).getstudentId() == studentID) {
                                    students.get(i).toString();
                                }
                            }
                            break;

                        case "b": System.out.println("Enter course ID: ");
                            courseID = input.nextLine();

                            for (int i = 0; i < courses.size(); i++) {
                                if (courses.get(i).getCourseId() == courseID) {
                                    courses.get(i).toString();
                                }
                            }
                            break;

                        case "c": System.out.println("Enter faculty ID: ");
                            facultyID = Integer.parseInt(input.nextLine());

                            for (int i = 0; i < faculty.size(); i++) {
                                if (faculty.get(i).getFacultyId() == facultyID) {
                                    faculty.get(i).toString();
                                }
                            }
                            break;
                    }
                    break;
            }
        }
    }
}
