package SortingAlgorithms;
class BubbleSortStudentMarks {
    public static void main(String[] args) {
        int[] marks = {65, 98, 45, 76, 88};
        bubbleSort(marks);
        for (int mark : marks) System.out.print(mark + " ");
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
