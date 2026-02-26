package Session13.Bai2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai2 {

    public static List<String> removeDuplicateAndSort(List<String> input) {

        List<String> result = new ArrayList<>();

        for (String medicine : input) {
            if (!result.contains(medicine)) {
                result.add(medicine);
            }
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("Paracetamol");
        input.add("Ibuprofen");
        input.add("Panadol");
        input.add("Paracetamol");
        input.add("Aspirin");
        input.add("Ibuprofen");

        List<String> output = removeDuplicateAndSort(input);

        System.out.println("Output: " + output);
    }
}

