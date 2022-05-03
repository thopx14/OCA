package main.java.klassen.aufgaben;

import java.util.Objects;

public class Person {

    private String prename;
    private String surname;
    private int yearOfBirth;
    private int zipCode;

    /*
    This constructor takes all arguments.
     */
    public Person( String prename, String surname, int yearOfBirth, int zipCode ) {
        this.prename = prename;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.zipCode = zipCode;
    }

    /*
    Create non-arg constructor that initialize all private fields with empty standard values.
     */
    public Person() {
        this( "", "", 0, 0 );
    }

    /*
    Setter
     */

    public void setPrename( String prename ) {

        this.prename = Objects.requireNonNull( prename );
    }

    public void setSurname( String surname ) {

        this.surname = Objects.requireNonNull( surname );
    }

    public void setYearOfBirth( int yob ) {

        this.yearOfBirth = Math.max( yob, 0 );
    }

    public void setZipCode( int zip ) {

        this.zipCode = Math.max( zip, 0 );
    }

    @Override
    public boolean equals( Object o ) {
        boolean isEqual = false;
        if ( o instanceof Person p ) {
            return Objects.equals( p.surname, this.surname ) &&
                    Objects.equals( p.prename, this.prename ) &&
                    p.yearOfBirth == this.yearOfBirth &&
                    p.zipCode == this.zipCode;
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return this.prename + " " + this.surname + ", Geburtsjahr: " + this.yearOfBirth + ", Plz: " + this.zipCode;
    }

    public static Person getMustermann() {

        return new Person( "Max", "Mustermann", 1960, 12345 );
    }

    public static void main( String[] args ) {
        Person p1 = new Person( "Hans", "Dampf", 1967, 12345 );
        System.out.println( p1 );
        System.out.println( Person.getMustermann() );

        Person p2 = new PersonBuilder().prename( "John" )
                .surname( "Doe" )
                .yearOfBirth( 1987 )
                .zipCode( 12345 )
                .build();
        System.out.println( p2 );
    }
}
