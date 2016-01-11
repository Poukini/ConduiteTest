package com.Launcher;

import com.Modules.*;

public class Main {

    public static void main(String[] args){
  	
    	Evaluation eval = new Evaluation(2,0);
    	eval.RemplirTabEval();
    	Score resultat = eval.EvaluationGlobale();
		Scores allScore = new Scores();
		allScore.load();
		allScore.appendScore(resultat);
		for(Score s : allScore.getListScore0())
		{
			System.out.println(s.getUserName());
		}
		allScore.save();
    }
}
