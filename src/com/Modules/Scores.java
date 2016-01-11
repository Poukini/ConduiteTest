package com.Modules;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created by benj on 14/12/2015.
 */
public class Scores implements Serializable{


    private List<Score> listScore0;
    private List<Score> listScore1;
    private List<Score> listScore2;

    public Scores(){
        this.listScore0 = new ArrayList<Score>();
        this.listScore1 = new ArrayList<Score>();
        this.listScore2 = new ArrayList<Score>();
    }

    public List<Score> getListScore0() {
        return listScore0;
    }

    public List<Score> getListScore1() {
        return listScore1;
    }

    public List<Score> getListScore2() {
        return listScore2;
    }

    private void setListScore0(List<Score> listScore0) {
        this.listScore0 = listScore0;
    }

    private void setListScore1(List<Score> listScore1) {
        this.listScore1 = listScore1;
    }

    private void setListScore2(List<Score> listScore2) {
        this.listScore2 = listScore2;
    }

    public void appendScore(Score s){
        if(s.getLevel()==0)
        {
            this.listScore0.add(s);
            Collections.sort(this.listScore0);
        }
        if(s.getLevel()==1)
        {
            this.listScore1.add(s);
            Collections.sort(this.listScore1);
        }
        if(s.getLevel()==2)
        {
            this.listScore2.add(s);
            Collections.sort(this.listScore2);
        }
    }

    public void load()
    {
        ObjectInputStream obj_in;
        FileInputStream f_in;
        try {

            f_in = new FileInputStream("myobject.data");
            obj_in = new ObjectInputStream (f_in);
            Object obj = obj_in.readObject();

            if (obj instanceof Scores)
            {
                this.setListScore0(((Scores) obj).getListScore0());
                this.setListScore1(((Scores) obj).getListScore1());
                this.setListScore2(((Scores) obj).getListScore2());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(){
        ObjectOutputStream obj_out;
        FileOutputStream f_out;
        try {
            f_out = new FileOutputStream("myobject.data");
            obj_out = new ObjectOutputStream (f_out);
            obj_out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
