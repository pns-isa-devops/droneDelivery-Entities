package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDate {

    private int day; private int month; private int year; private Date date; private int date_seconds;
    public MyDate(String new_date, String an_hour) throws Exception {
        date = parseparams(new_date);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        day = localDate.getDayOfMonth();
        month = localDate.getMonthValue();
        year = localDate.getYear();
        date_seconds= parsehour(an_hour);
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

    private Date parseparams(String adate) throws Exception {
        if(adate == null) throw  new Exception("The date cannot be null");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.parse(adate);
    }

    private int parsehour(String hours) throws Exception{
        String[] hours_split = hours.split("h");
        int seconds = 0;
        int temp = Integer.parseInt(hours_split[0]);
        seconds += temp* 3600;
        temp = Integer.parseInt(hours_split[1]);
        seconds += temp * 60;

        return seconds;
    }
}
