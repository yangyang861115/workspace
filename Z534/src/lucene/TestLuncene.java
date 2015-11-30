package lucene;

import org.junit.Test;

public class TestLuncene {
    @Test
    public void testIndex(){
        HelloLucene h1 = new HelloLucene();
        h1.index(); 
        h1.searcher();
    }
    
//    public void testSearch(){
//        HelloLucene h1  = new HelloLucene();
//        
//    }
}
