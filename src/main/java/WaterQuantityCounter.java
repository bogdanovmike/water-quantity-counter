import java.util.Scanner;

public class WaterQuantityCounter {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter landscape width: \n");

        int landscapeWidth = sc.nextInt();
        int[] landscape = generateLandscape(landscapeWidth);
        printLandscape(landscape);
        System.out.println(countWaterQuantity(landscape));

        sc.close();
    }

    private static int[] generateLandscape(int n) {
        System.out.println("Building landscape... ");
        int[] landscape = new int[n];

        for (int i = 0; i < landscape.length; i++) {
            landscape[i] = (int) (Math.random() * n);
        }
        System.out.println("completed");
        return landscape;
    }

    private static void printLandscape(int[] landscape) {
        System.out.println("Printing landscape...");

        for (int aLandscape : landscape) {
            System.out.print(aLandscape + ", ");
        }

        System.out.println();
    }

    static int countWaterQuantity(int[] landscape) {

        int[] maxFromRight = new int[landscape.length];

        maxFromRight[landscape.length - 1] = landscape[landscape.length - 1];
        for (int i = landscape.length - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i + 1], landscape[i]);
        }

        int waterQuantity = 0;

        int maxFromLeft = 0;
        for (int i = 0; i < landscape.length; i++) {
            if (maxFromLeft < landscape[i]) {
                maxFromLeft = landscape[i];
            }
            int minOfMaxLeftAndMaxRight = Math.min(maxFromLeft, maxFromRight[i]);
            waterQuantity += (minOfMaxLeftAndMaxRight - landscape[i]);
        }
        return waterQuantity;

    }

}



