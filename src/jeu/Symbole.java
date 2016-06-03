package jeu;

public enum Symbole {
	maison,
	etoile,
	diamant,
	ballon,
	arbre,
	fanion,
	VIDE;
	
	private static final Symbole[] LES_SYMBOLES = Symbole.values();
	public static final int NBR_SYMBOLE = LES_SYMBOLES.length;
	
	public static Symbole get(int i) {
		return LES_SYMBOLES[i];
	}
	
	public String toString() {
		String chaine = "";
		switch (this) {
		case maison:chaine="maison";
		break;
		case etoile:chaine="etoile";
		break;
		case ballon:chaine="ballon";
		break;
		case diamant:chaine="diaman";
		break;
		case arbre:chaine=" arbre";
		break;
		case fanion:chaine="fanion";
		break;
		case VIDE:chaine=" VIDE ";
		break;
		default: chaine="_-**-_";
		break;
		}
		return chaine;
	}
}
