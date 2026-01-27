package Session03.Bai6;

import java.util.Arrays;

public class Bai6 {
    public static void mergeBooks(int[] a, int[] b){

        int index = 0;
        int[] arrMerge = new int[a.length + b.length];
        for (int i = 0 ; i < a.length ; i++){
            arrMerge[index++] = a[i];
        }
        for (int i = 0 ; i < b.length ; i++){
            boolean check = true;
            for (int j = 0 ; j < arrMerge.length ; j++){
                if (arrMerge[j] == b[i]){

                    check = false;
                    break;
                }
            }
            if (check == true) arrMerge[index++] = b[i];
        }
        // sap xep
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1 - i; j++) {
                if (arrMerge[j] > arrMerge[j + 1]) {
                    int temp = arrMerge[j];
                    arrMerge[j] = arrMerge[j + 1];
                    arrMerge[j + 1] = temp;
                }
            }
        }
        // in
        System.out.println("Mang sau khi sap sep la :");
        for (int i = 0 ; i < index ; i++){
            System.out.printf("%d " , arrMerge[i]);
        }
    }
    static void main(String[] args) {
        int[] arrayFirst = new int[] {1,3,5,7,9};
        int[] arraySecond = new int[] {2,3,5,6,8,9,10};
        mergeBooks(arrayFirst,arraySecond);
    }
}
