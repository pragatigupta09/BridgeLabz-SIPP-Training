package SortingAlgorithms;

public class SelectionSortExamScores {
    public static void main(String[] args) {
        int[] scores = {56, 89, 90, 45, 76};
        selectionSort(scores);
        for (int score : scores) System.out.print(score + " ");
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
        }
    }
}
