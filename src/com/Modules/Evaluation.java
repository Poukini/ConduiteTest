package com.Modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.Modules.Calculations;

/**  Classe g�rant les Evaluations = Un ensemble de calculs propos� � l'utilisateur,
 *   Dont les r�sultats seront r�cup�r�s et trait�s dans cette classe pour rendre une
 *   note, une appr�ciation, quelque chose du genre quoi.
 */
public class Evaluation {

	private Chrono chrono;
	private Calculations[] TabCalculations;
	private int NbCalculations;

	//TabEval[i] informations du calcul i
	//TabEval[i][0] - R�ponse conforme ou non (0 ou 1)
	//TabEval[i][1] - Tps de r�ponse
	//TabEval[i][2] - Niveau de difficult�
	private long[][] TabEval;
	private int NiveauDifficult;
	private long ChronoTotal;
	private String userName;

	
    /**Constructeur avec le nombre de calcul et le niveau de difficult� de l'�valuation.
    *
    * @return Un entier r�sultat du calcul
    */
	public Evaluation(int nbCalculations, int niveauDifficult) {
		this.NbCalculations = nbCalculations;
		this.NiveauDifficult = niveauDifficult;
		this.chrono = new Chrono();
		this.TabCalculations = new Calculations[nbCalculations];
		this.TabEval = new long[nbCalculations][3];
		this.ChronoTotal = 0;
		int i = 0;
		for (i=0; i<this.NbCalculations; i++){
			if (niveauDifficult == 0)
				{this.TabCalculations[i] = new Calculations(0);}
			else if (niveauDifficult == 1)
				{this.TabCalculations[i] = new Calculations(1);}
			else if (niveauDifficult == 2)
				{this.TabCalculations[i] = new Calculations(2);}
			this.TabCalculations[i].ProvideCalc();
		}
	}
	
	
    /**M�thode d'interface avec l'utilisateur qui permet la r�ponse au calcul et qui stocke les r�sultats.
    *
    * 
    */
	public void RemplirTabEval(){
		int i =0;
	    int Result =0;
		/* Syst�me d'affichage et de saisie*/
		/* A modifier avec l'IHM */
	    System.out.println("Nom d'utilisateur ? ");
		try{
		    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    this.userName = bufferRead.readLine();
		      
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		chrono.goChronoGlobal();
		for (i=0; i<NbCalculations; i++){
			/* Syst�me d'affichage et de saisie*/
			/* A modifier avec l'IHM */
			String calcul = TabCalculations[i].getLNumber() + TabCalculations[i].getOperation()[TabCalculations[i].getOperatorIndex()] + TabCalculations[i].getRNumber() + " ? ";
		    System.out.println(calcul);
			try{
			    BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    Result = Integer.parseInt(bufferRead.readLine());
			      
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			if (TabCalculations[i].CheckResult(Result)){
				System.out.println("Bravo");
				this.TabEval[i][0] = 1;
				this.TabEval[i][1] = chrono.getTempsCalcul();
				this.TabEval[i][2] = TabCalculations[i].getLevel();
			}
			else{
				System.out.println("Echec.");
				this.TabEval[i][0] = 0;
				this.TabEval[i][1] = chrono.getTempsCalcul();
				this.TabEval[i][2] = TabCalculations[i].getLevel();
			}
		}
		ChronoTotal = chrono.stopChronoGlobal();
	}

	
	
    /**M�thode calculant les scores globaux de l'utilisateur
    *
    * @return Un tableau de string avec les donn�es de la partie. (voir score)
    */
	public Score EvaluationGlobale(){
		int i =0;
		int []TabNote = new int[NbCalculations];
		for (i=0; i<NbCalculations; i++){
			// Si erreur de l'utilisateur
			if (TabEval[i][0] == 0){
				if (TabEval[i][2] == 0)
					{TabNote[i] = 0;}
				if (TabEval[i][2] == 1 && (TabEval[i][1] <= 3000))
					{TabNote[i] = 1;}
				if (TabEval[i][2] == 2 && (TabEval[i][1] <= 5000))
					{TabNote[i] = 2;}
			}
			else{
				/*Pour les calculs faciles*/
				if (TabEval[i][2] == 0){
					if(TabEval[i][1] > 5000)
					{TabNote[i] = 0;}
					if(TabEval[i][1] <= 5000)
					{TabNote[i] = 2;}
					if(TabEval[i][1] <= 4500)
					{TabNote[i] = 4;}
					if(TabEval[i][1] <= 4000)
					{TabNote[i] = 6;}
					if(TabEval[i][1] <= 3500)
					{TabNote[i] = 8;}
					if(TabEval[i][1] <= 3000)
					{TabNote[i] = 10;}
					if(TabEval[i][1] <= 2500)
					{TabNote[i] = 12;}
					if(TabEval[i][1] <= 2000)
					{TabNote[i] = 14;}
					if(TabEval[i][1] <= 1500)
					{TabNote[i] = 16;}
					if(TabEval[i][1] <= 1000)
					{TabNote[i] = 18;}
					if(TabEval[i][1] <= 500)
					{TabNote[i] = 20;}
				}
				/*Pour les calculs moyens*/
				if (TabEval[i][2] == 1){	
					if(TabEval[i][1] > 10000)
					{TabNote[i] = 0;}
					if(TabEval[i][1] <= 10000)
					{TabNote[i] = 1;}
					if(TabEval[i][1] <= 9500)
					{TabNote[i] = 2;}
					if(TabEval[i][1] <= 9000)
					{TabNote[i] = 3;}
					if(TabEval[i][1] <= 8500)
					{TabNote[i] = 4;}
					if(TabEval[i][1] <= 8000)
					{TabNote[i] = 5;}
					if(TabEval[i][1] <= 7500)
					{TabNote[i] = 6;}
					if(TabEval[i][1] <= 7000)
					{TabNote[i] = 7;}
					if(TabEval[i][1] <= 6500)
					{TabNote[i] = 8;}
					if(TabEval[i][1] <= 6000)
					{TabNote[i] = 9;}
					if(TabEval[i][1] <= 5500)
					{TabNote[i] = 10;}
					if(TabEval[i][1] <= 5000)
					{TabNote[i] = 11;}
					if(TabEval[i][1] <= 4500)
					{TabNote[i] = 12;}
					if(TabEval[i][1] <= 4000)
					{TabNote[i] = 13;}
					if(TabEval[i][1] <= 3500)
					{TabNote[i] = 14;}
					if(TabEval[i][1] <= 3000)
					{TabNote[i] = 15;}
					if(TabEval[i][1] <= 2500)
					{TabNote[i] = 16;}
					if(TabEval[i][1] <= 2000)
					{TabNote[i] = 17;}
					if(TabEval[i][1] <= 1500)
					{TabNote[i] = 18;}
					if(TabEval[i][1] <= 1000)
					{TabNote[i] = 19;}
					if(TabEval[i][1] <= 500)
					{TabNote[i] = 20;}
				}
				/*Pour les calculs difficiles*/
				if (TabEval[i][2] == 2){
					if(TabEval[i][1] > 17000)
					{TabNote[i] = 0;}
					if(TabEval[i][1] <= 17000)
					{TabNote[i] = 1;}
					if(TabEval[i][1] <= 16000)
					{TabNote[i] = 2;}
					if(TabEval[i][1] <= 15000)
					{TabNote[i] = 3;}
					if(TabEval[i][1] <= 14000)
					{TabNote[i] = 4;}
					if(TabEval[i][1] <= 13000)
					{TabNote[i] = 5;}
					if(TabEval[i][1] <= 12000)
					{TabNote[i] = 6;}
					if(TabEval[i][1] <= 11500)
					{TabNote[i] = 7;}
					if(TabEval[i][1] <= 11000)
					{TabNote[i] = 8;}
					if(TabEval[i][1] <= 10500)
					{TabNote[i] = 9;}
					if(TabEval[i][1] <= 10000)
					{TabNote[i] = 10;}
					if(TabEval[i][1] <= 9500)
					{TabNote[i] = 11;}
					if(TabEval[i][1] <= 9000)
					{TabNote[i] = 12;}					
					if(TabEval[i][1] <= 8500)
					{TabNote[i] = 13;}
					if(TabEval[i][1] <= 8000)
					{TabNote[i] = 14;}
					if(TabEval[i][1] <= 7500)
					{TabNote[i] = 15;}
					if(TabEval[i][1] <= 7000)
					{TabNote[i] = 16;}
					if(TabEval[i][1] <= 6500)
					{TabNote[i] = 17;}
					if(TabEval[i][1] <= 6000)
					{TabNote[i] = 18;}
					if(TabEval[i][1] <= 5500)
					{TabNote[i] = 19;}
					if(TabEval[i][1] <= 5000)
					{TabNote[i] = 20;}
				}
				
			}
			
		}
		
		/*Calcul du score total*/
		int Score = 0;
		String Rang = "";
		for (i=0; i<NbCalculations; i++){
			Score = Score + TabNote[i];
		}
		Score = Score/NbCalculations;
		switch (Score){
		case 20 : Rang = "S+";
				break;
		case 19 : Rang = "S";
		break;
		case 18 : Rang = "S-";
		break;
		case 17 : Rang = "A+";
		break;
		case 16 : Rang = "A";
		break;
		case 15 : Rang = "A-";
		break;
		case 14 : Rang = "B+";
		break;
		case 13 : Rang = "B";
		break;
		case 12 : Rang = "B-";
		break;
		case 11 : Rang = "C+";
		break;
		case 10 : Rang = "C";
		break;
		case 9 : Rang = "C-";
		break;
		case 8 : Rang = "D+";
		break;
		case 7 : Rang = "D";
		break;
		case 6 : Rang = "D-";
		break;
		case 5 : Rang = "E+";
		break;
		case 4 : Rang = "E";
		break;
		case 3 : Rang = "E-";
		break;
		case 2 : Rang = "F+";
		break;
		case 1 : Rang = "F";
		break;
		case 0 : Rang = "F-";
		break;
		}
		
		String Niveau = "";
		if (NiveauDifficult == 0)
			{Niveau = "Facile";}
		if (NiveauDifficult == 1)
			{Niveau = "Moyen";}
		if (NiveauDifficult == 2)
			{Niveau = "Difficile";}
		String[] TabScore = new String[5];
		
		TabScore[0] = Rang; /*Rang*/
		TabScore[1] = (Score * ChronoTotal) + " points";/*valScore*/
		TabScore[2] = ChronoTotal + " ms"; /*Temps*/

		TabScore[3] = "Niveau " + NiveauDifficult; /*Difficult�*/
		TabScore[4] = userName;/*UserName*/
		System.out.println(TabScore[0] + " / " + TabScore[1] + " / " + TabScore[2] + " / " + TabScore[3] + " / " + TabScore[4]);
		Score s = new Score(Rang,(Score * ChronoTotal),(ChronoTotal + " ms"),NiveauDifficult, userName);


		return s;
	}
}
	
	
	
	
