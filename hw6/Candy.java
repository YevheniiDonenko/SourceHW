package hw6;

public class Candy implements Comparable<Candy> {
	String name;
	int sugar;
	int kcal;
	String type;
	String form;
	int weight;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getForm() {
		return form;
	}

	public int getSugar() {
		return sugar;
	}

	public int getKcal() {
		return kcal;
	}

	public int getWeight() {
		return weight;
	}

	public Candy(String name, String type, String form, int sugar, int kcal, int weight) {
		this.name = name;
		this.type = type;
		this.form = form;
		this.sugar = sugar;
		this.kcal = kcal;
		this.weight = weight;

	}

	public String printCand() {
		return name + ", " + type + ", кол-во сахара: " + sugar + "г, " + kcal + "ккал, " + weight + "г.";
	}

	@Override
	public int compareTo(Candy emp) {
		return (this.weight - emp.weight);
	}

	@Override
	public String toString() {
		return this.name + ", " + this.type + ", кол-во сахара: " + this.sugar + "г, " + this.kcal + "ккал, "
				+ this.weight + "г.\n" ;
	}

}
