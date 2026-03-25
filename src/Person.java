/**
 * Simple representation of an individual from the Epstein flight dataset.
 * Only the fields relevant to the analysis (name, number of flights,
 * nationality) are stored.
 */
public class Person {
    private String name;
    private int flights;
    private String nationality;

    public Person(String name, int flights, String nationality) {
        this.name = name;
        this.flights = flights;
        this.nationality = nationality;
    }

    public String getName() { return name; }
    public int getFlights() { return flights; }
    public String getNationality() { return nationality; }

    public String toString() {
        String nat = nationality;
        if (nat == null) {
            nat = "Unknown";
        }
        return name + " (" + flights + " flights, " + nat + ")";
    }
}
