package fr.nilswenting.globalconverter;

// GESTION DES ENTREES UTILISATEURS

import java.util.Scanner;

public class UserInputHandler {
	
	private static Scanner scanner;
	
	public UserInputHandler() {
		scanner = new Scanner(System.in);
		}
	
	 
	
	public String getStringFromUser() {
		System.out.println("Entrez une chaine de caractères : ");
		return scanner.nextLine();
	}
	
	
	
	public static char getConversionChoice() {
		System.out.println("Choisissez le type de conversion :");
        System.out.println("H. Hexadécimal");
        System.out.println("D. Décimal");
        System.out.println("O. Octal");
        System.out.println("B. Binaire");
        System.out.println("T. Texte");
        System.out.print("Votre choix : ");
        String choiceString = scanner.nextLine();        
        if (choiceString == null || choiceString.isEmpty()) {
            return '\u0000';
        }
        
        return choiceString.charAt(0);
    
	}
	
	
	public static char getRevertChoice() {
	    String choiceString = scanner.nextLine().trim();
	    if (choiceString.isEmpty()) {
	        return '\u0000';
	    }
	    return choiceString.charAt(0);
	}
	
	public char getContinueChoice() {
		  	System.out.print("Souhaitez-vous réaliser une nouvelle conversion ? (o: Oui, n: Non) ");
		    String choiceStringContinue = scanner.nextLine();
		    if (choiceStringContinue == null || choiceStringContinue.isEmpty() || choiceStringContinue.length() > 1 || (choiceStringContinue.charAt(0) != 'o' && choiceStringContinue.charAt(0) != 'n')) {
		         
		        return '\u0000';
		    }

		    return choiceStringContinue.charAt(0);
		}
	
	
	
	public void closeScanner() {
		scanner.close();
	}

}
