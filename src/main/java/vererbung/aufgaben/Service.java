package main.java.vererbung.aufgaben;

import java.util.Objects;

public abstract class Service {

    private final String name;

    protected Service( String name ) {
        this.name = Objects.requireNonNull( name );
    }

    protected Service() {
        this.name = "Unbekannter Service";
    }

    public abstract String doSomething();

    public static Service createNewService( String service ) {
        switch ( service ) {
            case "Defrag":
                return new Defrag();
            case "Email":
                return new EmailsAbrufer();
        }
        return new Service() {
            @Override
            public String doSomething() {
                return "Ich bin ein unbekannter Service - was soll ich tun?!";
            }
        };
    }

    @Override
    public String toString() {
        return "Service " + this.name + ": " + doSomething();
    }

    public String getName() {
        return name;
    }
}
