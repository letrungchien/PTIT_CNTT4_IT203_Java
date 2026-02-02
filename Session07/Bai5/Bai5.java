package Session07.Bai5;
 class Config {

    public static final int MAX_SCORE = 10;
    public static final int MIN_SCORE = 0;
}
public class Bai5 {
    public static void main(String[] args) {
        double score = 8;
        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Điểm hợp lệ: " + score);
        } else {
            System.out.println("Điểm không hợp lệ!");
        }
    }
}
