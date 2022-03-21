import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

public class SeznamiUVTest {
    SeznamiUV uv;
    @BeforeClass
    public void setUp(){
        uv = new SeznamiUV();
    }

    @After
    public void tearDown(){
        assertEquals("OK", uv.processInput("reset"));
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

    @Ignore("TO DO")
    @Test
    public void testPushMultipleWords(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushMultipleWords");
        assertEquals("OK", uv.processInput("push \"Test with multiple woords\""));
        assertEquals("1", uv.processInput("count"));
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

    @Ignore("TO DO")
    @Test
    public void testPopMultipleWord(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopMultipleWords");
        assertEquals("OK", "push \"Test with multiple words\"");
        assertEquals("OK", "push \"Another test with multiple words\"");

    }

    @Test
    public void testPopNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopNothing");
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

}