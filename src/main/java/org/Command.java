package org;


import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Command {

    public static void displayCommands(){
        System.out.println("1. Enroll a new student");
        System.out.println("2. Assign teacher to a course");
        System.out.println("3. See all courses");
        System.out.println("4. Search for a specific course");
        System.out.println("5. See all students");
        System.out.println("6. Search for a specific student");
        System.out.println("7. See all teachers");
        System.out.println("8. Search for a specific teacher");
        System.out.println("9. Show profit");
        System.out.println("10. Add new course");
        System.out.println("11. Add new student");
        System.out.println("12. Add new teacher");
        System.out.println("13. Remove teacher from course");
        System.out.println("14. Unenroll student from course");
        System.out.println("15. Enroll a list of students to course");
        System.out.println("16. Exit program");
        System.out.print("Enter your choice: ");
    }

    public static void enrollStudent(String studentId, String courseId, School school) {
        // Gets student by looking through students map
        Student student = CommandUtils.getStudentById(school.getStudentMap(), studentId);
        // Gets course by looking through courses map
        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);

        // Checks if the course and the student exist
        if (student != null && course != null) {
            // Check if the student is already enrolled in another course

            if (student.getCourse() != null) {
                throw new IllegalArgumentException("Student is already enrolled in a course.");
            }

            // Enrolls student in the course
            student.setCourse(course);


            // Updates money earned in the course based on its price
            course.updateMoney_earned(course.getPrice());
        } else {
            throw new IllegalArgumentException("Invalid student or course ID.");
        }
    }


    public static void assignTeacher(String teacherId, String courseId, School school){
        //find course by id, getCourseMap()
        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);

        if(course == null){
            throw new IllegalArgumentException("Course doesn't exist!");
        }

        //find teacher by teacher id, getTeacherMap()
        Teacher teacher = CommandUtils.getTeacherById(school.getTeacherMap(), teacherId);

        if(teacher == null){
            throw new IllegalArgumentException("Teacher doesn't exist!");
        }
        course.setTeacher(teacher);
    }

    public static void removeTeacherFromCourse(String courseId, School school){
        //find course by id, getCourseMap()
        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);

        if(course == null){
            throw new IllegalArgumentException("Course doesn't exist!");
        } else if (course.getTeacher() == null){
            throw new IllegalArgumentException("No teacher assigned to this course!");
        }

        else {
            course.removeTeacher();
        }
    }
    public static void unenrollStudent(String studentId, String courseId, School school){
        // Gets student by looking through students map
        Student student = CommandUtils.getStudentById(school.getStudentMap(), studentId);
        // Gets course by looking through courses map
        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);
        // Checks if the course and the student exist
        if (student != null && course != null) {
            // Check if the student is enrolled in the given course
            if (isStudentEnrolledInCourse(student, courseId)) {
                // Remove the course from the student
                student.setCourse(null);

                // Update money earned in the course based on its price
                course.updateMoney_earned(course.getMoney_earned() - course.getPrice());
            } else {
                throw new IllegalArgumentException("Student is not enrolled in this course.");
            }
        } else {
            throw new IllegalArgumentException("Invalid student or course ID.");
        }
    }

    // Helper method to check if a student is enrolled in a given course
    //quitarlo si no es List<Course>
    public static boolean isStudentEnrolledInCourse(Student student, String courseId) {
        Course course = student.getCourse();

        if (Objects.equals(course.getCourseId(), courseId)) {
                return true;
            } else {
            return false;
        }
    }


    public static void enrollStudents(List<String> studentsIds, String courseId, School school) {
        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);
        for(String id : studentsIds){
            Student student = CommandUtils.getStudentById(school.getStudentMap(), id);
            // Checks if the course and the student exist
            if (student != null && course != null) {
            //no comprobar si uno ya está matriculado, se vuelve a matricular

                // Enrolls student in the course
                student.setCourse(course);

                // Updates money earned in the course based on its price
                course.updateMoney_earned(course.getPrice());
            } else {
                throw new IllegalArgumentException("Invalid student or course ID.");
            }
        }
    }


    public static double showProfit(School school) throws IllegalArgumentException {
        double totalMoneyEarned = 0;
        double totalTeacherSalaries = 0;

        try {
            // Calculate total money earned from all courses
            for (Course course : school.getCourseMap().values()) {
                totalMoneyEarned += course.getMoney_earned();
            }

            // Calculate the sum of all the teachers' salaries
            for (Teacher teacher : school.getTeacherMap().values()) {
                totalTeacherSalaries += teacher.getSalary();
            }

            // Return the result (difference)
            return totalMoneyEarned - totalTeacherSalaries;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("An error occurred while calculating profit: " + e.getMessage());
        }
    }
}
