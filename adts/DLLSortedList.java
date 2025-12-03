package adts;

import nodes.DLLNode;

import interfaces.ListInterface;


 private String switcher = "forward";
public class DLLSortedList<E> implements ListInterface<E>
{
    private DLLNode<E> head = null;
    private DLLNode<E> tail = null;

    private int itemAmount = 0;

    @Override
    public void add(E element)
    {
        
    }

    @Override
    public boolean remove(E element)
    {
        return false;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean contains(E element)
    {
        return false;
    }

    @Override
    public E get(E element)
    {
        return null;
    }

    @Override
    public E get(int index)
    {
        return null;
    }

    @Override
    public String toString()
    {
        return null;
    }
}
@Override
	public Iterator<E> iterator() {
		String i = this.switcher;
		Iterator<E> switcher = null;
		
		if(i.compareTo("forward") == 0)
		switcher = new forwardIterator();
		else if(i.compareTo("reverse") == 0)
		switcher = new reverseIterator();
		else if(i.compareTo("random") == 0)
		switcher = new randomIterator();
		
		return switcher;
	}
	
	private class forwardIterator implements Iterator<E> {
		
		DLLNode<E> current = head;
		DLLNode<E> temp;
		@Override
		public boolean hasNext() {
			if(current == null)
				return false;
			else
				return true;
			
		}
		@Override
		public E next() {
			temp = current;
			current = current.getNext();
			return temp.getData();
			}
}

	private class reverseIterator implements Iterator<E> {
		DLLNode<E> current = tail;
		DLLNode<E> temp;
		
		@Override
		public boolean hasNext() {
			if(current == null)
				return false;
			else
				return true;
		}

		@Override
		public E next() {
			temp = current;
			
			current = current.getPrev();
			return temp.getData(); 
		}
}
	
	private class randomIterator implements Iterator<E> {
		DLLNode<E> current = head;
		DLLNode<E> temp;
		int[]filter = new int [size()];
		int zerocounter = 0; 
		
		
		@Override
		public boolean hasNext() {
			for(int i = 0; i <= filter.length-1; i++) {
				if(filter[i] == 0) {
					return true;}
				}
			return false;
		}

		@Override
		public E next() {
			
			
			int escape = 0;
			
			while(escape == 0) {
			
			int random_number = (int) (Math.floor(Math.random() * size()));
				
			if(random_number == 0 && filter[0] == 0) {
					filter[random_number] = 1;
					current = head;
					escape = 1;}
			else if (random_number > 0 && random_number < size()-1 && filter[random_number] == 0) {
				current = head;
				filter[random_number] = 1;
				escape = 1;
				for(int i = 0; i < random_number; i++) {
					current = current.getNext();}}
				else if (random_number == size() - 1 && filter[random_number] == 0) {
					filter[random_number] = 1;
					current = tail;
					escape = 1;}
			}
			
			return current.getData();
			
	
		
		}
	}

	public String getSwitcher() {
		return switcher;
	}

	public void setSwitcher(String switcher) {
		this.switcher = switcher;
	}



	}




