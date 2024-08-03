package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarContoller {

    private CarService carService;

    @Autowired
    public CarContoller(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> cars;
        if (count >= 5) {
            // Если count больше либо равен 5, выводим весь список
            cars = carService.getCars(Integer.MAX_VALUE); // или carService.getAllCars();
        } else {
            // В противном случае выводим только нужное количество машин
            cars = carService.getCars(count);
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}