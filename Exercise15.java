public class Exercise15 {

    /*
    Write a method called notEquals that accepts a second list as a parameter, returns true if the two lists are not
equal, and returns false otherwise. Two lists are considered unequal if they store the different values in any random
order and do not have the same length.
     */

    public static void main(String[] args) {
        LinkedIntList liste1 = new LinkedIntList();
        LinkedIntList liste2 = new LinkedIntList();

        liste1.add (100);
        liste1.add (213);
        liste1.add (72);
        liste1.add (19);
        liste1.add (23);
        liste1.add (1);
        liste1.add (2);
        liste1.add (3);

        liste2.add (100);
        liste2.add (213);
        liste2.add (72);
        liste2.add (19);
        liste2.add (23);
        liste2.add (11);
        liste2.add (22);

        System.out.println("Liste 1: " + liste1);
        System.out.println("Liste 2: " + liste2 + "\n");

        boolean notTheSame = liste1.NotEquals(liste2);

        if (!notTheSame)
        {
            System.out.println("The Lists are not equals! YES!");
        }
        else
        {
            System.out.println("The lists are the same... omg");
        }
    }
}

class List
{
    public int data;
    public List next;

    public List(int data) {
        this(data,null);
    }

    public List(int data, List next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedIntList {
    private List front;

    public LinkedIntList() {
        front = null;
    }

    public int size() {
        int count = 0;
        List current = front;

        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            List current = front.next;

            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "] ";
            return result;
        }
    }

    public void add(int value) {
        if (front == null) {
            front = new List(value);
        } else {
            List current = front;

            while (current.next != null) {
                current = current.next;
            }
            current.next = new List(value);
        }
    }

    public boolean NotEquals(LinkedIntList list)
    {
        int sizeOne = size();
        int sizeTwo = list.size();
        System.out.println("\n Size of SizeOneList: " + sizeOne);
        System.out.println("\n Size of SizeTwoList: " + sizeTwo);

        if (sizeOne != sizeTwo) {
            List l1 = front;
            List l2 = list.front;

            while (l1 != null) {
                if (l1.data == l2.data) {
                    return false;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            System.out.println("Listerne har ikke samme elementer i orden.");
            return true;

        }
        return false;
    }
}