package lesson1;
//Занятие 2. Домашнее задачение.
// Спроектировать иерархию классов с использованием интерфейсов и абстрактных классов

interface Transport {
    void printClassName();
}

abstract class Vehicle implements Transport {
    @Override
    public void printClassName() {
        System.out.println("Class: " + this.getClass().getSimpleName());
    }
}

interface Flying {
    void hasWings();
    void hasPropeller();
    void carriesCargo();
}

interface Land {
    void hasWheels();
    void carriesCargo();
}

class Airplane extends Vehicle implements Flying {
    @Override
    public void hasWings() {
        System.out.println("Airplane has wings.");
    }

    @Override
    public void hasPropeller() {
        System.out.println("Airplane has propeller.");
    }

    @Override
    public void carriesCargo() {
        System.out.println("Airplane carries cargo.");
    }
}

class Helicopter extends Vehicle implements Flying {
    @Override
    public void hasWings() {
        System.out.println("Helicopter does not have wings.");
    }

    @Override
    public void hasPropeller() {
        System.out.println("Helicopter has propeller.");
    }

    @Override
    public void carriesCargo() {
        System.out.println("Helicopter carries cargo.");
    }
}

class Boat extends Vehicle implements Transport {
    @Override
    public void printClassName() {
        System.out.println("Class: " + this.getClass().getSimpleName());
    }
}

class Ship extends Vehicle implements Transport {
    @Override
    public void printClassName() {
        System.out.println("Class: " + this.getClass().getSimpleName());
    }
}

class Truck extends Vehicle implements Land {
    @Override
    public void hasWheels() {
        System.out.println("Truck has wheels.");
    }

    @Override
    public void carriesCargo() {
        System.out.println("Truck carries cargo.");
    }
}

class Taxi extends Vehicle implements Land {
    @Override
    public void hasWheels() {
        System.out.println("Taxi has wheels.");
    }

    @Override
    public void carriesCargo() {
        System.out.println("Taxi carries passengers.");
    }
}

public class TransportMain {
    public static void main(String[] args) {
        Transport airplane = new Airplane();
        airplane.printClassName();

        Transport helicopter = new Helicopter();
        helicopter.printClassName();

        Transport boat = new Boat();
        boat.printClassName();

        Transport ship = new Ship();
        ship.printClassName();

        Transport truck = new Truck();
        truck.printClassName();

        Transport taxi = new Taxi();
        taxi.printClassName();
    }
}

//Этот код создает иерархию классов для различных типов транспортных средств, включая самолеты, вертолеты, лодки, грузовики и такси.
// Каждый класс реализует метод `printClassName()`, который выводит название класса, в котором он вызывается.
