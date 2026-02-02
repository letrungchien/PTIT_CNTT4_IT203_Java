package Session07.Bai6;

import java.util.ArrayList;

class  User{
     final int id;
    String username;
     String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public String toString() {
        return "User[id=" + id + ", name=" + username + "]";
    }
}

class UserManager {

    public static ArrayList<User> users = new ArrayList<>();

    public static void addUser(User u) {
        users.add(u);
    }

    public static boolean checkLogin(String username, String password) {
        for (User u : users) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
public class Bai6 {
   public static void main(String[] args) {
       User u1 = new User(1, "dev_a", "123456");
       User u2 = new User(2, "dev_b", "abcdef");
       User u3 = new User(3, "dev_c", "qwerty");

       UserManager.addUser(u1);
       UserManager.addUser(u2);
       UserManager.addUser(u3);

       System.out.println(">> Đã thêm 3 user vào hệ thống.");
       System.out.println("Danh sách hiện tại:");

       int i = 1;
       for (User u : UserManager.users) {
           System.out.println(i + ". " + u);
           i++;
       }

       System.out.println("\n>> Kiểm tra đăng nhập:");
       System.out.println("- Login (\"dev_a\", \"123456\"): "
               + (UserManager.checkLogin("dev_a", "123456") ? "Thành công!" : "Thất bại!"));

       System.out.println("- Login (\"dev_b\", \"sai_pass\"): "
               + (UserManager.checkLogin("dev_b", "sai_pass") ? "Thành công!" : "Thất bại!"));

    }
}
