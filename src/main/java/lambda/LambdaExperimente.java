package main.java.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExperimente {
    
    public static void main( String[] args ) {
        ArrayList<Person> people = new ArrayList<>();
        people.add( new Person( "Tom" ) );
        people.add( new Person( "Jerry" ) );
        people.add( new Person( "Max" ) );

//        people.removeIf( p -> p.getName().length() == 3 );
        List<Person> newList = new ArrayList<>();
        /*
            Konventionell:
         */
//        people.forEach( new Consumer<Person>() {
//            @Override
//            public void accept( Person person ) {
//                if ( person.name().length() == 3 ) {
//                    newList.add( person );
//                }
//            }
//        } );

        /*
            Mit Lambda:
         */
        // public void accept( Person person )
        people.forEach( p -> {
            if ( p.name().length() == 3 )
                newList.add( p );
        } );
        System.out.println( newList );

        // Kompakte Schreibweise, ohne return.
        TestLambdaInterface t1 = () -> 122;
    }
}

@FunctionalInterface
interface TestLambdaInterface {
    int test();
}

record Person(String name) {

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
