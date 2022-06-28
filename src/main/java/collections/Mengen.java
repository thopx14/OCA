package main.java.collections;

import java.util.*;

public class Mengen {
    public static void main( String[] args ) {
        /*
         Ein Set ist eine Menge. In der Menge kann es ein Element nur einmal geben.

         * Ein HashSet schreibt vor, dass die 'equals()' und 'hashCode()' Methode überschrieben
           sein muss.

         * Ein TreeSet ist eine sortierte Menge der natürlichen Ordnung (Comparator!)

         * Ein LinkedHashSet ist ein HashSet, in dem die Reihenfolge des Einfügens erhalten bleibt.
           Hier wird aber über die hashCode() und equals() Methoden garantiert, dass kein Element
           zweimal vorkommt.
         */

        class MyContainer implements Comparable<MyContainer> {
            String name;

            public MyContainer( String name ) {
                this.name = name;
            }

            @Override
            public boolean equals( Object o ) {
                if ( this == o ) return true;
                if ( o == null || getClass() != o.getClass() ) return false;
                MyContainer that = ( MyContainer ) o;
                return Objects.equals( name, that.name );
            }

            @Override
            public int hashCode() {
                return Objects.hash( name );
            }

            @Override
            public String toString() {
                return "MyContainer{" +
                        "name='" + name + '\'' +
                        '}';
            }

            @Override
            public int compareTo( MyContainer o ) {
                return this.name.compareTo( o.name );
            }
        }
        Set<MyContainer> set1 = new HashSet<>();
        set1.add( new MyContainer( "Hallo" ) );
        set1.add( new MyContainer( "Hallo" ) );
        set1.add( new MyContainer( "Welt" ) );
        set1.add( new MyContainer( "asdasd" ) );
        set1.add( new MyContainer( "DDeerer" ) );
        set1.add( new MyContainer( "ijasfASD" ) );
        set1.add( new MyContainer( "pplojj" ) );
        set1.add( new MyContainer( "pplojjasdlkjaslkdj" ) );
        set1.add( new MyContainer( "pplojjasdlkjaslkdj89897987" ) );

        System.out.println( set1 ); // [MyContainer{name='Hallo'}, MyContainer{name='Welt'}]

        Set<Integer> numbers = new HashSet<>();
        numbers.addAll( Arrays.asList( 1, 1, 2, 2, 3, 3, 4, 4, 3, 5, 5 ) ); // Autoboxing!
        System.out.println( numbers ); //[1, 2, 3, 4, 5]

        if ( numbers.contains( 3 ) )
            System.out.println( "3 ist im Set enthalten!" );

        Set<MyContainer> treeSet = new TreeSet<>();
        treeSet.add( new MyContainer( "Huhu" ) ); // MyContainer ist nicht Comparable!!
        treeSet.add( new MyContainer( "Huhu" ) );
        System.out.println( treeSet ); // [MyContainer{name='Huhu'}]

        treeSet.addAll( Arrays.asList(
                new MyContainer( "Hans" ),
                new MyContainer( "Wolf" ),
                new MyContainer( "Barbara!" ) ) );

        System.out.println( treeSet ); // [MyContainer{name='Barbara!'}, MyContainer{name='Hans'}, MyContainer{name='Huhu'}, MyContainer{name='Wolf'}]

        Set<Integer> linkedHashSet = new LinkedHashSet<>( Arrays.asList( 1, 2, 2, 3, 4, 5, 6 ) );

        System.out.println( linkedHashSet ); // [1, 2, 3, 4, 5, 6]

        Iterator<MyContainer> it = set1.iterator();
        while ( it.hasNext() ) {
            System.out.println( it.next() );
        }
        /*
            Ausgabe nicht wie Reihenfolge beim Einfügen:
                MyContainer{name='Hallo'}
                MyContainer{name='pplojjasdlkjaslkdj'}
                MyContainer{name='asdasd'}
                MyContainer{name='ijasfASD'}
                MyContainer{name='pplojj'}
                MyContainer{name='pplojjasdlkjaslkdj89897987'}
                MyContainer{name='Welt'}
                MyContainer{name='DDeerer'}
         */

        for ( Integer c : linkedHashSet ) {
            System.out.print( c + " " ); // 1 2 3 4 5 6 --> Ausgabe wie beim Einfügen!
        }

        System.out.println();
        NavigableSet<Integer> nSet = new TreeSet<>();
        nSet.addAll( Arrays.asList( 3, 5, 6, 7, 1, 44, 22, 101, 100 ) );
        System.out.println( nSet ); // [1, 3, 5, 6, 7, 22, 44, 100, 101]

        /*
            ceiling() gibt das nächste größere Element zurück (oder
            das übergebene, falls vorhanden).
         */
        System.out.println( nSet.ceiling( 2 ) ); // 3
        System.out.println( nSet.ceiling( 3 ) ); // 3

        /*
            floor() gibt das nächste kleinere Element zurück (oder
            das übergebene, falls vorhanden)
         */
        System.out.println( nSet.floor( 21 ) ); // 7

        /*
            bei higher() und lower() funktioniert es ähnlich,
            allerdings muss das Element echt größer oder echt kleiner
            sein!
         */
        System.out.println( nSet.higher( 21 ) ); // 22
        System.out.println( nSet.lower( 21 ) ); // 7
        System.out.println( nSet.higher( 22 ) ); // 44
        System.out.println( nSet.lower( 7 ) ); // 6

    }

}
