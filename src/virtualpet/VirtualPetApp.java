package virtualpet;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetApp {

	public static void gameOver(int hunger, int energy, int boredom) {
		if (hunger < 0) {
			System.out.println("You let Oswald starve to death! Shame on you!");
			System.exit(0);
		}
		if (energy < 0) {
			System.out.println("Oswald has died of exhaustion! Shame on you!");
			System.exit(0);
		}
		if (boredom > 30) {
			System.out.println("Oswald has died of boredom! Shame on you!");
			System.exit(0);
		}
	}
	private static String menuList;

	public static void displayMenu(String menuList) {
		System.out.println(
				"What would you like to do with Oswald?\n" + "1. Feed Oswald.\n" + "2. Give Oswald a puzzle to solve.\n"
						+ "3. Give Oswald a new place to play and hide.\n" + "4. Let Oswald get some sleep.\n"
						+ "5. Leave Oswald alone with his thoughts.\n" + "6. Pick up Oswald and try to cuddle.");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		VirtualPet stats = new VirtualPet(30, 30, 5);

		System.out.println("Meet Oswald the Octopus!");
		System.out.println("Contrary to popular belief, " + "octopi are actually very intelligent and "
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
			int random = rand.nextInt(3) + 1;
			if (selection == 1) {
				if (stats.getHunger() == 50) {
					System.out.println("Oswald is full. Please don't overfeed him.");
				}
				else if (stats.getBoredom() > 20) {
					System.out.println("Oswald is too bored to think about eating!");
				} else {
					System.out.println("What would you like to feed Oswald?");
					String foodResponse = input.next();
					stats.checkFood(foodResponse);
					stats.feed(amount);
				}
			}
			if (selection == 2) {
				if (stats.getEnergy() < 25) {
					System.out.println("Oswald is brain fried. Maybe you should let him sleep.");
				} else {
					stats.givePuzzle(amount);
					System.out.println("Oswald is now working on solving his puzzle.");
				}
			}
			if (selection == 3) {
				if (stats.getHunger() < 30) {
					System.out.println("Oswald is hangry. He has no energy to play!");
				} else {
					stats.giveHiding(amount);
					System.out.println("You've provided Oswald with a new hide and play spot.");
				}
			}
			if (selection == 4) {
				stats.sleep(amount);
				System.out.println("You've let Oswald get some sleep.");
			}
			if (selection == 5) {
				System.out.println("Oswald appreciates this moment of solitude. Namaste.");
			}
			if (selection == 6) {
				if (stats.getHunger() >= 30 && stats.getEnergy() >= 30 && stats.getBoredom() < 30) {
					System.out.println("Oswald appreciates that you're taking care of him properly. He loves you");
				} else if (stats.getHunger() < 25 && stats.getEnergy() < 25 && stats.getBoredom() >= 15) {
					System.out.println("Oswald has inked you! He is not happy with the state of his care.");
				} else {
					System.out.println("Oswald is trying to escape. Maybe you could improve his care.");
				}
			}
			gameOver(stats.getHunger(), stats.getEnergy(), stats.getBoredom());
			stats.tick(random, amount);
			gameOver(stats.getHunger(), stats.getEnergy(), stats.getBoredom());
			System.out.println(stats.oswaldStats());
			displayMenu(menuList);
			selection = input.nextInt();
			while (selection < 0 || selection > 6) {
				System.out.println("You have entered an invalid choice.");
				System.out.println(stats.oswaldStats());
				displayMenu(menuList);
				selection = input.nextInt();
			}
		}
		input.close();
	}
}
