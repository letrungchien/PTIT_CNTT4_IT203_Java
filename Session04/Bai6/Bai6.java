package Session04.Bai6;
import java.util.*;
import java.util.regex.*;

public class Bai6 {

    private static String star(int length) {
        return "*".repeat(length);
    }

    public static void main(String[] args) {

        String review = "Cuốn sách này rất tệ, nội dung thật là ngu ngốc và không đáng đọc.";
        List<String> blacklist = Arrays.asList(
                "tệ", "ngu", "ngu ngốc", "không đáng"
        );

        String regex = "(?i)\\b(" + String.join("|", blacklist) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(review);

        StringBuffer filteredReview = new StringBuffer();
        while (matcher.find()) {
            String badWord = matcher.group();
            matcher.appendReplacement(filteredReview, star(badWord.length()));
        }
        matcher.appendTail(filteredReview);

        String finalReview;
        if (filteredReview.length() > 200) {
            int limit = 200;

            while (limit > 0 && filteredReview.charAt(limit) != ' ') {
                limit--;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(filteredReview.substring(0, limit));
            sb.append("...");
            finalReview = sb.toString();
        } else {
            finalReview = filteredReview.toString();
        }

        System.out.println("Review sau khi xử lý: " + finalReview);
    }
}
