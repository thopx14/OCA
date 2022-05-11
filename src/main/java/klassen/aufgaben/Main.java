package main.java.klassen.aufgaben;

public class Main {

    public static void main( String[] args ) {
        Person p1 = new Person( "Hans", "Dampf", 1967, 12345, Gender.MALE );
        System.out.println( p1 );
        System.out.println( Person.getMustermann() );

        Person p2 = new PersonBuilder().prename( "John" )
                .surname( "Doe" )
                .yearOfBirth( 1987 )
                .zipCode( 12345 )
                .gender( Gender.DIVERS )
                .build();
        System.out.println( p2 );

        Person p3 = new Person();
        System.out.println( p3.getSurname() );
        System.out.println( p3.getYearOfBirth() );
        System.out.println( p3.getGender() );
    }
}
