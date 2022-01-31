package functionalInterfaces;

interface Engine {
    default String make() {
        return "DEFAULT_MAKE";
    }
}

interface Vehicle {
    default String model() {
        return "DEFAULT_MODEL";
    }
}

class Car implements Engine, Vehicle {
    String makeAndModel() {
        return new StringBuilder()
                .append(Engine.super.make())
                .append("&")
                .append(Vehicle.super.model())
                .toString();
    }
}

public class InheritanceBehaviour {
    public static void main(String[] args) {
        Car gol = new Car();
        System.out.println(gol.makeAndModel());
    }
}
