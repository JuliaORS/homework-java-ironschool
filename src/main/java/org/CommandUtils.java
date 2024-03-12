package org;


import java.util.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CommandUtils {

    public static void showAllTeachers(HashMap<String, Teacher> map){
        System.out.println(printHeaderTableTeacher());
        System.out.println(printRowSeparatorTeacher());
        int entryIndex = 0;
        for (Map.Entry<String, Teacher> entry : map.entrySet()) {
            Teacher teacher = entry.getValue();
            System.out.println("│" + teacher.getInfo() + "│");
            if (++entryIndex < map.size()) {
                System.out.println(printRowSeparatorTeacher());
            } else {
                System.out.println(printFooterTableTeacher());
            }

        }
    }




    public static void showAllCourses(HashMap<String, Course> map){
        System.out.println(printHeaderTableCourse());
        System.out.println(printRowSeparatorCourse());
        int entryIndex = 0;
        for (Map.Entry<String, Course> entry : map.entrySet()) {
            Course course = entry.getValue();
            System.out.println("│" + course.getInfo() + "│");
            if (++entryIndex < map.size()) {
                System.out.println(printRowSeparatorCourse());
            } else {
                System.out.println(printFooterTableCourse());
            }
        }
    }

    public static void showAllStudents(HashMap<String, Student> map){
        System.out.println(printHeaderTableStudent());
        System.out.println(printRowSeparatorStudent());
        int entryIndex = 0;
        for (Map.Entry<String, Student> entry : map.entrySet()) {
            Student student = entry.getValue();
            System.out.println("│" + student.getInfo() + "│");
            if (++entryIndex < map.size()) {
                System.out.println(printRowSeparatorStudent());
            } else {
                System.out.println(printFooterTableStudent());
            }
        }
    }

    public static void lookUpTeacher(HashMap<String, Teacher> map, String targetId){
        Teacher teacher = getTeacherById(map, targetId);
        if (teacher != null){
            System.out.println(printHeaderTableTeacher());
            System.out.println(printRowSeparatorTeacher());
            System.out.println("│" + teacher.getInfo() + "│");
            System.out.println(printFooterTableTeacher());
        }
    }

    public static void lookUpCourse(HashMap<String, Course> map, String targetId){
        Course course = getCourseById(map, targetId);
        if (course != null){
            System.out.println(printHeaderTableCourse());
            System.out.println(printRowSeparatorCourse());
            System.out.println("│" + course.getInfo() + "│");
            System.out.println(printFooterTableCourse());
        }
    }

    public static void lookUpStudent(HashMap<String, Student> map, String targetId){
        Student student = getStudentById(map, targetId);
        if (student != null){
            System.out.println(printHeaderTableStudent());
            System.out.println(printRowSeparatorStudent());
            System.out.println("│" + student.getInfo() + "│");
            System.out.println(printFooterTableStudent());
        }
    }

    public static Teacher getTeacherById(HashMap<String, Teacher> map, String targetId){
        Teacher teacher = map.get(targetId);
        if (teacher == null){
            throw new IllegalArgumentException("Invalid teacher ID");
        }
        return teacher;
    }

    public static Course getCourseById(HashMap<String, Course> map, String targetId){
        Course course = map.get(targetId);
        if (course == null){
            throw new IllegalArgumentException("Invalid course ID");
        }
        return course;
    }

    public static Student getStudentById(HashMap<String, Student> map, String targetId){
        Student student = map.get(targetId);
        if (student == null){
            throw new IllegalArgumentException("Invalid student ID");
        }
        return student;
    }

    public static String printHeaderTableTeacher() {
        return  "┌─────┬───────────────────┬──────────────┐\n" +
                "│ ID  │ Name              │ Salary       │";
    }

    public static String printRowSeparatorTeacher() {

        return "├─────┼───────────────────┼──────────────┤";
    }

    public static String printFooterTableTeacher() {
        return "└─────┴───────────────────┴──────────────┘\n";
    }

    public static String printHeaderTableCourse() {
        return  "┌─────┬───────────────────┬──────────────┬───────────────────┐\n" +
                "│ ID  │ Name              │ Salary       │ Teacher           │";
    }

    public static String printRowSeparatorCourse() {

        return "├─────┼───────────────────┼──────────────┼───────────────────┤";
    }

    public static String printFooterTableCourse() {
        return "└─────┴───────────────────┴──────────────┴───────────────────┘\n";
    }


    public static String printHeaderTableStudent() {
        return  "┌─────┬────────────────────┬────────────────────┬────────────────────┬────────────────────┐\n" +
                "│ ID  │ Name               │ Address            │ Email              │ Course             │";
    }
    public static String printRowSeparatorStudent() {

        return "├─────┼────────────────────┼────────────────────┼────────────────────┼────────────────────┤";
    }

    public static String printFooterTableStudent() {
        return "└─────┴────────────────────┴────────────────────┴────────────────────┴────────────────────┘\n";
    }
}
