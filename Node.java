public class Node implements Comparable<Node>{
    float xPos, yPos;
    int targetClass, pointNum;
    float calculatedDistance;
    Node(){}
    Node(float x, float y) {
        this.xPos = x;
        this.yPos = y;
    }
    Node(float x, float y, int z, int pNum) {
        this.xPos = x;
        this.yPos = y;
        this.targetClass = z;
        this.calculatedDistance = 0.0f;
        this.pointNum = pNum;
    }

    @Override
    public int compareTo(Node n) {
        if(this.calculatedDistance > n.calculatedDistance){
            return 1;
        }else if(this.calculatedDistance == n.calculatedDistance){
            return 0;
        }else{
            return -1;
        }
    }
}
