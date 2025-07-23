package com.aurionpro.GuitarApp.Solution.FinalTest;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import com.aurionpro.GuitarApp.Solution.model.Guitar;
import com.aurionpro.GuitarApp.Solution.model.GuitarSpecs;

public class GuitarPrinter {

    public static void printGuitars(List<Guitar> guitars) {
        if (guitars == null || guitars.isEmpty()) {
            System.out.println("\nNo guitars found matching your criteria.\n");
            return;
        }

        System.out.println("\nMatching Guitars:\n");

        printTopBorder();
        printHeader();
        printMidBorder();

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        for (Guitar guitar : guitars) {
            GuitarSpecs spec = guitar.getSpecs();
            System.out.printf("│ %-10s │ %-10s │ %-10s │ %-15s │ %-10s │ %-10s │ %-10s │%n",
                    guitar.getSerialNumber(),
                    nf.format(guitar.getPrice()),
                    spec.getBuilder().toString().toLowerCase(),
                    spec.getModel(),
                    spec.getType().toString().toLowerCase(),
                    spec.getBackwood().toString().toLowerCase(),
                    spec.getTopwood().toString().toLowerCase());
        }

        printBottomBorder();
    }

    private static void printTopBorder() {
        System.out.println("┌────────────┬────────────┬────────────┬─────────────────┬────────────┬────────────┬────────────┐");
    }

    private static void printHeader() {
        System.out.printf("│ %-10s │ %-10s │ %-10s │ %-15s │ %-10s │ %-10s │ %-10s │%n",
                "Serial No", "Price", "Builder", "Model", "Type", "BackWood", "TopWood");
    }

    private static void printMidBorder() {
        System.out.println("├────────────┼────────────┼────────────┼─────────────────┼────────────┼────────────┼────────────┤");
    }

    private static void printBottomBorder() {
        System.out.println("└────────────┴────────────┴────────────┴─────────────────┴────────────┴────────────┴────────────┘");
    }
}
