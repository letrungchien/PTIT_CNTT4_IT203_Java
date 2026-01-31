package Session06.Bai2;

class Account {
    String username;
    String password;
    String email;

   public  Account( String username,String password, String email){
       this.username=username;
       this.password=password;
       this.email =email;
   }
   public  void print(){
       System.out.println("Ten tai khoan :"+username);
       System.out.println("Email :"+email);
   }
   public void setNew_password(String new_password){
       this.password=new_password;
   }
}

public class Bai2 {
   public static void main(String[] args) {
    Account ac1= new Account("Lechien","000kkk","lec@gmail.com");
    ac1.setNew_password("Momo");
    ac1.print();
    }
}
