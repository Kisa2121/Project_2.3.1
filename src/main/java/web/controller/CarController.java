package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Supra", 1998));
        cars.add(new Car("Toyota", "Celica", 1999));
        cars.add(new Car("Toyota", "Crown", 2000));
        cars.add(new Car("Mitsubishi", "Eclipse", 2003));
        cars.add(new Car("Mitsubishi", "Lancer", 1997));

        List<Car> resultCars = carService.getCars(cars, count);
        model.addAttribute("cars", resultCars);
        return "cars";
    }
}
