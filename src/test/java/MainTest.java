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

    @Test
    public void ShouldReturnEmptyCommonWords() {
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("find", "intersection", "two", "lists"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("findz", "betweens", "twos", "listsz"));
        ArrayList<String> expectedCommonWords = new ArrayList<>();
        Main m = new Main();
        ArrayList<String> actualCommonWords = m.getCommonWords(firstWords, secondWords);
        Assert.assertEquals(expectedCommonWords, actualCommonWords);
    }

    @Test
    public void ShouldReturnEmptyWhenWordsIsEmpty() {
        ArrayList<String> firstWords = new ArrayList();
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("findz", "betweens", "twos", "listsz"));
        ArrayList<String> expectedCommonWords = new ArrayList<>();
        Main m = new Main();
        ArrayList<String> actualCommonWords = m.getCommonWords(firstWords, secondWords);
        Assert.assertEquals(expectedCommonWords, actualCommonWords);
    }

    @Test
    public void ShouldNotTreatedAsCommonWordsWhenCaseSensitive() {
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("Finds"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("finds"));
        ArrayList<String> expectedCommonWords = new ArrayList<>();
        Main m = new Main();
        ArrayList<String> actualCommonWords = m.getCommonWords(firstWords, secondWords);
        Assert.assertEquals(expectedCommonWords, actualCommonWords);
    }

    @Test
    public void ShoudlReturnTwiceWhenSameWordsInList() {
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("find", "common", "words", "find"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("find", "common"));
        ArrayList<String> expectedCommonWords = new ArrayList<>(Arrays.asList("find", "common", "find"));
        Main m = new Main();
        ArrayList<String> actualCommonWords = m.getCommonWords(firstWords, secondWords);
        Assert.assertEquals(expectedCommonWords, actualCommonWords);
    }

    @Test
    public void TestListOffWords() {
        Main m = new Main();
        ArrayList<String> firstWords = m.generateWords(5000000);
        ArrayList<String> secondWords = m.generateWords(5000000);
        ArrayList<String> actualCommonWords = m.getCommonWords(firstWords, secondWords);
        System.out.println(actualCommonWords);
    }

    @Test
    public void TestListOfWordsHashSet() {
        Main m = new Main();
        ArrayList<String> firstWords = m.generateWords(5000000);
        ArrayList<String> secondWords = m.generateWords(5000000);
        ArrayList<String> actualCommonWords = m.getCommonWordsHashSet(firstWords, secondWords);
        System.out.println(actualCommonWords);
    }

    @Test
    public void TestListOfWordsHashSetSimple() {
        Main m = new Main();
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("find", "intersection", "two", "lists"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("find", "between", "two", "lists"));
        ArrayList<String> expectedCommonWords = new ArrayList<>(Arrays.asList("find", "lists", "two"));
        ArrayList<String> actualCommonWords = m.getCommonWordsHashSet(firstWords, secondWords);
        Assert.assertEquals(expectedCommonWords, actualCommonWords);
    }
}

