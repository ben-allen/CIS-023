/**
 * Big O assignment: counting experiment.
 *
 * Each mystery method returns how many times its innermost statement runs
 * for an input of size n. Run main(): it prints the counts, and the ratio
 * of each count to the count on the line above it (the "doubling ratio").
 */
public class AssignmentCounter {

    public static long mysteryA(int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            count++;
        }
        return count;
    }

    public static long mysteryB(int n) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }

    public static long mysteryC(int n) {
        long count = 0;
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000};
        long prevA = 0, prevB = 0, prevC = 0;
        System.out.printf("%6s | %9s %6s | %11s %6s | %9s %6s%n",
                "n", "mysteryA", "ratio", "mysteryB", "ratio", "mysteryC", "ratio");
        for (int n : sizes) {
            long a = mysteryA(n), b = mysteryB(n), c = mysteryC(n);
            System.out.printf("%6d | %9d %6s | %11d %6s | %9d %6s%n",
                    n, a, ratio(a, prevA), b, ratio(b, prevB), c, ratio(c, prevC));
            prevA = a; prevB = b; prevC = c;
        }
    }

    private static String ratio(long now, long before) {
        return before == 0 ? "-" : String.format("%.2f", (double) now / before);
    }
}
