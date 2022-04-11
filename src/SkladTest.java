import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkladTest {
    Sklad<String> sklad;

    @BeforeEach
    public void setUp(){
        sklad = new Sklad<>();
    }

    @Test
    public void testPush(){
        sklad.push("Test1");
    }

    @Test
    public void testPop(){
        sklad.push("Test1");
        assertEquals("Test1", sklad.pop());
    }

    @Test
    public void testExist(){
        sklad.push("Test1");
        sklad.push("Test2");
        assertTrue(sklad.exist("Test1"));
    }

    @Test
    public void testRemove(){
        sklad.push("Test1");
        sklad.push("Test2");
        sklad.push("Test3");
        assertEquals("Test2", sklad.remove("Test2"));
    }

    @Test
    public void testSize(){
        sklad.push("Test1");
        sklad.push("Test2");
        sklad.push("Test3");
        assertEquals(3, sklad.size());
    }




}