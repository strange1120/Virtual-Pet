package virtualpet;

public class VirtualPet {

	private int hunger;
	private int energy;
	private int boredom;
	
	
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
	public void tick(int amount) {
		hunger -= amount;
		energy -= amount;
		boredom -= amount;
	}
	public String oswaldStats() {
		return "Here are Oswalds current stats:\n"
				+ "Hunger:" + hunger + "\nEnergy:" + energy + "\nBoredom:" + boredom;
		
	}
	
}
