import java.util.Scanner;
import java.util.Arrays;

public class UserInput extends KNearestNeighbour{
    void getCoordinates(int n, int k){
        Scanner inp = new Scanner(System.in);
        Node[] coords = new Node[n];
        Node qPoint = new Node();

        //SET THIS TO FALSE IF YOU WANT TO DYNAMICALLY ENTER THE COORDINATES
        if (true){
            qPoint = new Node(3f,2f); //QUERY POINT
    
            coords[0] = new Node(0.8f,0.8f,1,0);
            coords[1] = new Node(1f,1,1,1);
            coords[2] = new Node(1.2f,0.8f,1,2);
            coords[3] = new Node(0.8f,1.2f,1,3);
            coords[4] = new Node(1.2f,1.2f,1,4);
            coords[5] = new Node(4f,3,2,5);
            coords[6] = new Node(3.8f,2.8f,2,6);
            coords[7] = new Node(4.2f,2.8f,2,7);
            coords[8] = new Node(3.8f,3.2f,2,8);
            coords[9] = new Node(4.2f,3.2f,2,9);
            coords[11] = new Node(4.4f,3.2f,2,11);
            coords[10] = new Node(4.4f,2.8f,2,10);
            coords[12] = new Node(3.2f,0.4f,3,12);
            coords[13] = new Node(3.2f,0.7f,3,13);
            coords[14] = new Node(3.8f,0.5f,3,14);
            coords[15] = new Node(3.5f,1,3,15);
            coords[16] = new Node(4f,1,3,16);
            coords[17] = new Node(4f,0.7f,3,17);
        }
        
        //SET THIS TO TRUE IF YOU WANT TO DYNAMICALLY ENTER THE COORDINATES
        if(false) {
            System.out.print("Enter xPos of Query Point: ");
            float qXPos = inp.nextFloat();
            
            System.out.print("Enter yPos of Query Point: ");
            float qYPos = inp.nextFloat();
    
            // Node qPoint = new Node(qXPos,qYPos);
            System.out.println("\n\n"); //Line-breaker
    
            for (int i=0; i < n; ++i) {
                System.out.print("Enter xPos of "+(i+1)+" :");
                float xPos = inp.nextFloat();
                
                System.out.print("Enter yPos of "+(i+1)+" :");
                float yPos = inp.nextFloat();
    
                System.out.print("Enter target class of "+(i+1)+" :");
                int targetClass = inp.nextInt();
    
                coords[i] = new Node(xPos, yPos, targetClass, i);
    
                System.out.println("\n\n");//Line-breaker
            }
        }

        inp.close();

        calculateK(qPoint, coords, n);

        Arrays.sort(coords);
        for (int i = 0; i < n; ++i) {
            System.out.println((coords[i].pointNum+1)+ "\t:\t" +coords[i].calculatedDistance+ "\tCLASS: " +coords[i].targetClass);
        }

        int predictedClass = predictClass(k, coords);
        System.out.println("\nQuery Point belongs to the class: " +predictedClass);
    }
}