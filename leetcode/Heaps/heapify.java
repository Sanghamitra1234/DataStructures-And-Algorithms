// Heapify helps in building a max or min heap
// Max Heap means a complete binary tree which has its parent node always greater than its child
// Time complexity is O(log n)
class heapify {
        static int [] input = {10,20,3,60,80,90};

        public static void main (String [] args) {

                int n = input.length;
                buildHeap(input, n);

                for(int i = 0; i < n; i++) {
                        System.out.print(input[i]+" ");
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