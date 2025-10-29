package adts;

import interfaces.ListInterface;

public class ArraySortedList<E> extends ArrayBasedList<E> implements ListInterface<E> {

	public ArraySortedList() {
		super();
	}

	public ArraySortedList(int capacity) {
		super(capacity);
	}
	
	@Override
	public void add(E element) {
		if (numElements == list.length) {
			enlarge();
		}
		
		int addLocation = 0;
		while (addLocation < numElements) {
			if (((Comparable)element).compareTo(list[addLocation]) > 0) {
				addLocation++;
			}
			else {
				break;
			}
		}
		for (int i = numElements; i > addLocation; i--) {
			list[i] = list[i-1];
		}
		list[addLocation] = element;
		numElements++;
	}
	
	
	@Override
	public boolean remove(E element) {
    	find(element);  // sets found, and when found is true, sets location
	    if (found) {
	    	for (int i = location; i < numElements - 1; i++) {
		    	list[i] = list[i + 1];
	    	}
	    	list[numElements - 1] = null;
	    	numElements--;
	    }
	    return found;
	}
	
}
