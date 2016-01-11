package com.Test;

import com.Modules.Calculations;
import org.junit.Assert.*;

/**
 * Created by Kev1 on 11/01/2016.
 */
public class CalculationsTest {

    void setUp() {
        super.setUp();
    }


    void tearDown() {

    }


    void testGetLevel() {
        Calculations Test = new Calculations(0);
        assertEquals(0, Test.getLevel());
    }

    void testSetLevel() {
        Calculations Test = new Calculations(0);
        Test.setLevel(1);
        assertEquals(1, Test.getLevel());
        assertEquals(2, Test.getOperatorIndexLimit());
    }

    /**Permet de vérifier que les nombres sont bien définies entres les bornes des niveaux
     * On teste distinctement les nombre de droite et de gauche de l'opération car ils peuvent être différents
     */

    void testGetLNumber() {
        //CALCUL FACILE
        Calculations Test = new Calculations(0);
        Test.ProvideCalc();
        //ADDITION - SOUSTRACTION
        assertTrue(10 >= Test.getLNumber());
        assertTrue(1 <= Test.getLNumber());

        //CALCUL MOYEN
        Test = new Calculations(1);
        Test.ProvideCalc();
        //MULTIPLICATION
        if (Test.getOperatorIndex() == 2){
            assertTrue(10 >= Test.getLNumber());
            assertTrue(2 <= Test.getLNumber());
        }
        //ADDITION - SOUSTRACTION
        else {
            assertTrue(100 >= Test.getLNumber());
            assertTrue(1 <= Test.getLNumber());
        }

        //CALCUL DIFFICILE
        Test = new Calculations(2);
        Test.ProvideCalc();
        //DIVISION
        if (Test.getOperatorIndex() == 3){
            assertTrue(100 >= Test.getLNumber());
            assertTrue(10 <= Test.getLNumber());
        }
        //MULTIPLICATION
        else if (Test.getOperatorIndex() == 2) {
            assertTrue(12 >= Test.getLNumber());
            assertTrue(5 <= Test.getLNumber());
        }
        //ADDITION - SOUSTRACTION
        else {
            assertTrue(150 >= Test.getLNumber());
            assertTrue(50 >= Test.getLNumber());
        }


    }

    void testSetLNumber() {

    }

    /**Permet de vérifier que les nombres sont bien définies entres les bornes
     * Les bornes sont fixés en fonction du niveau et de l'opération
     * On teste distinctement les nombre de droite et de gauche de l'opération car ils peuvent être différents
     */

    void testGetRNumber() {
        //CALCUL FACILE
        Calculations Test = new Calculations(0);
        Test.ProvideCalc();
        //ADDITION - SOUSTRACTION
        assertTrue(10 >= Test.getLNumber());
        assertTrue(1 <= Test.getLNumber());

        //CALCUL MOYEN
        Test = new Calculations(1);
        Test.ProvideCalc();
        //MULTIPLICATION
        if (Test.getOperatorIndex() == 2){
            assertTrue(10 >= Test.getLNumber());
            assertTrue(2 <= Test.getLNumber());
        }
        //ADDITION - SOUSTRACTION
        else {
            assertTrue(100 >= Test.getLNumber());
            assertTrue(1 <= Test.getLNumber());
        }

        //CALCUL DIFFICILE
        Test = new Calculations(2);
        Test.ProvideCalc();
        //DIVISION
        if (Test.getOperatorIndex() == 3){
            assertTrue(10 >= Test.getLNumber());
            assertTrue(1 <= Test.getLNumber());
        }
        //MULTIPLICATION
        else if (Test.getOperatorIndex() == 2) {
            assertTrue(12 >= Test.getLNumber());
            assertTrue(5 <= Test.getLNumber());
        }
        //ADDITION - SOUSTRACTION
        else {
            assertTrue(150 >= Test.getLNumber());
            assertTrue(50 >= Test.getLNumber());
        }
    }

    void testSetRNumber() {

    }

    void testGetOperatorIndex() {

    }

    void testSetOperatorIndex() {

    }

    void testGetOperation() {

    }

    void testSetOperation() {

    }

    void testGetOperationIndexLimit() {

    }

    void testSetOperationIndexLimit() {

    }

    void testGetResult() {

    }

    void testSetResult() {

    }

    void testGetOperator() {

    }

    void testSetOperator() {

    }

    void testProvideCalc() {
        Calculations Test = new Calculations(0);
        Test.ProvideCalc();
        assertEquals(1,Test.getOperatorIndexLimit());
        assertTrue(1 >= Test.getOperatorIndex());
    }


}
