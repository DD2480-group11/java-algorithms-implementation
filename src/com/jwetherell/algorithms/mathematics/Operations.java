package com.jwetherell.algorithms.mathematics;

import java.math.BigDecimal;
import java.math.BigInteger;


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