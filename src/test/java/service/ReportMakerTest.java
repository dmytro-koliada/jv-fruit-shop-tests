package service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;
import org.junit.BeforeClass;
import org.junit.Test;
import service.impl.ReportMakerImpl;

public class ReportMakerTest {
    private static final StringBuilder EXPECTED = new StringBuilder("fruit,quantity")
            .append(System.lineSeparator())
            .append("banana,152")
            .append(System.lineSeparator())
            .append("apple,90");
    private static final Map<Fruit, Integer> storage = new HashMap<>();
    private static ReportMaker reportMaker;

    @BeforeClass
    public static void beforeClass() {
        reportMaker = new ReportMakerImpl();
        storage.put(new Fruit("banana"), 152);
        storage.put(new Fruit("apple"), 90);
    }

    @Test
    public void reportIsValid_Ok() {
        String actual = reportMaker.createReport(storage.entrySet());
        assertEquals(EXPECTED.toString(), actual);
    }

    @Test
    public void emptyReport_NotOk() {
        Map<Fruit, Integer> emptyMap = new HashMap<>();
        String expected = "fruit,quantity";
        String actual = reportMaker.createReport(emptyMap.entrySet());
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void emptyPath_NotOk() {
        reportMaker.createReport(null);
    }
}
