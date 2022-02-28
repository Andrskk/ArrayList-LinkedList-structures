import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class ListTester {
    public static void main(String[] args)
    {

        MyArrayList myArrayList = new MyArrayList();
        MyLinkedList myLinkedList =new MyLinkedList();

        Random random = new Random();

        // add block

        long startTime = System.nanoTime();

        for (int i=0;i<10;i++)
        {
            //int randNum = 1 + random.nextInt(6);
            char randomChar = (char) (random.nextInt(26) + 'a');
            myArrayList.add(randomChar);
        }
        long stopTime = System.nanoTime();
        System.out.println(("Time: "+(stopTime - startTime)/100));

        //remove block
        for (int i=0;i<10;i++)
        {
            //int randNum = 1 + random.nextInt(6);
            char randomChar = (char) (random.nextInt(26) + 'a');
            String s=Character.toString(randomChar);
            myArrayList.remove(s);
        }

        /*MyArrayList myArrayList = new MyArrayList();
        MyLinkedList myLinkedList =new MyLinkedList();

        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");
        myArrayList.add("d");
        myArrayList.add("e");
        System.out.println(myArrayList);
        myArrayList.add("f");
        System.out.println(myArrayList);
        System.out.println("*****************************");
        myArrayList.remove(0);
        System.out.println(myArrayList);
        myArrayList.remove(0);
        System.out.println(myArrayList);
*/

    }
}
    //*************** Time measurements **************************
/*
Random random = new Random();

        // add block
        long startTime = System.nanoTime();
        for (int i=0;i<10;i++)
        {
            //int randNum = 1 + random.nextInt(6);
            char randomChar = (char) (random.nextInt(26) + 'a');
            list.add(randomChar);
        }
        long stopTime = System.nanoTime();
        System.out.println(("Time: "+(stopTime - startTime)/100));

        //remove block
        for (int i=0;i<10;i++)
        {
            //int randNum = 1 + random.nextInt(6);
            char randomChar = (char) (random.nextInt(26) + 'a');
            String s=Character.toString(randomChar);
            list.remove(s);
        }
 */