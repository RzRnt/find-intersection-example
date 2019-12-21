import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void ShouldReturnCommonWords() {
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("find", "intersection", "two", "lists"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("find", "between", "two", "lists"));
        ArrayList<String> expectedCommonWords = new ArrayList<>(Arrays.asList("find", "two", "lists"));
        Main m = new Main();
        ArrayList<String> actualCommonWords = m.getCommonWords(firstWords, secondWords);
        Assert.assertEquals(expectedCommonWords, actualCommonWords);
    }
}

