package main.java.lambda.aufgaben.javatipp;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main( String[] args ) {

        ArrayList<JavaTipp> javaTipps = new ArrayList<>();

        String text1 = """
                Mit dem Schlüsselwort 'implements' kann eine Klasse ein Interface realisieren.
                """;
        String text2 = """
                Eine Klasse kann nur eine andere Klasse erweitern.
                """;

        String text3 = """
                Statische Methoden werden mit dem Klassennamen aufgerufen.
                """;

        String text4 = """
                Alle Attribute in einem neuen Objekt werden im Konstruktor initialisiert.
                """;

        String text5 = """
                Beim Überschreiben darf die Sichtbarkeit nicht verschärft werden.
                """;

        String text6 = """
                Alle Elemente in einem Interface sind immer 'public'.
                """;


        javaTipps.add( new JavaTipp( text1, new Topic( "Vererbung" ), new Topic( "Klassen" ), new Topic( "Interfaces" ) ) );
        javaTipps.add( new JavaTipp( text2, new Topic( "Vererbung" ), new Topic( "Klassen" ) ) );
        javaTipps.add( new JavaTipp( text3, new Topic( "Methoden" ), new Topic( "Klassen" ), new Topic( "static" ) ) );
        javaTipps.add( new JavaTipp( text4, new Topic( "Klassen" ), new Topic( "Konstruktoren" ), new Topic( "Attribute" ) ) );
        javaTipps.add( new JavaTipp( text5, new Topic( "Klassen" ), new Topic( "Methoden" ), new Topic( "Überschreiben" ) ) );
        javaTipps.add( new JavaTipp( text6, new Topic( "Interfaces" ), new Topic( "Sichtbarkeiten" ), new Topic( "Java 8" ) ) );


        System.out.println( "***** Contains 'implements'" );
        System.out.println( "============================" );
        searchTip2( javaTipps, tipp -> tipp.getText().contains( "implements" ), tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Has exact 2 topics" );
        System.out.println( "============================" );
        searchTip2( javaTipps, tipp -> tipp.getTopic().size() == 2, tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Contains 'kLaSse'" );
        System.out.println( "============================" );
        searchTip2( javaTipps, tipp -> tipp.getText().toLowerCase().contains( "kLaSse".toLowerCase() ), tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Contains topic 'Klassen'" );
        System.out.println( "============================" );
        searchTip2( javaTipps, tipp -> tipp.getTopic().toString().contains( "Klassen" ), tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Contains topic 'Klassen', but not 'Vererbung'" );
        System.out.println( "============================" );
        Predicate<JavaTipp> p1 = tipp -> tipp.getTopic().toString().contains( "Klassen" );
        Predicate<JavaTipp> p2 = tipp -> ! tipp.getTopic().toString().contains( "Vererbung" );
        searchTip2( javaTipps, p1.and( p2 ), tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Has exact 3 topics" );
        System.out.println( "============================" );
        searchTip2( javaTipps, tipp -> tipp.getTopic().size() == 3, tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Contains Text 'Konstruktor'" );
        System.out.println( "============================" );
        Predicate<JavaTipp> constructorPredicate = tipp -> {
            boolean foundText = tipp.getText().contains( "Konstruktor" );
            if ( ! foundText ) {
                for ( Topic topic : tipp.getTopic() ) {
                    if ( topic.getText().contains( "Konstruktor" ) ) {
                        foundText = true;
                        break;
                    }
                }
            }
            return foundText;
        };
        searchTip2( javaTipps, constructorPredicate, tipp -> System.out.println( tipp + "\n" ) );
        System.out.println( "***** Contains Text 'stat'" );
        System.out.println( "============================" );
        Predicate<JavaTipp> statPredicate = tipp -> {
            boolean foundText = tipp.getText().toLowerCase().contains( "stat" );
            if ( ! foundText ) {
                for ( Topic topic : tipp.getTopic() ) {
                    if ( topic.getText().toLowerCase().contains( "stat" ) ) {
                        foundText = true;
                        break;
                    }
                }
            }
            return foundText;
        };
        searchTip2( javaTipps, statPredicate, tipp -> System.out.println( tipp + "\n" ) );

    }

    static void searchTip2( ArrayList<JavaTipp> arr, Predicate<JavaTipp> toSearch, Consumer<JavaTipp> c ) {
        for ( JavaTipp javaTipp : arr ) {
            if ( toSearch.test( javaTipp ) )
                c.accept( javaTipp );
        }
    }
}
