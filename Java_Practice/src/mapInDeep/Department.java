package mapInDeep;

import java.util.Objects;

public class Department implements Comparable<Department>{
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() { return name; }


    @Override
    public int compareTo(Department other) {
        return this.name.compareTo(other.name); // natural order by name
    }

    @Override
    public String toString() {
        return name;
    }

    // For use as a key in maps → must implement equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department d = (Department) o;
        return Objects.equals(name, d.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
