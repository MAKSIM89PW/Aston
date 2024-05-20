package lesson1;
import java.util.Objects;

interface Animal {
    void printClassName();
}

interface Mammal extends Animal {
    void hasSpine();
}

interface Fish extends Animal {
    void livesInWater();
}

abstract class MammalImpl implements Mammal {
    @Override
    public void printClassName() {
        System.out.println("Class: " + this.getClass().getSimpleName());
    }

    // Занятие №3
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MammalImpl mammal = (MammalImpl) o;
        return Objects.equals(this.getClass(), mammal.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }
}

abstract class FishImpl implements Fish {
    @Override
    public void printClassName() {
        System.out.println("Class: " + this.getClass().getSimpleName());
    }

    // Занятие №3
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FishImpl fish = (FishImpl) o;
        return Objects.equals(this.getClass(), fish.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }
}

class Whale extends MammalImpl implements Fish {
    @Override
    public void hasSpine() {
        System.out.println("Whale has a spine.");
    }

    @Override
    public void livesInWater() {
        System.out.println("Whale lives in the water.");
    }
}

class Bear extends MammalImpl {
    @Override
    public void hasSpine() {
        System.out.println("Bear has a spine.");
    }

    public void hasFur() {
        System.out.println("Bear has fur.");
    }
}

class Cat extends MammalImpl {
    public void hasFur() {
        System.out.println("Cat has fur.");
    }

    @Override
    public void hasSpine() {
        System.out.println("Cat has a spine.");
    }
}

class FishExample extends FishImpl {
    @Override
    public void livesInWater() {
        System.out.println("Fish lives in the water.");
    }
}

public class Animals {
    public static void main(String[] args) {
        MammalImpl whale = new Whale();
        whale.printClassName();
        whale.hasSpine();
        ((Fish) whale).livesInWater();

        Bear bear = new Bear();
        bear.printClassName();
        bear.hasSpine();
        bear.hasFur();

        Cat cat = new Cat();
        cat.printClassName();
        cat.hasSpine();
        cat.hasFur();

        Fish fish = new FishExample();
        fish.printClassName();
        ((Fish) fish).livesInWater();

        // Тестирование equals и hashCode
        System.out.println("Testing equals and hashCode:");
        MammalImpl whale2 = new Whale();
        System.out.println("whale.equals(whale2): " + whale.equals(whale2));
        System.out.println("whale.hashCode(): " + whale.hashCode());
        System.out.println("whale2.hashCode(): " + whale2.hashCode());
    }
}
