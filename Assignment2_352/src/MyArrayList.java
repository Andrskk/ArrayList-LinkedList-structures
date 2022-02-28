import java.util.*;

//Arraylist class
public class MyArrayList <E> implements List<E> {

    //Instance variables initialization
    private final int INITIAL_CAPACITY=10;
    private Object [] data;
    private int size;
    private int n;

    //Parameterized constructor
    public MyArrayList(int size)
    {
        this.n=0;
        this.size=size;
        this.data=new Object[size];
    }

    //Default constructor
    public MyArrayList()
    {
        this.size= INITIAL_CAPACITY;
        this.n=0;
        this.data=new Object[size];
    }

    //Dynamic resizing (double the size when growing and halve the size when less than 25 % of the capacity is used)
    public boolean adjustArraySize()
    {
        if (n>(size*0.5))
        {
            size=size*2;
            Object[] newArray = new Object[size];
            for (int i=0;i<data.length;i++)
            {
                newArray[i] = data[i];
            }
            setData(newArray);

        }
        else if (n < (size*0.25))
        {
            size=size/2;
            Object[] newArray = new Object[size];
            for (int i=0;i<size;i++)
            {
                newArray[i] = data[i];
            }
            setData(newArray);
        }

        return true;
    }

    private void setData(Object[] o)
    {
        data=o;
    }

    // Appends the specified element to the end of this list
    public boolean add (E e)
    {
        data[n]=e;
        n++;
        adjustArraySize();
        return true;
    }
    // Inserts the specified element at the specified position in this list
    public void add(int index, E e)
    {
        if (index<0||index>n) System.out.println("Index is out of bounds, can't add the element.");

        else if(index==n)
        {
            data[index]=e;
            n++;
        }

        else
        {
            n++;
            Object[] newArray = new Object[size];

            for (int i = 0; i < size-1; i++)
            {
                if (i==index)newArray[i] = e;

                else if(i>index)newArray[i] = data[i-1];

                else newArray[i] = data[i];
            }
            setData(newArray);
        }
        adjustArraySize();
    }

    // Removes all of the elements from this list
    public void clear()
    {
        n=0;
        size=INITIAL_CAPACITY;
        Object[] newArray=new Object[size];
        setData(newArray);
    }

    // Removes the element at the specified position in this list
    public E remove(int index)
    {
        if (index<0||index>n) System.out.println("Index is out of bounds, can't add the element.");
        else
        {
            n--;
            Object[] newArray = new Object[size];

            for (int i = 0; i < size-1; i++)
            {
                if (i>=index)newArray[i] = data[i+1];

                else newArray[i] = data[i];
            }
            setData(newArray);
        }
        adjustArraySize();

        return (E)data[index];
    }

    // Removes the first occurrence of the specified element from this list
    public boolean remove(Object o)
    {
        for (int i=0;i<size-1;i++)
        {
            if (data[i]==null)break;
            if (data[i].equals(o))
            {
                n--;
                remove(i);
                adjustArraySize();
                return true;
            }
        }
        return false;
    }
    // Returns a string representation of this list
    @Override
    public String toString()
    {
        return "MyArrayList " +Arrays.toString(data);
    }

    // Returns the number of elements in this list
    public int size(){return size;}

    @Override
    public boolean addAll(Collection c){throw new UnsupportedOperationException();}

    @Override
    public boolean addAll(int index, Collection c){throw new UnsupportedOperationException();}

    @Override
    public boolean retainAll(Collection c){throw new UnsupportedOperationException();}

    @Override
    public boolean removeAll(Collection c){throw new UnsupportedOperationException();}

    @Override
    public boolean containsAll(Collection c){throw new UnsupportedOperationException();}
    @Override
    public boolean isEmpty(){throw new UnsupportedOperationException();}

    @Override
    public boolean contains(Object o){throw new UnsupportedOperationException();}

    @Override
    public Iterator iterator(){throw new UnsupportedOperationException();}

    @Override
    public Object[] toArray(){throw new UnsupportedOperationException();}

    @Override
    public Object[] toArray(Object[] a){throw new UnsupportedOperationException();}

    @Override
    public int indexOf(Object o){throw new UnsupportedOperationException();}

    @Override
    public int lastIndexOf(Object o){throw new UnsupportedOperationException();}

    @Override
    public ListIterator listIterator(){throw new UnsupportedOperationException();}

    @Override
    public ListIterator listIterator(int index){throw new UnsupportedOperationException();}

    @Override
    public List subList(int fromIndex, int toIndex){throw new UnsupportedOperationException();}
    @Override
    public E get(int index){throw new UnsupportedOperationException();}

    @Override
    public E set(int index, Object element){throw new UnsupportedOperationException();}

}

