package com.jwetherell.algorithms.mathematics;

import java.math.BigDecimal;
import java.math.BigInteger;


/*

 public int compare(T o1, T o2) {
            int result = 0;
            if (o1 instanceof BigDecimal || o2 instanceof BigDecimal) {
                BigDecimal c1 = (BigDecimal)o1;
                BigDecimal c2 = (BigDecimal)o2;
                result = c1.compareTo(c2);
            } else if (o1 instanceof BigInteger || o2 instanceof BigInteger) {
                BigInteger c1 = (BigInteger)o1;
                BigInteger c2 = (BigInteger)o2;
                result = c1.compareTo(c2);
            } else if (o1 instanceof Long || o2 instanceof Long) {
                Long c1 = o1.longValue();
                Long c2 = o2.longValue();
                result = c1.compareTo(c2);
            } else if (o1 instanceof Double || o2 instanceof Double) {
                Double c1 = o1.doubleValue();
                Double c2 = o2.doubleValue();
                result = c1.compareTo(c2);
            } else if (o1 instanceof Float || o2 instanceof Float) {
                Float c1 = o1.floatValue();
                Float c2 = o2.floatValue();
                result = c1.compareTo(c2);
            } else {
                Integer c1 = o1.intValue();
                Integer c2 = o2.intValue();
                result = c1.compareTo(c2);
            }
            return result;
        }
*/
public class Operations{
    public static int compare(Number a, Number b){
        if (a instanceof BigDecimal || b instanceof BigDecimal){
            return ((BigDecimal)a).compareTo((BigDecimal)b);
        }    
        else if (a instanceof BigInteger || b instanceof BigInteger){
            return ((BigInteger)a).compareTo((BigInteger)b);
        } 
        else if (a instanceof Long || b instanceof Long){
            return ((Long)a).compareTo((Long)b);
        }   
        else if (a instanceof Double || b instanceof Double){
            return ((Double)a).compareTo((Double)b);
        }   
        else if (a instanceof Float || b instanceof Float){
            return ((Float)a).compareTo((Float)b);
        }
        else{
            return ((Integer)a).compareTo((Integer)b);
        }
    }
}