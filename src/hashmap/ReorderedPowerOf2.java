package hashmap;

/**
 * We can compare two freq maps
 *  freq cnt of n (will stay same even if we reorder digits)
 *  we can create freq cnt for every 2's power
 *  if we get a match return true
 */

public class ReorderedPowerOf2 {
    private static int[] freqCnt(int n) {
        int[] digitsFreq = new int[10];
        while (n > 0) {
            digitsFreq[n % 10]++;
            n = n / 10;
        }
        return digitsFreq;
    }

    private static boolean compareFreqCnt(int[] freqCnt1, int[] freqCnt2) {
        for (int i = 0; i < 10; i++) {
            if (freqCnt1[i] != freqCnt2[i])
                return false;
        }
        return true;
    }

    public static boolean reorderedPowerOf2(int n) {
        int[] digitsFreq = freqCnt(n);
        int[] powerOf2FreqCnt = new int[10];
        for (int i = 0; i < 31; i++) // all possible powers of 2
        {
            int powerOf2 = (int) Math.pow(2, i);
            powerOf2FreqCnt = freqCnt(powerOf2);
            if (compareFreqCnt(digitsFreq, powerOf2FreqCnt))
                return true;
        }
        return false;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
