/*
 * by Nick Comfort
 */
public class Sheep implements Comparable {

	private String name;
	private double weight;
	public Sheep()
	{
		this.name = "";
		this.weight = 0;
	}
	public Sheep(String aName, double aWeight)
	{
		this.setName(aName);
		this.setWeight(aWeight);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if (weight > 0)
			this.weight = weight;
	}
	public String toString()
	{
		return "Name: "+this.getName()+" Weight: "+this.getWeight();
	}
	public int compareTo(Object anObject)
	{
		if (anObject == null)
			return 0;
		Sheep aSheep = (Sheep)(anObject);
		if (this.weight < aSheep.getWeight())
			return -1;
		if (this.weight> aSheep.getWeight())
			return 1;
		else 
		return 0;
	}
}
