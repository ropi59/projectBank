package fr.banque;

public interface ICompteRemunere {

		//methods
		public double calculerInterets(double taux);
		public void verserInterets(double taux);
		
		//getters setters
		public double getTaux();

		public void setTaux(double taux) throws BanqueException;
	
}