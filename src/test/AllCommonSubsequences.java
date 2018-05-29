package test;

/*
 * Copyright (c) 2006-2015 Mirth Corporation.
 * All rights reserved.
 *
 * NOTICE:  All information contained herein is, and remains, the
 * property of Mirth Corporation. The intellectual and technical
 * concepts contained herein are proprietary and confidential to
 * Mirth Corporation and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret
 * and/or copyright law. Dissemination of this information or reproduction
 * of this material is strictly forbidden unless prior written permission
 * is obtained from Mirth Corporation.
 */

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 *
 */
public class AllCommonSubsequences {

    
    /**
     * Computes the similarity between two strings as the total length of all
     * common subsequences with length greater than two, divided by either the
     * length of the shorter string (if useMin) or the longer string (if
     * !useMin).
     * 
     * @param leftString One of the two strings to compare.
     * @param rightString The other of the two strings to compare.
     * @param useMin True to divide by the length of the shorter string, or
     * false to divide by the length of the longer string.
     * @return The computed similarity score.
     */
    public static double compare(String leftString, String rightString, boolean useMin) {

        if (leftString.length() == 1 || rightString.length() == 1) {
            return leftString.equals(rightString) ? 1.0 : 0.0;
        } else {
            int acsLen = acsTotalLength(leftString, rightString);
            double strSz;
            if (useMin) {
                strSz = Math.min(leftString.length(), rightString.length());
            }
            else {
                strSz = Math.max(leftString.length(), rightString.length());
            }
            return acsLen / strSz;
        }
    }

    public static double compareLcs(String leftString, String rightString, boolean useMin) {

        if (leftString.length() == 1 || rightString.length() == 1) {
            return leftString.equals(rightString) ? 1.0 : 0.0;
        } else {
            int lcsLen = longestCommonSubsequence(leftString, rightString)[0].length();
            double strSz;
            if (useMin) {
                strSz = Math.min(leftString.length(), rightString.length());
            }
            else {
                strSz = Math.max(leftString.length(), rightString.length());
            }
            return lcsLen / strSz;
        }
    }
 
    /**
     * Finds the longest common subsequence between two strings, and the
     * characters remaining in the two source strings after the subsequence
     * characters are removed.
     * 
     * Algorithm based on http://www.ics.uci.edu/~eppstein/161/960229.html
     * 
     * @param leftString One of the two strings to compare.
     * @param rightString The other of the two strings to compare.
     * @return A String[3], where [0] is the computed longest common subsequence,
     * [1] is the characters remaining in leftString after the common subsequence
     * is removed, and [2] is the characters remaining in rightString after the
     * common subsequence is removed.
     */
    public static String [] longestCommonSubsequence(String leftString, String rightString) {

        int[][] num = new int[leftString.length() + 1][rightString.length() + 1];  //2D array, initialized to 0

        //Actual algorithm
        for (int i = 1; i <= leftString.length(); i++) {
            for (int j = 1; j <= rightString.length(); j++) {
                if (leftString.charAt(i - 1) == rightString.charAt(j - 1)) {
                    num[i][j] = 1 + num[i - 1][j - 1];
                } else {
                    num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]);
                }
            }
        }

        //System.out.println("length of LCS = " + num[s1.length()][s2.length()]);

        int s1position = leftString.length(), s2position = rightString.length();

        StringBuilder result = new StringBuilder();
        StringBuilder s1rest = new StringBuilder();
        StringBuilder s2rest = new StringBuilder();
        
        while (s1position != 0 && s2position != 0) {
            if (leftString.charAt(s1position - 1) == rightString.charAt(s2position - 1)) {
                result.append(leftString.charAt(s1position - 1));
                s1position--;
                s2position--;
            } else if (num[s1position][s2position - 1] >= num[s1position - 1][s2position]) {
                s2rest.append(rightString.charAt(s2position - 1));
                s2position--;
            } else {
                s1rest.append(leftString.charAt(s1position - 1));
                s1position--;
            }
        }
        
        // finish up
        while (s1position != 0) {
            s1rest.append(leftString.charAt(s1position - 1));
            s1position--;
        }
        while (s2position != 0) {
            s2rest.append(rightString.charAt(s2position - 1));
            s2position--;
        }        
        
        s1rest.reverse();
        s2rest.reverse();
        result.reverse();

        
        return new String[] {result.toString(), s1rest.toString(), s2rest.toString()};
    }    
    
    /**
     * Returns the total length of all common subsequences at least 2 characters
     * long, of the two source Strings.
     * @param leftString One of the two strings to compare.
     * @param rightString The other of the two strings to compare.
     * @return the total length of all common subsequences at least 2 characters
     * long, of the two source Strings.
     */
    public static int acsTotalLength(String leftString, String rightString) {
        String [] lcsParts = longestCommonSubsequence(leftString, rightString);
        String lcs = lcsParts[0];
        int tot = 0;
        if (lcs.length() > 1) {
            tot = lcs.length();
            tot += acsTotalLength(lcsParts[1], lcsParts[2]);
        }
        return tot;
    }
    
    public static void test(String leftValue, String rightValue) {

        System.out.println(MessageFormat.format("\"{0}\",\"{1}\",{2},{3},{4}, lcs:{5}, {6}, {7}",
                leftValue, rightValue, compare(leftValue, rightValue, true),
                compare(leftValue, rightValue, false),
                acsTotalLength(leftValue, rightValue),
                
                
                longestCommonSubsequence(leftValue, rightValue)[0],
                compareLcs(leftValue, rightValue, true),
                compareLcs(leftValue, rightValue, false)));
    }

    public static void main (String [] args) {

        System.out.println("Left,Right,Similarity (min),Similarity (max)Total Length");
        String leftValue = "leo tolstoy";
        String rightValue = "leo";

        
        String leftPart = leftValue.split(" ")[0];
        String rightPart = rightValue.split(" ")[0];
        System.out.println("left part: " + leftPart + " right part: " + rightPart);
        test(leftPart, rightPart);
        test("jack", "jack");
    }
}
