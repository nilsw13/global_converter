package fr.nilswenting.globalconverter;
//Importer les fichiers de classes Converter et UserInputHandler si pas dans le même package

public class GlobalConverter {
	public static void main(String[] args) {
		Converter converter = new Converter();
        UserInputHandler inputHandler = new UserInputHandler();
        boolean continueConversion;
        do {
            String input = inputHandler.getStringFromUser();
            boolean isValid = converter.validateInput(input);
            
            
            while (!isValid) {
                System.out.println("Erreur ! Veuillez entrer uniquement des caractères alphanumériques, des espaces ou des apostrophes.");
                input = inputHandler.getStringFromUser();
                isValid = converter.validateInput(input);
            }
            
            char choice = UserInputHandler.getConversionChoice();
            String convertedResult = converter.converterInput(input, choice);
            System.out.println("Résultat : " + convertedResult);
            char continueChoice;
            
            
            do {
                continueChoice = inputHandler.getContinueChoice();
                if (continueChoice != 'o' && continueChoice != 'n') {
                    System.out.println("Erreur ! Veuillez choisir 'o' pour Oui ou 'n' pour Non.");
                }
            } while (continueChoice != 'o' && continueChoice != 'n');

            continueConversion = (continueChoice == 'o');

            
        } while (continueConversion);

        inputHandler.closeScanner();
        System.exit(0);
    }
}


           
