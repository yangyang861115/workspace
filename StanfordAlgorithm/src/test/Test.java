package test;

import java.util.Iterator;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("test" + '\t' + "tt");
        
        int l = 0b1100011;
        int y = l ^ (1 << 3);
        System.out.println(Integer.toBinaryString(l));
        System.out.println(Integer.toBinaryString(y));
        
    }

}
class MyList implements Iterable {

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return new MyIterator();
    }
    
}
class MyIterator implements Iterator {

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object next() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
