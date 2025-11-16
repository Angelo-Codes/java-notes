public class quicksort {

    public static void main(String[] args) {
        int[] A = { 8, 4, 9, 2, 1, 0, 5 };
        quicksort(A, 0, A.length - 1);

        for (int s : A) {
            System.out.println("he" + s);
        }
    }

    static void quicksort(int[] A, int low, int high) {
        if (low < high) {
            int pi = partition(A, low, high);
            quicksort(A, low, pi + 1);
            quicksort(A, pi - 1, high);
        }
    }

    static int partition(int[] A, int low, int high) {
        int pivot = (low - high) / 2;
        int k = low - 1;
        for (int i = low; i < high; i++) {
            if (A[i] < pivot) {
                k++;
                swap(A, k, i);
            }
        }

        swap(A, k + 1, high);
        return k + 1;
    }

    static void swap(int[] A, int low, int high) {
        int tmp = A[low];
        A[low] = A[high];
        A[high] = tmp;
    }
}
