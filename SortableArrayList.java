import java.util.Comparator;

/**
 * SortableArrayList inherits instance variables and methods from SimpleArrayList 
 * and have the sort method that will take in a comparator and reorder the list in ascending order.
 * 
 * @author Edwin Sanchez Huizar
 *
 * @param <T>
 */
public class SortableArrayList<T> extends SimpleArrayList<T>{

	/**
	 * Construct a new list with the default starting capacity.
	 * initialize all the instance variables defined in SimpleArrayList.
	 */
	public SortableArrayList() {
		super();
	}

	/**
	 * Construct a new list with the given starting capacity.
	 * initialize all the instance variables defined in SimpleArrayList.
	 * @param startingCapacity
	 */
	public SortableArrayList(int startingCapacity) {
		super(startingCapacity);
	}

	/**
	 * the sort method accepts a comparator object and use selection sort to reorder 
	 * the list in ascending order. Note that it changes the existing list and therefore 
	 * returns void as opposed to creating and returning a sorted copy of the list.
	 */
	public void sort(Comparator<? super T> c) {

		for (int i = size()-1; i >= 0; i--) {
			int maxIndex = i; //index

			//find max element
			for (int j = i; j >= 0; j--) {
				if (c.compare(get(j), get(maxIndex)) > 0) {
					maxIndex = j;
				}
			}
			T prevElement = set(i, get(maxIndex));
			set(maxIndex, prevElement);
		}
	}

	public String toString() {
		return super.toString();
	}
}
