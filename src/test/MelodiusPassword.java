package test;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class MelodiusPassword {

    static String[] c = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};
    static String[] v = {"a", "e", "i", "o", "u"};
    static StringBuilder output = new StringBuilder();
    static OutputStream out = new BufferedOutputStream ( System.out );

    public static void main(String[] args) throws Exception {
        int n = 6;

        StringBuilder sb = new StringBuilder();
        recurse(0, n, true, sb);
        recurse(0, n, false, sb);
       out.write((output.toString() + "\n").getBytes());
        
    }

    
    public static void recurse(int size, int target, boolean vowel, StringBuilder sb) throws Exception{

    	if(size>=target){
            return;
        }
        
        if(vowel){
            for(int i = 0; i<v.length; i++){
                sb.append(v[i]);
                output.append(sb.toString());
                output.append(System.getProperty("line.separator"));
//                out.write((sb.toString() + "\n").getBytes());
                recurse(++size, target,false, sb);
                sb.setLength(sb.length() - 1);
                size--;
            }
        }else{
            for(int i = 0; i<c.length; i++){
                sb.append(c[i]);
                output.append(sb.toString());
                output.append(System.getProperty("line.separator"));
//                out.write((sb.toString() + "\n").getBytes());
                recurse(++size, target, true, sb);
                sb.setLength(sb.length() - 1);
                size--;


            }
        }

    }
}