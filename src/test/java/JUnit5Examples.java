import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class JUnit5Examples {


    @BeforeAll
    static void beforeAll(){
        System.out.println("### BeforeAll !");
    }

    @AfterAll
    static void afterALL(){
        System.out.println("### AfterAll !");
    }

    @BeforeEach
    void beforeEach(){
        //open ("google.com")
        System.out.println("###  BeforeEach  !");
    }

    @AfterEach
    void afterEach(){
        //open ("google.com")
        System.out.println("###    afterEach  !");
    }


    @Test
    void firstTest(){
        System.out.println("###       @Test firstTest() !");
        assertTrue ( 3>2);
    }

    @Test
    void secondTest(){
        System.out.println("###       @Test secondTest() !");
        assertFalse ( 3<2);
//        $("TextArea").shouldNot(text("fhhf"));
    }
}
