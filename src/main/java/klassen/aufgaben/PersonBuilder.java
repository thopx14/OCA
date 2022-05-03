package main.java.klassen.aufgaben;

import java.util.Objects;

public class PersonBuilder {

    private final Person person;

    public PersonBuilder( Person p ) {

        this.person = p;
    }

    public PersonBuilder() {

        this.person = new Person();
    }

    public PersonBuilder prename( String prename ) {
        this.person.setPrename( Objects.requireNonNull( prename ) );
        return this;
    }

    public PersonBuilder surname( String surename ) {
        this.person.setSurname( Objects.requireNonNull( surename ) );
        return this;
    }

    public PersonBuilder yearOfBirth( int yob ) {
        this.person.setYearOfBirth( Math.max( yob, 0 ) );
        return this;
    }

    public PersonBuilder zipCode( int zip ) {
        this.person.setZipCode( Math.max( zip, 0 ) );
        return this;
    }

    /*
    Returns the actual Person object!
     */
    public Person build() {
        return this.person;
    }
}
