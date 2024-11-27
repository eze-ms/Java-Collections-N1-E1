import java.util.ArrayList;
import java.util.List;

public class Month {
    private final int id;
    private String name;
    private static int numberMonth = 0;


    public Month() {
        this.id = ++Month.numberMonth;
    }


    public Month(String name) {
        this();
        this.name = name;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }



    public static List<Month> createMonthList() {
        List<Month> months = new ArrayList<>();
        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));
        return months;
    }
}
