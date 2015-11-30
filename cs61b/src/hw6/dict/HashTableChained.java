/* HashTableChained.java */

package hw6.dict;
import hw5.list.*;
/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
   private List<Entry> table[];
   private int tablesize;
   private int size;
   private int numDuplicates;
   
   
   public int collisions() {
       return numDuplicates;
   }

  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
	  tablesize = sizeEstimate * 5 / 3;
	  size = 0;
	  numDuplicates = 0;
	  while(!isPrime(size)){
		  tablesize++;
	  }
	  table = new DList[tablesize];
	  for(int i = 0; i < tablesize; i++){
		  table[i] = new DList<Entry>();
	  }
	  
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
	  tablesize = 101;
	  size = 0;
	  numDuplicates = 0;
	  table = new DList[tablesize];
	  for(int i = 0; i < tablesize; i++){
		  table[i] = new DList<Entry>();
	  }
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
	  int hashVal = code % tablesize;
	  if(hashVal < 0) return hashVal + tablesize;
      return hashVal;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return (size == 0);
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
	  int hash = key.hashCode();
      Entry entry = new Entry();
      entry.key = key;
      entry.value = value;
      if(table[compFunction(hash)].length() != 0){
    	  numDuplicates++;
      }
      table[compFunction(hash)].insertFront(entry);
      size++;
      return entry;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
	  int hash = key.hashCode();
	  ListNode node = table[compFunction(hash)].front();
      if (node.isValidNode()) {
        try {
			return (Entry) node.item();
		} catch (InvalidNodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
	int hash = key.hashCode();
	ListNode node = table[compFunction(hash)].front();
    if (node.isValidNode()) {
      Entry entry;
		try {
			entry = (Entry) node.item();
			node.remove();
			numDuplicates--;
			size--;
			return entry;
		} catch (InvalidNodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      
    }
    return null;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
	  for(int i = 0; i < tablesize; i++){
		  table[i] = new DList<Entry>();
	  }
	  size = 0;
	  numDuplicates = 0;
  }
  /**
   * Tests if the integer parameter is prime.
   * @return true if the parameter is a prime number.
   */
  private boolean isPrime(int n) {
    for (int divisor = 2; divisor < n; divisor++) {
      if (n % divisor == 0) {
        return false;
      }
    }
    return true;
  }
}
