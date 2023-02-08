package org.example.io;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.model.Student;
import org.example.model.University;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsxRead {
    private static final Logger logger = Logger.getLogger(XlsxRead.class.getName());
    private XlsxRead() {
    }

    public static ArrayList<Student> getStudents(File file) {
        ArrayList<Student> collection = new ArrayList<>();
        try {
            logger.log(Level.INFO, "Excel reading started");

            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = null;
            if (file.getName().toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (file.getName().toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            if (workbook != null) {
                Sheet sheet = workbook.getSheet("Студенты");
                Iterator<Row> rowIterator = sheet.iterator();

                rowIterator.next();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    String universityId = row.getCell(0).getStringCellValue();
                    String fullName = row.getCell(1).getStringCellValue();
                    int currentCourseNumber = (int) row.getCell(2).getNumericCellValue();
                    float avgExamScore = (float) row.getCell(3).getNumericCellValue();

                    Student student = new Student(fullName, universityId, currentCourseNumber, avgExamScore);
                    collection.add(student);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Excel reading failed", e);
        }

        logger.log(Level.INFO, "Excel reading finished successfully");
        return collection;
    }

    public static ArrayList<University> getUniversity(File file) {
        ArrayList<University> collection = new ArrayList<>();
        try {
            logger.log(Level.INFO, "Excel reading started");

            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = null;
            if (file.getName().toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (file.getName().toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            if (workbook != null) {
                Sheet sheet = workbook.getSheet("Университеты");
                Iterator<Row> rowIterator = sheet.iterator();

                rowIterator.next();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    String id = row.getCell(0).getStringCellValue();
                    String fullName = row.getCell(1).getStringCellValue();
                    String shortName = row.getCell(2).getStringCellValue();
                    int yearOfFoundation = (int) row.getCell(3).getNumericCellValue();
                    StudyProfile mainProfile = StudyProfile.valueOf(row.getCell(4).getStringCellValue());

                    University university = new University(id, fullName, shortName, yearOfFoundation, mainProfile);
                    collection.add(university);
                }
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Excel reading failed", e);
        }

        logger.log(Level.INFO, "Excel reading finished successfully");
        return collection;
    }
}
