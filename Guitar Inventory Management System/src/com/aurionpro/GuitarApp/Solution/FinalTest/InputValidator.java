package com.aurionpro.GuitarApp.Solution.FinalTest;

import java.util.Scanner;

import com.aurionpro.GuitarApp.Solution.model.Builder;
import com.aurionpro.GuitarApp.Solution.model.Type;
import com.aurionpro.GuitarApp.Solution.model.Wood;

public class InputValidator {
    public static String readString(Scanner sc, String field) {
        System.out.print("Enter " + field + ": ");
        return sc.nextLine().trim();
    }

    public static String readOptionalString(Scanner sc, String field) {
        System.out.print("Enter " + field + " (or press Enter to skip): ");
        String input = sc.nextLine().trim();
        return input.isEmpty() ? null : input;
    }

    public static int readInt(Scanner sc, String field) {
        while (true) {
            try {
                System.out.print("Enter " + field + ": ");
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static double readDouble(Scanner sc, String field) {
        while (true) {
            try {
                System.out.print("Enter " + field + ": ");
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static Builder readBuilder(Scanner sc) {
        return readBuilder(sc, false);
    }

    public static Builder readBuilder(Scanner sc, boolean optional) {
        while (true) {
            System.out.print("Enter Builder" + (optional ? " (or press Enter to skip)" : "") + ": ");
            String input = sc.nextLine().trim().toUpperCase();
            if (input.isEmpty() && optional) return null;
            try {
                return Builder.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid builder. Try again.");
            }
        }
    }

    public static Type readType(Scanner sc) {
        return readType(sc, false);
    }

    public static Type readType(Scanner sc, boolean optional) {
        while (true) {
            System.out.print("Enter Type" + (optional ? " (or press Enter to skip)" : "") + ": ");
            String input = sc.nextLine().trim().toUpperCase();
            if (input.isEmpty() && optional) return null;
            try {
                return Type.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid type. Try again.");
            }
        }
    }

    public static Wood readWood(Scanner sc, String field) {
        return readWood(sc, field, false);
    }

    public static Wood readWood(Scanner sc, String field, boolean optional) {
        while (true) {
            System.out.print("Enter " + field + (optional ? " (or press Enter to skip)" : "") + ": ");
            String input = sc.nextLine().trim().toUpperCase();
            if (input.isEmpty() && optional) return null;
            try {
                return Wood.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid wood. Try again.");
            }
        }
    }
    
}
