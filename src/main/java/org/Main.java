package org;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String schoolName = "";
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi!");
        System.out.println("Welcome to the School Manager Tool.");

        System.out.println(printBlue("Please, text the name for your school:"));
        schoolName = scanner.nextLine();
        System.out.println("");
        System.out.println(printYellow("Perfect, we have created the school: ") + printPurple(schoolName));
        System.out.println("");

        itemCreator("teacher", schoolName, teachers, null);
        itemCreator("course", schoolName, courses, teachers);
        itemCreator("student", schoolName, students, null);

        School school = new School(schoolName, teachers, courses, students);

        int choiceMenu;
        Command command = new Command();

        do{

            command.displayCommands();
            choiceMenu = scanner.nextInt();
            String studentId;
            String courseId;
            String teacherId;

            switch(choiceMenu){
                case 1:
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();

                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        //command.enrollStudent(studentId, courseId);

                        System.out.println(printPurple("Congratulations! Your student has been successfully enrolled to the course."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());

                    }

                    break;
                case 2:
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();

                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        //command.assignTeacher(teacherId, courseId);

                        System.out.println(printPurple("Congratulations! Your teacher has been successfully assigned to the course."));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());

                    }

                    break;
                case 3:
                    try{

                        // TODO check como se definio esta funcion e implementarla - Victoria
                       // System.out.println(printPurple(command.showCourses()));


                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(printBlue("Enter the id of the course:"));
                    scanner.nextLine();
                    courseId = scanner.nextLine();

                    try{
                        //Course course = command.lookupCourse(courseId);

                        // TODO check como se definio esta funcion e implementarla - Victoria

                        //TODO Agregar un esperando o buscando? - Victoria
                        //System.out.println(printPurple(course));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 5:
                    try{
                        // TODO check como se definio esta funcion e implementarla - Victoria

                        //System.out.println(printPurple(showStudents()));
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println(printBlue("Enter the id of the student:"));
                    scanner.nextLine();
                    studentId = scanner.nextLine();

                    try{
                        //Student student = command.lookupStundent(studentId);
                        // TODO check como se definio esta funcion e implementarla - Victoria

                        //System.out.println(printPurple(student));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 7:
                    try{
                        // TODO check como se definio esta funcion e implementarla - Victoria
                        //System.out.println(printPurple(showTeachers()));
                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println(printBlue("Enter the id of the teacher:"));
                    scanner.nextLine();
                    teacherId = scanner.nextLine();

                    try{
                        //Teacher teacher = command.lookupTeacher(teacherId);
                        //System.out.println(printPurple(teacher));

                    }catch(IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Closing program.");
                    scanner.close();
                    break;
            }

        }while(choiceMenu != 9);

    }

    private static void itemCreator(String type, String schoolName, List collection, List teachers) {
        boolean is_num = false;
        int totalItems = 0;
        Scanner scanner = new Scanner(System.in);

        while (!is_num) {
            System.out.println(printBlue("How many " + type + "s are in " + schoolName + "?"));
            try {
                totalItems = scanner.nextInt();
                scanner.nextLine();
                if (totalItems > 0) {
                    System.out.println("Okey, let's create now each " + type + ".");

                    for (int i = 0; i < totalItems; i++) {
                        System.out.println("");
                        System.out.println(type.toUpperCase() + " " + (i+1) + ":");
                        if (Objects.equals(type, "teacher")) {
                            teacherCreator(collection);
                        } else if(Objects.equals(type, "course")) {
                            courseCreator(collection, teachers);
                        } else if(Objects.equals(type, "student")) {
                            studentCreator(collection);
                        } else {
                            System.err.println("Type not valid.");
                        }
                    }
                    System.out.println("");
                    System.out.println(printYellow("Congratulations! We have created all the " + type + "s."));
                    System.out.println("");
                    is_num = true;
                } else {
                    System.err.println("Oops! You need to have at least one " + type + ".");
                }
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }
        is_num = false;
    }

    private static void teacherCreator(List teachers){
        boolean is_num = false;
        String name = "";
        double salary = 00.00;
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter teacher name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter teacher salary:"));
        while (!is_num) {
            try {
                salary = scanner.nextDouble();
                scanner.nextLine();
                is_num = true;
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }

        Teacher teacher = new Teacher(name, salary);
        teacher.getInfo();
        teachers.add(teacher);
    }

    private static void courseCreator(List courses, List<Teacher> teachers){
        boolean is_num = false;
        String name = "";
        double price = 00.00;
        int teacherSelection = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter course name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter course price:"));
        while (!is_num) {
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                is_num = true;
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }
        is_num = false;
        System.out.println(printBlue("Select an associated teacher:"));
        System.out.println("0 - No teacher associated");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i+1) + " - " + teachers.get(i).getName() + " (" + teachers.get(i).getSalary() + "€)");
        }

        while (!is_num) {
            try {
                teacherSelection = scanner.nextInt();
                scanner.nextLine();
                is_num = true;
            } catch (InputMismatchException ie) {
                scanner.nextLine();
                System.err.println("Oops! You need to enter a number.");
            }
        }

        Course course = null;
        if (teacherSelection == 0) {
            // course = new Course(name, price, (double) 0);
        } else {
            course = new Course(name, price, (double) 0, teachers.get(teacherSelection-1));
        }
        course.getInfo();
        courses.add(course);
    }

    private static void studentCreator(List students){
        String name = "";
        String address = "";
        String email = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println(printBlue("Enter student name:"));
        name = scanner.nextLine();
        System.out.println(printBlue("Enter student adress:"));
        address = scanner.nextLine();
        System.out.println(printBlue("Enter student email:"));
        email = scanner.nextLine();

        Student student = new Student(name, address, email);
        student.getInfo();
        students.add(student);
    }

    private static String printBlue(String text) {
        return ConsoleColors.BLUE + text + ConsoleColors.RESET;
    }

    private static String printPurple(String text) {
        return ConsoleColors.PURPLE + text + ConsoleColors.RESET;
    }

    private static String printYellow(String text) {
        return ConsoleColors.YELLOW + text + ConsoleColors.RESET;
    }
}