package main.java.vererbung.aufgaben;


public class KleineAufgabeVererbung {

    public static void main( String[] args ) {

        Service service = new Defrag();

        System.out.println( service.getName() );

        service = new EmailsAbrufer();

        System.out.println( service.getName() );

//        Service service2 = new Service( "Huhu" ); // Abstrakte Methoden können nicht direkt instanziiert werden.
//        System.out.println( service2 );

        service.doSomething();

        service = new Defrag();

        service.doSomething();

        Service newService = Service.createNewService( "Email" );
        Service newService2 = Service.createNewService( "defrag" );
        System.out.println( newService );
        System.out.println( newService2 );

    }

}
