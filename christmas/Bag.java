package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return this.color;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        Present heaviest = null;

        for (Present present : data) {
            if (heaviest == null || heaviest.getWeight() < present.getWeight()) {
                heaviest = present;
            }
        }
        return heaviest;

    }

    public Present getPresent(String name) {
        Present currentPresent = null;

        for (Present present : data) {
            if (currentPresent == null || currentPresent.getName().equals(name)) {
                currentPresent = present;
            }
        }
        return currentPresent;
    }

    public String report() {
        StringBuilder result = new StringBuilder(String.format("%s bag contains:",this.color))
                .append(System.lineSeparator());
        for (Present present : data) {
            result.append(present).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

}
