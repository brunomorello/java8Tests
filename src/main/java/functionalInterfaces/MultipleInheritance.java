package functionalInterfaces;

interface EngineV2 {
    default String model(int id) {
        return "DEFAULT_ENGINE";
    }
}

interface VehicleV2 {
    default String model(int id) {
        return "DEFAULT_VEHICLE";
    }
}

class CarV2 implements EngineV2, VehicleV2 {
    // re-implementing model method fix compiler complain
    public String model(int id) {
        return "DEFAULT_CAR";
    }
}

interface VehicleV3 extends EngineV2 {
    default String model(int id) {
        return "DEFAULT_VEHICLE_V3";
    }
}

class CarV3 implements VehicleV3 {}

public class MultipleInheritance {
    public static void main(String[] args) {
        Car carV1 = new Car();
        System.out.println("carv1 carV1.makeAndModel() " + carV1.makeAndModel());

        CarV2 carV2 = new CarV2();
        System.out.println("carv2 carV2.model(1) " + carV2.model(1));

        CarV3 carV3 = new CarV3();
        System.out.println("carv3 carV3.model(1) " + carV3.model(1));

        /**
         * Abstract Class
         *  Instance fields and methods
         *  Any access modifiers (public, private, protected, static, final and non-final)
         *  When to use ?
         *      common functionality
         *      related class groups
         *      inherit state and behaviour
         * Interfaces
         *  Restricted access modifiers (public, static and final)
         *  implicit access
         *  When to use?
         *      multiple types
         *      logic from many interfaces
         *      inherit behaviour
          */
    }
}
