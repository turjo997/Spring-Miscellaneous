package mapInDeep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapImpl2 {
    public static void main(String[] args) {

        // Outer Map: Department -> (Inner Map: Project -> Employees)
        Map<Department, Map<Project, List<Employee>>> erpData = new HashMap<>();

        // IT Department
        Department it = new Department("IT");
        Map<Project, List<Employee>> itProjects = new HashMap<>();

        itProjects.put(new Project("IT101", "Website Revamp"), Arrays.asList(
                new Employee(1, "Alice", 70000),
                new Employee(2, "Bob", 72000)
        ));
        itProjects.put(new Project("IT202", "ERP Integration"), Arrays.asList(
                new Employee(3, "Charlie", 80000),
                new Employee(4, "Diana", 85000)
        ));
        erpData.put(it, itProjects);

        // Finance Department
        Department finance = new Department("Finance");
        Map<Project, List<Employee>> financeProjects = new HashMap<>();
        financeProjects.put(new Project("FN101", "Audit 2025"), Arrays.asList(
                new Employee(5, "Eve", 60000),
                new Employee(6, "Frank", 62000)
        ));
        erpData.put(finance, financeProjects);

        // Iterate through ERP Data
        System.out.println("=== ERP Data (HashMap) ===");
        for (Map.Entry<Department, Map<Project, List<Employee>>> deptEntry : erpData.entrySet()) {
            System.out.println("Department: " + deptEntry.getKey());
            for (Map.Entry<Project, List<Employee>> projEntry : deptEntry.getValue().entrySet()) {
                System.out.println("  Project: " + projEntry.getKey());
                for (Employee e : projEntry.getValue()) {
                    System.out.println("    Employee: " + e);
                }
            }
        }
    }
}
