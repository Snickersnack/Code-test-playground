package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class FilyaAndHomework {

	static class InputReader {
		HashSet<String> set = new HashSet<String>();
		public BufferedReader br;
		public StringTokenizer st;
		// String input = "5" + "\n" + "1 1 0 0 1";
		String input = "4" + "\n" + "RLRL" + "\n" + "2 4 6 10";
		InputStream is = new ByteArrayInputStream(input.getBytes());

		public InputReader() {
			br = new BufferedReader(new InputStreamReader(is));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) throws Exception {
		Numbers();
	}

	public static void Numbers() throws IOException {

		// String _source2 = "3 4" + "\n"
		// +" .*.." + "\n"
		// +" ...." + "\n"
		// +" .*..";

		String _source2 = "4" + "\n" + "10 10 10 10";

		InputStream in = new ByteArrayInputStream(_source2.getBytes("UTF-8"));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuilder sb = new StringBuilder();
		String firstLine = br.readLine();
		int n = Integer.parseInt(firstLine);
		String nextLine = br.readLine();
		String[] inputArray = nextLine.split(" ");
		int[] intArray = new int[n];
		int answer = 0;
		for (int i = 0; i < n; i++) {
			intArray[i] = Integer.parseInt(inputArray[i]);
			answer += intArray[i];
		}

		answer = answer / (n / 2);
		for (int i = 0; i < n - 1; i++) {
			if (intArray[i] == 0) {
				continue;
			}
			for (int j = i+1; j < n; j++) {
				if (intArray[j] == 0) {
					continue;
				}

				if (intArray[i] + intArray[j] == answer) {

					System.out.println((i + 1) + " " + (j + 1) + " ");
					intArray[i] = 0;
					intArray[j] = 0;
					break;

				}
			}
		}

	}

	public static String BomberMan() throws IOException {

		// String _source2 = "3 4" + "\n"
		// +" .*.." + "\n"
		// +" ...." + "\n"
		// +" .*..";

		String _source2 = "7 10" + "\n" + ".......*.." + "\n" + ".......*.."
				+ "\n" + ".......*.." + "\n" + "**.***.***" + "\n"
				+ ".......*.." + "\n" + ".......*.." + "\n" + ".......*..";

		InputStream in = new ByteArrayInputStream(_source2.getBytes("UTF-8"));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		StringBuilder sb = new StringBuilder();
		String firstLine = br.readLine();
		String[] firstLineArray = new String[2];
		firstLineArray = firstLine.split(" ");
		int row = Integer.parseInt(firstLineArray[0]);
		int column = Integer.parseInt(firstLineArray[1]);
		String[][] bombField = new String[row][column];
		String mines;
		String[] mineLine = new String[column];
		int rowCounter = 0;
		int totalMines = 0;
		while ((mines = br.readLine()) != null) {
			for (int i = 0; i < mineLine.length; i++) {
				mineLine[i] = Character.toString(mines.charAt(i));
			}
			for (int i = 0; i < mineLine.length; i++) {

				bombField[rowCounter][i] = mineLine[i];
				if (mineLine[i].equals("*")) {
					totalMines++;
				}
			}
			rowCounter++;
		}
		System.out.println(Arrays.deepToString(bombField));
		int rowMax = 0;
		int columnMax = 0;
		int rowIndex = 0;
		int columnIndex = 0;
		System.out.println(row + " " + column);
		for (int i = 0; i < row; i++) {
			int mineCount = 0;
			for (int j = 0; j < column; j++)
				if (bombField[i][j].equals("*")) {
					mineCount++;

				}
			if (mineCount > rowMax) {
				rowMax = mineCount;
				rowIndex = i;
			}

		}

		for (int i = 0; i < column; i++) {
			int mineCount = 0;
			for (int j = 0; j < row; j++)
				if (bombField[j][i].equals("*")) {
					mineCount++;

				}
			if (mineCount > columnMax) {
				columnMax = mineCount;
				columnIndex = i;
			}

		}

		if (totalMines > (rowMax + columnMax)) {
			sb.append("NO");
		} else {
			System.out.println("Total Mines " + totalMines);
			System.out.println(rowMax + columnMax);
			sb.append("YES" + "\n");
			sb.append((rowIndex + 1) + " " + (columnIndex + 1));
		}
		return sb.toString();
	}
}