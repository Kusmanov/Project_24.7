package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.University;

public class UniversityShortNameComparator implements UniversityComparator{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
