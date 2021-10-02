/**
 *
 * @author adameinstein
 */
import java.util.Random;
public class SheepHeapTester {

	public static int getRandNum()//random number generator 0-99
	{
		Random r = new Random();
		int num = r.nextInt(100);
		while (num <= 0)
			num = r.nextInt(100);
		return num;
	}
	
	public static final int SIZE = 15;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Sheep Heap Tester");
		System.out.println();
		System.out.println("Starting by adding 15 sheep to the heap");
		SheepHeap heap = new SheepHeap(SIZE);
		for (int i=0;i<SIZE;i++)
		{
			String name = "Sheep"+(i+1);
			double weight = getRandNum();
			Sheep temp = new Sheep(name,weight);
			heap.addSheep(temp);
			System.out.println("Adding "+temp.getName()+" to the heap");
		}
		System.out.println();
		System.out.println("Sheep Roll Call!");
		heap.sheepRollCall();
		System.out.println();
		System.out.println("Removing 5 sheep from the heap");
		for (int i=0;i<5;i++)
		{
			Sheep temp = (Sheep)heap.removeSheep();
			System.out.println("Removing "+temp.getName()+" from the heap");
		}
		System.out.println();
		System.out.println("Sheep Roll Call!");
		heap.sheepRollCall();
		System.out.println();
		System.out.println("Sorting the heap by weight");
		heap.sheepHeapSort();
		System.out.println();
		System.out.println("DONE!");
	}

}
