package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class InputOutputCode {

public static void main(String[] args) {

    
        try {
        	
            File file = new File("input.txt");
            InputStream input = System.in;
            OutputStream output = System.out;
            if (file.canRead()) {
                input = (new FileInputStream(file));
                output = (new PrintStream("output.txt"));
            }
            br = new BufferedReader(new InputStreamReader(input));
            out = new PrintWriter(output);
            Eduardo();
            out.close();
            br.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
	
static BufferedReader br;
static StringTokenizer st;
static PrintWriter out;
	public static void Eduardo() throws IOException{
		
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		String[] inputArray = input.split(" ");
		
	}
}


