package jeu;

import java.util.ArrayList;
import java.util.Collections;

public class PaquetCartes {
	//
	private ArrayList<Carte> cartes = new ArrayList<Carte>();
	private Joueur joueur;

	//
	private static final int NBR_CARTE = 72;

	/**
	 * Constructeur standard créant une liste d'objet carte de dimension NBR_CARTE et l'assigne à un joueur
	 */
	public PaquetCartes(Joueur joueur) {
		super();
		this.joueur = joueur;

		//On remplis le paquet de cartes jusqu'à qu'il soit plein
		boolean paquetPlein = false;
		while (!paquetPlein) {
			int i = 0;
			while (i < Carte.NBR_MOTIF && !paquetPlein) {
				int j = 0;
				while (j < Carte.NBR_COULEUR && !paquetPlein) {			
					int k =0;
					while (k < Carte.NBR_VALEUR && !paquetPlein) {
						paquetPlein = (this.size() == (PaquetCartes.NBR_CARTE*2));
						this.add(new Carte(j,k,Symbole.get(i)));
						k++;
					}	
					j++;
				}	
				i++;
			}
		}

		//On mélange les cartes
		Collections.shuffle(cartes);

		//On enlève la moitié des cartes
		for (int l = 0; l < NBR_CARTE; l++) {
			this.remove(this.size()-1);
		}

	}

	/**
	 * constructeur secondaire qui crée une liste d'objet carte de dimension nbcartes à partir de l'objet PaquetCartes p
	 * @param nbCartes taille du paquet de cartes
	 * @param p paquet de cartes dont les cartes seront retirées
	 */
	public PaquetCartes(PaquetCartes p, int nbCartes) {
		super();
		if (p.size() >= nbCartes) {
			this.joueur = p.getJoueur();
			for (int i = 0; i < p.size(); i++) {
				int pos = (int) (Math.random()*p.size());
				this.add(p.remove(pos));
			}
		}
		else {
			System.err.println("Le paquet "+p+"ne contient pas assez de cartes");
			System.exit(0);
		}
	}

	/**
	 * Raccourci vers la méthode cartes.add
	 * @param arg0
	 * @return
	 */
	public boolean add(Carte arg0) {
		return cartes.add(arg0);
	}

	/**
	 * Raccourci vers la methode cartes.remove
	 * @param index
	 * @return l'élément supprimé de la liste
	 */
	public Carte remove(int index) {
		return cartes.remove(index);
	}

	/**
	 * Raccourci vers la methode cartes.size
	 * @return la taille de la liste sous forme d'entier
	 */
	public int size() {
		return cartes.size();
	}

	public String getNomJoueur() {
		return this.joueur.nom;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public boolean gagne() {
		return !cartes.isEmpty() && cartes.get(0).isVide();
	}

	public void gererErreur(PaquetCartes paquet2) {
		this.getJoueur().ajoutePenalite();
		paquet2.getJoueur().annulerPenalite();
	}

	public Carte testerCarteSommet(int positionCarte, Carte sommet1, PaquetCartes paquet2) {
		if (sommet1.estCompatible(this.get(positionCarte))) {
			paquet2.joueur.oterEventuellementUnePenalite();
			return this.remove(positionCarte);
		} else {
			return null;	
		}
	}

	public boolean sansPenalite() {
		return joueur.sansPenalite();
	}

	public Carte get(int index) {
		return cartes.get(index);
	}
	
}