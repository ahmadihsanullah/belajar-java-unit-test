package programmer.zaman.now.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    public class WhenNew {

        @BeforeEach
        @Test
        void setUp() {
            queue = new LinkedList<>();
        }

        @DisplayName("When offer, size must be 1")
        @Test
        void offerNewData() {
            queue.offer("eko");
            Assertions.assertEquals(1, queue.size());
        }

        @DisplayName("When offer 2, size must be 2")
        @Test
        void offerMoreData() {
            queue.offer("eko 2");
            queue.offer("eko 2 lagi");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
