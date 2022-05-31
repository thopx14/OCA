package main.java.nested;

public class NestedNonStatic {
    class MyNestedNonStatic {
        String name;

        public MyNestedNonStatic( String name ) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyNestedNonStatic{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main( String[] args ) {
        // Mit diesen Aufrufen lassen sich innere Klassen erzeugen.
        NestedNonStatic.MyNestedNonStatic nestedNonStatic = new NestedNonStatic().new MyNestedNonStatic( "Test" );
        Test.InnerTest innerTest = new Test( "Test" ).new InnerTest( "InnerTest" );

        System.out.println( innerTest );
    }
}

class Test {
    String name;

    public Test( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }

    class InnerTest {
        String name;

        public InnerTest( String name ) {
            this.name = name;
        }

        @Override
        public String toString() {
            // Jede innere Klasse speichert intern eine Referenz auf die umschließende Klasse.
            return Test.this.toString() +
                    "InnerTest{" +
                    "name='" +
                    name +
                    "'}";
        }
    }
}
