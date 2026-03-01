package Session14.Lythuyet.Sap_xep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tao_ds_sx {
    public static void main(String[] args) throws ParseException {
        List<Product> list =new ArrayList<Product>();
        SimpleDateFormat sdf =new SimpleDateFormat( "dd/MM/yyyy");
        list.add(new Product(1,"Tivi",sdf.parse("21/01/2026"),40000000.0));


        Comparator<Product> comparator =new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return  0;
//                return o1.getName().compareTo(o2.getName());
            }
        };
        list.sort(comparator);
    }
}
