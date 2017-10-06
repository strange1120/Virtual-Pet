package virtualpet;

import java.util.Scanner;

public class VirtualPetApp {
	
	private static String menuList;

	public static void displayMenu(String menuList) {
		System.out.println("What would you like to do with Oswald?\n"
				+ "1. Feed Oswald.\n"
				+ "2. Give Oswald a puzzle to solve.\n"
				+ "3. Give Oswald a new place to play and hide.\n"
				+ "4. Let Oswald get some sleep.\n"
				+ "5. Leave Oswald alone with his thoughts.\n"
				+ "6. Pick up Oswald and try to cuddle.");
		}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		VirtualPet stats = new VirtualPet(50,40,45);

		System.out.println("Meet Oswald the Octopus!");
		System.out.println("Contrary to popular belief, "
				+ "octopi are actually very intelligent and "
				+ "capable of solving complex puzzles");		
		
		System.out.println(stats.oswaldStats());
		displayMenu(menuList);
		
		
		int selection = input.nextInt();
		while (selection < 1 || selection > 6) {
			System.out.println("You have entered an invalid choice.");
			System.out.println(stats.oswaldStats());
			displayMenu(menuList);
			selection = input.nextInt();
		}
		int amount = 5;
		while (selection >= 1 && selection <= 6) {
			if (selection == 1) {
				stats.feed(amount);
				System.out.println("You have fed Oswald.");
			}
			if (selection == 2) {
					stats.givePuzzle(amount);
					System.out.println("Oswald is now working on solving his puzzle.");
			}
			if (selection == 3) {
				stats.giveHiding(amount);
				System.out.println("You've provided Oswald with a new hide and play spot.");
			}
			if  (selection == 4) {
				stats.sleep(amount);
				System.out.println("You've let Oswald get some sleep.");
			}

			if (selection == 5) {
				System.out.println("Oswald appreciates this moment of solitude. Namaste.");
			}
			
			if (selection == 6) {
				if (stats.getHunger() >= 30 && stats.getEnergy() >= 30 && stats.getBoredom() <=30) {
					System.out.println("Oswald appreciates that you're taking care of him properly. He loves you");
				} else if (stats.getHunger() < 30 && stats.getEnergy() < 30 && stats.getBoredom() > 30) {
					System.out.println("Oswald has inked you! He is not happy with the state of his care.");
				} else  {
					System.out.println("Oswald is trying to escape. Maybe you could improve his care.");				}
			}
			stats.tick(amount);
			System.out.println(stats.oswaldStats());
			displayMenu(menuList);
			selection = input.nextInt();
			while (selection < 0 || selection > 6) {
				System.out.println("You have entered an invalid choice.");
				System.out.println(stats.oswaldStats());
				displayMenu(menuList);;
				selection = input.nextInt();

			}

		}
		
		input.close();
	}
		
}

