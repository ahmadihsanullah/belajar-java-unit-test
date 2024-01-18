package programmer.zaman.now2.test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// dengan test instance liubah menjadi lifecycle per class maka 
// tiap objek akan mempunyai 1 objek yang sama
// selain itu beforeAll dan afterAll tidak perlu static lagi
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrdererTest {

    private int counter = 0;

    @Test
    @Order(3)
    void test3(){
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2(){
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(1)
    void test1(){
        counter++;
        System.out.println(counter);
    }
    
}
