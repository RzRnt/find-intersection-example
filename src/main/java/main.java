import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;


class main
{
    public static void main ( String [] arguments )
    {
        ArrayList<String> firstWords = new ArrayList(Arrays.asList("find", "intersection", "two", "lists"));
        ArrayList<String> secondWords = new ArrayList<>(Arrays.asList("find", "between", "two", "lists"));
        main m = new main();
        System.out.println(m.getCommonWords(firstWords, secondWords));
    }

    public ArrayList<String> getCommonWords(ArrayList<String> list1, ArrayList<String> list2) {
        List<String> commonWords = list1.stream().filter( list -> list2.contains(list)).collect(Collectors.toList());
        return new ArrayList<>(commonWords);
    }
}