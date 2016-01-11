package com.Modules;

import java.util.Random;

/**
 * Cette classe fournit des calculs aléatoires en fonction d'un niveau fixé lors de son instanciation
 * Les niveaux détermine la limite des nombres apparaissant dans les calculs ainsi que les opérateurs
 * Elle garde à chaque calcul qu'elle fournit tous les membres de l'opération (nombre,opérateur, résultat)
 */
public class Calculations {

    private static Random seed = new Random();

    //Operator used for the toString method
    private static String[] Operation = new String[]{"+", "-", "x", "/"};

    /**
     * Ces 2 tableaux définiront les limites des nombres pour les différents calculs
     * Le premier indice correspond à l'opération (+-,x,/)
     * Le second indice correspond au niveau de calcul
     * Niveau facile :      1..10 +- 1..10
     * Niveau moyen :       1..100 +- 1..100;   2..10 x 2..10
     * Niveau difficile :   50..150 +- 50..150; 5..12 x 5..12; 10..100/1..10
     *
     */

    //Le premier indice est l'opérateur (4 sous-tableaux)
    // le second indice est le niveau (3 entier par sous-tableaux)
    private static int[][] UpBound = {{10, 100, 150},  {10, 100, 150}, {10, 10, 12},   {1, 10, 100}};
    private static int[][] LowerBound = {{1, 1, 50},   {1, 1, 50},     {2, 2, 5},       {2, 2, 10}};

    //The current level of evaluations
    private int Level;
    //Limit of the random number used according to the level
    private int LLimit;
    private int RLimit;
    //Left and Right side number of the calcul
    private int LNumber;
    private int RNumber;


    //Index of the operator in the operation array
    private int OperatorIndex;


    //Limit of the operator's index, 2 -> +,- ; 3 -> +,-,x ; 4 -> +,-,x,/  (for the random functionnality)
    private int OperatorIndexLimit;

    //The stored result of the calcul
    private int Result;

    /**
     * Construit une instance de calcul définit pour un niveau
     * On y fixe la limite des entiers, et les opérateurs utilisés
     * L'opérateur n'est pas fixé, il variera au fur et a mesure des calculs proposés
     *
     * @param pLevel le level de l'instance de calcul
     */
    public Calculations(int pLevel) {

        this.Level = pLevel;

        //Level 0 : +, -
        //Level 1 : +, -, x
        //Level 2 : +, -, x, /
        OperatorIndexLimit = pLevel + 1;
    }


    /**
     * Méthode générant une chaîne de caractère aléatoire d'un calcul à effectuer
     * et enregistre les données de ce calculs (nombre droit et gauche, opérateur, résultat)
     * Génère les nombre droit et gauche aléatoirement de 1 à 'Limit'
     * Choisit l'opérateur du calcul à l'aide d'un index entre 0 et OperatorIndexLimit
     *
     * @return Une chaine de caractère d'un calcul à effectuer
     */
    public void ProvideCalc(int pOper) {
        //Defining the index of the Calcul's operator (+, -, x, /)
        OperatorIndex = pOper;

        LNumber = seed.nextInt(UpBound[OperatorIndex][Level]) + LowerBound[OperatorIndex][Level];

        //Pour une division, on prend les limites du niveau inférieur afin d'avoir 10..100 / 1..10
        RNumber = (OperatorIndex == 3)? seed.nextInt(UpBound[OperatorIndex][Level - 1]) + LowerBound[OperatorIndex][Level - 1]
                : seed.nextInt(UpBound[OperatorIndex][Level]) + LowerBound[OperatorIndex][Level];

        Result = CalcResult(OperatorIndex);

        //not used in Evaluation class
        //return LNumber + Operation[OperatorIndex] + RNumber;
    }

    /**
     * Méthode générant une chaîne de caractère aléatoire d'un calcul à effectuer
     * et enregistre les données de ce calculs (nombre droit et gauche, opérateur, résultat)
     * Génère les nombre droit et gauche aléatoirement de 1 à 'Limit'
     * Choisit l'opérateur du calcul à l'aide d'un index entre 0 et OperatorIndexLimit
     *
     * @return Une chaine de caractère d'un calcul à effectuer
     */
    public void ProvideCalc() {
        //Defining the index of the Calcul's operator (+, -, x, /)
        OperatorIndex = seed.nextInt(OperatorIndexLimit + 1);

        LNumber = seed.nextInt(UpBound[OperatorIndex][Level]) + LowerBound[OperatorIndex][Level];

        //Pour une division, on prend les limites du niveau inférieur afin d'avoir 10..100 / 1..10
        RNumber = (OperatorIndex == 3)? seed.nextInt(UpBound[OperatorIndex][Level - 1]) + LowerBound[OperatorIndex][Level - 1]
                : seed.nextInt(UpBound[OperatorIndex][Level]) + LowerBound[OperatorIndex][Level];

        Result = CalcResult(OperatorIndex);

        //not used in Evaluation class
        //return LNumber + operation[OperatorIndex] + RNumber;
    }

    /**
     * Méthode calculant le résultat du dernier calcul proposé par la classe
     *
     * @param pOper l'index de l'opérateur du calcul
     * @return Un entier résultat du calcul
     */
    private int CalcResult(int pOper) {
        int result = 0;
        try {
            // Tri-opérateur ternaire, c'est un Pokémon très très rare !
            result = (OperatorIndex == 0) ? LNumber + RNumber
                    : (OperatorIndex == 1) ? LNumber - RNumber
                    : (OperatorIndex == 2) ? LNumber * RNumber
                    : LNumber / RNumber;
        } catch (ArithmeticException e) {
            System.out.println("Erreur calcul résultat " + LNumber + Operation[pOper] + RNumber);
        }
        return result;
    }

    /**
     * Méthode vérifiant que le résultat donnée en paramètre est le même
     * que celui calculé lors de la précédente génération de calcul, stocké dans Result
     *
     * @param pResult le résultat de l'utilisateur à comparer
     * @return True si ce sont les mêmes, False sinon
     */
    public Boolean CheckResult(int pResult) {
        return Result == pResult;
    }

        public Random getSeed() {
        return seed;
    }

    public void setSeed(Random seed) {
        this.seed = seed;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public int getLNumber() {
        return LNumber;
    }

    public void setLNumber(int lNumber) {
        LNumber = lNumber;
    }

    public int getRNumber() {
        return RNumber;
    }

    public void setRNumber(int rNumber) {
        RNumber = rNumber;
    }

    public int getOperatorIndex() {
        return OperatorIndex;
    }

    public void setOperatorIndex(int operatorIndex) {
        OperatorIndex = operatorIndex;
    }

    public String[] getOperation() {
        return Operation;
    }

    public void setOperation(String[] operation) {
        Operation = operation;
    }

    public int getOperatorIndexLimit() {
        return OperatorIndexLimit;
    }

    public void setOperatorIndexLimit(int operatorIndexLimit) {
        OperatorIndexLimit = operatorIndexLimit;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int result) {
        Result = result;
    }

    public String getOperator() {
        return Operation[OperatorIndex];
    }

    //Search the s string in the operation array 
    //And change the OperatorIndex depending on the result
    public void setOperator(String s){
        int i = 0;

        for (i = 0 ; i < 4 ; i++)
            if (s == Operation[i])
                OperatorIndex = i;
    }

    public String toString(){
        return this.LNumber+this.Operation[this.OperatorIndex] + this.RNumber;
    }

}
