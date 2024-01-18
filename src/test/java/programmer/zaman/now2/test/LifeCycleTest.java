package programmer.zaman.now2.test;

import org.junit.jupiter.api.Test;

public class LifeCycleTest {
    //method didalam class independen
    //sehingga tiap class itu sebenrnya membuat ulang objeknya sendiri
    
    private String temp;

    @Test
    void testA(){
        temp = "ahmad";
    }

    @Test
    void testB(){
        System.out.println(temp);
    }
}
