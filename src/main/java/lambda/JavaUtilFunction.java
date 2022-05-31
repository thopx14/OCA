package main.java.lambda;

import java.util.function.BiFunction;

public class JavaUtilFunction {
    public static void main( String[] args ) {

        Calculator c = new Calculator( 1, 2 );
        int i1 = c.operate( Calculator.ADDITION );
        int i2 = c.operate( Calculator.DIVISION );
        int i3 = c.operate( Calculator.SUBTRACT );

        System.out.println( i1 );
        System.out.println( i2 );
        System.out.println( i3 );

    }
}

class Calculator {

    int a;
    int b;
    // R    apply(T t)
//    final BiFunction<Integer, Integer, Integer> addition = ( a, b ) -> a + b;
    public static final BiFunction<Integer, Integer, Integer> ADDITION = Integer::sum;
    public static final BiFunction<Integer, Integer, Integer> DIVISION = ( a, b ) -> a / b;
    public static final BiFunction<Integer, Integer, Integer> SUBTRACT = ( a, b ) -> a - b;

    public Calculator( int a, int b ) {
        this.a = a;
        this.b = b;
    }

    public Integer operate( BiFunction<Integer, Integer, Integer> c ) {
        return c.apply( a, b );
    }
}

