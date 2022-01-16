package cs.vsu.ru.lyashenko_e_v;
import java.util.Scanner;

public class Main {
    public static int maxLength(int[] arr){
        boolean order = false; //проверка на последовательность
        int start = 0;
        int end = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for(int i = 0; i <= arr.length - 2; i++) {
            if ((!order) && (arr[i] < arr[i + 1])) { //нашли ли мы новую последовательность
                start = i;
                end = i + 1;
                order = true;
            }
            if (order)
                if (arr[i] < arr[i + 1]) {
                    end = i + 1;
                } else {
                    if ((maxEnd - maxStart) < (end - start)) {
                        maxEnd = end;
                        maxStart = start;
                    }
                    order = false;
                }

        }
        boolean order1 = false; //проверка на последовательность
        int start1 = 0;
        int end1 = 0;
        int maxStart1 = 0;
        int maxEnd1 = 0;
        for(int i = 0; i <= arr.length - 2; i++) {
            if ((!order1) && (arr[i] > arr[i + 1])) {
                start1 = i;
                end1 = i + 1;
                order1 = true;
            }
            if (order1)
                if (arr[i] > arr[i + 1]) {
                    end1 = i + 1;
                } else {
                    if ((maxEnd1 - maxStart1) < (end1 - start1)) {
                        maxEnd1 = end1;
                        maxStart1 = start1;
                    }
                    order1 = false;
                }
        }
        if ((maxEnd - maxStart) < (end - start)) { //в буфере хранится переменная. для него проверка
            maxEnd = end;
            maxStart = start;
        }

        if((order)&&(arr[arr.length - 2] < arr[arr.length - 1]))
            maxEnd++;

        if ((maxEnd1 - maxStart1) < (end1 - start1)) {
            maxEnd1 = end1;
            maxStart1 = start1;
        }
        if((order1)&&(arr[arr.length - 2] < arr[arr.length - 1]))
            maxEnd1++;

        if((maxEnd - maxStart) > (maxEnd1 - maxStart1))
            return maxEnd - maxStart;
        else
            return maxEnd1 - maxStart1;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Введите длину массива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print(" Введите массив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Ответ " + maxLength(arr));
    }
}