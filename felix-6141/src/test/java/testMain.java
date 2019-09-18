import org.junit.Test;

public class testMain {
    @Test
    public void test0() {
        Main.main((String[])null);
    }

    @Test
    public void test1() {
        Main run = new Main();
        run.testMapEntry6();
    }

    @Test
    public void test2() {
        Main run = new Main();
        run.testMapEntry9();
    }
}