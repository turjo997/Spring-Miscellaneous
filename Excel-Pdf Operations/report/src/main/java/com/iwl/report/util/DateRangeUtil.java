package com.iwl.report.util;

import java.time.LocalDate;

public class DateRangeUtil {

    public static boolean isValidRange(LocalDate start, LocalDate end) {
        return !(start == null || end == null || end.isBefore(start));
    }
}
