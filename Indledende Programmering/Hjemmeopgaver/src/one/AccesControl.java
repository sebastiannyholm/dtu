package one;

import java.util.Scanner;

public class AccesControl {

	static Scanner s = new Scanner(System.in);
	static String username, password, passwordRepeat, logInUsername, changePassword;
	static int choice;
	
	public static void main(String[] args) {
		
		int state = 0; // 0: Creat User, 1: Log in, 2: Logged in, 3: Change password, 4: Log off, 5: Shut down 
		
		while ( true ) {
			
			if ( state == 0 ) {
				
				state = createUser();
				
			} else if ( state == 1 ) {
				
				state = logIn();
				
			} else if ( state == 2 ) {
				
				state = loggedIn(); 
				
			} else if ( state == 3 ) {
				
				state = changePassword();
				
			} else if ( state == 4 ) {
				
				System.out.println("Logging off, bye bye " + username + ".");
				state = 1;
				
			} else if ( state == 5 ) {
				
				System.out.println("Shutting down, bye bye " + username + "!");
				break;
				
			}
			
		}
		
	}

	private static int createUser() {
		
		System.out.print("Please enter a non-empty username: ");
		username = s.nextLine();
		
		System.out.print("Please enter a password: ");
		password = s.nextLine();
		
		System.out.print("Please repeat the password: ");
		passwordRepeat = s.nextLine();
		if ( password.equals(passwordRepeat)) {
			System.out.println("You can now log in.");
			return 1;
		} else {
			System.out.println("Your passwords are not identical, try again.");
		}
		return 0;
	}

	private static int logIn() {
		
		System.out.print("Please enter your username: ");
		
		logInUsername = s.nextLine();
		
		if ( logInUsername.equals(username) ) {
			System.out.print("Please enter your password: ");
			if ( s.nextLine().equals(password) ) {
				System.out.println("You are now logged in.");
				System.out.println("Hello " + username + ", you now have three choices:");
				return 2;
			} else {
				System.out.println("Wrong password");
			}
		} else {
			System.out.println("The username doesnt exist, plz try again.");
		}
		return 1;
		
	}
	
	private static int loggedIn() {
		
		choice = 0;
		
		System.out.println("1 - Change password");
		System.out.println("2 - Log off");
		System.out.println("3 - Shut down");
		System.out.print("Please select: ");
		
		choice = Integer.parseInt(s.nextLine());
		
		if ( choice == 1 || choice == 2 || choice == 3 ) {
			
			return choice + 2;
		} else {
			System.out.println("That option is not available");
			return 2;
		}
		
	}
	
	private static int changePassword() {
		
		System.out.println("You can now change your password");
		System.out.print("Please enter your password: ");
		changePassword = s.nextLine();
		
		System.out.print("Please repeat your password: ");
		passwordRepeat = s.nextLine();
		
		if ( changePassword.equals(passwordRepeat)) {
			System.out.println("Your password has been changed.");
			password = changePassword;
			return 2;
		} else {
			System.out.println("Your passwords are not identical, try again.");
		}
		return 3;
		
		
		
	}
	
}
