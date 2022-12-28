package org.example;

public class Main {
    public static void main(String[] args) {
        University university = new University(
                "1",
                "Asfendiyarov Kazakh National Medical University",
                "AKNMU",
                1930,
                StudyProfile.MEDICINE);

        Student student = new Student("Nurlan Saburov", "1", 1, 1.25f);

        System.out.println(university);
        System.out.println(student);
    }
}