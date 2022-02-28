import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

//Linkedlist class
public class MyLinkedList<E> implements List<E> {

    //Instance variables initialization
    private int size;
    private Node head;

    //Parameterized constructor
    public MyLinkedList(int size, Node head)
    {
        this.size = size;
        this.head = head;
    }

    //Default constructor
    public MyLinkedList()
    {
        this.head=null;
        this.size=size();
    }

    // Appends the specified element to the end of this list
    public boolean add(E e)
    {
        Node newNode = new Node(e);

        if (head==null)
        {
            head = newNode;
            head.previous=null;
            head.next=null;
            return true;
        }

        else
        {
            Node position = head;
            while (position.next!=null)
            {
                position=position.next;
            }
            position.next=newNode;
            newNode.previous=position;
            newNode.next=null;

            return true;
        }
    }

    // Inserts the specified element at the specified position in this list
    public void add(int index, E element)
    {
        Node newNode = new Node(element);
        Node current = head;
        if (index>=size()||index<0)
        {
            System.out.println("Impossible to add the element, index " + index+" is out of bounds." +
                    " Needs to be between 0 and " + (size()-1));return;
        }
        else if (index==0)
        {
            newNode.previous=null;
            newNode.next=head;
            head.previous=newNode;
            head=newNode;
        }

        else
        {
            for (int i=0;i<index-1;i++)
            {
                current=current.next;
            }

            newNode.previous=current;
            newNode.next=current.next;
            current.next=newNode;
            current.next.previous=newNode;
        }
    }

    // Removes all of the elements from this list
    public void clear(){head=null;}

    // Removes the element at the specified position in this list
    public E remove(int index)
    {
        Node current = head;
        if (index>=size()||index<0)
        {
            if (size()==0)
            {
                System.out.println("Impossible to remove the element "+index + ", list is empty");
                return (E)"-1";
            }
            else
            {
                System.out.println("Impossible to remove the element, index " + index+" is out of bounds." +
                        " Needs to be between 1 and " + (size()-1));return (E)"-1";
            }
        }
        else if(index==0)head=head.next;


        else
        {
            for (int i=0;i<index;i++)
            {
                current=current.next;
            }
            Node nextNode = current.next;
            Node previousNode = current.previous;
            if (nextNode==null){previousNode.next=null;}
            else
            {
                previousNode.next=nextNode;
                nextNode.previous=previousNode;
            }
        }
        return current.value;
    }

    // Removes the first occurrence of the specified element from this list
    public boolean remove(Object o)
    {
        Node position = head;
        int counter=0;
        while (position!=null)
        {
            if (position.value.equals(o))
            {
                remove(counter);
                System.out.println("Node "+"\""+o+"\""+" has been deleted.");
                return true;
            }
            counter++;
            position=position.next;
        }
        System.out.println("Node "+"\""+o+"\""+" is not found.");
        return false;
    }

    // Returns the number of elements in this list
    public int size()
    {
        int count=0;
        Node position = head;
        while (position!=null)
        {
            count++;
            position=position.next;
        }
        return count;
    }

    // Returns a string representation of this list
    @Override
    public String toString()
    {
        String result="";
        Node current = head;
        if (head==null)
        {
            return "List is empty";
        }
        result+="Nodes of the list: [ ";
        while (current!=null)
        {
            result+=current.getValue()+" ";

            current=current.next;
        }
        result+="]";

        return result;
    }

    //Node class
    private class Node{

        private E value;
        private Node previous;
        private Node next;

        public Node(E value,Node previous, Node next)
        {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
        public Node(E value)
        {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
        public Node()
        {
            this.value = null;
            this.next = null;
            this.previous = null;
        }

        public E getValue()
        {
            return value;
        }

        public void setValue(E value)
        {
            this.value = value;
        }

        public Node getNext()
        {

            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public Node getPrevious()
        {
            return previous;
        }

        public void setPrevious(Node previous)
        {
            this.previous = previous;
        }

        private Node copy(Node node)
        {
            Node newNode = new Node();
            newNode.setValue(node.value);
            newNode.setPrevious(node.getPrevious());
            newNode.setNext(node.getNext());
            return newNode;
        }
    }
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
