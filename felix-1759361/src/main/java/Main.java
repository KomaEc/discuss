import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.osgi.service.converter.Adapter;
import org.osgi.service.converter.ConvertFunction;
import org.osgi.service.converter.Converter;
import org.osgi.service.converter.Rule;

import org.apache.felix.converter.impl.*;

public class Main {
    private Converter converter;

    public Main () {
        converter = new ConverterImpl();
    }

    public void ignoreBool(boolean b) {
        return;
    }

    static String convertToString(char[] a) {
        StringBuilder sb = new StringBuilder();
        for (char c : a) {
            sb.append(c);
        }
        return sb.toString();
    }

    public void testSecondLevelAdapter() {
        Adapter ca = converter.getAdapter();

        ca.rule(char[].class, String.class, Main::convertToString, null);
        ca.rule(new Rule<String, Number>(String.class, Number.class, new ConvertFunction<String, Number>() {
            @Override
            public Number convert(String obj, Type targetType) throws Exception {
                if (Integer.class.equals(targetType))
                    return Integer.valueOf(-1);
                else if (Long.class.equals(targetType))
                    return Long.valueOf(-1);
                return null;
            }
        }));

        ignoreBool("hi" == ca.convert(new char[] {'h', 'i'}).to(String.class));
        ignoreBool(Integer.valueOf(-1) == ca.convert("Hello").to(Integer.class));
        ignoreBool(Long.valueOf(-1) == ca.convert("Hello").to(Long.class));

        Adapter ca2 = ca.getAdapter();
        // Shadow the Integer variant but keep Long going to the Number variant.
        ca2.rule(String.class, Integer.class, v -> v.length(), null);
        ignoreBool((Integer)5 == ca2.convert("Hello").to(Integer.class));
        ignoreBool(Long.valueOf(-1) == ca2.convert("Hello").to(Long.class));
    }

    public static void main(String... args) {
        Main run = new Main();
        run.testSecondLevelAdapter();
    }
}