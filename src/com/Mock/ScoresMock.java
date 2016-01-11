package com.Mock;

import com.Modules.Score;
import com.Modules.Scores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by benj on 08/01/2016.
 */
public class ScoresMock {
    private Scores scoreMock;

    private List<Score> listScore0;
    private List<Score> listScore1;
    private List<Score> listScore2;

    public ScoresMock(){
        this.listScore0 = new ArrayList<Score>();
        this.listScore1 = new ArrayList<Score>();
        this.listScore2 = new ArrayList<Score>();
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
    public List<Score> getListScore0() {
        return listScore0;
    }

    public List<Score> getListScore1() {
        return listScore1;
    }

    public List<Score> getListScore2() {
        return listScore2;
    }

    private void setListScore0(List<Score> listScore0) { this.listScore0 = listScore0; }

    private void setListScore1(List<Score> listScore1) { this.listScore1 = listScore1; }
    private void setListScore2(List<Score> listScore2) {
        this.listScore2 = listScore2;
    }


    /**
     * Fonction permettant de simuler des valeurs pour lorsque l'on charge les valeurs contenues dans le fichier.
     * Retourne 5 valeurs pour la liste de difficulté 0, 6 pour la difficulté 1 et 7 pour la difficulté 2.
     */
    public void load()
    {
        for(int lvl =0; lvl<=2;lvl++)
        {
            for(int i =0; i<=(lvl+5);i++) {
                Score s = new Score("S", i, "16", lvl, "AAA");
                this.appendScore(s);
            }
        }
    }


}
