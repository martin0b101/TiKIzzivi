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



}