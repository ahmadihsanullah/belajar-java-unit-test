package programmer.zaman.now2.test;

import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockTest {
    //mock akan mengembalikan data null jika tidak ada tanpa thwor NullPointerException
    @Test
    void testMock(){
        // membuat mock
        List<String> list = Mockito.mock(List.class);

        //menambah behaviour
        Mockito.when(list.get(0)).thenReturn("ahmad");

        System.out.println(list.get(0));
        // System.out.println(list.get(0)); error karena dipanggil 2 kali method get dengan indeks 0

        //menambah verify bahwa mock lick dengan method get(0) dipanggil 1 kali
        Mockito.verify(list, times(1)).get(0);

    }
}
