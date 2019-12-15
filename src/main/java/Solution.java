import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] x = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            x[i] = arItem;
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] f = new int[n];

        String[] arItems2 = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems2[i]);
            f[i] = arItem;
        }

        int sumF = 0;
        for (int i = 0; i < n; i++) {
            sumF = sumF + f[i];
        }

        int[] s = new int[sumF];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < f[i]; j++) {
                s[count] = x[i];
                count++;
            }
        }

        Arrays.sort(s);

        int[] l;
        int[] u;
        if (sumF%2 == 0) { //четное
            l = Arrays.copyOfRange(s, 0, sumF/2);
            u = Arrays.copyOfRange(s, sumF/2,sumF);
        } else {
            l = Arrays.copyOfRange(s, 0, sumF/2);
            u = Arrays.copyOfRange(s, sumF/2+1, sumF);
        }
        double q1 = calcMedian(l);
        double q3 = calcMedian(u);

        System.out.println(String.format("%.1f", q3 - q1));

        scanner.close();


    }

    private static double calcMedian(int[] param) {
        double median = 0;
        int n = param.length;
        if (n%2==0) { //четное
            median = ((double) (param[n/2] + param[(n/2)-1]))/2;
        } else {
            median = param[n/2];
        }

        return median;
    }


}
