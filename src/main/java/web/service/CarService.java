package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car("Toyota", 5, "blue"));
        cars.add(new Car("BMW", 4, "red"));
        cars.add(new Car("Audi", 3, "green"));
        cars.add(new Car("Honda", 2, "yellow"));
        cars.add(new Car("Mercedes", 1, "yellow"));
    }

    public List<Car> getCars(int count) {
        return count < 5 ? cars.subList(0, count) : cars;
    }

    public List<Car> getAllCars() {
        // Возвращаем весь список
        return cars;
    }
}
