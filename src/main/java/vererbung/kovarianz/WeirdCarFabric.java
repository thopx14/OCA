package main.java.vererbung.kovarianz;

public class WeirdCarFabric extends AbstractFabric {

    /*
        Compiliert nicht! Car <- IS-A <- Object !!! NOT TRUE !!!
        Siehe Kovarianz_AbstractFabric.uxf

        @Override
        Object create() {
            return null;
        }
     */


    @Override
    Car create() {
        return null;
    }


}
