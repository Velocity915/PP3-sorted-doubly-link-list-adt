package adts;

import nodes.DLLNode;

import java.util.Iterator;

import interfaces.ListInterface;

public class DLLSortedList<E> implements ListInterface<E>, Iterable<E>
{
    private DLLNode<E> head = null;
    private DLLNode<E> tail = null;

    private String switcher = "forward";
    private boolean searchMode = true; //true == Sequential search || false == Binary search
    private int itemAmount = 0;

    public void switchSearch(String mode)
    {
        if(mode.toLowerCase().equals("sequential"))
        {
            searchMode = true;
        }
        else if(mode.toLowerCase().equals("binary"))
        {
            searchMode = false;
        }
    }

    private DLLNode<E> find(E element)
    {
	    if(searchMode)
        {
            DLLNode<E> temp = head;
            while (temp != null) 
            {
	            if (element.equals(temp.getData())) 
                {
	        	    return temp;
	            }
	            else 
                {
                    temp = temp.getNext();
	            }
	        }
        }
        else
        {
            DLLNode<E> mid = head;
            int lowIndex = 0;
            int highIndex = itemAmount-1;
            int midIndex = 0;
            for(int i = 1; i <= lowIndex + (highIndex - lowIndex)/2; i++)
            {
                mid = mid.getNext();
                midIndex = i;
            }


            while(lowIndex <= highIndex)
            {
                
                if(((Comparable)element).compareTo(mid.getData()) > 0)
                {
                    lowIndex = midIndex+1;
                    for(int i = lowIndex; i <= lowIndex + (highIndex - lowIndex)/2; i++)
                    {
                        mid = mid.getNext();
                        midIndex = i;
                    }
                }
                else if(((Comparable)element).compareTo(mid.getData()) < 0)
                {
                    highIndex = midIndex-1;
                    for(int i = highIndex; i >= lowIndex + (highIndex - lowIndex)/2; i--)
                    {
                        mid = mid.getPrev();
                        midIndex = i;
                    }
                }
                if(element.equals(mid.getData()))
                {
                    return mid;
                }
                
            }

        }
        return null;
    }
    
    @Override
    public void add(E element)
    {
        DLLNode<E> newNode = new DLLNode<>(element);
        if(itemAmount == 0)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            DLLNode<E> temp = head;
            while(temp != null)
            {
                if (((Comparable)element).compareTo(temp.getData()) > 0) 
                {
                    temp = temp.getNext();
                }
                else
                {
                    break;
                }
            }
            if(temp == null)
            {
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            }
            else if(temp == head)
            {
                head.setPrev(newNode);
                newNode.setNext(head);
                head = newNode;
            }
            else
            {
                newNode.setNext(temp);
                newNode.setPrev(temp.getPrev());
                temp.getPrev().setNext(newNode);
                temp.setPrev(newNode);
            }
        }
        itemAmount++;
    }

    @Override
    public boolean remove(E element)
    {
        DLLNode<E> temp = find(element);

        if(temp != null)
        {
            if(itemAmount == 1)
            {
                head = null;
                tail = null;
            }
            else if(temp == head)
            {
                head.getNext().setPrev(null);
                head = head.getNext();
            }
            else if(temp == tail)
            {
                tail.getPrev().setNext(null);
                tail = tail.getPrev();
            }
            else
            {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
            }
            itemAmount--;
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int size()
    {
        return itemAmount;
    }

    @Override
    public boolean isEmpty()
    {
        return itemAmount == 0;
    }

	@Override
	public boolean contains(E element) {
		DLLNode<E> currentLocation = head; 
		while(currentLocation.getData() !=null) {
			if(currentLocation.getData() == element)
				return true;
			else 
				currentLocation = currentLocation.getNext();	
		}
			return false;
	}

    @Override
    public E get(E element)
    {
        return find(element).getData();
    }

    @Override
    public E get(int index) {
        DLLNode<E> currentLocation;
		if(index == 0) return head.getData();
		else {
			currentLocation = head;
		
		for(int i = 0; i < index; i++) {
			currentLocation = currentLocation.getNext();
			}
		}
		return currentLocation.getData();
	}	
    @Override
    public String toString()
    {
    	DLLNode <E> currentLocation = head; 
		StringBuilder listStr = new StringBuilder("----------------\n");
    	 for(int i = 0; i < itemAmount; i++) {
    		listStr.append(currentLocation.getData()+ "\n");
    		currentLocation = currentLocation.getNext();
    	}
		return listStr.toString();
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
		int[]filter = new int [size()];
		
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
