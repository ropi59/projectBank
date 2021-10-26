package fr.banque;

import java.util.Arrays;
import java.util.Map;

public class Client {
	
	//attributs
	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private Map <Integer> listComptes;
	private int compteLimit = 5;
	int nbComptes = 0;
	//public List<Compte>listComptes = new ArrayList<>();
	
	//constructors
	public Client() {
		super();
	}
	
	public Client(int unNumero, String unNom, String unPrenom, int age) {
		super();
		this.numero = unNumero;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.setAge(age);
	}
	
	public Client(int unNumero, String unNom, String unPrenom, int age, Compte[] listComptes) {
		super();
		this.numero = unNumero;
		this.nom = unNom;
		this.prenom = unPrenom;
		this.age = age;
		
	}

	//getters setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age >=0) {
		this.age = age;
		}else {
			System.out.println("L'age doit etre positif");
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	//methods
	public void ajouterCompte(Compte unCompte) throws BanqueException{
		//verifier si je peux ajouter un compte
		// ajouter le compte
		for (int i = 0; i < this.listComptes.length; i++) {
				if(this.listComptes[i] == null) {
					nbComptes+=1;
					this.listComptes[i] = unCompte;
				System.out.println(nbComptes);
				break;
			}else {
				//verififer si le compte n'est pas deja present.
				if (this.listComptes[i].getNumero() == unCompte.getNumero()) {
					System.out.println("Attention ce compte existe!");	
					break;
				}
			}
		}
		//verifier si il reste des comptes de disponible
		if (nbComptes == compteLimit) {
			throw new BanqueException("Vous avez atteint le nombre maximal de comptes");
		}
	}
	
	//recuperer un compte par son numero
	public Compte getCompte(int numeroCompte){
		Compte findCompte = new Compte();
		for (int i = 0; i < this.listComptes.length; i++) {
			if(this.listComptes[i].getNumero() == numeroCompte) {
				findCompte = this.listComptes[i];
				break;
			}
		}if (findCompte.equals(null)) {
			System.out.println("Le compte n'a pas été trouvé.");
		}
		return findCompte;
	}
	
	//verifier si il y a encore des comptes de dispo avant d'en ajouter un
	public void setComptes(Compte[] listComptes) {
		if(listComptes.length != 5) {
			System.out.println("Il doit y avoir " + compteLimit + " comptes ratachés maximum.");
		}else {
			this.listComptes = listComptes;
		}
	}
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", numero=" + numero + ", listComptes="
				+ Arrays.toString(listComptes) + "]";
	}
}
