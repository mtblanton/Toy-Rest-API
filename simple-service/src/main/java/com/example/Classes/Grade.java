package com.example.Classes;

import java.util.Date;

/**
 * Created by Taylor on 7/22/2016.
 */
public class Grade {
    private Date date;
    private char grade;
    private int score;

    public Grade(Date date, char grade, int score) {
        this.date = date;
        this.grade = grade;
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
