package topic1;

public class Main {


    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Hello user! what is your firstname, lastname, and age");
            return;
        }
        else if (args.length != 3){
            System.out.println("Incorrect number of arguments provided\nThe correct format is firstname, lastname, and age");
            return;
        }

        String firstName = args[0];
        String lastName = args[1];
        int age;
        try {
            age = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e){
            System.out.println("Please provide a number as input for age");
            return;
        }

        System.out.println("Hello my name is " + firstName + " " + lastName + " and my age is " + age);

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


