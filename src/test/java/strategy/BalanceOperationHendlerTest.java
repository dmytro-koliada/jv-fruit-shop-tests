package strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;
import model.Fruit;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import storage.Storage;

public class BalanceOperationHendlerTest {
    private static OperationHandler balanceOperationHandler;
    private static Map<Fruit, Integer> storage;

    @BeforeClass
    public static void beforeClass() {
        balanceOperationHandler = new BalanceOperationHandler();
        storage = Storage.data;
    }

    @Test
    public void validBalance_Ok() {
        balanceOperationHandler.apply(new Fruit("banana"), 100);
        assertTrue(storage.containsKey(new Fruit("banana")));
        assertTrue(storage.containsValue(100));
        assertEquals(1, storage.size());
    }

    @After
    public void afterEach() {
        storage.clear();
    }
}