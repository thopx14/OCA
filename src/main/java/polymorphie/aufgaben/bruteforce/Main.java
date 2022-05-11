package main.java.polymorphie.aufgaben.bruteforce;

public class Main {
    public static void main( String[] args ) {
        char[] pw1 = {
                'a', 'b', 'c', 'd'
        };

        char[] pw2 = {
                'b', 'a', 'c', 'd'
        };

        char[] pw3 = {
                'a', 'b', 'd', 'c'
        };

        char[] pw4 = {
                '1', '2', '3', '4'
        };

        Safe safe1 = new Safe( pw1 );
        Safe safe2 = new Safe( pw2 );
        Safe safe3 = new Safe( pw3 );
        SimpleBruteForce simpleBruteForce = new SimpleBruteForce( safe1, new ConsoleLogger() );
        if ( simpleBruteForce.bruteforce() ) {
            System.out.println( "Found password!" );
        }
        simpleBruteForce.setSafe( safe2 );
        if ( simpleBruteForce.bruteforce() ) {
            System.out.println( "Found password!" );
        }

        simpleBruteForce.setSafe( safe3 );
        if ( simpleBruteForce.bruteforce() ) {
            System.out.println( "Found password!" );
        }

        BruteforceHeap heapAttack = new BruteforceHeap( safe1, new ConsoleLogger() );
        if ( heapAttack.bruteforce() ) {
            System.out.println( "Found password!" );
        }
        heapAttack.setSafe( safe2 );
        if ( heapAttack.bruteforce() ) {
            System.out.println( "Found password!" );
        }
        heapAttack.setSafe( safe3 );
        if ( heapAttack.bruteforce() ) {
            System.out.println( "Found password!" );
        }

        BruteForceDictionary dic = new BruteForceDictionary( safe1, new ConsoleLogger() );
        if ( dic.bruteforce() ) {
            System.out.println( "Found password!" );
        }

        Safe s4 = new Safe( pw4 );
        dic.setSafe( s4 );

        if ( dic.bruteforce() ) {
            System.out.println( "Found password!" );
        }
    }
}
