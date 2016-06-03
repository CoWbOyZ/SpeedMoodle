package jeu;

public class Joueur {
	String nom;
	public static final int PENALITE = 3;
	public int penalite = 0;

	public Joueur(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void annulerPenalite() {
		this.penalite = 0;
	}
	
	public void ajoutePenalite() {
		this.penalite = Joueur.PENALITE;
	}
	
	public boolean sansPenalite() {
		return (penalite == 0);
	}
	
	public void oterEventuellementUnePenalite() {
		if (penalite>0) {
			penalite--;
		}
	}
}