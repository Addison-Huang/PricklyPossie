/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

/* Team PricklyPossie -- Addison Huang, Shayan Chowdhury, Thet Zaw
lab 03
*/

import java.util.ArrayList;

public class ALHeapMax
{

  //instance vars
  private ArrayList<Integer> _heap; 

  /*****************************************************
   * default constructor  ---  inits empty heap
   *****************************************************/
  public ALHeapMax()
  {
      _heap = new ArrayList<Integer>(); 
  }



  /*****************************************************
   * toString()  ---  overrides inherited method
   * Returns either 
   * a) a level-order traversal of the tree (simple version)
   * b) ASCII representation of the tree (more complicated, more fun)
   *****************************************************/
  public String toString() 
  {
      String retStr = "";
      for ( Integer g : _heap ) {
	  retStr = retStr + " " + g;
      }
      return retStr; 
  }//O(n)


  /*****************************************************
   * boolean isEmpty()
   * Returns true if no meaningful elements in heap, false otherwise
   *****************************************************/
  public boolean isEmpty()
  {
      return _heap.isEmpty();
  }//O(1)


  /*****************************************************
   * Integer peekMin()
   * Returns min value in heap
   * Postcondition: Heap remains unchanged.
   *****************************************************/
  public Integer peekMax()
  {
	if ( _heap.size() < 1 )
	    return null;
	else
	    return _heap.get(0); 
  }//O(1)


  /*****************************************************
   * add(Integer) 
   * Inserts an element in the heap
   * Postcondition: Tree exhibits heap property.
   *****************************************************/
  public void add( Integer addVal )
  {
      _heap.add(addVal); //First add the value to the heap.

      int currentIndex = _heap.size() - 1;  //It's index is _heap.size() - 1
      int parentIndex = (currentIndex - 1) / 2; //Index of the parent

      //Check to see if the parent is less than the child
      //If it is, swap positions
      //Keeps on checking (and swapping) until the parent is no longer less than the child or the child has become the root/first element
      while (addVal > _heap.get( parentIndex ) && currentIndex != 0) { 
	  swap(currentIndex, parentIndex);
	  currentIndex = parentIndex;
	  parentIndex = ( currentIndex - 1) / 2;
      } 
  }//O(n)


  /*****************************************************
   * removeMax()  ---  means of removing an element from heap
   * Removes and returns greatest element in heap.
   * Postcondition: Tree maintains heap property.
   *****************************************************/
  public Integer removeMax()
  {
      if ( isEmpty()) 
	  throw new NullPointerException();
	//store root 
	Integer ret = peekMax();
	//store val about to be swapped into temp
	Integer temp = _heap.get( _heap.size() - 1);
	//swap root and leaf
	swap( 0, _heap.size() - 1 );
	//cut off leaf
	_heap.remove( _heap.size() - 1);
	int pos = 0;
	int maxChild;
	while( pos < _heap.size() ) {
	    maxChild= maxChildPos(pos);
            //no children
	    if ( maxChild == -1 ) 
		break;
	    //> child
	    else if ( temp.compareTo( _heap.get(maxChild) ) >= 0 ) 
		break;
	    // < child
	    else {
		swap(pos, maxChild);
		pos = maxChild;
	    }
	}
	return ret;
  }//O(n)


  /*****************************************************
   * maxChildPos(int)  ---  helper fxn for removeMax()
   * Returns index of greatest child, or 
   * -1 if no children, or if input pos is not in ArrayList
   * Postcondition: Tree unchanged
   *****************************************************/
  private int maxChildPos( int pos )
  {
	int ret;
	int left = 2*pos + 1; //index of left child
	int right = 2*pos + 2; //index of right child
	//leaf or not in the heap
	if (pos >= _heap.size() || left >= _heap.size() ||  pos < 0 )
	    ret = -1;
	//only a right child
	else if ( right >= _heap.size() )
	    ret = left;
	//2 children
	else if ( _heap.get(left).compareTo(_heap.get(right)) > 0 )
	    ret = left;
	else
	    ret= right;
	return ret;
  }//O(n)
  

  //************ aux helper fxns ***************
  private Integer maxOf( Integer a, Integer b )
  {
    if ( a.compareTo(b) > 0 )
	    return a;
    else
	    return b;
  }

  //swap for an ArrayList
  private void swap( int pos1, int pos2 )
  {
    _heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
  }
  //********************************************



  //main method for testing
  public static void main( String[] args )
  {
    
      ALHeapMax pile = new ALHeapMax();

      pile.add(2);
      System.out.println(pile);
      pile.add(4);
      System.out.println(pile);
      pile.add(6);
      System.out.println(pile);
      pile.add(8);
      System.out.println(pile);
      pile.add(10);
      System.out.println(pile);
      pile.add(1);
      System.out.println(pile);
      pile.add(3);
      System.out.println(pile);
      pile.add(5);
      System.out.println(pile);
      pile.add(7);
      System.out.println(pile);
      pile.add(9);
      System.out.println(pile);

      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
      System.out.println("removing " + pile.removeMax() + "...");
      System.out.println(pile);
  }//end main()

}//end class ALHeap
