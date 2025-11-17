public class quicksort {

    public static void main(String[] args) {
        int[] A = { 8, 4, 9, 2, 1, 0, 5 };
        quicksort(A, 0, A.length - 1);

        for (int s : A) {
            System.out.println("he : " + s);
        }
    }

    static void quicksort(int[] A, int low, int high) {
        if (low < high) {
            int pi = partition(A, low, high);
            quicksort(A, low, pi - 1);
            quicksort(A, pi + 1, high);
        }
    }

    static int partition(int[] A, int low, int high) {
        int pivot = A[(low + high) / 2];
        int k = low;
        int m = high;
        while(k <= m) {
            while(A[k] < pivot) k++;
            while(A[m] > pivot) m--;
            
            if(k <= m) {
                swap(A, k, m);
                k++;
                m--;
            }
        }
        return k;
    }

    static void swap(int[] A, int low, int high) {
        int tmp = A[low];
        A[low] = A[high];
        A[high] = tmp;
    }
}

