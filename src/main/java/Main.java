import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;


class Main
{
    public static void main ( String [] arguments )
    {
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("find", "intersection", "two", "lists"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("find", "between", "two", "lists"));

        ArrayList<String> third = new ArrayList(Arrays.asList("find", "wele", "two", "lists"));
        ArrayList<String> fourth = new ArrayList<>(Arrays.asList("find", "wele", "lists"));

        HashMap<ArrayList<String>, ArrayList<String>> Lists = new HashMap<>();
        Lists.put(firstWords, secondWords);
        Lists.put(third, fourth);

        Main m = new Main();
        m.TestingCommonwords(Lists);
    }

    public ArrayList<String> getCommonWords(ArrayList<String> list1, ArrayList<String> list2) {
        List<String> commonWords = list1.stream().filter( list -> list2.contains(list)).collect(Collectors.toList());
        return new ArrayList<>(commonWords);
    }

    public void TestingCommonwords(HashMap<ArrayList<String>, ArrayList<String>> Lists) {
        Lists.entrySet().forEach(list -> {
            ArrayList<String> commonWords = getCommonWords(list.getKey(), list.getValue());
            System.out.println(commonWords);
        });
    }
}