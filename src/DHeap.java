/**
 * D-Heap
 */

public class DHeap {

	private int size, max_size, d;
	private DHeap_Item[] array;

	// Constructor
	// m_d >= 2, m_size > 0
	DHeap(int m_d, int m_size) {
		max_size = m_size;
		d = m_d;
		array = new DHeap_Item[max_size];
		size = 0;
	}

	// Getter for size
	public int getSize() {
		return size;
	}

	/**
	 * public void arrayToHeap()
	 * 
	 * The function builds a new heap from the given array. Previous data of the
	 * heap should be erased. preconidtion: array1.length() <= max_size
	 * postcondition: isHeap() size = array.length()
	 */
	public int arrayToHeap(DHeap_Item[] array1) {
		this.array = array1;
		int count = 0;
		for (DHeap_Item item : this.array)
			count += heapifyDown(item);
		return count; // just for illustration - should be replaced by student
						// code
	}

	private int heapifyDown(DHeap_Item item) {
		DHeap_Item smallest = item;
		int count=0;
		for (int i=item.getPos(); i<d+item.getPos(); i++){
			count+=1;
			if (this.array[i].getKey()<smallest.getKey())
				smallest=this.array[i];
		}
		if (smallest==item)
			return count;
		else{
			this.array[smallest.getPos()]=item;
			this.array[item.getPos()]=smallest;
			int positions = smallest.getPos();
			int positioni= item.getPos();
			item.setPos(positions);
			smallest.setPos(positioni);
			return count+heapifyDown(item);
		}
	}

	/**
	 * public boolean isHeap()
	 * 
	 * The function returns true if and only if the D-ary tree rooted at
	 * array[0] satisfies the heap property or size == 0.
	 * 
	 */

	public boolean isHeap() {
		if (size == 0)
			return true;
		for (int i = 0; d * i + 1 < (array.length); i++)
			for (int j = 1; j < d; j++)
				if (this.array[i].getKey() < this.array[d * i + j].getKey())
					return false;
		return true;
	}

	/**
	 * public static int parent(i), child(i,k) (2 methods)
	 * 
	 * precondition: i >= 0
	 * 
	 * The methods compute the index of the parent and the k-th child of vertex
	 * i in a complete D-ary tree stored in an array. 1 <= k <= d. Note that
	 * indices of arrays in Java start from 0.
	 */
	public static int parent(int i, int d) {
		return ((i - 1) / d);
	} // just for illustration - should be replaced by student code

	public static int child(int i, int k, int d) {
		return d * i + k;
	}

	/**
	 * public int Insert(DHeap_Item item)
	 * 
	 * precondition: item != null isHeap() size < max_size
	 * 
	 * postcondition: isHeap()
	 */
	public int Insert(DHeap_Item item) {
		return d;// should be replaced by student code
	}

	/**
	 * public int Delete_Min()
	 * 
	 * precondition: size > 0 isHeap()
	 * 
	 * postcondition: isHeap()
	 */
	public int Delete_Min() {
		this.array[0] = this.array[this.size - 1];
		this.size--;
		this.array[0].setPos(0);
		int count = this.heapifyDown(this.array[0]);
		return count;
	}

	/**
	 * public String Get_Min()
	 * 
	 * precondition: heapsize > 0 isHeap() size > 0
	 * 
	 * postcondition: isHeap()
	 */
	public DHeap_Item Get_Min() {
		return this.array[0];
	}

	/**
	 * public int Decrease_Key(DHeap_Item item, int delta)
	 * 
	 * precondition: item.pos < size; item != null isHeap()
	 * 
	 * postcondition: isHeap()
	 */
	public int Decrease_Key(DHeap_Item item, int delta) {
		return delta;// should be replaced by student code
	}

	/**
	 * public void Delete(DHeap_Item item)
	 * 
	 * precondition: item.pos < size; item != null isHeap()
	 * 
	 * postcondition: isHeap()
	 */
	public int Delete(DHeap_Item item) {
		return d;// should be replaced by student code
	}

	/**
	 * Sort the array in-place using heap-sort (build a heap, and perform n
	 * times: get-min, del-min). Sorting should be done using the DHeap, value
	 * of item is irrelevant. Return the number of comparison performed.
	 */
	public static int DHeapSort(int[] array, int d) {
		return d;
	}
}
