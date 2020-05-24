package petSearch;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter; 


public class PetSearch implements java.io.Serializable{
	static int petCount = 0;
	static Pet pets[] = new Pet[100];
	public static void main(String[] args) {
		
		readFromFile();
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		boolean loop2 = true;
		int input=0;
		System.out.println("Pet Database Program.\r\n");
		while(loop) {
		System.out.print("What would you like to do?\r\n" + 
				" 1) View all pets\r\n" + 
				" 2) Add more pets\r\n" + 
				" 3) Remove an existing pet\r\n" + 
				" 4) Exit program\r\n\n" +
				"Your choice: ");

			while(loop2) {					//Continuous loop until valid input entered (No error checking on input type at the moment)
				try {
					input = sc.nextInt();
				} catch (InputMismatchException  e) {
					System.out.println("Error: Invalid input");
					clearLine(sc);
				}
				
				if(input>0&&input<5) {
					System.out.println(); //create new line
					loop2=false;
				}
				else {
					System.out.println("Error: Please enter a value between 1 and 4");
				}
			}
			loop2=true;
			
			switch(input) {			//Menu input selection switch
			case 1:		//view
				fullTable();
				break;
			case 2:		//Add
				int petsAdded=0;
				
				boolean loop3=true;
				clearLine(sc);
				while(loop3) {
					System.out.print("add pet (name, age): ");
					String petInput = sc.nextLine();
					if(petCount>=5) {
						System.out.println("Error: Database is full");
						System.out.println(petsAdded+" pets added.\n");
						break;
					}
					if(petInput.compareToIgnoreCase("done")==0) {
						loop3=false;
						System.out.println(petsAdded+" pets added.\n");
						break;
					}
					
					String[] petInputArr = petInput.split(" ", 3);
					if(petInputArr.length!=2||petInputArr[1]=="") {
						System.out.println("Error: "+petInput+" is not a valid input.");
					}
					else if(!(Integer.parseInt(petInputArr[1])>=0)||!(Integer.parseInt(petInputArr[1])<=20)) {
						System.out.println("Error: "+petInputArr[1]+" is not a valid age.");
					}
					else {
						pets[petCount]= new Pet();
						pets[petCount].setName(petInputArr[0]);
						pets[petCount].setAge(Integer.parseInt(petInputArr[1]));
						petCount++;
						petsAdded++;
					}
					
				}
				break;
			case 3:		//Remove
				clearLine(sc);
				fullTable();
				System.out.print("Enter the pet ID to remove: ");	//Release 3
				int r = sc.nextInt();
				if(r<0||r>=petCount) {
					System.out.println("Error: ID "+r+" does not exist.");
					break;
				}
				System.out.println(pets[r].getName()+" "+pets[r].getAge()+" is removed.");
				removeElement(r);
				break;
			case 4:			//Exit
				saveToFile(pets);
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
	static void createFile() {
		try {
		      File petFile = new File("petList.txt");
		      if (petFile.createNewFile()) {
		        System.out.println("File created: " + petFile.getName());
		      } 
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	static void saveToFile(Pet pet[]) {
		createFile();
		try {
		      FileWriter writer = new FileWriter("petList.txt");
		      for(int i=0;i<petCount;i++)
		    	  writer.write(pet[i].getName()+" "+pet[i].getAge()+"\n");
		      writer.close();
		    } catch (IOException e) {
		      System.out.println("IOException");
		      e.printStackTrace();
		    }
	}
	static void readFromFile() {
		 try {
		      File inputFile = new File("petList.txt");
		      Scanner sc = new Scanner(inputFile);
		      int i=0;
		      while (sc.hasNextLine()) {
		        String data = sc.nextLine();
		        String[] dataSplit = data.split(" ", 2);
		        pets[i] = new Pet();
		        pets[i].setName(dataSplit[0]);
		        pets[i].setAge(Integer.parseInt(dataSplit[1]));
		        i++;
		        petCount++;
		      }
		      sc.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
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


