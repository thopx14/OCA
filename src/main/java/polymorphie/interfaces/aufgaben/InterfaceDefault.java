package main.java.polymorphie.interfaces.aufgaben;

import java.util.ArrayList;

interface Sum {

    default int add( int a, int b ) {
        return a + b;
    }
}

interface Container {

    /*
     * Speichert x im Container.
     * Liefert die neue Containergröße zurück.
     */
    int add( int x );


    /*
     * Überladen.
     * Speichert im Container x, danach y.
     * Liefert die neue Containergröße zurück.
     */
    //A2.
    default int add( int x, int y ) {
        // UnsupportedOperationException ist eine RuntimeException und muss somit nicht mit
        // 'throws' geworden werden.
        throw new UnsupportedOperationException( "This method has not been implemented!" );
    }
}

class MyContainer implements Sum, Container {

    // Wird im Standardkonstruktor initialisiert mit 'null'
    ArrayList<Integer> list;

    /*
    // Compiler generiert wie folgt:
    public TestClass() {
        list = null;
    }
    */

    public MyContainer() {
        list = new ArrayList<>();
    }

    @Override
    public int add( int x ) {
        list.add( x );
        return list.size();
    }

    @Override
    public int add( int x, int y ) {
        list.add( x );
        list.add( y );
        return list.size();
    }
}

class MyContainer2 implements Container, Sum {

    private final ArrayList<Integer> list;

    public MyContainer2() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add( int x ) {
        list.add( x );
        return list.size();
    }

    @Override
    public int add( int x, int y ) {
        return Sum.super.add( x, y );
    }
}

class MyContainer3 implements Container, Sum {

    private final ArrayList<Integer> list;

    public MyContainer3() {
        this.list = new ArrayList<>();
    }

    @Override
    public int add( int x ) {
        list.add( x );
        return list.size();
    }

    @Override
    public int add( int x, int y ) {
        return Container.super.add( x, y );
    }
}

public class InterfaceDefault {

    public static void main( String[] args ) {
        //A1.
        Sum s1 = new Sum() {
            @Override
            public int add( int a, int b ) {
                return Sum.super.add( a, b );
            }
        };
        System.out.println( s1.add( 1, 2 ) );

        //A3.
        Container c1 = new MyContainer();
        System.out.println( c1.add( 12 ) );
        System.out.println( c1.add( 13, 14 ) );
        Sum c2 = new MyContainer();
        System.out.println( c2.add( 2, 2 ) );

        MyContainer2 c3 = new MyContainer2();
        System.out.println( c3.add( 33 ) );
        System.out.println( c3.add( 5, 5 ) );

        MyContainer3 c4 = new MyContainer3();
        System.out.println( c4.add( 33 ) );
        /*
        Exception in thread "main" java.lang.UnsupportedOperationException: This method has not been implemented!
            at main.java.polymorphie.interfaces.aufgaben.Container.add(InterfaceDefault.java:30)
            at main.java.polymorphie.interfaces.aufgaben.MyContainer3.add(InterfaceDefault.java:98)
            at main.java.polymorphie.interfaces.aufgaben.InterfaceDefault.main(InterfaceDefault.java:127)
         */
        System.out.println( c4.add( 5, 5 ) );

    }

}
