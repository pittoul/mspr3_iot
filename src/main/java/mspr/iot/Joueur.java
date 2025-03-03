package mspr.iot;

import mspr.iot.Joueur;

public class Joueur {

	private String nom;

	public Joueur(String nom) {
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom)  || nom == "Vaneloppe")
			return false;
		return true;
	}


}
