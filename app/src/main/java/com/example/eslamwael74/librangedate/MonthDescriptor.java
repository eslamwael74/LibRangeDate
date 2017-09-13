package com.example.eslamwael74.librangedate;

/**
 * Created by eslamwael74 on 12/09/17.
 */



import java.util.Date;

class MonthDescriptor {
    private final int month;
    private final int year;
    private final Date date;
    private String label;

    MonthDescriptor(int month, int year, Date date, String label) {
        this.month = month;
        this.year = year;
        this.date = date;
        this.label = label;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date getDate() {
        return date;
    }

    public String getLabel() {
        return label;
    }

    void setLabel(String label) {
        this.label = label;
    }

    @Override public String toString() {
        return "MonthDescriptor{"
                + "label='"
                + label
                + '\''
                + ", month="
                + month
                + ", year="
                + year
                + '}';
    }
}