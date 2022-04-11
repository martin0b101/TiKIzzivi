import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SeznamiUVTest {

    SeznamiUV uv = new SeznamiUV();

    @BeforeEach
    public void setUp(){
        uv.processInput("use sk");
    }


    public SeznamiUVTest(){
    }





    @Test
    public void testPushBasic(){
        //SeznamiUV uv = new SeznamiUV();

        System.out.println("testPushBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));

    }

    @Test
    public void testPushMultipleWords(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushMultipleWords");
        assertEquals("OK", uv.processInput("add \"Test with multiple words\""));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("size"));
    }

    @Test
    public void testPushNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }
    @Test
    public void testPopBasic(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopBasic");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }


    @Test
    public void testPopMultipleWord(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopMultipleWords");
        assertEquals("OK", uv.processInput("add \"Test with multiple words\""));
        assertEquals("OK", uv.processInput("add \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("size"));
        assertEquals("Another test with multiple words", uv.processInput("remove_first"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("Test with multiple words", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));

    }

    @Test
    public void testPopNothing(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: stack is empty", uv.processInput("remove_first"));

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
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: stack is empty", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));
    }

    @Test
    public void testCountOnEmpty(){
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOnEmpty");
        assertEquals("0", uv.processInput("size"));
    }

    @Test
    public void testCountOne() {
        System.out.println("testCountOne");
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("size"));
    }

    @Test
    public void testCountTwo() {
        //SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountTwo");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }

    @Test
    public void testIsTop() {
        System.out.println("testIsTop");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Test1", uv.processInput("get_first Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
    }

    @Test
    public void testIsTopEmpty(){
        System.out.println("testIsTopEmpty");
        assertEquals("Error: stack is empty", uv.processInput("get_first"));
    }

    @Test
    public void testStackExist(){
        System.out.println("testStackExist");
        assertEquals("Element does not exist", uv.processInput("exist Test1"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Element exist", uv.processInput("exist Test1"));
    }

    @Test
    public void testStackRemove(){
        System.out.println("testStackRemove");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("Test1", uv.processInput("remove Test1"));
        assertEquals("Element does not exist", uv.processInput("exist Test1"));
    }


    //Test for pq
    @Test
    public void testPqAdd(){
        uv.processInput("use pv");
        System.out.println("testPqAdd");
        assertEquals("OK", uv.processInput("add Test1"));
    }

    @Test
    public void testPqRemoveFirst(){
        uv.processInput("use pv");
        System.out.println("testPqRemoveFirst");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }

    @Test
    public void testPqRemoveNothing(){
        uv.processInput("use pv");
        System.out.println("testPqRemoveNothing");
        assertEquals("Error: priority queue is empty", uv.processInput("remove_first"));
    }

    @Test
    public void testPqGetFirst(){
        uv.processInput("use pv");
        System.out.println("testPqGetFirst");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Test1", uv.processInput("get_first"));
    }

    @Test
    public void testPqGetFirstNothing(){
        uv.processInput("use pv");
        System.out.println("testPqGetFirstNothing");
        assertEquals("Error: priority queue is empty", uv.processInput("get_first"));
    }
    @Test
    public void testPqSize(){
        uv.processInput("use pv");
        System.out.println("testPqSize");
        assertEquals("0", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }
    @Test
    public void testPqDepth(){
        uv.processInput("use pv");
        System.out.println("testPqDepth");
        assertEquals("0", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("1", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("2", uv.processInput("depth"));
    }
    @Test
    public void testPqIsEmpty(){
        uv.processInput("use pv");
        System.out.println("testPqIsEmpty");
        assertEquals("Error: priority queue is empty", uv.processInput("isEmpty"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Error: priority queue is not empty", uv.processInput("isEmpty"));
    }

    @Test
    public void testPqExist(){
        uv.processInput("use pv");
        System.out.println("testPqExist");
        assertEquals("Element does not exist", uv.processInput("exist Test1"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Element exist", uv.processInput("exist Test1"));
    }

    @Test
    public void testPqRemove(){
        uv.processInput("ise pv");
        System.out.println("testPqRemove");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("Test2", uv.processInput("remove Test2"));
        assertEquals("Element does not exist", uv.processInput("exist Test2"));
    }

    // binarno drevo
    @Test
    public void testBSTadd(){
        uv.processInput("use bst");
        System.out.println("testBSTadd");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Test1", uv.processInput("get_first"));
    }

    @Test
    public void testBSTaddNothing(){
        uv.processInput("use bst");
        System.out.println("testBSTaddNothing");
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }

    @Test
    public void testBSTremoveFirst(){
        uv.processInput("use bst");
        System.out.println("testBSTremoveFirst");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }

    @Test
    public void testBSTremoveOnEmpty(){
        uv.processInput("use bst");
        System.out.println("testBSTremoveOnEmpty");
        assertEquals("Error: binary search tree is empty", uv.processInput("remove_first"));
    }

    @Test
    public void testBSTgetFirst(){
        uv.processInput("use bst");
        System.out.println("testBSTgetFirst");
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("Test1", uv.processInput("get_first"));
    }

    @Test
    public void testBSTgetFirstOnEmpty(){
        uv.processInput("use bst");
        System.out.println("testBSTgetFirstOnEmpty");
        assertEquals("Error: binary search tree is empty", uv.processInput("get_first"));
    }

    @Test
    public void testBSTsize(){
        uv.processInput("use bst");
        System.out.println("testBSTsize");
        assertEquals("0", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("3", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test0"));
        assertEquals("3", uv.processInput("size"));
    }

    @Test
    public void testBSTisEmpty(){
        uv.processInput("use bst");
        System.out.println("testBSTisEmpty");
        assertEquals("Error: binary search tree is empty", uv.processInput("isEmpty"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Error: binary search tree is not empty", uv.processInput("isEmpty"));
    }

    //remove
    @Test
    public void testBSTremove(){
        uv.processInput("use bst");
        System.out.println("testBSTremove");
        assertEquals("Error: can not remove element that does not exist", uv.processInput("remove Test1"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Test1", uv.processInput("remove Test1"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("OK", uv.processInput("add Test0"));
        assertEquals("Test2", uv.processInput("remove Test2"));
        assertEquals("Error: can not remove element that does not exist", uv.processInput("remove Test2"));
    }

    @Test
    public void testBSTremoveOnEmptySelected(){
        uv.processInput("use bst");
        System.out.println("testBSTremoveOnEmpty");
        assertEquals("Error: please specify a string", uv.processInput("remove"));
    }


    //exist
    @Test
    public void testBSTexist(){
        uv.processInput("use bst");
        System.out.println("testBSTexist");
        assertEquals("Element does not exist", uv.processInput("exist Test1"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Element exist", uv.processInput("exist Test1"));
    }


    //use testi
    @Test
    public void testUseWrongDataSt(){
        assertEquals("Error: please specify a correct data structure type (pv, sk, bst)", uv.processInput("use ps"));
    }

    @Test
    public void testUseNothing(){
        assertEquals("Error: please specify a data structure type (pv, sk, bst)", uv.processInput("use"));
    }





}