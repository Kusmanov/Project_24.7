package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Student;

public class StudentUniversityIdComparator implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getUniversityId(), o2.getUniversityId());
    }
}
