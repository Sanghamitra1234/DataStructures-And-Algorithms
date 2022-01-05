// For heap sort we basically first create the heap
// Now our first index has maximum, so we swap between first and last index
// Delete the laat index (as per now its sorted).
// Again we run heapify from first index (excluding last index)
// Time complexity is O(n log n)
public class HeapSort {
        static int [] input = {10,20,3,60,80,90};

        public static void main (String [] args) {

                int n = input.length;

                //Build a max heap;
                buildHeap(input, n);
                System.out.println("Max heap is below ");
                for(int i = 0; i < n; i++) {
                        System.out.print(input[i]+" ");
                }
                System.out.println();

                heapsort(input, n);
        }
        private static void heapsort(int[] input, int n) {
                System.out.println("Sorted heap is below ");
                for (int i = n-1; i >= 0; i--) {

                        int a = input[i];
                        input[i] = input[0];
                        input[0] = a;

                        System.out.print(input[i]+" ");

                        heapify(input, i-1, 0);
                }
                
        }
        public static void buildHeap (int [] input, int n) {
                for (int i = n/2 - 1; i >= 0; i--) {
                        heapify(input, n, i);
                }
        }
        public static void heapify (int [] input, int n, int i) {
                int largest = i;
                int left = 2 * i + 1;
                int right = left + 1;

                if (left < n && input[left] > input[largest]) {
                        largest = left;
                }
                if (right < n && input[right] > input[largest]) {
                        largest = right;
                }
                if (largest != i) {
                        int a = input[largest];
                        input[largest] = input[i];
                        input[i] = a;

                        heapify(input, n, largest);
                }
        }
}
