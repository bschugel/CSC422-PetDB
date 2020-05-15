package petSearch;

import java.util.Scanner;

public class PetSearch {
	static int petCount = 0;
	static Pet pets[] = new Pet[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		boolean loop2 = true;
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
				" 7) Exit program\r\n\n" + 
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
				fullTable();
				break;
			case 2:
				int petsAdded=0;
				boolean loop3=true;
				clearLine(sc);
				while(loop3) {
					System.out.print("add pet (name, age): ");
					String petInput = sc.nextLine();
					if(petInput.compareToIgnoreCase("done")==0) {
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
				clearLine(sc);
				fullTable();
				System.out.print("Enter the pet ID you want to update: ");	//Release 3
				int id = sc.nextInt();
				clearLine(sc);
				System.out.print("Enter the new name and new age: ");
				String petInput = sc.nextLine();
				String[] petInputArr = petInput.split(" ", 2);
				pets[id].setName(petInputArr[0]);
				pets[id].setAge(Integer.parseInt(petInputArr[1]));
				break;
			case 4:
				clearLine(sc);
				fullTable();
				System.out.print("Enter the pet ID to remove: ");	//Release 3
				int r = sc.nextInt();
				System.out.println(pets[r].getName()+" "+pets[r].getAge()+" is removed.");
				removeElement(r);
				break;
			case 5:
				clearLine(sc);
				System.out.print("Enter a name to search: ");	//Release 2
				petSearch(sc.nextLine());
				break;
			case 6:
				clearLine(sc);
				System.out.println("Enter age to search: ");	//Release 2
				petSearch(sc.nextInt());
				break;
			case 7:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			}
		}

	}
	static void petSearch(String name) {
		tableStart();
		for(int i=0; i<petCount;i++) {
			if(name.compareToIgnoreCase(pets[i].getName())==0) {
				tableMiddle(i);
			}
		}
		tableEnd();
	}
	static void petSearch(int age) {
		tableStart();
		for(int i=0; i<petCount;i++) {
			if(age==pets[i].getAge()) {
				tableMiddle(i);
			}
		}
		tableEnd();
	}
	static void clearLine(Scanner sc) {
		if(sc.hasNextLine()) {
			sc.nextLine();
		}
	}
	static void tableStart() {
		System.out.println("+-------------------------+");
		System.out.printf("%1s %4s %1s %10s %1s %3s %1s\n","|", "ID","|","NAME","|","AGE","|");
		System.out.println("+-------------------------+");
	}
	static void tableMiddle(int i) {
		System.out.printf("%1s %4s %1s %10s %1s %3s %1s\n","|", i,"|",pets[i].getName(),"|",pets[i].getAge(),"|");
	}
	static void tableEnd() {
		System.out.println("+-------------------------+");
	}
	static void fullTable() {
		tableStart();
		for(int i=0; i<petCount; i++) {
			tableMiddle(i);
		}
		tableEnd();
		System.out.println(petCount+" rows in set.\n");
	}
	static void removeElement(int index) {
		Pet petsTemp[] = new Pet[100];
		for(int i=0;i<index;i++) {
			petsTemp[i]=pets[i];
		}
		for(int i=(index+1);i<petCount;i++) {
			petsTemp[i-1]=pets[i];
		}
		pets=petsTemp;
		petCount--;
	}
}


