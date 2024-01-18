package programmer.zaman.now2.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Information Test")
public class InformationTest {
    
    @Test
    @Tags({
        @Tag("one"),
        @Tag("two"),
    })
    @DisplayName("this is test 1")
    void testInfo(TestInfo testInfo){
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getClass());
        System.out.println(testInfo.getTestMethod());
        System.out.println(testInfo.getTags());

    }
}
