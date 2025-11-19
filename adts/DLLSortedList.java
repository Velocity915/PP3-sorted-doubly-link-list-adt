package adts;

import nodes.DLLNode;

import interfaces.ListInterface;

public class DLLSortedList<E> implements ListInterface<E>
{
    private DLLNode<E> head = null;
    private DLLNode<E> tail = null;

    private boolean sequentialSearch = true;
    private int itemAmount = 0;

    private void switchSearch()
    {
        sequentialSearch = !sequentialSearch;
    }

    private DLLNode<E> find(E element)
    {
	    if(sequentialSearch)
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
                    for(int i = midIndex; i <= lowIndex + (highIndex - lowIndex)/2; i++)
                    {
                        mid = mid.getNext();
                        midIndex = i;
                    }
                }
                else if(((Comparable)element).compareTo(mid.getData()) < 0)
                {
                    highIndex = midIndex-1;
                    for(int i = midIndex; i >= lowIndex + (highIndex - lowIndex)/2; i--)
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
}


