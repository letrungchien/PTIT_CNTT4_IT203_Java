    package Session04.Bai1;

    import java.util.Locale;

    public class Bai1 {
       public static void main(String[] args) {
           String title ="    lập TRÌNH java      CƠ bản ";
           String author = "nguyễn   văn    a";

           title = title.trim();
           title = title.replace(" ", "\n");
           String[] arr = title.split("\\n+");
           String fixedTitle = "";
           for (String s : arr) {
               fixedTitle += s.toUpperCase() + " ";
           }

           author = author.trim();
           author = author.replace(" ", "\n");
           String[] arrAuthor = author.split("\\n+");
           String fixedAuthor = "";
           for (String s : arrAuthor) {
               fixedAuthor += s.substring(0, 1).toUpperCase()
                       + s.substring(1).toLowerCase()
                       + " ";
           }

           System.out.printf("[%s] - Tác giả: %s",fixedTitle ,fixedAuthor.trim());
        }
    }
