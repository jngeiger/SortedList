import java.util.function.BiFunction;
import java.util.function.Function;

public class SortedList<T extends Comparable<T>> {
    class Node{
        T payload;
        Node next;
        Node(T value)
        {
            this.payload = value;
        }
    }
    Node head;

    public void insert(T value, BiFunction<T,T, Boolean> func){
        if (head == null)
        {
            head = new Node(value);
        }
        else {
            if (func.apply(value,head.payload))
            {
                Node temp = head;
                head = new Node(value);
                head.next = temp;
            }

            else {
                Node currentNode = head;
                while (currentNode.next != null)
                {
                    if (func.apply(value,currentNode.next.payload))
                    {
                        Node temp = currentNode.next;
                        currentNode.next = new Node(value);
                        currentNode.next.next = temp;
                        return;
                    }
                    currentNode = currentNode.next;
                }
                currentNode.next = new Node(value);
            }
        }
    }

    public String toString()
    {
        String retVal = "";
        Node currentNode = head;
        while (currentNode != null)
        {
            retVal += currentNode.payload;
            if (currentNode.next != null)
                retVal += ",";
            currentNode = currentNode.next;
        }
        return retVal;
    }
    public static void main(String[] args)
    { }
}
