import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var myList = new MyArrayList<String>();
        var testList = new ArrayList<String>();

        testList.add("test");
        testList.add("test");
        testList.add("test");

        myList.add("asd");
        myList.add("dsd");
        myList.add("bsd");
        System.out.println(myList.get(0) + "\n");

        myList.size();
        myList.display();

        myList.addAll(testList);
        myList.size();
        myList.display();

        System.out.println();
        myList.remove(0);
        myList.display();

        myList.sort();
        myList.display();
        myList.sort();
    }
}