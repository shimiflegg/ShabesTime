package com.shimi.shabestime;

public class Shabbath {

    private String name;
    private String Date;

    public Shabbath() {
    }

    public String getName() {
        return name;

    }

    public Shabbath(String name, String date, String entry_time, String exit_time) {
        this.name = name;
        Date = date;
        Entry_time = entry_time;
        Exit_time = exit_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEntry_time() {
        return Entry_time;
    }

    public void setEntry_time(String entry_time) {
        Entry_time = entry_time;
    }

    public String getExit_time() {
        return Exit_time;
    }

    public void setExit_time(String exit_time) {
        Exit_time = exit_time;
    }

    private String Entry_time;
    private String Exit_time;
}
