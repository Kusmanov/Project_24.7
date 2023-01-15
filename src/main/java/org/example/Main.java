package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/resources/universityInfo.xlsx");
        System.out.println(xlsxOpen.getStudents(file));
        System.out.println(xlsxOpen.getUniversity(file));
    }
}