
import java.io.InputStream;

import org.apache.tika.parser.crypto.Pkcs7Parser;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
public class Main {
    public void testDetachedSignature() throws Exception {
        InputStream input = Main.class.getResourceAsStream(
                "testDetached.p7s");
        try {
            ContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            new Pkcs7Parser().parse(input, handler, metadata, new ParseContext());
        } finally {
            input.close();
        }
    }
    
    public static void main(String... args) throws Exception {
        Main run = new Main();
        run.testDetachedSignature();
    }
}