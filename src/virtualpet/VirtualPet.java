package virtualpet;

import java.util.ArrayList;

public class VirtualPet {

	private int hunger;
	private int energy;
	private int boredom;
	public ArrayList<String> favoriteFoods;

	public VirtualPet(int hunger, int energy, int boredom) {
		this.hunger = hunger;
		this.energy = energy;
		this.boredom = boredom;
	}

	public int getHunger() {
		return hunger;
	}

	public int getEnergy() {
		return energy;
	}

	public int getBoredom() {
		return boredom;
	}

	public void feed(int amount) {
		hunger += amount;
		energy += amount;
	}

	public void givePuzzle(int amount) {
		boredom -= amount;
		hunger -= amount;
	}

	public void giveHiding(int amount) {
		energy -= amount;
		hunger -= amount;
	}

	public void sleep(int amount) {
		energy += amount;
		boredom += amount;
	}

	public void addFavFoods() {
		favoriteFoods.add("Mollusk");
		favoriteFoods.add("Crab");
		favoriteFoods.add("Shrimp");
	}
	
	public String checkFood(String foodResponse) {
		if (favoriteFoods.contains(foodResponse)) {
			return "Oswald love that!";
		} else {
			return "Oswald hates that!";
		}
	}

	public String oswaldStats() {
		return "Here are Oswalds current stats:\n" + "Hunger:" + hunger + "\nEnergy:" + energy + "\nBoredom:" + boredom;
	}

	public void tick(int random, int amount) {
		if (random == 1) {
			if (hunger < 5) {
				hunger += amount;
			} else if (energy < 5) {
				energy += amount;
			} else if (boredom > 30) {
				boredom -= amount;
			} else {
				hunger += amount;
				boredom -= amount;
				energy -= amount;
			}
		}
		if (random == 2) {
			if (hunger < 5) {
				hunger += amount;
			} else if (energy < 5) {
				energy += amount;
			} else if (boredom > 30) {
				boredom -= amount;
			} else {
				hunger -= amount;
				boredom += amount;
				energy -= amount;
			}
		}
		if (random == 3) {
			if (hunger < 5) {
				hunger += amount;
			} else if (energy < 5) {
				energy += amount;
			} else if (boredom > 30) {
				boredom -= amount;
			} else {
				hunger -= amount;
				boredom -= amount;
				energy += amount;
			}

		}
		if (hunger > 50) {
			hunger = 50;
		}
		if (energy > 50) {
			energy = 50;
		}
		if (boredom < 0) {
			boredom = 0;
		}
	}
}
