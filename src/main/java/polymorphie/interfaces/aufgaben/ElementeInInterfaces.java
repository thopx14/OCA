package main.java.polymorphie.interfaces.aufgaben;

public interface ElementeInInterfaces {
    /*
    abstrakte Instanz methoden
     */
    public abstract void m1();

    abstract void m2();                 // implizit public abstract

    void m3();                          // implizit public abstract
//    private void m4();                // cf: darf nur public sein
//    void md() {}                      // cf: darf keine Implementierung geben

    // So geht's. Hier kann die Methode überschrieben werden, muss aber nicht.
    default void md2() {
        m1();
        m2();
    }

    // Implizit public!
    public default void md3() {
        m1();
        m2();
    }

    /*
    Statische Methoden
     */
    public static void m5() {
        System.out.println( "m5" );
    }

    // implizit public
    static void m6() {
        System.out.println( "m6" );
    }

    /*
    statische Konstanten
     */
//    public static final int K1;       // cf: Muss explizit instantiiert werden
    public static final int K2 = 1;     // public static final ist implizit
    int K3 = 5;                         // automatisch public static final
}
