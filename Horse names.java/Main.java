public class Main {
    public static void main(String[] args) {
        // Creating three different horse objects
        Horse horse1 = new Horse("Silver", 2018);
        Horse horse2 = new Horse("Midnight", 2021);
        Horse horse3 = new Horse("Biscuit", 2015);

        // Printing the details of each horse
        System.out.println("--- Horse Roster ---");
        System.out.println(horse1);
        System.out.println(horse2);
        System.out.println(horse3);
    }
}

class Horse {
    private String name;
    private int birthYear;

    public Horse(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Horse{name='" + name + "', birthYear=" + birthYear + "}";
    }
}