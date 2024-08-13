package topic1;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args){
          int[] array = new int[]{10, 80, 30, 90, 40};
          quick_sort(array);
          System.out.println(Arrays.toString(array));
    }

    public static void quick_sort(int[] list) {
        quick_sort_rec(list, 0, list.length - 1);
    }

    private static void quick_sort_rec(int[] list, int low, int high){
        if (low < high) {
            int p_index = partition(list, low, high);

            quick_sort_rec(list, low, p_index - 1);
            quick_sort_rec(list, p_index + 1, high);
        }

        return;
    }

    private static int partition(int[] list, int low, int high){
        int pivot = list[high];

        int i = low - 1;

        for (int j = low; j < high; j++){
            if (list[j] < pivot){
                i++;
                // swap
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        //swap pivot
        list[high] = list[i+1];
        list[i+1] = pivot;
        return i+1;
    }

}
