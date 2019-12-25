import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Main
{
    /*
        -- Brute Force --
        Get Common Words from two list

        this method doesn't exclude same words from two list
        ex: List1 -> ["find", "common", "words", "find"], List2 -> ["find", "common"] should return ["find", "common", "find"]

        this method is not case-sensitive
        ex: List1 -> ["Find"], List2 -> ["find"] should return []

        Complexity: Big O(n * m) - For Every List1 as value Then For Every List2 ensure value is in it
    */
    public ArrayList<String> getCommonWords(ArrayList<String> list1, ArrayList<String> list2) {
        List<String> commonWords = list1.stream().filter( list -> list2.contains(list)).collect(Collectors.toList());
        return new ArrayList<>(commonWords);
    }

    /*
         -- Brute Force --

         Complexity: Big O(n * m + o) - For Every List1 as value Then For Every List2 ensure value is in it as results
         Then For Every words in Results Remove same word
     */
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

    /*
        -- Hash Set --

        Complexity: Big O(n + m)
     */
    public ArrayList<String> getCommonWordsHashSet(ArrayList<String> list1, ArrayList<String> list2) {
        if(list1.size() == 0 || list2.size() == 0) {
            return new ArrayList<>();
        }

        Set<String> temp = new HashSet<>();
        Set<String> commonWords = new HashSet<>();

        for (String list : list1) {
            temp.add(list);
        }

        for (String list : list2) {
            if (temp.contains(list)) {
                commonWords.add(list);
            }
        }

        return new ArrayList<>(commonWords);
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