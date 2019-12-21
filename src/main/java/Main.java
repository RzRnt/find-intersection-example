import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Main
{
    public static void main ( String [] arguments )
    {
        ArrayList<String> third = new ArrayList(Arrays.asList("Find", "wele", "two", "lists", "FIND"));
        ArrayList<String> fourth = new ArrayList<>(Arrays.asList("find", "wele", "lists"));

        HashMap<ArrayList<String>, ArrayList<String>> Lists = new HashMap<>();
        Lists.put(third, fourth);

        Main m = new Main();
        System.out.println(m.getCommonWordsAdvanced(third,fourth));
        System.out.println(m.getCommonWords(third,fourth));
    }

    /*
        Get Common Words from two list

        this method doesn't exclude same words from two list
        ex: List1 -> ["find", "common", "words", "find"], List2 -> ["find", "common"] should return ["find", "common", "find"]

        this method is case-sensitive
        ex: List1 -> ["Find"], List2 -> ["find"] should return []
    */
    public ArrayList<String> getCommonWords(ArrayList<String> list1, ArrayList<String> list2) {
        List<String> commonWords = list1.stream().filter( list -> list2.contains(list)).collect(Collectors.toList());
        return new ArrayList<>(commonWords);
    }


    public ArrayList<String> getCommonWordsAdvanced(ArrayList<String> list1, ArrayList<String> list2) {
        List<String> commonWords = list1
                .stream()
                .map(list -> list.toLowerCase())
                .filter(list -> list2.stream().map(l -> l.toLowerCase()).collect(Collectors.toList()).contains(list))
                .collect(Collectors.toList());
        Set<String> wordSet = new LinkedHashSet<>();
        commonWords.forEach(word -> wordSet.add(word));
        return new ArrayList<>(wordSet);
    }

    public void TestingCommonwords(HashMap<ArrayList<String>, ArrayList<String>> Lists) {
        Lists.entrySet().forEach(list -> {
            ArrayList<String> commonWords = getCommonWords(list.getKey(), list.getValue());
            System.out.println(commonWords);
        });
    }

    public ArrayList<String> generateWords(int count) {
        Faker faker = new Faker();
        ArrayList<String> words = new ArrayList<>();
        IntStream.range(0, count).forEach(c -> {
            words.add(faker.country());
        });
        return words;
    }
}