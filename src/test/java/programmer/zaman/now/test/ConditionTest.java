package programmer.zaman.now.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

@Tag("integration-test")
public class ConditionTest {
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyWindows(){

    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    void testDisableRunOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_20)
    void testEnabledRunOnJava20() {
    }

    @Test
    @DisabledOnJre(JRE.JAVA_20)
    void testDisabledRunOnJava14() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_16, max = JRE.JAVA_20)
    void testOnlyRunJava16To20() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_16, max = JRE.JAVA_20)
    void testDisabledOnlyRunJava16To20() {
    }

    //mengecek sistme property


    @Test
    void testSystemProperty() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println( key + ": " + value);
        });
    }

    @Test
    @EnabledIfSystemProperties(
            @EnabledIfSystemProperty(named="java.vendor", matches = "Oracle Corporation")
    )
    void testEnableOnOracle() {

    }

    @Test
    @DisabledIfSystemProperties(
            @DisabledIfSystemProperty(named="java.vendor", matches = "Oracle Corporation")
    )
    void testDisabledOnOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named="PROFILE", matches="DEV")
    void testEnablesOnProfiveDev() {
    }

    @Test
    @DisabledIfEnvironmentVariable(named="PROFILE", matches="DEV")
    void testDisabledOnProfiveDev() {
    }
}
