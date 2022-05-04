package strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import model.Fruit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import storage.Storage;

public class ReturnOperationHandlerTest {
    private static OperationHandler returnOperationHandler;
    private static Map<Fruit, Integer> storage;

    @BeforeClass
    public static void beforeClass() {
        returnOperationHandler = new ReturnOperationHandler();
        storage = Storage.data;
    }

    @Test
    public void validReturn_Ok() {
        storage.put(new Fruit("banana"), 10);
        returnOperationHandler.apply(new Fruit("banana"), 40);
        assertTrue(storage.containsKey(new Fruit("banana")));
        assertTrue(storage.containsValue(50));
        assertEquals(1, storage.size());
    }

    @After
    public void afterEach() {
        storage.clear();
    }
}
