package main.java.nested;

public class LocalInnerTypes {

    public static void main( String[] args ) {
        Animal mouse = new Animal( "Maus" );
        Animal katze = new Animal( "Katze" );

        AnimalPrinter animalPrinter = mouse.printAnimal();
        System.out.println( animalPrinter.printName() );
    }
}

interface AnimalPrinter {
    String printName();
}

class Animal {
    String name;

    public Animal( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public AnimalPrinter printAnimal() {
        class AnimalPrinterImpl implements AnimalPrinter {

            public String printName() {
                return Animal.this.name;
            }
        }
        return new AnimalPrinterImpl();
    }
}
