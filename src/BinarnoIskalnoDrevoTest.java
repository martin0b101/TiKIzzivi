import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarnoIskalnoDrevoTest {
    BinarnoIskalnoDrevo<String> bst;


    @BeforeEach
    public void setUp() {
        bst = new BinarnoIskalnoDrevo();
    }


    @Test
    public void testAdd(){
        bst.add("Test1");
        bst.add("Test2");
    }

    @Test
    public void testRemoveFirst(){
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test0");
        assertEquals("Test1", bst.removeFirst());
        assertEquals("Test2", bst.removeFirst());
        assertEquals("Test0", bst.removeFirst());
    }


    @Test
    public void testExists(){
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test0");
        assertTrue(bst.exist("Test2"));
        assertFalse(bst.exist("Test11"));
    }

    @Test
    public void testGetFirst(){
        assertEquals(null, bst.getFirst());
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test0");
        assertEquals("Test1", bst.getFirst());
    }

    @Test
    public void testIsEmpty(){
        assertTrue(bst.isEmpty());
        bst.add("Test1");
        assertFalse(bst.isEmpty());
    }

    @Test
    public void testSize(){
        assertEquals(0, bst.size());
        bst.add("Test1");
        assertEquals(1, bst.size());
        bst.add("Test2");
        bst.add("Test0");
        assertEquals(3, bst.size());
        bst.add("Test3");
        assertEquals(4, bst.size());

    }

    @Test
    public void testDepth(){
        assertEquals(0, bst.depth());
        bst.add("Test1");
        assertEquals(1, bst.depth());
        bst.add("Test2");
        bst.add("Test0");
        assertEquals(2, bst.depth());
        bst.add("Test3");
        assertEquals(3, bst.depth());
    }


    @Test
    public void testRemove(){
        assertThrows(java.util.NoSuchElementException.class, () -> {
            bst.remove("Test1");
        }, "No such element in priority queue");
        bst.add("Test1");
        bst.add("Test0");
        assertEquals("Test1", bst.remove("Test1"));




    }

}