import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        try (Scanner sc = new Scanner(file)) {
            if (sc.hasNextLine()) {
                sc.nextLine(); // header
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;
                // split on commas that are not inside quotes
                // the regex contains backslashes and quotes, so they must be escaped
                String[] toks = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
                if (toks.length < 10) continue;
                String name = toks[1];
                int flights = parseFlights(toks[5]);
                String nationality = toks[9];
                people.add(new Person(name, flights, nationality));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dataset file not found: " + file.getPath());
            return;
        }

        System.out.println("Loaded " + people.size() + " person records from Epstein dataset.\n");

        // sort by flights descending
        people.sort((a, b) -> Integer.compare(b.getFlights(), a.getFlights()));

        // who had the most flights?
        if (!people.isEmpty()) {
            Person top = people.get(0);
            System.out.println("Person with most flights: " + top.getName() + " (" + top.getFlights() + " flights)");
        }

        // list all records sorted by flight count (top 10 for brevity)
        System.out.println("\nTop 10 individuals by flight count:");
        int limit = Math.min(10, people.size());
        for (int i = 0; i < limit; i++) {
            Person p = people.get(i);
            System.out.printf(" %2d. %-25s %4d flights\n", i+1, p.getName(), p.getFlights());
        }

        // who had over 100 flights?
        System.out.println("\nIndividuals with more than 100 flights:");
        boolean any = false;
        for (Person p : people) {
            if (p.getFlights() > 100) {
                System.out.printf(" - %s: %d flights\n", p.getName(), p.getFlights());
                any = true;
            } else {
                // list is sorted descending; once we hit 100 we can break
                break;
            }
        }
        if (!any) {
            System.out.println("  (none)");
        }

        // flights by nationality
        System.out.println("\nTotal flights by nationality:");
        Map<String, Integer> byNat = new java.util.HashMap<>();
        for (Person p : people) {
            String nat = p.getNationality();
            if (nat == null || nat.isEmpty()) nat = "Unknown";
            byNat.put(nat, byNat.getOrDefault(nat, 0) + p.getFlights());
        }
        // sort nationalities by total flights descending
        List<Map.Entry<String, Integer>> natList = new ArrayList<>(byNat.entrySet());
        natList.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for (Map.Entry<String, Integer> entry : natList) {
            System.out.printf(" %-15s : %d flights\n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nAnalysis complete.");
    }

    private static int parseFlights(String s) {
        if (s == null) return 0;
        String digits = s.replaceAll("[^0-9]", "");
        if (digits.isEmpty()) return 0;
        try {
            return Integer.parseInt(digits);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
