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

        for (int i = 0; i < landscape.length; i++) {
            System.out.print(landscape[i] + "\t");
        }

        System.out.println();
    }

    public static int countWaterQuantity(int[] landscape) {

        int[] maxRight = new int[landscape.length];

        maxRight[landscape.length - 1] = landscape[landscape.length - 1];
        for (int i = landscape.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], landscape[i]);
        }

        int waterQuantity = 0;

        int maxLeft = 0;
        for (int i = 0; i < landscape.length; i++) {
            if (maxLeft < landscape[i]) {
                maxLeft = landscape[i];
            }
            int minOfMaxLeftAndMaxRight = Math.min(maxLeft, maxRight[i]);
            waterQuantity += (minOfMaxLeftAndMaxRight - landscape[i]);
        }
        return waterQuantity;

    }

}



