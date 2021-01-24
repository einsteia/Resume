/*
 * by Nick Comfort
 */
public class SheepHeap <Sheep extends Comparable>{

	private Sheep[] heap;
	private int lastIndex;
	public static final int DEF_SIZE = 128;
	public SheepHeap()
	{
		init(DEF_SIZE);
	}
	public SheepHeap(int size)
	{
		init(size);
	}
	public void init(int size)
	{
		if (size <= 0)
			return;
		heap = (Sheep[])(new Comparable[size]);
	}
	public void addSheep(Sheep aData)
	{
		if (lastIndex >= heap.length)
			return;
		heap[lastIndex] = aData;
		climbUp();
		lastIndex++;
	}
	private void climbUp()
	{
		int index = lastIndex;
		while (index > 0 && heap[pIndex(index)].compareTo(heap[index])<0)
		{
			Sheep temp = heap[pIndex(index)];
			heap[pIndex(index)] = heap[index];
			heap[index] = temp;
			index = pIndex(index);
		}
	}
	private int pIndex(int index)
	{
		return (index-1)/2;
	}
	private int lIndex(int index)
	{
		return index*2+1;
	}
	private int rIndex(int index)
	{
		return index*2+2;
	}
	public Sheep removeSheep()
	{
		if (heap == null)
			return null;
		Sheep temp = heap[0];
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		climbDown();
		return temp;
	}
	private void climbDown()
	{
		int index = 0;
		while (lIndex(index) < lastIndex)
		{
			if (heap[lIndex(index)] == null && heap[rIndex(index)] == null)
				break;
			int bigIndex = lIndex(index);
			if (rIndex(index) < lastIndex && heap[lIndex(index)].compareTo(heap[rIndex(index)])<0)
				bigIndex = rIndex(index);
			if (heap[index].compareTo(heap[bigIndex])<0)
			{
				Sheep temp = heap[index];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break;
			index = bigIndex;
		}
	}
	public void sheepRollCall()
	{
		for (int i=0;i<lastIndex;i++)
			System.out.println(heap[i].toString());
	}
	public void sheepHeapSort()
	{
		int temp = lastIndex;
		try {
			Sheep[] heap2 = heap.clone();
			for (int i =0; i<10; i++) {
				System.out.println(this.removeSheep() + " ");
			}
			for (int i = 0; i<heap2.length; i++) {
				heap[i] = heap2[i];
			}
			lastIndex = temp;
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public Sheep getSheep(int index)
	{
		if (heap[index] == null)
			return null;
		return heap[index];
	}
}
