package com.Modules;


/**  Dans cette classe on s'occupe de cr�er les chronos �valuant chaque calcul que l'utilisateur fait
 *   On y garde un total de chrono et on g�re l'instanciation, le d�clenchement et l'arr�t de chaque chrono.
 */
public class Chrono {
	
	// Fonctions pour le chronometre
	private long ChronoGlobalInitial = 0 ;
	private long ChronoGlobalDernierCalcul = 0;

	// Lancement du chrono
	public void goChronoGlobal() {
		ChronoGlobalInitial = java.lang.System.currentTimeMillis() ;
		ChronoGlobalDernierCalcul = java.lang.System.currentTimeMillis();
	}

	// Arret du chrono
	public long stopChronoGlobal() {
		long ChronoActuel = java.lang.System.currentTimeMillis() ;
		long temps = ChronoActuel - ChronoGlobalInitial ;
		System.out.println("Temps total = " + temps + " ms") ;
		return temps;
	} 
	// Calcul du temps de l'�preuve
	public long getTempsCalcul(){
		long TempsCalcul = 0;
		long ChronoActuel = java.lang.System.currentTimeMillis() ;
		TempsCalcul = ChronoActuel - ChronoGlobalDernierCalcul ;
		ChronoGlobalDernierCalcul = ChronoActuel;
		System.out.println("Temps de calcul = " + TempsCalcul + " ms") ;
		
		return TempsCalcul;
	}
}
