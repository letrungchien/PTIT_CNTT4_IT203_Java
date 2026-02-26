package Session13.Bai3;

import java.util.ArrayList;
import java.util.List;

public class Bai3 {

    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {
        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {


        List<Integer> list1 = List.of(101, 102, 105);
        List<Integer> list2 = List.of(102, 105, 108);
        System.out.println("Test Case 1 Output: " +
                findCommonPatients(list1, list2));


        List<String> list3 = List.of("DN01", "DN02", "DN03");
        List<String> list4 = List.of("DN02", "DN04");
        System.out.println("Test Case 2 Output: " +
                findCommonPatients(list3, list4));
    }
}
