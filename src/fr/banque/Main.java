package fr.banque;

import java.util.Hashtable;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		//creation d'une liste de compte
		//Compte[] listComptes = new Compte[5];
		private Map<Integer, Integer> listeComptes = new Hashtable<Integer, Integer>();
		//creation d'un client
		Client client1 = new Client(1234, "LAMARCQ", "Olivier", 36);
		//creation de comptes 
		client1.setComptes(listComptes);
		Compte compte1 = new Compte(1234, 10000);
		Compte compte2 = new Compte(5678, 20000);
		CompteASeuil compte3 = new CompteASeuil(58418, 30000, 28000);
		CompteASeuil compte4 = new CompteASeuil(5124, 22000, 15000);
		CompteRemunere compte5 = new CompteRemunere(1213514634, 34000, 0.15);
		Compte compte6 = new Compte(85426, 30000);
		
		try {
		
		System.out.println("*** client 1***");
		System.out.println(client1);
		
		//ajout des comptes a client
		System.out.println("*** ajout des comptes***");
		System.out.println("compte1");
		client1.ajouterCompte(compte1);
		System.out.println("compte2");
		client1.ajouterCompte(compte2);
		System.out.println("compte3");
		client1.ajouterCompte(compte3);
//		System.out.println("compte4");
//		client1.ajouterCompte(compte4);
		System.out.println("compte5");
		client1.ajouterCompte(compte5);
//		System.out.println("compte6");
//		client1.ajouterCompte(compte6);
//		System.out.println(client1);
		
		//tests  des fonctions
		System.out.println("***retrait autorisé***");
		System.out.println(compte4);
		compte4.retirer(2000);
		System.out.println(compte4);
		System.out.println("***interets***");
		System.out.println(compte5);
		compte5.calculerInterets(0.15);
		compte5.verserInterets(0.15);
		System.out.println(compte5);
		
		//tests interfaces
		CompteASeuilRemunere compte7 = new CompteASeuilRemunere(15248, 15000, 10000, 0.15);
		client1.ajouterCompte(compte7);
		
		//tests  des fonctions
		System.out.println(client1);
		System.out.println("***retrait autorisé***");
		System.out.println(compte7);
		compte7.retirer(2000);
		System.out.println(compte7);
		System.out.println("***interets***");
		System.out.println(compte7);
		compte7.calculerInterets(0.15);
		compte7.verserInterets(0.15);
		System.out.println(compte7);
		
		//test compte en trop
		System.out.println("compte6");
		client1.ajouterCompte(compte6);
		
		
		
	} catch (BanqueException e){
		System.out.println(e.getMessage());
	}
}
}
