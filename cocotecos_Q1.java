
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class cocotecos_Q1 {

    public static void main(String[] args) {
        List<Employee> cocoemployees = generateEmployees();
        findTopEarners(cocoemployees);
 }

    private static List<Employee> generateEmployees() {
        List<Employee>cocoemployees = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            String name = "Employee" + i;
            int[] commissions = generateRandomCommissions(random);
           cocoemployees.add(new Employee(name, commissions));
        }

        return cocoemployees;
        
    }

    private static int[] generateRandomCommissions(Random random) {
        int[] commissions = new int[12];
        for (int i = 0; i < 10; i++) {
            commissions[i] = random.nextInt(4001) + 1000;
        }
        return commissions;
    }

    private static void findTopEarners(List<Employee> employees) {
        Collections.sort(employees, (e1, e2) -> Double.compare(e2.getAverageCommission(), e1.getAverageCommission()));
        System.out.println("Top 5 Employees  for cocotecos with Highest Average Commission:");
        for (int i = 0; i < 5; i++) {
            Employee employee = employees.get(i);
            System.out.printf("", i + 1, employee.getName(), employee.getAverageCommission());
        }
    }

    static class Employee {
        private final String name;
        private final int[] commissions;

        public Employee(String name, int[] commissions) {
            this.name = name;
            this.commissions = commissions;
        }

        public String getName() {
            return name;
        }

        public double getAverageCommission() {
            double total = 0;
            for (int commission : commissions) {
                total += commission;
            }
            return total / commissions.length;
        }
    }
}
    

