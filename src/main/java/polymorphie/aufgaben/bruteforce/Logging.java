package main.java.polymorphie.aufgaben.bruteforce;

public abstract class Logging {
    
    private final String loggerName;

    public Logging( String name ) {
        this.loggerName = name;
    }

    public abstract void log( Object loggingClass, String... texts );

    public String getLoggerName() {
        return loggerName;
    }
}
