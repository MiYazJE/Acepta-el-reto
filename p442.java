import java.util.Scanner;

public class p442 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String variable;
		String notacion;
		String result;
		char firstChar;					
		char currentChar;
		char previousChar;

		while(s.hasNext()) {

			result = "";

			variable = s.next();
			notacion = s.next();

			switch(notacion) {

				case "kebab-case":

					if(variable.indexOf("_") == -1) {

						result = ("" + variable.charAt(0));
						for(int i=1; i<variable.length(); i++) {

							currentChar = variable.charAt(i);
							previousChar = variable.charAt(i-1);

							if(Character.isUpperCase(currentChar)) {
								result = result + "-" + currentChar;
							} else {
								result += currentChar;
							}

						}

						result = result.toLowerCase();

						System.out.println(result);

					} else {

						variable = variable.toLowerCase();
						System.out.println(variable.replace('_', '-'));

					}

					

					break;

				case "CamelCase":

					variable = variable.replace('-',' ');
					variable = variable.replace('_',' ');

					firstChar = variable.charAt(0);
					result += Character.toUpperCase(firstChar);

					for(int i=1; i<variable.length(); i++) {

						currentChar = variable.charAt(i);
						previousChar = variable.charAt(i-1);

						if(previousChar == ' ') {
							result += Character.toUpperCase(currentChar);
						} else if(currentChar != ' ') {
							result += currentChar;
						}

					}

					System.out.println(result);
					break;

				case "snake_case":

					if(variable.indexOf("-") == -1) {

						result = ("" + variable.charAt(0));
						for(int i=1; i<variable.length(); i++) {

							currentChar = variable.charAt(i);
							previousChar = variable.charAt(i-1);

							if(Character.isUpperCase(currentChar)) {
								result = result + "_" + currentChar;
							} else {
								result += currentChar;
							}

						}

						result = result.toLowerCase();

						System.out.println(result);

					} else {

						variable = variable.toLowerCase();
						System.out.println(variable.replace('-', '_'));

					}

					

					break;

			}


		}





	}




}