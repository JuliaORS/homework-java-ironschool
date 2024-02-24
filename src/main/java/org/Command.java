package org;

import java.util.List;
import java.util.Map;

public class Command {
    public void displayCommands(){
        System.out.println("1. Enroll a new student");
        System.out.println("2. Assign teacher to a course");
        System.out.println("3. See all courses");
        System.out.println("4. Search for a specific course");
        System.out.println("5. See all students");
        System.out.println("6. Search for a specific student");
        System.out.println("7. See all teachers");
        System.out.println("8. Search for a specific teacher");
        System.out.print("Enter your choice: ");
    }

    public void enrollStudent(String studentId, String courseId, Map<String, Student> studentsList, Map<String, Course> coursesList) {
        try {
            // Handle exception: checks if studentId or courseId is null
            if (studentId == null || courseId == null) {
                throw new IllegalArgumentException("Student ID or Course ID cannot be empty");
            }

            Student student = studentsList.get(studentId);
            Course course = coursesList.get(courseId);

            // Handle exception: checks if student or course is null
            if (student == null || course == null) {
                throw new IllegalArgumentException("Student or Course are not found");
            }

            // Enroll student to the course
            student.setCourse(course);

            // Update money_earned
            double moneyEarned = course.getMoney_earned() + course.getPrice();
            course.setMoney_earned(moneyEarned);

            System.out.println(student.getName() + " successfully enrolled into the course of " +
                    course.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void assignTeacher(String teacherId, String courseId){}

    public List<Course> showCourses(){}

    public List<Student> showStudents(){}

    public List<Teacher> showTeachers(){}

    public Course lookupCourse(String courseId){}

    public Student lookupStundent(String studentId){}

    public Teacher lookupTeacher(String teacherId){}

    public double showProfit(){}




}
