package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UFClient {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("uf.txt"));
        int n = in.nextInt();
        QuickUnionUF uf = new QuickUnionUF(n);

        while (in.hasNextInt()) {
            int p = in.nextInt();
            int q = in.nextInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        System.out.println(uf.count() + " components");
        in.close();
    }
}
