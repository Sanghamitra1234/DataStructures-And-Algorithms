public class KLargest {
        static int [] input = {602 ,324 ,133 ,473 ,153 ,88 ,571 ,764 ,902 ,104 ,424 ,528 ,601 ,970 ,16 ,566 ,29 ,544 ,348};
        public static void main (String [] args) {
                kLargest(input, input.length, 17);
                
        }
        private static void heapsort(int[] input, int n, int k) {
                System.out.println("Sorted heap is below ");
                for (int i = n-1; i >= n-k; i--) {

                        int a = input[i];
                        input[i] = input[0];
                        input[0] = a;

                        System.out.print(input[i]+" ");

                        heapify(input, i, 0);
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
        static void kLargest(int[] arr, int n, int k) {

                //Build a max heap;
                buildHeap(input, n);
                System.out.println("Max heap is below ");
                for(int i = 0; i < n; i++) {
                        System.out.print(input[i]+" ");
                }
                System.out.println();

                heapsort(input, n, k);
        }
}