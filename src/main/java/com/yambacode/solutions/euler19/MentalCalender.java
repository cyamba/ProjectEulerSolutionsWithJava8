package com.yambacode.solutions.euler19;

import com.yambacode.solutions.AbstractEulerSolver;

/**
 * Created by
 * Christopher Yamba
 * <p>
 * 2011-11-23
 */
public class MentalCalender extends AbstractEulerSolver {

    @Override
    public String doSolve() {
        return null;
    }

    enum Month {
        JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30), JUL(31), AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);

        private int days;

        Month(int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }
    }

    public Number calculate() {
        int result = 0;
        int year = 1901;
        int dayCount = 365;
        int endYear = 2000;
        while (year <= endYear) {
            for (Month m : Month.values()) {

                if (MentalCalendarUtil.isLeapYear(year)) {
                    dayCount += (m == Month.FEB) ? m.getDays() + 1 : m.getDays();
                } else {
                    dayCount += m.getDays();
                }
                if (dayCount % 7 == 6) {
                    result++;
                }
            }
            year++;
        }
        return result;
    }


}
