//Thet Htay Zaw
//APCS2 pd2
//HW46 -- Arr, There Be Priorities Matey
//2018-05-09

import java.util.ArrayList; 

public class ArrayPriorityQueue implements PriorityQueue {

    //instance variables
    private ArrayList<String> _data;

    //Constructor
    public ArrayPriorityQueue()
    {
	_data = new ArrayList<String>();
    }


    //Methods

    //Simply adds the value to the end of the ArrayList
    //O(1)
    public void add(String insert)
    {
	_data.add(insert); 
    }


    //Just checks if its empty
    //O(1)
    public boolean isEmpty()
    {
	if (_data.size() <= 0 ) {
	    return true;
	}
	else {
	    return false;
	} 
    }

    
    //Precondition: _data is not empty
    //O(n) -- iterates through the ArrayList
    public String peekMin()
    {
	if (isEmpty()) {
	    throw new NullPointerException("The Queue is Empty");
	}
	else { 
	    String min = _data.get(0);
	    for ( String e : _data ) { //searches for smallest value
		if ( min.compareTo(e) > 0 ) {
		    min = e;
		}
	    }
	    return min; //returns smallest value
	}
    }

    //Precondition: _data is not empty
    //O(n) -- iterates through the ArrayList (twice. So technically O(2n) which falls to O(n) ) 
    public String removeMin()
    {
	if (isEmpty()) {
	    throw new NullPointerException("The Queue is Empty");
	}

	else {
	    String min = _data.get(0);
	    int minIndex = 0;
	    for (int i = 0; i < _data.size() ; i++ ) {
		if ( min.compareTo( _data.get(i)  ) > 0 ) {
		    min = _data.get(i);
		    minIndex = i; //finds smallest value and records it and its  index
		}
	    }
	    _data.remove(minIndex); //removes smallest value
	    return min; //indicates what was removed
	} 
    }

    public static void main(String[] args) {
	
	ArrayPriorityQueue schedulechange = new ArrayPriorityQueue();

	schedulechange.add("foo");
	schedulechange.add("moo");

	System.out.println(schedulechange.peekMin());
	System.out.println("\n" + schedulechange.removeMin());

	schedulechange.add("goo");
	schedulechange.add("hoo");
	schedulechange.add("doo");

	for (int i = 0 ; i < 4 ; i++ ) {
	    System.out.println("\n" + schedulechange.peekMin());
	    System.out.println(schedulechange.removeMin());
	}

	System.out.println("\n" + schedulechange.removeMin());
	

	/*What is printed out should be in this order:
	  foo 

	  doo (x2) 

	  goo (x2) 

	  hoo (x2) 

	  moo (x2) 

	  NullPointerException
	*/ 

	  

    } 
	




} 
