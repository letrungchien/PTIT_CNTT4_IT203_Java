package Session06.Bai6;
class User{
    private String id;
    private String username ;
    private String password;
    private String email;

    public void setPassword(String password){
        if(password.isEmpty()){
            System.out.println("Mat khau khong duoc de trong");
        }else {
            this.password=password;
        }
    }
    public void setEmail(String email) {
        if ( email.trim().isEmpty()) {
            System.out.println(" Email khong duoc trong");
            return;
        }

        if (!email.contains("@")) {
            System.out.println(" Email khong hop le");
            return;
        }

        this.email = email;
    }

    public User(String id,String username,String password,String email){
        this.id=id;
        this.username=username;
        setEmail(email);
        setPassword(password);
    }
    public void print(){
        System.out.println("Ma: "+id);
        System.out.println("Ten: "+username);
        System.out.println("Email: "+email);
        System.out.println("-------------------");
    }

}
public class Bai6 {
  public   static void main(String[] args) {
        User user1=new User("U01","Le Thi A","09654","a@gmail.com");
        User user2=new User("U02","Nguyen Thi B","","b@gmail.com");
        User user3=new User("U03","Nguyen Thi C","5675","bgmail.com");
        User user4=new User("U04","Nguyen Thi D","57676","");

        user1.print();
        user2.print();
        user3.print();
        user4.print();
    }
}
