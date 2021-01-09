package com.demo.store;

public class StoreMain {
    public static void main(String[] args) {
        Movie movieCinemaParadise = new Movie("Cinema Paradiso", Movie.REGULAR);
        Movie movieTenet = new Movie("Tenet", Movie.NEW_RELEASE);
        Movie movieFrozen = new Movie("Frozen", Movie.CHILDREN);

        Rental rentalCinemaParadise = new Rental(movieCinemaParadise, 10);
        Rental rentalTenet = new Rental(movieTenet, 2);
        Rental rentalFrozen = new Rental(movieFrozen, 1);

        Customer aCustomer = new Customer("Mike");
        aCustomer.addRental(rentalTenet);
        aCustomer.addRental(rentalCinemaParadise);
        aCustomer.addRental(rentalFrozen);

        System.out.println(aCustomer.statement());
    }
}
