import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MonthApp {
    public static void main(String[] args) {

        List<Month> monthList = Month.createMonthList();

        try (Scanner consola = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                showMenu();
                try {
                    exit = executeOption(consola, monthList);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                }
                System.out.println();
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
        =============================
        ** Month List **
        =============================
        1. List
        2. Insert "Agost"
        3. Convert to HashSet
        4. Exit
        =============================
        """);
        System.out.print("Choose an option: ");
    }

    private static boolean executeOption(Scanner consola, List<Month> monthList) {
        boolean exit = false;
        boolean found = false;

        try {
            int option = Integer.parseInt(consola.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.println("Month List (using for-each):");
                    if (monthList.isEmpty()) {
                        System.out.println("There are no months in the list.");
                    } else {
                        monthList.forEach(System.out::println);
                        System.out.println("\nMonth List (using classic for loop):");
                        for (int i = 0; i < monthList.size(); i++) {
                            System.out.println("Month at index " + i + ": " + monthList.get(i).getName());
                        }
                    }
                }
                case 2 -> {
                    for (Month month : monthList) {
                        if ("Agost".equals(month.getName())) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        monthList.add(7, new Month("Agost"));
                        // Mensaje claro si "Agost" fue agregado
                        System.out.println("\"Agost\" has been added in its correct position.");
                    } else {
                        System.out.println("\"Agost\" is already in the list.");
                    }
                }
                case 3 -> {
                    HashSet<Month> monthHashSet = new HashSet<>(monthList);
                    System.out.println("HashSet created. Duplicates removed if any.");
                    System.out.println("HashSet content:");
                    monthHashSet.forEach(System.out::println);

                    System.out.println("\nTraversing HashSet using Iterator:");
                    Iterator<Month> iterator = monthHashSet.iterator();
                    while (iterator.hasNext()) {
                        Month month = iterator.next();
                        System.out.println(month.getName());
                    }
                }
                case 4 -> {
                    System.out.println("See you soon!");
                    exit = true;
                }
                default -> {
                    System.out.println("Option not recognized. Please choose a valid option from the menu.");
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input: Please enter a valid numeric option.");
        }

        return exit;
    }
}
