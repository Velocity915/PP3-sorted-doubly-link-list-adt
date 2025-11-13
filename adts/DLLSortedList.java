package adts;

import nodes.DLLNode;

import interfaces.ListInterface;

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
