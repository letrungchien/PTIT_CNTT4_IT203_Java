package Session14.Thuc_hanh;

import Session14.Lythuyet.Sap_xep.Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class HienThi_SapXep {
    public static void main(String[] args) throws Exception {
        List<Book> list =new ArrayList<Book>();
        SimpleDateFormat sdf =new SimpleDateFormat( "dd/MM/yyyy");

        list.add(new Book(1,"Tuan","Lam giau","kim dong" ,sdf.parse("21/02/2023"),24,255555));
        list.add(new Book(2,"Tuan","An giau ko kho","kim dong" ,sdf.parse("21/02/2023"),24,255555));
        list.add(new Book(1,"Tuan","Cam giau","kim dong" ,sdf.parse("21/02/2023"),24,255555));
        list.add(new Book(2,"Tuan","Anh giau ko kho","kim dong" ,sdf.parse("21/02/2023"),24,255555));

        Comparator<Book> comparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        list.sort(comparator);
        for (Book b : list) {
            System.out.println(b.getName());
        }
    }
}
