
 import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int p = in.nextInt();
            int n = in.nextInt();
            List<String> passwords = new ArrayList<String>();
            int index = 0;
            while (in.hasNext()) {
                passwords.add(in.next());
                index++;
            }
            int passwordSize = passwords.get(passwords.size() - 1).length();
            String target = passwords.get(passwords.size()-1);
            passwords.remove(passwords.get(passwords.size() - 1));
            Collections.sort(passwords, new comp());
            StringBuilder sb = new StringBuilder();
            int attempts = 0;
            int totalTime = 0;
            int lengthCount = 0;
            
            boolean recorded = false;

            for (int i = 0; i < passwords.size(); i++) {
                String pass = passwords.get(i);
                //This is the time of all passwords less than the size of current (quickest password time)
                if (pass.length() >= passwordSize && !recorded) {
                    recorded = true;
                    lengthCount = totalTime + 1;
                }
                if (pass.equals(target)) {
                    continue;
                }
                if (pass.length() > passwordSize) {
                    break;
                }

                attempts++;
                if (attempts % n == 0) {
                    totalTime += 6;

                } else {
                    totalTime++;
                }


            }
            if(passwords.size() == 1){
                lengthCount = 1;
            }
            totalTime = totalTime + 1;
            sb.append(lengthCount + " " + totalTime);
            out.println(sb.toString());
        }

        class comp implements Comparator<String> {
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }

        }

    }
}