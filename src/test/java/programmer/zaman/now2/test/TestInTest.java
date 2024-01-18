package programmer.zaman.now2.test;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@DisplayName("A Queue")
public class TestInTest {
    private Queue<String> queue;

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("When New")
    public class WhenNew{

        @BeforeAll
        void setUp(){
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("When offer, size must be 1")
        void offerNewData(){
            queue.offer("ahmad");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("When offer more, size must be 2")
        void offerMoreData(){
            queue.offer("ihsan");
            Assertions.assertEquals(2, queue.size());
        }
    }
}
