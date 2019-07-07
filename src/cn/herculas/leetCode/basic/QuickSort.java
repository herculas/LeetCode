package cn.herculas.leetCode.basic;

import java.util.Arrays;

public class QuickSort {
    private int partition(int[] a, int low, int high) {
        int i = low + 1;
        int j = high;

        while (true) {
            while (a[i] < a[low]) {
                i++;
                if (i == high)
                    break;
            }
            while (a[low] < a[j]) {
                j--;
                if (j == low)
                    break;
            }
            if (i >= j) break;
            this.exchange(a, i, j);
        }
        this.exchange(a, low, j);
        return j;
    }

    private void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void sort(int[] a) {
        this.sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int low, int high) {
        if (high <= low) return;
        int partition = this.partition(a, low, high);

        this.sort(a, low, partition - 1);
        this.sort(a, partition + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {5, 8, 7, 1, 3, 6, 8, 9, 4, 5, 6, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
