package Session03.Bai4;


public class Bai4 {
    public static int[] sortBook(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = i + 1 ; j < arr.length - 1 ; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j + 1] ;
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public static void displayBooks(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.printf("%d " , arr[i]);
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int[] arr = new int[] {105 , 102 , 109 , 101 , 103};
        System.out.println("truoc khi sap xep : ");
        displayBooks(arr);
        System.out.println("sau khi sap xep :");
        sortBook(arr);
        displayBooks(arr);
    }
}