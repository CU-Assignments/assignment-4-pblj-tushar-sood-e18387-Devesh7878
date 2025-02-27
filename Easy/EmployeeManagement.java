import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static List<Employee> employees = new ArrayList<>();

    static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
    }

    static void updateEmployee(int id, String newName, double newSalary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = newName;
                emp.salary = newSalary;
                return;
            }
        }
    }

    static void removeEmployee(int id) {
        employees.removeIf(emp -> emp.id == id);
    }

    static Employee searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                return emp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter ID, Name, Salary:");
                addEmployee(sc.nextInt(), sc.next(), sc.nextDouble());
            } else if (choice == 2) {
                System.out.println("Enter ID, New Name, New Salary:");
                updateEmployee(sc.nextInt(), sc.next(), sc.nextDouble());
            } else if (choice == 3) {
                System.out.println("Enter ID to remove:");
                removeEmployee(sc.nextInt());
            } else if (choice == 4) {
                System.out.println("Enter ID to search:");
                Employee emp = searchEmployee(sc.nextInt());
                System.out.println(emp != null ? emp : "Employee not found");
            } else if (choice == 5) {
                break;
            }
        }
        sc.close();
    }
}
