import java.util.*;
import ohtu.Multiplier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int lol = 3;
        Multiplier kolme = new Multiplier(lol);
        System.out.println("anna luku ");
        int luku = scanner.nextInt();

        if (luku != 0) {
            System.out.println("luku kertaa kolme on "+kolme.multipliedBy(luku) );
        }
    }
}