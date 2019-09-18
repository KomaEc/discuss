
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.util.converter.*;

public class Main {


    private Converter converter;

    public Main() {
        converter = Converters.standardConverter();
    }

    private <K,V> Map.Entry<K,V> getMapEntry(Map<K,V> map) {
        return map.entrySet().iterator().next();
    }

    public void testMapEntry6() {
    	// Value is null, key is the right type
    	Map<Short, Integer> m1 = Collections.singletonMap((short) 4, null);
    	Map.Entry<Short, Integer> e1 = getMapEntry(m1);
    	
    	if (4 == converter.convert(e1).to(Short.class).intValue()) {
            System.out.println("good");
        }
    }
    public void testMapEntry9() {
    	// Key is null, value is a String 
    	Map<Short, String> m1 = Collections.singletonMap(null, "5");
    	Map.Entry<Short, String> e1 = getMapEntry(m1);
    	
    	if ((Integer) 5 == converter.convert(e1).to(Integer.class)) {
            System.out.println("good");
        }
    }
    public static void main(String... args) {
        Main run = new Main();
        run.testMapEntry6();
        run.testMapEntry9();
    }
}