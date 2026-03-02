package Session15.lythuyet;

import java.util.Scanner;
import java.util.Stack;

public class thuc_hanh {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String chuoi;
        Stack<String> stack =new Stack<String>();
        System.out.println("nhap bieu thuc muon kiem tra");
        chuoi=sc.nextLine();

        for (int i =0;i<chuoi.length()-1;i++){
            if(chuoi.charAt(i)==('(')){
              stack.push("(");
            } else if (chuoi.charAt(i)==(')')) {
                stack.pop();
            }
        }

        if (!stack.empty()){
            System.out.println("hop le");
        }else {
            System.out.println("khong hop le");
        }

    }
}
