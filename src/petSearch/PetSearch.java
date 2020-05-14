package petSearch;

import java.util.Scanner;

public class PetSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		Pet[] pets = new Pet[100];
		int petCount = 0;
		
		System.out.print("Pet Database Program.\r\n\n" + 	
				"What would you like to do?\r\n" + 
				" 1) View all pets\r\n" + 
				" 2) Add more pets\r\n" + 
				" 3) Update an existing pet\r\n" + 
				" 4) Remove an existing pet\r\n" + 
				" 5) Search pets by name\r\n" + 
				" 6) Search pets by age\r\n" + 
				" 7) Exit program\r\n" + 
				"Your choice: ");
		int input=0;
		while(loop) {					//Continuous loop until valid input entered (No error checking on input type at the moment)
			
			input = sc.nextInt();              
			if(input>0&&input<8) {
				System.out.println("ok");
				loop=false;
			}
			else {
				System.out.println("Please enter a value from 1 to 7\r\n"
						+ "Your choice: ");
			}
		}
		switch(input) {			//Menu input selection switch
		case 1:
			System.out.println("View all pets here");
			for(int i=0; i<petCount; i++) {
				System.out.println("Name"+pets[i].getName());
			}
			break;
		case 2:
			if(sc.hasNextLine()) {
				sc.nextLine();
			}
			System.out.println("Add pet here");
			System.out.println("Input name");
			String nameInput = sc.nextLine();
			System.out.println("Input age");
			int ageInput = sc.nextInt();
			System.out.println(nameInput);
			pets[petCount].setName(nameInput);
			pets[petCount].setAge(ageInput);
			petCount++;
			break;
		case 3:
			System.out.println("Update pet TODO");	//Release 3
			break;
		case 4:
			System.out.println("Remove pet TODO");	//Release 3
			break;
		case 5:
			System.out.println("Search by Name TODO");	//Release 2
			break;
		case 6:
			System.out.println("Search by Age TODO");	//Release 2
			break;
		case 7:
			System.exit(0);
			break;
		}
		
	}
}

