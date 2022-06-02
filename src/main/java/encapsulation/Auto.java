package main.java.encapsulation;

import java.time.LocalDate;

public class Auto {
    private String manufacturer;
    public String shortName;
    protected String model;
    /* default, package visible */ final LocalDate dateOfManufacturing = LocalDate.now();

    void testAccess() {
        System.out.println( manufacturer );
        System.out.println( shortName );
        System.out.println( model );
        System.out.println( dateOfManufacturing );
    }

}
