/*my ArrayPriorityQueue removes from the end of the ArrayList
it adds to the index where it is greater than the value at that index

ArrayPriorityQueue
end ->        <- front

 */

/*Addison Huang
APCS2 pd02
HW #46 -- Arrr, There Be Priorities Here Matey 
2018 05 10
*/

import java.util.ArrayList;

public class ArrayPriorityQueue {
    // instance variables                                                       
    ArrayList<String> list;

    // default constructor                                                      
    public ArrayPriorityQueue() {
        list = new ArrayList<String>();
    }

    // methods
    //add to the index where it is greater than the value at that index
    //O(n)
    public void add (String value) {
	if (list.size() == 0) {
	    list.add(value);
	    return;
	}
        for (int i = 0; i < list.size(); i++) {
            if (value.compareTo(list.get(i)) > 0) {
                list.add(i,value);
                return;
            }
        }
    }

    //removes minimum by removing the last element
    //O(1)
    public String removeMin() {
	return list.remove(list.size()-1);
    }

    //uses isEmpty of ArrayList
    //O(1)
    public boolean isEmpty() {
	return list.isEmpty();
    }

    //returns minimum
    //O(1)
    public String peekMin() {
	if (list.size() < 1) 
	    return null;
	else
	    return list.get(list.size()-1);
    }

    //overwritten toString method
    //O(n)
    public String toString() {
	String ret = "end -> ";
	for (String s: list) {
	    ret = ret + s + " ";
	}
	ret += "<-front";
	return ret;
    }
	    

    public static void main(String[] args) {
	ArrayPriorityQueue joe = new ArrayPriorityQueue();
	joe.add("boo");
	joe.add("foo");
	joe.add("goo");
	joe.add("doo");
	joe.add("poo");
	System.out.println(joe);
	System.out.println(joe.peekMin());
	joe.removeMin();
	System.out.println(joe);
    }
}
