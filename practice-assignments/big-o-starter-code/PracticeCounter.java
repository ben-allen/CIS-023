/**
 * Big O practice: counting experiment.
 *
 * Each mystery method returns how many times its innermost statement runs
 * for an input of size n. Run main(), copy the counts into your answers,
 * and use them to figure out each method's growth rate.
 */
public class PracticeCounter {

    public static long mysteryA(int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                count++;
            }
        }
        return count;
    }

    public static long mysteryB(int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            int k = n;
            while (k > 1) {
                k = k / 2;
                count++;
            }
        }
        return count;
    }

    public static long mysteryC(int n) {
        long count = 0;
        for (int i = 1; i < n; i = i * 2) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000};
        System.out.printf("%8s %14s %14s %14s%n", "n", "mysteryA", "mysteryB", "mysteryC");
        for (int n : sizes) {
            System.out.printf("%8d %14d %14d %14d%n", n, mysteryA(n), mysteryB(n), mysteryC(n));
        }
    }
}
