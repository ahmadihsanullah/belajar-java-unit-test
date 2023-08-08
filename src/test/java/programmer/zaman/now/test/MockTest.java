package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void mockTest() {
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("ahmad");
        Mockito.when(list.get(100)).thenReturn("ahmad ihsan");

        System.out.println(list.get(0));
        System.out.println(list.get(100));

        //objek muncul 1 kali
        Mockito.verify(list, Mockito.times(1)).get(0);

    }
}
