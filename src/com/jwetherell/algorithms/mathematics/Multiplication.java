package com.jwetherell.algorithms.mathematics;

import java.util.ArrayList;
import java.util.Collections;

import com.jwetherell.algorithms.numbers.Complex;

public class Multiplication {

    static boolean[] reachedBranch = new boolean[200];
     private static void BRANCH(int index, String name) {
         if (!reachedBranch[index]) {
             reachedBranch[index] = true;
             System.out.println("--------------");
             System.out.println("Multiplication." + name + "\n");
             for (int i = 0; i < reachedBranch.length; i++) {
                 if (reachedBranch[i]) {
                     System.out.println("REACHED BRANCH #" + i);
                 }
             }
         }
     }
    public static final long multiplication(int a, int b) {
        long result = ((long) a) * ((long) b);
        return result;
    }

    public static final long multiplyUsingLoop(int a, int b) {
        int absB = Math.abs(b);
        long result = a;
        for (int i = 1; i < absB; i++) {
            result += a;
        }
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingRecursion(int a, int b) {
        int absB = Math.abs(b);
        long result = a;
        if (absB == 1)
            return result;

        result += multiplyUsingRecursion(a, absB - 1);
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingShift(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        long result = 0L;
        while (absA > 0) {
            if ((absA & 1) > 0)
                result += absB; // Is odd
            absA >>= 1;
            absB <<= 1;
        }

        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static final long multiplyUsingLogs(int a, int b) {
        long absA = Math.abs(a);
        long absB = Math.abs(b);
        long result = Math.round(Math.pow(10, (Math.log10(absA) + Math.log10(absB))));
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static String multiplyUsingFFT(String a, String b) {
        String name = "multiplyUsingFFT";
        if (a.equals("0") || b.equals("0")) {
            BRANCH(1,name);
            return "0";
        }else{
            BRANCH(2,name);
        }
        boolean negative = false;
        if ((a.charAt(0) == '-' && b.charAt(0) != '-') || (a.charAt(0) != '-' && b.charAt(0) == '-')) {
            BRANCH(3,name);
            negative = true;
        }else{
            BRANCH(4,name);
        }
        if (a.charAt(0) == '-') {
            BRANCH(5,name);
            a = a.substring(1);
        }else{
            BRANCH(6,name);
        }
        if (b.charAt(0) == '-') {
            BRANCH(7,name);
            b = b.substring(1);
        }else{
            BRANCH(8,name);
        }
        int size = 1;
        while (size < (a.length() + b.length())) {
            BRANCH(9,name);
            size *= 2;
        }
        Complex[] aCoefficients = new Complex[size];
        Complex[] bCoefficients = new Complex[size];
        for (int i = 0; i < size; i++) {
            BRANCH(10,name);
            aCoefficients[i] = new Complex();
            bCoefficients[i] = new Complex();
        }
        for (int i = 0; i < a.length(); i++) {
            BRANCH(11,name);
            aCoefficients[i] = new Complex((double) (Character.getNumericValue(a.charAt(a.length() - i - 1))), 0.0);
        }
        for (int i = 0; i < b.length(); i++) {
            BRANCH(12,name);
            bCoefficients[i] = new Complex((double) (Character.getNumericValue(b.charAt(b.length() - i - 1))), 0.0);
        }

        FastFourierTransform.cooleyTukeyFFT(aCoefficients);
        FastFourierTransform.cooleyTukeyFFT(bCoefficients);

        for (int i = 0; i < size; i++) {
            BRANCH(13,name);
            aCoefficients[i] = aCoefficients[i].multiply(bCoefficients[i]);
        }
        for (int i = 0; i < size / 2; i++) {
            BRANCH(14,name);
            Complex temp = aCoefficients[i];
            aCoefficients[i] = aCoefficients[size - i - 1];
            aCoefficients[size - i - 1] = temp;
        }
        FastFourierTransform.cooleyTukeyFFT(aCoefficients);

        ArrayList<Integer> res = new ArrayList<Integer>();
        int pass = 0;
        for (int i = 0; i < size; i++) {
            BRANCH(15,name);
            res.add((int) (pass + Math.floor((aCoefficients[i].abs() + 1) / size)));
            if (res.get(i) >= 10) {
                BRANCH(16,name);
                pass = res.get(i) / 10;
                res.set(i, res.get(i) % 10);
            } else {
                BRANCH(17,name);
                pass = 0;
            }
        }
        Collections.reverse(res);
        StringBuilder result = new StringBuilder();
        if (negative) {
            BRANCH(18,name);
            result.append('-');
        }else{
            BRANCH(19,name);
        }
        boolean startPrinting = false;
        for (Integer x : res) {
            BRANCH(20,name);
            if (x != 0) {
                BRANCH(21,name);
                startPrinting = true;
            }else{
                BRANCH(22,name);
            }
            if (startPrinting) {
                BRANCH(23,name);
                result.append(x);
            }else{
                BRANCH(24,name);
            }
        }
        return result.toString();
    }

    public static String multiplyUsingLoopWithStringInput(String a, String b) {
        String name = "multiplyUsingLoopWithStringInput";
        int k,i,j,carry=0,rem,flag=0,lim1,lim2,mul;

        boolean aIsNegative = false;
        ArrayList<Integer> first = new ArrayList<Integer>();
        for (char n : a.toCharArray()){
            BRANCH(1+100,name);
            if (n=='-') {
                BRANCH(2+100,name+"broken");
                aIsNegative = true;
                continue;
            }else{
                BRANCH(3+100,name);
            }
            first.add(n-'0');
        }

        boolean bIsNegative = false;
        ArrayList<Integer> second = new ArrayList<Integer>();
        for (char n : b.toCharArray()){
            BRANCH(4+100,name);
            if (n=='-') {
                BRANCH(5+100,name);
                bIsNegative = true;
                continue;
            }else{
                BRANCH(6+100,name);
            }
            second.add(n-'0');
        }

        lim1=first.size()-1;
        lim2=second.size()-1;

        ArrayList<Integer> res = new ArrayList<Integer>(Collections.nCopies(first.size()+second.size(), 0));
        for (i=0;i<=lim1;i++) {
            BRANCH(7+100,name);
            k=i;
            for (j=0;j<=lim2;j++) {
                BRANCH(8+100,name);
                int f = first.get(i);
                int s = second.get(j);
                mul=f*s;
                res.set(k,res.get(k)+(mul/10));
                k++;
                res.set(k,res.get(k)+(mul%10));
            }
        }

        for (i=(lim1+lim2)+1;i>=0;i--) {
            BRANCH(9+100,name);
            if (flag==1){
                BRANCH(10+100,name);
                res.set(i,res.get(i)+carry);
                flag=0;
            }else{
                BRANCH(11+100,name);
            }

            if (res.get(i)>=10 && i!=0) {
                BRANCH(12+100, name);
                rem=res.get(i)%10;
                carry=res.get(i)/10;
                res.set(i,rem);
                flag++;
            }else{
                BRANCH(13+100,name);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (aIsNegative ^ bIsNegative){
            BRANCH(14+100,name);
            sb.append('-');
        }else{
            BRANCH(15+100,name);
        }

        boolean zeroCheck = true;
        for (Integer s : res) {
            BRANCH(16+100,name);
            if (zeroCheck && s.equals(0)){
                BRANCH(17,name);
                continue;
            }else{
                BRANCH(18+100,name);
            }

            zeroCheck = false;
            sb.append(s);
        }
        return sb.toString();
    }

    public static int multiplyUsingLoopWithIntegerInput(int a, int b) {
        boolean aIsNegative = a<0;
        boolean bIsNegative = b<0;
        a = Math.abs(a);
        b = Math.abs(b);

        // Find the largest multiple of ten which is larger than 'a'
        int largerMultipleA=1;
        int numberOfDigitsInA=0;
        while (largerMultipleA<a){
            largerMultipleA *= 10;
            numberOfDigitsInA++;
        }

        // Find the largest multiple of ten which is larger than 'b'
        int largerMultipleB = 1;
        int numberOfDigitsInB=0;
        while (largerMultipleB<b){
            largerMultipleB *= 10;
            numberOfDigitsInB++;
        }

        // Store the results
        int[] res = new int[numberOfDigitsInA+numberOfDigitsInB];

        // Reduce the digits to the first digit on the left
        largerMultipleA /= 10;
        numberOfDigitsInA--;
        largerMultipleB /= 10;
        numberOfDigitsInB--;

        // Store original 'q' and 'b', to reset
        int originalMultipleB = largerMultipleB;
        int originalB = b;

        int carry=0,rem,flag=0,mul;
        for (int i=numberOfDigitsInA; i>=0; i--) {
            int k=numberOfDigitsInA-i;
            // reset
            largerMultipleB = originalMultipleB;
            b = originalB;
            for (int j=numberOfDigitsInB; j>=0; j--) {
                int f = a/largerMultipleA;
                int s = b/largerMultipleB;

                b %= largerMultipleB;
                largerMultipleB /= 10;

                mul=f*s;
                res[k] = res[k]+(mul/10);
                k++;
                res[k] = res[k]+(mul%10);
            }
            a %= largerMultipleA;
            largerMultipleA /= 10;
        }

        for (int i=(numberOfDigitsInA+numberOfDigitsInB)+1; i>=0; i--) {
            if (flag==1){
                res[i] = res[i]+carry;
                flag=0;
            }

            if (res[i] >=10 && i!=0) {
                rem = res[i]%10;
                carry = res[i] /10;
                res[i] = rem;
                flag++;
            }
        }

        int result = 0;
        int m = 1;
        for (int idx=res.length-1; idx>=0; idx--) {
            int s = res[idx];
            result += s*m;
            m *= 10;
        }
        // adjust for negatives
        if (aIsNegative ^ bIsNegative)
            result *= -1;
        return result;
    }
}
