import java.util.ArrayList;
import java.util.*;


class main
{
    public static void main ( String [] arguments )
    {
        ArrayList<String> x = new ArrayList(Arrays.asList("find", "intersection", "two", "lists"));
        ArrayList<String> dua = new ArrayList<>(Arrays.asList("find", "between", "two", "lists"));

        System.out.println(getCommonWords(x, dua));
    }

    public static ArrayList<String> getCommonWords(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> commonWords = new ArrayList<>();
        list1.forEach( list -> {
            if (list2.contains(list)) {
                commonWords.add(list);
            }
        });
        return commonWords;
    }
}