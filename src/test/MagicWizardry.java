package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;

public class MagicWizardry {
    public static void print(String s) {
        System.out.println(s);
    }
    public static ArrayList<Integer> readInts(Scanner in, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            list.add(in.nextInt());
        }
        return list;
    }
    public static String join(ArrayList<? extends Object> list) {
        if (list.size() == 0) {
            return "";
        }
        String out = "" + list.get(0);
        for (int i = 1; i < list.size(); i++) {
            out += " " + list.get(i);
        }
        return out;
    }

    //String.format("%d", c);
    //n = total original  d = current remaining card  l = maximum number
    public static String solve(int n, int d, int l) {
        int negative = n / 2;
        int positive = n - negative;
        int max = (l * positive) - negative;
        int min = positive - (l * negative);
        if (d < min || d > max) {
            return "-1";
        }

        //Start at minimum
        ArrayList<Integer> set = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                set.add(1);
            } else {
                set.add(-l);
            }
        }

        //Increment
        for (int i = 0; i < d - min; i++) {
            set.set(i % n, set.get(i % n) + 1);
        }

        //Make all positive
        for (int i = 0; i < n; i++) {
            set.set(i, Math.abs(set.get(i)));
        }

        return join(set);
    }

    public static void main(String[] args) throws FileNotFoundException {
        boolean debug = false;

        InputStream input = System.in;
        if (debug) {
            input = new FileInputStream("input.in");
        }
        Scanner in = new Scanner(input);

        int n = in.nextInt();
        int d = in.nextInt();
        int l = in.nextInt();
        print(solve(n, d, l));
    }
}