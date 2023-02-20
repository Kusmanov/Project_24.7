package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.io.JsonWrite;
import org.example.io.XlsxRead;
import org.example.io.XlsxWrite;
import org.example.io.XmlWrite;
import org.example.model.FullInfo;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.util.ComparatorUtil;
import org.example.util.StatisticsUtil;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        File file = new File("src/resources/universityInfo.xlsx");

        List<Student> students = XlsxRead.getStudents(file);
        StudentComparator studentComparator = ComparatorUtil
                .getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);
        //String studentsJson = JsonUtil.studentListToJson(students);
        // проверяем, что json создан успешно
        //System.out.println(studentsJson);
        //List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        //System.out.println(students.size() == studentsFromJson.size());
        //students.forEach(student -> {
            //String studentJson = JsonUtil.studentToJson(student);
            // проверяем, что json из отдельного элемента создан успешно
            //System.out.println(studentJson);
            //Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверяем, что обратно элемент воссоздаётся
            //System.out.println(studentFromJson);
        //});

        List<University> universities = XlsxRead.getUniversity(file);
        UniversityComparator universityComparator = ComparatorUtil
                .getUniversityComparator(UniversityComparatorType.YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        //String universitiesJson = JsonUtil.universityListToJson(universities);
        // проверяем, что json создан успешно
        //System.out.println(universitiesJson);
        //List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // проверяем, что обратно коллекция воссоздаётся в таком же количестве элементов
        //System.out.println(universities.size() == universitiesFromJson.size());
        //universities.forEach(university -> {
            //String universityJson = JsonUtil.universityToJson(university);
            // проверяем, что json из отдельного элемента создан успешно
            //System.out.println(universityJson);
            //University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверяем, что обратно элемент воссоздаётся
            //System.out.println(universityFromJson);
        //});

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsxWrite.writeXlsxStatistics(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWrite.generateXmlReq(fullInfo);
        JsonWrite.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
}