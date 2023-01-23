package org.example.util;

import org.example.comparator.*;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;

public class ComparatorUtil {
    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        switch (studentComparatorType) {
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            case COURSE_NUMBER:
                return new StudentCourseNumberComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        switch (universityComparatorType) {
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case MAIN_PROFILE:
                return new UniversityMainProfileComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
