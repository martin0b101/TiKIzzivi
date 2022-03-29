import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeznamiUVTest {

    SeznamiUV uv;


    @BeforeEach
    public void setUp(){
        uv = new SeznamiUV();
        //pq = new SeznamiUV();

    }

    public SeznamiUVTest(){
    }

    @Test
    public void testPushBasic(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushBasic");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));

    }

    @Test
    public void testPushMultipleWords(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushMultipleWords");
        assertEquals("OK", uv.processInput("s_add \"Test with multiple words\""));
        assertEquals("1", uv.processInput("s_size"));
        assertEquals("OK", uv.processInput("s_add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("s_size"));
    }

    @Test
    public void testPushNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string", uv.processInput("s_add"));
    }
    @Test
    public void testPopBasic(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopBasic");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
        assertEquals("Test2", uv.processInput("s_remove_first"));
        assertEquals("Test1", uv.processInput("s_remove_first"));
    }


    @Test
    public void testPopMultipleWord(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopMultipleWords");
        assertEquals("OK", uv.processInput("s_add \"Test with multiple words\""));
        assertEquals("OK", uv.processInput("s_add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("s_size"));
        assertEquals("Another test with multiple words", uv.processInput("s_remove_first"));
        assertEquals("1", uv.processInput("s_size"));
        assertEquals("Test with multiple words", uv.processInput("s_remove_first"));
        assertEquals("0", uv.processInput("s_size"));

    }

    @Test
    public void testPopNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty", uv.processInput("s_remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("s_add"));
        assertEquals("Error: stack is empty", uv.processInput("s_remove_first"));

    }
    @Test
    public void testResetOnEmpty(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testResetOnEmpty");
        assertEquals("OK", uv.processInput("reset"));
    }

    @Test
    public void testResetOnFull(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testResetOnFull");
        assertEquals("OK", uv.processInput("s_add Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: stack is empty", uv.processInput("s_remove_first"));
        assertEquals("0", uv.processInput("s_size"));
    }

    @Test
    public void testCountOnEmpty(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOnEmpty");
        assertEquals("0", uv.processInput("s_size"));
    }

    @Test
    public void testCountOne() {
        System.out.println("testCountOne");
        assertEquals("OK", uv.processInput("s_add Test"));
        assertEquals("1", uv.processInput("s_size"));
    }

    @Test
    public void testCountTwo() {
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountTwo");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
        assertEquals("2", uv.processInput("s_size"));
    }

    @Test
    public void testIsTop() {
        System.out.println("testIsTop");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("OK", uv.processInput("s_get_first Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
        assertEquals("Error: wrong element", uv.processInput("s_get_first Test1"));
        assertEquals("Error: please specify a string", uv.processInput("s_get_first"));

    }
    @Test
    public void testIsTopEmpty(){
        System.out.println("testIsTopEmpty");
        assertEquals("Error: stack is empty", uv.processInput("s_get_first Test1"));
    }

    @Test
    public void testSearch(){
        System.out.println("testSearch");
        assertEquals("OK", uv.processInput("s_add Test1"));
        assertEquals("0", uv.processInput("search Test1"));
        assertEquals("OK", uv.processInput("s_add Test2"));
        assertEquals("1", uv.processInput("search Test1"));
        assertEquals("OK", uv.processInput("s_add Test3"));
        assertEquals("2", uv.processInput("search Test1"));
        assertEquals("Test3", uv.processInput("s_remove_first"));
        assertEquals("Test2", uv.processInput("s_remove_first"));
        assertEquals("Test1", uv.processInput("s_remove_first"));
        assertEquals("-1", uv.processInput("search Test1"));
        assertEquals("Error: please specify a string", uv.processInput("search"));
    }


    //Test for pq
    @Test
    public void testPqAdd(){
        System.out.println("testPqAdd");
        assertEquals("OK", uv.processInput("pq_add Test1"));
    }

    @Test
    public void testPqRemoveFirst(){
        System.out.println("testPqRemoveFirst");
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("Test1", uv.processInput("pq_remove_first"));
    }

    @Test
    public void testPqRemoveNothing(){
        System.out.println("testPqRemoveNothing");
        assertEquals("Error: priority queue is empty", uv.processInput("pq_remove_first"));
    }

    @Test
    public void testPqGetFirst(){
        System.out.println("testPqGetFirst");
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("Test1", uv.processInput("pq_get_first"));
    }

    @Test
    public void testPqGetFirstNothing(){
        System.out.println("testPqGetFirstNothing");
        assertEquals("Error: priority queue is empty", uv.processInput("pq_get_first"));
    }
    @Test
    public void testPqSize(){
        System.out.println("testPqSize");
        assertEquals("0", uv.processInput("pq_size"));
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("1", uv.processInput("pq_size"));
        assertEquals("OK", uv.processInput("pq_add Test2"));
        assertEquals("2", uv.processInput("pq_size"));
    }
    @Test
    public void testPqDepth(){
        System.out.println("testPqDepth");
        assertEquals("0", uv.processInput("pq_depth"));
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("1", uv.processInput("pq_depth"));
        assertEquals("OK", uv.processInput("pq_add Test2"));
        assertEquals("2", uv.processInput("pq_depth"));
        assertEquals("OK", uv.processInput("pq_add Test3"));
        assertEquals("2", uv.processInput("pq_depth"));
    }
    @Test
    public void testPqIsEmpty(){
        System.out.println("testPqIsEmpty");
        assertEquals("Priority queue is empty", uv.processInput("pq_isEmpty"));
        assertEquals("OK", uv.processInput("pq_add Test1"));
        assertEquals("Priority queue is not empty", uv.processInput("pq_isEmpty"));
    }





}