package SortingAlgorithms;

public class CountingSortStudentAges {
    public static void main(String[] args) {
        int[] ages = {15, 17, 12, 10, 15, 18, 14};
        int[] sorted = countingSort(ages, 10, 18);
        for (int age : sorted) System.out.print(age + " ");
    }

    static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        for (int num : arr) count[num - min]++;
        int[] sorted = new int[arr.length];
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) sorted[index++] = i + min;
        }
        return sorted;
    }
}
