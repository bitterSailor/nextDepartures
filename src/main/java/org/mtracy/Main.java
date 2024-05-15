package org.mtracy;

import java.util.Scanner;

public class Main {
    // Asks for a stop ID and calls NextDeparturesUI
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Stop ID (place-WML-0177 for Natick Center)");
        NextDeparturesUI.stopDepartures(input.nextLine());
    }
}