package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.io.xlsxOpen;
import org.example.model.Student;
import org.example.model.University;
import org.example.util.ComparatorUtil;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/resources/universityInfo.xlsx");

        List<Student> students = xlsxOpen.getStudents(file);
        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

        List<University> universities = xlsxOpen.getUniversity(file);
        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR_OF_FOUNDATION);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
    }
}