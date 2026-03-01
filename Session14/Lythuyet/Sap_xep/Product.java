package Session14.Lythuyet.Sap_xep;

import java.util.Date;

public class Product {
    private Integer id;
    private  String name;
    private Date year;
    private Double price;

    public Product(Integer id, String name ,Date year, Double price){
        this.id=id;
        this.name=name;
        this.year=year;
        this.price=price;
    }
    public void getName(){
        System.out.print(name);
    }
}
