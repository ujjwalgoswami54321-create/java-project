import java.util.Scanner;

// Course Class
class Course {
    private String courseName;
    private String courseId;
    private String duration;

    public Course(String courseName, String courseId, String duration) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getDuration() {
        return duration;
    }

    public void displayCourse() {
        System.out.println("Course Name : " + courseName);
        System.out.println("Course ID   : " + courseId);
        System.out.println("Duration    : " + duration);
    }
}

// Student Class
class Student {
    private String studentName;
    private String studentId;
    private int progress;

    // Array to store enrolled courses
    private Course[] enrolledCourses = new Course[5];
    private int courseCount = 0;

    public Student(String studentName, String studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.progress = 0;
    }

    // Enroll student in a course
    public void enroll(Course course) {
        if (courseCount < enrolledCourses.length) {
            enrolledCourses[courseCount] = course;
            courseCount++;
            System.out.println(studentName + " enrolled in " + course.getCourseName());
        } else {
            System.out.println("Course limit reached!");
        }
    }

    // Update progress
    public void updateProgress(int progress) {
        if (progress >= 0 && progress <= 100) {
            this.progress = progress;
        } else {
            System.out.println("Progress must be between 0 and 100.");
        }
    }

    public int getProgress() {
        return progress;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void displayStudentDetails() {
        System.out.println("\nStudent Name : " + studentName);
        System.out.println("Student ID   : " + studentId);
        System.out.println("Progress     : " + progress + "%");

        System.out.println("Enrolled Courses:");
        if (courseCount == 0) {
            System.out.println("No courses enrolled.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + enrolledCourses[i].getCourseName());
            }
        }
    }
}

// Main Class
public class finalproject {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array of Courses
        Course[] courses = new Course[3];

        courses[0] = new Course("Java Programming", "C101", "8 Weeks");
        courses[1] = new Course("Data Structures", "C102", "10 Weeks");
        courses[2] = new Course("Web Development", "C103", "12 Weeks");

        // Array of Students
        Student[] students = new Student[2];

        students[0] = new Student("Nikhil", "Ta22");
        students[1] = new Student("Ujjwal", "Ta21");

        // Enroll Students
        students[0].enroll(courses[0]);
        students[0].enroll(courses[1]);

        students[1].enroll(courses[0]);
        students[1].enroll(courses[2]);

        // Update Progress
        students[0].updateProgress(80);
        students[1].updateProgress(65);

        // Display Course Details
        System.out.println("\n========== COURSE DETAILS ==========");
        for (int i = 0; i < courses.length; i++) {
            courses[i].displayCourse();
            System.out.println("-----------------------------");
        }

        // Display Student Details
        System.out.println("\n========== STUDENT DETAILS ==========");
        for (int i = 0; i < students.length; i++) {
            students[i].displayStudentDetails();
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
