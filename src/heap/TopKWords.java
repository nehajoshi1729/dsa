package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TopKWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
        }
        List<String> result = new ArrayList(freqMap.keySet());
        //sort lexicographically if same freq, or else go for higher freq
        Collections.sort(result, (w1, w2) -> freqMap.get(w1).equals(freqMap.get(w2)) ? w1.compareTo(w2) : freqMap.get(w2) - freqMap.get(w1));
        return result.subList(0, k);
    }
}
