package Session14.Thuc_hanh;

import java.util.Date;

public class Book {
    Integer id ;
    String name;
    String author;
    String nsx;
    Date year;
    Integer  numberPages;
    Integer price;

    public  Book(Integer id ,String author ,String name,String nsx,Date year, Integer numberPages,Integer price){
        this.id=id;
        this.name=name;
        this.author=author;
        this.nsx=nsx;
        this.year=year;
        this.numberPages=numberPages;
        this.price=price;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setYear(Date year) {
        this.year = year;
    }



    public Integer getId(){
        return id;
    }

    public Date getYear() {
        return year;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public Integer getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getNsx() {
        return nsx;
    }


}
