package greedy;

import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxBoxUnits = 0;
        //sort on the basis of number of box units for greedy
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] box : boxTypes) {
            int numOfBoxes = box[0];
            int numOfBoxUnits = box[1];

            if (truckSize >= numOfBoxes) {
                maxBoxUnits += numOfBoxes * numOfBoxUnits;
                truckSize -= numOfBoxes;

            } else {
                maxBoxUnits += truckSize * numOfBoxUnits;
                return maxBoxUnits;
            }
        }
        return maxBoxUnits;
    }
}
