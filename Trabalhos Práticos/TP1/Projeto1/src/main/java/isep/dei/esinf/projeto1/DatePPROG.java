package isep.dei.esinf.projeto1;

import java.util.Calendar;

/**
 *
 * @author 1190402_1191045
 */
public class DatePPROG {

    /**
     * The year of the date.
     */
    private int year;

    /**
     * The month of the date.
     */
    private Month month;

    /**
     * The day of the date.
     */
    private int day;

    /**
     * Represents the days of the weeks.
     */
    private static enum DayOfWeek {

        /**
         * The days of the week.
         */
        SUNDAY {
            @Override
            public String toString() {
                return "Sunday";
            }
        },
        MONDAY {
            @Override
            public String toString() {
                return "Monday";
            }
        },
        TUESDAY {
            @Override
            public String toString() {
                return "Tuesday";
            }
        },
        WEDNESDAY {
            @Override
            public String toString() {
                return "Wednesday";
            }
        },
        THURSDAY {
            @Override
            public String toString() {
                return "Thursday";
            }
        },
        FRIDAY {
            @Override
            public String toString() {
                return "Friday";
            }
        },
        SATURDAY {
            @Override
            public String toString() {
                return "Saturday";
            }
        };

        /**
         * Returns the description of the day of the week which order is
         * recieved as a parameter.
         *
         * @param dayOfWeekOrder the order of the day of the week between 0 and
         * 6. The lowest order corresponds to Sunday.
         * @return the designation of the day of the week.
         */
        public static String designationDayOfWeek(int dayOfWeekOrder) {
            return DayOfWeek.values()[dayOfWeekOrder].toString();
        }
    }

    /**
     * Represents the months.
     */
    public static enum Month {

        /**
         * Months of the year.
         */
        JANUARY(31) {
            @Override
            public String toString() {
                return "January";
            }
        },
        FEBRUARY(29) {
            @Override
            public String toString() {
                return "February";
            }
        },
        MARCH(31) {
            @Override
            public String toString() {
                return "March";
            }
        },
        APRIL(30) {
            @Override
            public String toString() {
                return "April";
            }
        },
        MAY(31) {
            @Override
            public String toString() {
                return "May";
            }
        },
        JUNE(30) {
            @Override
            public String toString() {
                return "June";
            }
        },
        JULY(31) {
            @Override
            public String toString() {
                return "July";
            }
        },
        AUGUST(31) {
            @Override
            public String toString() {
                return "August";
            }
        },
        SEPTEMBER(30) {
            @Override
            public String toString() {
                return "September";
            }
        },
        OCTOBER(31) {
            @Override
            public String toString() {
                return "October";
            }
        },
        NOVEMBER(30) {
            @Override
            public String toString() {
                return "November";
            }
        },
        DECEMBER(31) {
            @Override
            public String toString() {
                return "December";
            }
        };

        /**
         * The number of days in a month.
         */
        private final int numberOfDays;

        /**
         * Builds a month with the number of days received as parameter.
         *
         * @param numberOfDays the number of days in the month.
         */
        private Month(int numberOfDays) {
            this.numberOfDays = numberOfDays;
        }

        /**
         * Returns the number of days of the month received as a parameter.
         *
         * @param year the year of the month.
         * @return the number of days of the month of the year.
         */
        public int numberOfDays(int year) {
            if (ordinal() == 1 && DatePPROG.isLeapYear(year)) {
                return numberOfDays + 1;
            }
            return numberOfDays;
        }

        /**
         * Returns the month which order is received as a parameter.
         *
         * @param orderOfMonth the order of the month.
         * @return the month which order is received as a parameter.
         */
        public static Month getMonthOrder(int orderOfMonth) {
            return Month.values()[orderOfMonth - 1];
        }

    }

    /**
     * Constructs an instance of Date receiving the year, the month and the day.
     *
     * @param year the year of the date.
     * @param month the month of the date.
     * @param day the day of the date.
     * @throws isep.dei.esinf.projeto1.InvalidMonthException
     * @throws isep.dei.esinf.projeto1.InvalidDayException
     */
    public DatePPROG(int year, int month, int day) throws InvalidMonthException, InvalidDayException {
        setDate(year, month, day);
    }

    /**
     * Constructs an instance of Date with the same characteristics of date
     * received as parameter.
     *
     * @param otherDate the date with the characteristics to copy.
     */
    public DatePPROG(DatePPROG otherDate) {
        year = otherDate.year;
        month = otherDate.month;
        day = otherDate.day;
    }

    /**
     * Returns the year of the date.
     *
     * @return year of date
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the month of the date.
     *
     * @return month of date.
     */
    public int getMonth() {
        return month.ordinal() + 1;
    }

    /**
     * Returns the year of the date.
     *
     * @return day of date.
     */
    public int getDay() {
        return day;
    }

    /**
     * Modifies the year, month and day of date.
     *
     * @param year the new year of date.
     * @param month the new month of date.
     * @param day the new day of date.
     * @throws isep.dei.esinf.projeto1.InvalidMonthException
     * @throws isep.dei.esinf.projeto1.InvalidDayException
     */
    public final void setDate(int year, int month, int day) throws InvalidMonthException, InvalidDayException {
        if (month < 1 || month > 12) {
            throw new InvalidMonthException("Month " + month + " is invalid!!");
        }
        if (day < 1 || day > Month.getMonthOrder(month).numberOfDays(year)) {
            throw new InvalidDayException("Day " + year + "/" + month + "/" + day
                    + " is invalid!!");
        }
        this.year = year;
        this.month = Month.getMonthOrder(month);
        this.day = day;
    }

    /**
     * Returns the textual description of date in the format; dayOfWeek, day of
     * month of the year.
     *
     * @return characteristics of date.
     */
    @Override
    public String toString() {
        return String.format("%-4d-%02d-%02d", year, month.ordinal() + 1, day);
    }

    /**
     * Returns a date with the object received. Compara a date com o objeto
     * recebido.
     *
     * @param otherObject the object to compare with the date.
     * @return true if the object received represents a date equivalent to date.
     * Otherwise, returns false.
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        DatePPROG otherDate = (DatePPROG) otherObject;
        return year == otherDate.year && month.equals(otherDate.month)
                && day == otherDate.day;
    }

    /**
     * Compares a date with another received as parameter.
     *
     * @param otherDate a date to be compared.
     * @return the value 0 if the otherDate received is equals to the date; the
     * value -1 if the otherDate is after the date; the value 1 if the otherDate
     * is before the date.
     */
    public int compareTo(DatePPROG otherDate) {
        return (otherDate.isBigger(this)) ? -1 : (isBigger(otherDate)) ? 1 : 0;
    }

    /**
     * Returns the day of the week of date.
     *
     * @return day of week of date.
     */
    public String dayOfWeek() {
        int totalDays = countsDays();
        totalDays = totalDays % 7;

        return DayOfWeek.designationDayOfWeek(totalDays);
    }

    /**
     * Returns true if a date is bigger than the otherDate. If a date is smaller
     * or the same as otherDate, devolve false.
     *
     * @param otherDate the other date to compare to the date.
     * @return true if a date is bigger than the date received as parameter,
     * otherwise returns false.
     */
    public boolean isBigger(DatePPROG otherDate) {
        int totalDays = countsDays();
        int totalDays1 = otherDate.countsDays();

        return totalDays > totalDays1;
    }

    /**
     * Returns the difference in number of days between the date and the one
     * received as parameter.
     *
     * @param otherDate the other date to compare to date, in order to calculate
     * the difference between the number of days.
     * @return difference in number of days between the two dates.
     */
    public int difference(DatePPROG otherDate) {
        int totalDays = countsDays();
        int totalDays1 = otherDate.countsDays();

        return Math.abs(totalDays - totalDays1);
    }

    /**
     * Returns the difference in number of days between two dates.
     *
     * @param otherDate the other date to compare with the date to calculate the
     * difference of number of days.
     * @return difference in number of days between two dates.
     */
    public int differenceE(DatePPROG otherDate) {
        int totalDays = countsDays();
        int totalDays1 = otherDate.countsDays();

        return totalDays - totalDays1;
    }

    /**
     * Returns the difference in number of days between two dates, receiving the
     * year, month and day as parameter.
     *
     * @param year the year of date with which we compare the date to calculate
     * the difference of number of days.
     * @param month the month of date with which we compare the date to
     * calculate the difference of number of days.
     * @param day the day of date with which we compare the date to calculate
     * the difference of number of days.
     * @return difference in number of days between date and the date received
     * with year, month and day as parameter.
     * @throws isep.dei.esinf.projeto1.InvalidMonthException
     * @throws isep.dei.esinf.projeto1.InvalidDayException
     */
    public int difference(int year, int month, int day) throws InvalidMonthException, InvalidDayException {
        int totalDays = countsDays();
        DatePPROG otherDate = new DatePPROG(year, month, day);
        int totalDays1 = otherDate.countsDays();

        return Math.abs(totalDays - totalDays1);
    }

    /**
     * Return true if the year passed as parameter is a leap year, otherwise
     * returns false.
     *
     * @param year the year to validate.
     * @return true if the year passed as parameter is a leap year, otherwise
     * returns false.
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * Returns the date of the system in tha actual moment.
     *
     * @return the date of the system in tha actual moment.
     * @throws isep.dei.esinf.projeto1.InvalidMonthException
     * @throws isep.dei.esinf.projeto1.InvalidDayException
     */
    public static DatePPROG dateAtual() throws InvalidMonthException, InvalidDayException {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH) + 1;
        int day = today.get(Calendar.DAY_OF_MONTH);
        return new DatePPROG(year, month, day);
    }

    /**
     * Returns the number of days since day 1/1/1 until the date.
     *
     * @return number of days since day 1/1/1 until the date.
     */
    private int countsDays() {
        int totalDays = 0;

        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month.ordinal() + 1; i++) {
            totalDays += Month.getMonthOrder(i).numberOfDays(year);
        }
        totalDays += day;

        return totalDays;
    }

    public int returnNumberOfDays() {
        return month.numberOfDays;
    }
}
