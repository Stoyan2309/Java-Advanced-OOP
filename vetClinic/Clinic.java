package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {

    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {

        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet result = null;

        for (Pet pet : data) {
            if (result == null || pet.getAge() > result.getAge()) {
                result = pet;
            }
        }
        return result;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        out.append("The clinic has the following patients:");
        out.append(System.lineSeparator());
        for (Pet pet : data) {
            out.append(pet.getName()).append(" ");
            out.append(pet.getOwner());
            out.append(System.lineSeparator());
        }
        return out.toString().trim();
    }

}

