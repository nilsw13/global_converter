package fr.nilswenting.globalconverter;

// GESTION DES DIFFERENTES CONVERSIONS

public class Converter {
	
		
		private static final String[] hexadecimalValues = { 
		    "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "41", "42", "43", "44", "45", "46",
	            "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56",
	            "57", "58", "59", "5A", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C",
	            "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "20", "27"
		
	};
		
		private static final String[] decimalValues = { 
		    "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "65", "66", "67", "68", "69", "70", "71",
		    "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "97", "98", "99", "100", "101", "102", "103",
		    "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "32", "39"
		};
		
		private static final String[] octalValues = {
	    	    "060", "061", "062", "063", "064", "065", "066", "067", "070", "071", "101", "102", "103", "104", "105",
	            "106", "107", "110", "111", "112", "113", "114", "115", "116", "117", "120", "121", "122", "123",
	            "124", "125", "126", "127", "130", "131", "132", "141", "142", "143", "144", "145", "146", "147",
	            "150", "151", "152", "153", "154", "155", "156", "157", "160", "161", "162", "163", "164", "165",
	            "166", "167", "170", "171", "172", "040", "047"
	    };
		
		
		private static final String[] binaryValues = {
	            "00110000", "00110001", "00110010", "00110011", "00110100", "00110101", "00110110", "00110111", "00111000", "00111001", "01000001", "01000010", "01000011",
	            "01000100", "01000101", "01000110", "01000111", "01001000", "01001001", "01001010", "01001011", "01001100", "01001101",
	            "01001110", "01001111", "01010000", "01010001", "01010010", "01010011", "01010100", "01010101", "01010110",
	            "01010111", "01011000", "01011001", "01011010", "01100001", "01100010", "01100011", "01100100",
	            "01100101", "01100110", "01100111", "01101000", "01101001", "01101010", "01101011", "01101100",
	            "01101101", "01101110", "01101111", "01110000", "01110001", "01110010", "01110011", "01110100",
	            "01110101", "01110110", "01110111", "01111000", "01111001", "01111010", "00100000", "00100111"
	    };
		
		public boolean validateInput(String input) {
			return input.matches("[a-zA-Z0-9' ]+");
		}
		
		public boolean accurateChar(String input) {
			return input.matches("[hob]");
		}
		
		public boolean isValidChoice(char choice) {
	        return choice == 'h' || choice == 'o' || choice == 'b' || choice == 't' || choice == 'd';
	    }
		
		
		public String converterInput(String input, char choice) {
		    String result = "";
		    boolean validChoice = false; 
		    do {
		        
		        switch (choice) {
		            case 'h':
		                result = convertToHexadecimal(input);
		                validChoice = true;
		                break;
		            case 'd':
		            	result = convertToDecimal(input);
		            	validChoice = true;
		            	break;
		            case 'o':
		                result = convertToOctal(input);
		                validChoice = true;
		                break;
		            case 'b':
		                result = convertToBinary(input);
		                validChoice = true;
		                break;
		            case 't':
		                result = convertToText(input, ' ');
		                validChoice = true;
		                break;
		            default:
		                System.out.println("Choix invalide. Veuillez choisir parmi les propositions.");
		                choice = UserInputHandler.getConversionChoice();     
		        }
		    } while (!validChoice);

		    return result;
		}
		
		
		private String convertToDecimal (String input) {
			StringBuilder decimal = new StringBuilder();
			for (char c : input.toCharArray()) {
				int index = c - 'A';
				if (Character.isDigit(c) && c != '0') {
					index = c - '1' + 1;
	        	}else if (c == '\'') {
	        		index = 63;
	        	}else if (c == '0') {
	        	    index = 0;
	        	}else if ( Character.isUpperCase(c)) {
	        		index = c - 'A' +10;
	        	} else if (Character.isLowerCase(c)) {
	                index = c - 'a' + 36;
	            } else if (Character.isWhitespace(c)) {
	            	index = c - ' ' +62;
	            }
	            if (index >= 0 && index < 64) {
	                decimal.append(decimalValues[index]);
	                decimal.append(" ");
	                
	            }
	        }
	        return decimal.toString();
		}
		
		
		
		
		private String convertToHexadecimal(String input) {
			StringBuilder hexadecimal = new StringBuilder();
	        for (char c : input.toCharArray()) {
	        	int index = c - 'A';
	        	if (Character.isDigit(c) && c != '0') {
	        	    index = c - '1' + 1;
	        	}else if (c == '\'') {
	        		index = 63;
	        	}else if (c == '0') {
	        	    index = 0;
	        	}else if ( Character.isUpperCase(c)) {
	        		index = c - 'A' +10;
	        	} else if (Character.isLowerCase(c)) {
	                index = c - 'a' + 36;
	            } else if (Character.isWhitespace(c)) {
	            	index = c - ' ' +62;
	            }
	            if (index >= 0 && index < 64) {
	                hexadecimal.append(hexadecimalValues[index]);
	                //hexadecimal.append(" ");
	            }
	        }
	        String hexadecimalString = hexadecimal.toString();
	        String[] split = hexadecimalString.split("(?<=\\G.{2})");

	        return String.join(" ", split);
		}
		
		private static String convertToOctal(String input) {
	        StringBuilder octal = new StringBuilder();
	        for (char c : input.toCharArray()) {
	        	int index = c - 'A';
	        	if (Character.isDigit(c) && c != '0') {
	        	    index = c - '1' + 1;
	        	}else if (c == '\'') {
	        		index = 63;
	        	}else if (c == '0') {
	        	    index = 0;
	        	} else if ( Character.isUpperCase(c)) {
	        		index = c - 'A' +10;
	        	}
	        	else if (Character.isLowerCase(c)) {
	                index = c - 'a' + 36;
	            } else if (Character.isWhitespace(c)) {
	            	index = 62;
	            }
	            if (index >= 0 && index < 64) {
	                octal.append(octalValues[index]);
	                //octal.append(" ");
	            } 
	        }
	        String octalString = octal.toString();
	        String[] split = octalString.split("(?<=\\G.{3})");

	        return String.join(" ", split);
	        
		}

	
	
	private static String convertToBinary(String input) {
        StringBuilder binary = new StringBuilder();
        for (char c : input.toCharArray()) {
            int index = c - 'A';
            if (Character.isDigit(c) && c != '0') {
        	    index = c - '1' + 1;
        	}else if (c == '\'') {
        		index = 63;
        	}else if (c == '0') {
        	    index = 0;
        	}else if ( Character.isUpperCase(c)) {
        		index = c - 'A' +10;
        	} else if (Character.isLowerCase(c)) {
                index = c - 'a' + 36;
            } else if (Character.isWhitespace(c)) {
            	index = c - ' ' +62;
            }
            if (index >= 0 && index < 64) {
                binary.append(binaryValues[index]);
                
            } 
        }
        String binaryString = binary.toString();
        String[] split = binaryString.split("(?<=\\G.{8})");

        return String.join(" ", split);
    }
	
	public String convertToText(String input, char choice) {
       
        String result = "";
        do {
            System.out.println("Choisissez la base de conversion pour revenir au texte :");
            System.out.println("o. Octal");
            System.out.println("h. Hexadécimal");
            System.out.println("b. Binaire");
            System.out.println("d. Décimal");
            choice = UserInputHandler.getRevertChoice();

            switch (choice) {
                case 'o':
                    result = revertFromOctal(input);
                    break;
                case 'h':
                    result = revertFromHexadecimal(input);
                    break;
                case 'b':
                    result = revertFromBinary(input);
                    break;
                case 'd':
                    result = revertFromDecimal(input);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir parmi les propositions.");
            }
        } while (choice != 'o' && choice != 'h' && choice != 'b' && choice != 'd');
     
        return result;
    }
        
        
    
        private static String revertFromOctal(String input) {
            StringBuilder text = new StringBuilder();
            String[] split = input.split(" ");
            for (String s : split) {
                int decimal = 0;
                int power = 0;
                for (int i = s.length() - 1; i >= 0; i--) {
                    int digit = s.charAt(i) - '0';
                    decimal += digit * Math.pow(8, power);
                    power++;
                }
                text.append((char) decimal);
            }
            return text.toString();
        }
        
        private static String revertFromHexadecimal(String input) {
            StringBuilder text = new StringBuilder();
            String[] split = input.split(" ");
            for (String s : split) {
                int decimal = 0;
                int power = 0;
                for (int i = s.length() - 1; i >= 0; i--) {
                    int digit = Converter.getHexadecimalValue(s.charAt(i));
                    decimal += digit * Math.pow(16, power);
                    power++;
                }
                text.append((char) decimal);
            }
            return text.toString();
        }
        
        
        private static int getHexadecimalValue(char c) {
            if (c >= '0' && c <= '9') {
                return c - '0';
            } else if (c >= 'A' && c <= 'F') {
                return c - 'A' + 10;
            } else if (c >= 'a' && c <= 'f') {
                return c - 'a' + 10;
            }
            return 0;
        }
        
        private static String revertFromBinary(String input) {
            StringBuilder text = new StringBuilder();
            String[] split = input.split(" ");
            for (String s : split) {
                int decimal = 0;
                int power = 0;
                for (int i = s.length() - 1; i >= 0; i--) {
                    int digit = s.charAt(i) - '0';
                    decimal += digit * Math.pow(2, power);
                    power++;
                }
                text.append((char) decimal);
                
            }
            return text.toString();
        }
        
        private static String revertFromDecimal(String input) {
            StringBuilder text = new StringBuilder();
            String[] split = input.split(" ");
            for (String s : split) {
                int decimal = Integer.parseInt(s);
                text.append((char) decimal);
            }
            return text.toString();
            }
            
            
        
	
	

}
