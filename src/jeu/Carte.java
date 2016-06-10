package jeu;

import java.awt.Color;

public class Carte implements Test {

	private Color couleur;
	private Symbole motif;
	private int valeur;
	private boolean vide;

	public static int NBR_COULEUR = 5;
	public static int NBR_MOTIF = 5;
	public static int NBR_VALEUR = 5;

	/* (non-Javadoc)
	 * @see jeu.Test#getCouleur()
	 */
	@Override
	public Color getCouleur() {
		return couleur;
	}

	/* (non-Javadoc)
	 * @see jeu.Test#getMotif()
	 */
	@Override
	public Symbole getMotif() {
		return motif;
	}

	/* (non-Javadoc)
	 * @see jeu.Test#getValeur()
	 */
	@Override
	public int getValeur() {
		return valeur;
	}

	/* (non-Javadoc)
	 * @see jeu.Test#isVide()
	 */
	@Override
	public boolean isVide() {
		return vide;
	}

	/**
	 * Constructeur de cartes vides
	 */
	public Carte() {
		super();
		this.forceVide();
	}

	private void forceVide() {
		this.couleur = Color.darkGray;
		this.valeur = -1;
		this.motif = Symbole.VIDE;
		this.vide = true;
	}

	/**
	 * Constructeur de carte
	 * @param Couleur : sa couleur
	 * @param valeur : le nombre de motifs
	 * @param motif : son motif de type symbole
	 */
	public Carte(int indiceCouleur, int valeur, Symbole motif) {
		super();
		if (indiceCouleur>NBR_COULEUR || valeur>NBR_VALEUR) {
			System.out.println("couleur ou valeur de carte non valide");
			this.forceVide();
		} else if (Carte.NBR_MOTIF>Symbole.NBR_SYMBOLE){
			System.out.println("Nombre de motifs autorisés trop élevé");
			this.forceVide();
		}
		this.valeur = valeur;
		this.vide = false;
		this.motif = motif;
		this.couleur = getColor(indiceCouleur);
	} 

	private static Color getColor (int indiceCouleur) {
		Color couleur = null;
		switch (indiceCouleur) {
		case 1 : couleur=Color.blue;
		break;
		case 2 : couleur=Color.green;
		break;
		case 3 : couleur=Color.orange;
		break;
		case 4 : couleur=Color.pink;
		break;
		case 5 : couleur=Color.yellow;
		break;
		default: couleur=Color.darkGray;
		break;
		}
		return couleur;
	}

	public boolean estCompatible (Carte c2) {
		boolean test = false; 
		if (!c2.isVide() && !this.isVide() &&
				(this.couleur == c2.couleur) || (this.motif == c2.motif) || (this.valeur == c2.valeur)) {
			test = true;
		}
		return test;
	}

	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", motif=" + motif + ", valeur=" + valeur + ", vide=" + vide + "]";
	}
}
