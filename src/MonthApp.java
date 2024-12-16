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
                    int option = Integer.parseInt(consola.nextLine());
                    exit = executeOption(option, monthList);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
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

    private static boolean executeOption(int option, List<Month> monthList) {
        switch (option) {
            case 1 -> listMonths(monthList);
            case 2 -> insertAugust(monthList);
            case 3 -> convertToHashSet(monthList);
            case 4 -> {
                System.out.println("See you soon!");
                return true;
            }
            default -> System.out.println("Option not recognized. Please choose a valid option from the menu.");
        }
        return false;
    }

    private static void listMonths(List<Month> monthList) {
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

    private static void insertAugust(List<Month> monthList) {
        boolean found = monthList.stream().anyMatch(month -> "Agost".equals(month.getName()));
        if (!found) {
            monthList.add(7, new Month("Agost"));
            System.out.println("\"Agost\" has been added in its correct position.");
        } else {
            System.out.println("\"Agost\" is already in the list.");
        }
    }

    private static void convertToHashSet(List<Month> monthList) {
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
}
