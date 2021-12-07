//https://leetcode.com/problems/count-common-words-with-one-occurrence/

class Solution {
    public int countWords(String[] words1, String[] words2) {
       HashMap<String, Integer> h = new HashMap<>();
        for(int i = 0; i < words1.length; i++){
            if(h.containsKey(words1[i])){
                h.put(words1[i], -1);
            }else{
                h.put(words1[i], 1);
            }
        }

        for(int i = 0; i < words2.length; i++){
            if(h.containsKey(words2[i])){
                h.put(words2[i], h.get(words2[i])-1);
            }
        }
        int count = 0;
        for (Map.Entry mapElement : h.entrySet()) {

            int value = ((int)mapElement.getValue());
            if(value == 0){
                count++;
            }
        }

        return count;
    }
}
