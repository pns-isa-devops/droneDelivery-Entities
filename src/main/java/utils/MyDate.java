package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDate {

    private int day;
    private int month;
    private int year;
    private Date date;
    private int date_seconds;
    private String new_date;
    private String an_hour;

    static LocalDate localDate = LocalDate.now();

    public static String date_now = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public MyDate() {

    }

    public MyDate(String new_date, String an_hour) throws ParseException {
        date = parseparams(new_date);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        day = localDate.getDayOfMonth();
        month = localDate.getMonthValue();
        year = localDate.getYear();
        date_seconds = parsehour(an_hour);
        this.an_hour = an_hour;
        this.new_date = new_date;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDate_seconds() {
        return date_seconds;
    }

    public Date getDate() {
        return date;
    }

    private Date parseparams(String adate) throws ParseException {
        if (adate == null) throw new ParseException("The date cannot be null", 0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(adate);
    }

    private int parsehour(String hours) {
        String[] hours_split = hours.split("h");
        int seconds = 0;
        int temp = Integer.parseInt(hours_split[0]);
        seconds += temp * 3600;
        temp = Integer.parseInt(hours_split[1]);
        seconds += temp * 60;

        return seconds;
    }

    @Override
    public String toString() {
        return new_date + " " + an_hour;
    }

    public String getDate_now() {
        return date_now;
    }

    public void setDate_now(String date_now) {
        MyDate.date_now = date_now;
    }

    public static String convertMillisecondInHours(int milliseconds_given){
        int hours =  ((milliseconds_given / 3600000)%24);
        int minutes = ((milliseconds_given / 60000)%60);

        return hours + "h"+minutes;
    }

}
