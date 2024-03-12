package org;



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

    public static Course assignTeacher(String teacherId, String courseId, School school){
        //find course by id, getCourseMap()
        Course course = CommandUtils.getCourseById(school.getCourseMap(), courseId);
        //find teacher by teacher id, getTeacherMap()
        Teacher teacher = CommandUtils.getTeacherById(school.getTeacherMap(), teacherId);
        //set teacher to course
        if(course == null){
            throw new IllegalArgumentException("Course doesn't exist!");
        } else {
            course.setTeacher(teacher);
            return course;
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
