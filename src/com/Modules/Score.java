package com.Modules;

import java.io.Serializable;

/**
 * Created by benj on 14/12/2015.
 */
public class Score implements Comparable<Score>, Serializable{
    private String userName;
    private String rang;
    private double valScore;
    private String time;
    private int level;

    public Score(String rang, double valScore, String time, int level, String userName) {
        this.rang = rang;
        this.valScore = valScore;
        this.time = time;
        this.level = level;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public double getValScore() {
        return valScore;
    }

    public void setValScore(Double valScore) {
        this.valScore = valScore;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int compareTo(Score o) {
        if (this.valScore > o.valScore)
            return -1;
        if(this.valScore == o.valScore)
            return 0;
        return 1;
    }
}
