package mapInDeep;

import java.util.Objects;

public class Project {
    private String code;
    private String name;

    public Project(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }

    @Override
    public String toString() {
        return name + " [" + code + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project p = (Project) o;
        return Objects.equals(code, p.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
