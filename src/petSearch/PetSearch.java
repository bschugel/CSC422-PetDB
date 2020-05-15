package petSearch;

import java.util.Scanner;

public class PetSearch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		boolean loop2 = true;
		Pet pets[] = new Pet[100];
		int petCount = 0;
		int input=0;
		System.out.println("Pet Database Program.\r\n");
		while(loop) {
		System.out.print("What would you like to do?\r\n" + 
				" 1) View all pets\r\n" + 
				" 2) Add more pets\r\n" + 
				" 3) Update an existing pet\r\n" + 
				" 4) Remove an existing pet\r\n" + 
				" 5) Search pets by name\r\n" + 
				" 6) Search pets by age\r\n" + 
				" 7) Exit program\r\n" + 
				"Your choice: ");

			while(loop2) {					//Continuous loop until valid input entered (No error checking on input type at the moment)
				
				input = sc.nextInt();              
				if(input>0&&input<8) {
					System.out.println(); //create new line
					loop2=false;
				}
				else {
					System.out.println("Please enter a value from 1 to 7\r\n"
							+ "Your choice: ");
				}
			}
			loop2=true;
			
			switch(input) {			//Menu input selection switch
			case 1:
				System.out.println("+-------------------------+");
				System.out.printf("%1s %4s %1s %10s %1s %3s %1s\n","|", "ID","|","NAME","|","AGE","|");
				System.out.println("+-------------------------+");
				for(int i=0; i<petCount; i++) {
					//System.out.println("Name: "+pets[i].getName()+"  Age: "+pets[i].getAge());
					System.out.printf("%1s %4s %1s %10s %1s %3s %1s\n","|", i,"|",pets[i].getName(),"|",pets[i].getAge(),"|");
				}
				System.out.println("+-------------------------+");
				System.out.println(petCount+" rows in set.\n");
				break;
			case 2:
				int petsAdded=0;
				boolean loop3=true;
				if(sc.hasNextLine()) {
					sc.nextLine();
				}
				while(loop3) {
					

					System.out.print("add pet (name, age): ");
					String petInput = sc.nextLine();
					if(petInput.compareTo("done")==0) {
						loop3=false;
						System.out.println(petsAdded+" pets added.\n");
						break;
					}
					
					String[] petInputArr = petInput.split(" ", 2);
					pets[petCount]= new Pet();
					pets[petCount].setName(petInputArr[0]);
					pets[petCount].setAge(Integer.parseInt(petInputArr[1]));
					petCount++;
					petsAdded++;
					
				}
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
}

