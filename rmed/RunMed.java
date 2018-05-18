/**
 * Algorithm: 
 * This running median algorithm uses a min heap and a max heap together
 * The min heap stores the larger half of the values
 * The max heap stores the smaller half of the values
 * This makes it so the root of both these heaps are close to the median as possible (or they are the median)
 * 
 * To find the median, we first compare the sizes of the heaps.
 * If they are the same size, then the median is the average of the two roots
 * If they are not the same size, the median is the root of the heap with a greater number of elements/nodes. 
 **/

public class RunMed {

    //instance variables
    private ALHeapMin _bigVals;
    private ALHeapMax _lilVals;


    //constructors
    public RunMed() {
	_bigVals = new ALHeapMin();
	_lilVals = new ALHeapMax();
    }

    //Refer to above block comment for how the median is received
    public double getMedian() {
	//if the two heaps are the same size
	if (_bigVals.size() == _lilVals.size())
		return ((double) _bigVals.peekMin() + _lilVals.peekMax()) / 2;
	//if the minheap size is > maxheap size
	    else if (_bigVals.size() > _lilVals.size())
		return _bigVals.peekMin();
	//if the maxheap size is > minheap size
	else
		return _lilVals.peekMax();
    }

    /** 
     * To add a value, we first compare it to the root of the max heap.
     * If the value is less than (or equal to) the root of the max heap, we add the value to the max heap
     * Reminder: The max heap is the heap with all of the smaller values. Yes it's confusing
     * If it is not, we add the value to the minHeap. 
     * If the size of the heaps begin to differ by a value greater than one, we remove the root of the larger heap and add it to the other
     * The root wlll always be the smallest value in the min heap or the largest value in the max heap
     * This keeps the heaps balanced and allows the getMedian() algorithm to work at any stage
     **/ 
    public void add(Integer newVal) {
	//if int is in the lower half of numbers
	if (newVal <= _bigVals.peekMin()) {
		_bigVals.add(newVal);
	//if int is in the bigger half of numbers
	else {
		_lilVals.add(newVal);
	}
	//if the size differs by more than one
	if (_bigVals.size() - _lilVals.size == 2) {
		_lilVals.add(_bigVals.removeMin());
	}
	else if (_lilVals.size - bigVals.size() == 2) {
		_bigVals.add(_lilVals.removeMax());
	}
    } 


} 
