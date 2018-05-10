// Shayan Chowdhury
// APCS2 pd2
// HW46 -- Arrr, There Be Priorities Here Matey
// 2018-5-10 F

import java.util.ArrayList;

public class ArrayPriorityQueue {

    private ArrayList<String> _queue;
    private boolean peeked;
    private int minIndex;

    public ArrayPriorityQueue() {
	_queue = new ArrayList();
    }

    public void add(String s) {
	_queue.add(s);
	peeked = false;
    }

    public boolean isEmpty() {
	return _queue.isEmpty();
    }

    public String peekMin(){
	if (isEmpty()) return null;
	String min = _queue.get(0);
	minIndex = 0;
	for (int i = 1; i < _queue.size(); i ++) {
	    if (_queue.get(i).compareTo( min ) < 0) {
		min = _queue.get(i);
		minIndex = i;
	    }
	}
	peeked = true;
	return min;
    }

    public String removeMin() {
	if (isEmpty()) return null;
	if (peeked) {
	    peeked = false;
	    return _queue.remove(minIndex);
	}
	int min = 0;
	for (int i = 1; i < _queue.size(); i ++) {
	    if ( _queue.get(i).compareTo( _queue.get(min) ) < 0 )
		 min = i;
	}
	return _queue.remove(min);
    }

    public static void main( String[] args ){

	ArrayPriorityQueue apq = new ArrayPriorityQueue();

	apq.add("foo");
	apq.add("moo");
	System.out.println( apq.peekMin( ) ); //foo
	System.out.println( apq.removeMin() ); //foo
	apq.add("goo");
	apq.add("hoo");
	System.out.println( apq.peekMin() ); //goo
	apq.add("doo");
	System.out.println( apq.removeMin() ); //doo

    }

}
