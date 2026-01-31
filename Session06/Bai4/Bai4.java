package Session06.Bai4;
class Employee{
    String ma;
    String ten;
    int luong;

    public Employee(){
        this.ma="Trong";
        this.ten="Trong";
        this.luong=0;
    }
    public Employee(String ma,String ten){
        this.ma=ma;
        this.ten=ten;
        this.luong=0;
    }
    public Employee(String ma,String ten,int luong){
        this.ma=ma;
        this.ten=ten;
        this.luong=luong;
    }
    public void print(){
        System.out.println("Ma: "+ma);
        System.out.println("Ten: "+ten);
        System.out.println("Luong: "+luong);
        System.out.println("---------------------\n\n\n");
    }
}
public class Bai4 {
   public static void main(String[] args) {
        Employee e1 =new Employee();
        Employee e2 =new Employee("E02","Ten");
        Employee e3= new Employee("E03","Chien",100000);
        e1.print();
        e2.print();
        e3.print();
    }
}
