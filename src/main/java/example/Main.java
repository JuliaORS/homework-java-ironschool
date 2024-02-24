package example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("cencia!!!", 150, 4000, new Teacher());
        Course c2 = new Course("mates", 1500, 6000, new Teacher());
        System.out.println(c2.getCourseId());
    }

}
