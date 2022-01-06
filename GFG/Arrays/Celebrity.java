import java.util.*;

class Celebrity
{ 
        static final int N = 4;

        static int MATRIX[][] = { { 0, 0, 1, 0 },
                                { 0, 0, 1, 0 },
                                { 0, 0, 0, 0 },
                                { 0, 0, 1, 0 } };
                                
        public static void main(String [] args) {

           System.out.println(celebrity(MATRIX, N));     
        }

        // Function to find if there is a celebrity in the party or not.
        // Indegree Out Degree logic : Time Complexity O(n2) ans space Complexity (O(n))
        // static int celebrity(int M[][], int n)
        // {
        //         // code here
        //         int [] ans = new int [n];
        //         for (int i = 0; i < M.length; i++) {
        //                 for (int j = 0; j < M[0].length; j++) {
        //                         System.out.println(M[i][j]);
        //                         if (M[i][j] == 1) {
        //                                 ans[i]--;
        //                                 ans[j]++;
        //                         }
        //                 }
        //         }
        //         // System.out.println(Arrays.toString(ans));
        //         for (int i = 0; i < n; i++){
        //                 if (ans[i] == n-1){
        //                         return i;
        //                 }
        //         }
        //         return -1;
        // }
        
        // Assumption A know B . B may be celebrity, A is not
        // A doesnt know B. A may be celebrity, B is not
        //Time Complexity : O(n)
        static int celebrity(int M[][], int n)
        {
                // code here
                Stack<Integer> st = new Stack<>();
                for (int i = 0; i < n; i++){
                       st.push(i);
                }

                while(st.size() > 1){
                        int a = st.pop();
                        int b = st.pop();

                        if (M[a][b] == 1) {
                                st.push(b);
                        } else {
                                st.push(a);
                        }
                }

                if (st.empty()){
                        return -1;
                }
                int celeb = st.pop();
                //System.out.println(celeb);
                for (int i = 0; i < n; i++){
                       if (celeb != i && (M[i][celeb] == 0 || M[celeb][i] == 1)) {
                                return -1;
                       }
                }
                return celeb;
        }
}