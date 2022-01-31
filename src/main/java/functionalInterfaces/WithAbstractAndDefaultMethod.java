package functionalInterfaces;

public class WithAbstractAndDefaultMethod {
    @FunctionalInterface
    interface Employee {
        // abstract method
        Employee find(int id);
        // default method
        default boolean isExecutive(int id) {
            return true;
        }
        // static method
        static String getDefaultCountry() {
            return "BR";
        }
    }

    public static void main(String[] args) {
        class EmployeeImpl implements Employee {
            @Override
            public Employee find(int id) {
                boolean isExecutive = isExecutive(id);
                return null;
            }
        }

        EmployeeImpl impl = new EmployeeImpl();
        System.out.println("Abstract Method: " + impl.isExecutive(0));
        System.out.println("Static Method: what is the default Country? " + Employee.getDefaultCountry());
    }
}
