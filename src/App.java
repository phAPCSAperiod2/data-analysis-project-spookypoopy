import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application for the data analysis mini‑project. Reads the cleaned
 * Epstein flight CSV and performs several analyses about flights taken by
 * individuals.
 */
public class App {

    public static void main(String[] args) {
        // always run the Epstein dataset analysis
        runEpsteinAnalysis();
    }


    /* --------------------------------------------------------------------- */
    /* epstein dataset helpers                                                */
    /* --------------------------------------------------------------------- */

    private static void runEpsteinAnalysis() {
        File file = new File("data/epstein-persons-2026-02-13_cleaned.csv");
        ArrayList<Person> people = new ArrayList<>();

        // Try to read the file
        try (Scanner sc = new Scanner(file)) {
            // Skip the header row
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
            
            // Read each person from the CSV file
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                
                // Split the line by commas
                String[] parts = line.split(",");
                if (parts.length < 10) continue;
                
                // Extract data from the correct columns
                String name = parts[1];
                int flights = parseFlights(parts[5]);
                String nationality = parts[9];
                
                // Create a new Person and add to our list
                people.add(new Person(name, flights, nationality));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dataset file not found: " + file.getPath());
            return;
        }

        System.out.println("Loaded " + people.size() + " person records from Epstein dataset.\n");

        // Sort by number of flights from highest to lowest
        sortByFlightsDescending(people);

        // Find and display the person with the most flights
        if (!people.isEmpty()) {
            Person top = people.get(0);
            System.out.println("Person with most flights: " + top.getName() + " (" + top.getFlights() + " flights)");
        }

        // Show the top 10 people by flight count
        System.out.println("\nTop 10 individuals by flight count:");
        int limit = Math.min(10, people.size());
        for (int i = 0; i < limit; i++) {
            Person p = people.get(i);
            System.out.println(" " + (i+1) + ". " + p.getName() + " - " + p.getFlights() + " flights");
        }

        // Count and display anyone with more than 100 flights
        System.out.println("\nIndividuals with more than 100 flights:");
        boolean found = false;
        for (Person p : people) {
            if (p.getFlights() > 100) {
                System.out.println(" - " + p.getName() + ": " + p.getFlights() + " flights");
                found = true;
            } else {
                // List is sorted by flights; once we go below 100, we can stop
                break;
            }
        }
        if (!found) {
            System.out.println("  (none)");
        }

        System.out.println("\nAnalysis complete.");
    }

    private static int parseFlights(String s) {
        // If the string is null or empty, return 0
        if (s == null || s.trim().isEmpty()) {
            return 0;
        }
        
        // Try to convert the string to a number
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            // If conversion fails, return 0
            return 0;
        }
    }

    private static void sortByFlightsDescending(ArrayList<Person> people) {
        // Bubble sort: compare each pair of adjacent people
        // Move the person with more flights toward the beginning
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = 0; j < people.size() - 1 - i; j++) {
                Person current = people.get(j);
                Person next = people.get(j + 1);
                
                // If current person has fewer flights than next,
                // swap them (to sort highest to lowest)
                if (current.getFlights() < next.getFlights()) {
                    people.set(j, next);
                    people.set(j + 1, current);
                }
            }
        }
    }
}
