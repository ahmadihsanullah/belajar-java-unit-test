package programmer.zaman.now2.test;

import static org.mockito.ArgumentMatchers.matches;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionTest {

    //sistem properties

    @Test
    void testSystemProperty() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> {
            System.out.println( key + ": " + value);
        });
    }

    //versi OS
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyWindows(){
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnWindows(){
    }

    // versi java

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    void testEnabledOnJRE8(){

    }

    @Test
    @DisabledOnJre({JRE.JAVA_8})
    void testDisabledOnJRE8(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_15, max = JRE.JAVA_20)
    void testEnabledJava15TO20(){

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_15, max = JRE.JAVA_20)
    void testDisabledJava15TO20(){

    }

    // sistem properti
    @Test
    @EnabledIfSystemProperties({
        @EnabledIfSystemProperty(named="java.vendor", matches="Eclipse Adoptium")
        }
    )
    void testEnabledOnJavaVendorEclipse(){

    }

    @Test
    @DisabledIfSystemProperties({
        @DisabledIfSystemProperty(named="java.vendor", matches="Eclipse Adoptium")
        }
    )
    void testDisabledOnJavaVendorEclipse(){
        
    }

    //environment variable

      @Test
    @EnabledIfEnvironmentVariable(named="PROFILE", matches="DEV")
    void testEnablesOnProfiveDev() {
    }

    @Test
    @DisabledIfEnvironmentVariable(named="PROFILE", matches="DEV")
    void testDisabledOnProfiveDev() {
    }

    


}
