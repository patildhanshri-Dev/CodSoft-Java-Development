import java.util.ArrayList;
import java.util.Scanner;


// Course class
class Course {

    String courseCode;
    String title;
    String description;
    int capacity;
    int registeredStudents;

    Course(String courseCode, String title,
           String description, int capacity) {

        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.registeredStudents = 0;
    }

    // Display course information
    void displayCourse() {

        System.out.println("\nCourse Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Available Slots: "
                + (capacity - registeredStudents));
    }
}


// Student class
class Student {

    String studentId;
    String name;

    ArrayList<String> registeredCourses =
            new ArrayList<>();

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}


// Main class
public class CourseRegistrationSystem {

    static ArrayList<Course> courses =
            new ArrayList<>();

    static Student student;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create courses
        courses.add(new Course(
                "C101",
                "Java Programming",
                "Learn Java programming",
                3));

        courses.add(new Course(
                "C102",
                "Database Management",
                "Learn DBMS concepts",
                2));

        courses.add(new Course(
                "C103",
                "Data Structures",
                "Learn data structures",
                4));

        // Create student
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        student = new Student(id, name);

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Display Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Display Registered Courses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    registerCourse(sc);
                    break;

                case 3:
                    removeCourse(sc);
                    break;

                case 4:
                    displayRegisteredCourses();
                    break;

                case 5:
                    System.out.println(
                            "Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }


    // Display available courses
    static void displayCourses() {

        System.out.println("\n===== AVAILABLE COURSES =====");

        for (Course course : courses) {
            course.displayCourse();
        }
    }


    // Register for course
    static void registerCourse(Scanner sc) {

        System.out.print("Enter Course Code: ");
        String code = sc.next();

        for (Course course : courses) {

            if (course.courseCode.equalsIgnoreCase(code)) {

                if (course.registeredStudents
                        < course.capacity) {

                    if (!student.registeredCourses
                            .contains(code)) {

                        student.registeredCourses.add(code);
                        course.registeredStudents++;

                        System.out.println(
                                "Course registered successfully.");

                    } else {
                        System.out.println(
                                "You are already registered.");
                    }

                } else {
                    System.out.println(
                            "No available slots.");
                }

                return;
            }
        }

        System.out.println("Course not found.");
    }


    // Remove course
    static void removeCourse(Scanner sc) {

        System.out.print("Enter Course Code to remove: ");
        String code = sc.next();

        if (student.registeredCourses.remove(code)) {

            for (Course course : courses) {

                if (course.courseCode.equalsIgnoreCase(code)) {
                    course.registeredStudents--;
                    break;
                }
            }

            System.out.println(
                    "Course removed successfully.");

        } else {

            System.out.println(
                    "You are not registered for this course.");
        }
    }


    // Display student's registered courses
    static void displayRegisteredCourses() {

        System.out.println("\n===== REGISTERED COURSES =====");

        if (student.registeredCourses.isEmpty()) {

            System.out.println(
                    "No courses registered.");

        } else {

            for (String courseCode :
                    student.registeredCourses) {

                System.out.println(courseCode);
            }
        }
    }
}