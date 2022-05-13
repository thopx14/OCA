package main.java.polymorphie.aufgaben.bruteforce;

import java.util.Objects;

public abstract class Bruteforce {

    private Safe safe;
    private final Loggable logger;

    public Bruteforce( Safe safe, Loggable logger ) {
        this.safe = safe;
        this.logger = logger;
    }

    public abstract boolean bruteforce();

    public Safe getSafe() {
        return safe;
    }

    public Loggable getLogger() {
        return logger;
    }

    public void setSafe( Safe safe ) {
        this.safe = Objects.requireNonNull( safe );
    }
}
