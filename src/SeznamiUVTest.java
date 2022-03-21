import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeznamiUVTest {

    SeznamiUV uv;

    @BeforeEach
    public void setUp(){
        uv = new SeznamiUV();
    }

    public SeznamiUVTest(){
    }



    @Test
    public void testPushBasic(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));

    }

    @Test
    public void testPushMultipleWords(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushMultipleWords");
        assertEquals("OK", uv.processInput("push \"Test with multiple words\""));
        assertEquals("1", uv.processInput("count"));
        assertEquals("OK", uv.processInput("push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
    }

    @Test
    public void testPushNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string", uv.processInput("push"));
    }
    @Test
    public void testPopBasic(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("Test2", uv.processInput("pop"));
        assertEquals("Test1", uv.processInput("pop"));
    }


    @Test
    public void testPopMultipleWord(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopMultipleWords");
        assertEquals("OK", uv.processInput("push \"Test with multiple words\""));
        assertEquals("OK", uv.processInput("push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
        assertEquals("Another test with multiple words", uv.processInput("pop"));
        assertEquals("1", uv.processInput("count"));
        assertEquals("Test with multiple words", uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));

    }

    @Test
    public void testPopNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty", uv.processInput("pop"));
        assertEquals("Error: please specify a string", uv.processInput("push"));
        assertEquals("Error: stack is empty", uv.processInput("pop"));

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
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: stack is empty", uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    public void testCountOnEmpty(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOnEmpty");
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    public void testCountOne() {
        System.out.println("testCountOne");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("1", uv.processInput("count"));
    }

    @Test
    public void testCountTwo() {
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountTwo");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("2", uv.processInput("count"));
    }

    @Test
    public void testIsTop() {
        System.out.println("testIsTop");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("isTop Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("Error: wrong element", uv.processInput("isTop Test1"));
        assertEquals("Error: please specify a string", uv.processInput("isTop"));

    }
    @Test
    public void testIsTopEmpty(){
        System.out.println("testIsTopEmpty");
        assertEquals("Error: stack is empty", uv.processInput("isTop Test1"));
    }

    @Test
    public void testSearch(){
        System.out.println("testSearch");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("0", uv.processInput("search Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("1", uv.processInput("search Test1"));
        assertEquals("OK", uv.processInput("push Test3"));
        assertEquals("2", uv.processInput("search Test1"));
        assertEquals("Test3", uv.processInput("pop"));
        assertEquals("Test2", uv.processInput("pop"));
        assertEquals("Test1", uv.processInput("pop"));
        assertEquals("-1", uv.processInput("search Test1"));
        assertEquals("Error: please specify a string", uv.processInput("search"));
    }
}