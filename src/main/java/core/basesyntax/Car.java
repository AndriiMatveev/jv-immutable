package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = getCopy(wheels);
        if (engine == null) {
            this.engine = null;
        } else {
            this.engine = engine.clone();
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return getCopy(wheels);
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    public Car changeEngine(Engine engine) {
        return new Car(this.year, this.color, getCopy(wheels), engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> newWheels = getCopy(wheels);
        newWheels.add(wheel);
        return new Car(this.year, this.color, newWheels, engine.clone());
    }

    public Car changeColor(String color) {
        return new Car(this.year, color, getCopy(wheels), engine.clone());
    }

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    private List<Wheel> getCopy(List<Wheel> wheels) {
        List<Wheel> clonedList = new ArrayList<>(wheels.size());
        for (Wheel wheel : wheels) {
            clonedList.add(wheel.clone());
        }
        return clonedList;
    }
}
