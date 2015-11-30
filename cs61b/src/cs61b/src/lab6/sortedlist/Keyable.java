/* Keyable.java */

package cs61b.src.lab6.sortedlist;

public interface Keyable {
    public int getKey();
    public boolean lessThan(Keyable x);
}
