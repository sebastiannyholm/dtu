package hjemmeopgave01;

public class Password {
	
	public static boolean checkPWD(String password){

		//splitting the password into its character components
		char[] element = new char[password.length()];
		int count = 0;
		int passLength = password.length();
		element = password.toCharArray();
		
		//check1 - 8 characters long
		if (passLength < 8) return false;

		//check2 - alpha-numerical, use count to determine truth value for each index of the char[]
		for (int i = 0; i < passLength; i++){
			if (!Character.isLetterOrDigit(element[i]) || (int) element[i] == 43 || (int) element[i] == 45) return false;
		}
		
		//check3 - two letters
		for (int a = 0; a < passLength; a++){
			if (Character.isLetter(element[a])) count++;
			if (count == 2) break;
		}
		if (count != 2) return false;
		
		//check4 - two numbers
		count = 0;
		for (int s = 0; s < passLength; s++){
			if (Character.isDigit(element[s])) count++;
			if (count == 2) break;
		}
		if (count != 2) return false;

		//check5 - upper case letter
		for (int p = 0; p < passLength; p++){
			if (Character.isUpperCase(element[p])) break;
			if (p == passLength-1) return false;
		}

		//check6 - lower case letter
		for (int c = 0; c < passLength; c++){
			if (Character.isLowerCase(element[c])) break;
			if (c == passLength-1) return false;
		}
		//passed all test
		return true;	
	}
}











