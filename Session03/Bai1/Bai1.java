package Session03.Bai1;



import java.util.Scanner;

public class Bai1 {
    public static int[] addBookToLibraries(int n){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Nhap ma so cho " + n +" cuon sach");
        for (int i = 0 ; i < 5 ; i++){
            System.out.print("cuon sach thu " + (i+1) + ": ");
            arr[i] =  sc.nextInt();
        }
        return  arr;
    }
    public static void displayLibraries(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap n :");
        int n = sc.nextInt();
        int[] arr;
        arr = addBookToLibraries(n);
        displayLibraries(arr);
    }
}
