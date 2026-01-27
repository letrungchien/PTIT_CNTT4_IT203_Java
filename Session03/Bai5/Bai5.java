package Session03.Bai5;

import java.util.Scanner;
public class Bai5 {
    public static int[] inputArr( int n){
        Scanner sc = new Scanner(System.in);
        int[] arr  = new int[n];
        for (int i = 0 ; i < n ; i++){
            System.out.println("nhap gia tri thu " + (i+1));
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void printArr(int[] arr , int n){
        for (int i = 0 ; i < n; i++){
            System.out.printf("%d ", arr[i]);
        }
        System.out.println("");
    }
    public static int deleteBook(int[] arr, int n, int bookId){
        int index = 0 ;
        for (int i = 0 ; i < n ; i++){
            if (arr[i] == bookId) index = i;
        }
        for (int i = index ; i < n - 1   ; i++){
            arr[i] = arr[i + 1];
        }
        n --;
        return  n;
    }
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong sach hien tai :");
        int n = sc.nextInt();
        int[] arr ;
        arr = inputArr(n);
        printArr(arr , n);
        System.out.println("nhap id ban muon xoa :");
        int bookId = sc.nextInt();
        int n2 = deleteBook(arr,n,bookId);
        printArr(arr,n2);
    }
}
