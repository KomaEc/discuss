import org.apache.felix.scr.impl.config.ComponentContainer;
import org.apache.felix.scr.impl.helper.ComponentMethods;
import org.apache.felix.scr.impl.metadata.ComponentMetadata;
import org.apache.felix.scr.impl.metadata.DSVersion;
import java.lang.reflect.Field;
import org.apache.felix.scr.impl.manager.SingleComponentManager;
import org.mockito.Mockito;
import org.apache.felix.scr.impl.manager.Helper;

public class Main {

    public void testGetServiceWithNullComponentContext() {
        ComponentMetadata cm = new ComponentMetadata(DSVersion.DS13);
        cm.setImplementationClassName("foo.bar.SomeClass");
        cm.validate(null);

        @SuppressWarnings("unchecked")
        ComponentContainer<Object> cc = Mockito.mock(ComponentContainer.class);
        Mockito.when(cc.getComponentMetadata()).thenReturn(cm);

        SingleComponentManager<?> scm = new Helper<Object>(cc, new ComponentMethods());

        if (scm.getService(null, null) == null) {
            System.out.println("good");
        }
    }

    public static void main(String... args) {
        Main run = new Main();
        run.testGetServiceWithNullComponentContext();
    }
}