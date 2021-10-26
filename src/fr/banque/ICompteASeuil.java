package fr.banque;

public interface ICompteASeuil {

	//methods
	public void retirer(double montant) throws BanqueException;
	

	//getters setters
	public double getSeuil();

	public void setSeuil(double seuil);
}
