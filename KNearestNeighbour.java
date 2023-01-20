import java.util.*;

public class KNearestNeighbour {
    
    float euclideanDistance(Node queryPoint, Node[] dataPoints, int i) {
        double dis = Math.sqrt((queryPoint.xPos-dataPoints[i].xPos)*(queryPoint.xPos-dataPoints[i].xPos) + 
                                (queryPoint.yPos-dataPoints[i].yPos)*(queryPoint.yPos-dataPoints[i].yPos));
        float result = (float)dis;
        return result;
    }

    public void calculateK(Node queryPoint, Node[] dataPoints, int n) {
        float distancesFromQuery[] = new float[n];
        for (int i = 0;  i < n; ++i) {
            dataPoints[i].calculatedDistance = euclideanDistance(queryPoint, dataPoints, i);
            distancesFromQuery[i] = euclideanDistance(queryPoint, dataPoints, i);
        }
    }

    int predictClass(int k, Node[] dataPoints) { 
        HashMap<Integer, Integer> kPoints = new HashMap<Integer, Integer>();
        int[] finalTargetClasses = new int[k];
        int nextIndex = 0;

        for (int i = 0; i < k; ++i) {
            if (kPoints.containsKey(dataPoints[i].targetClass)){
                kPoints.put(dataPoints[i].targetClass, kPoints.get(dataPoints[i].targetClass)+1);
            }else{
                finalTargetClasses[nextIndex++] = dataPoints[i].targetClass;
                kPoints.put(dataPoints[i].targetClass, 1);
            }
        }

        int maxClassFreq = Integer.MIN_VALUE;
        int maxClass = 0;
        for (int i = 0; i < k; ++i) {
            if (finalTargetClasses[i] == 0) break;

            else if (kPoints.get(finalTargetClasses[i]) > maxClassFreq) {
                maxClassFreq = kPoints.get(finalTargetClasses[i]);
                maxClass = finalTargetClasses[i];
            }
        }
        return maxClass;
    }
}
