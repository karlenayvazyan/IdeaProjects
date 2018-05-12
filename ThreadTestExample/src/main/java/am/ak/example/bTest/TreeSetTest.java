package am.ak.example.bTest;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by karlen on 9/16/16.
 */
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);


        SortedSet<Item> sortByDescription = new TreeSet<>((o1, o2) ->  {
            String descrA = o1.getDescription();
            String descrB = o2.getDescription();
            return descrA.compareTo(descrB);
        });
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}

class Item implements Comparable<Item> {

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    /**
     * Gets the description of this item.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[descripion=" + description + ", partNumber=" + partNumber + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (partNumber != item.partNumber) return false;
        return description.equals(item.description);

    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber, o.partNumber);
    }
}
