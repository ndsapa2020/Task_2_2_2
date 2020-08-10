package web.controller;

import hibernate.config.HibernateConfig;
import hibernate.model.Car;
import hibernate.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ResourceBundle;

@Controller
@RequestMapping("/cars")
public class CarController {

    private static AnnotationConfigApplicationContext context;
    private static CarService carService;

    public CarController() {
        context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        carService = context.getBean(CarService.class);
        insertDataToDb();
    }

    private void insertDataToDb() {
        Car audi = context.getBean(Car.class);
        audi.setName("Audi");
        audi.setModel("A6");
        audi.setYear(2015);

        Car bmw = new Car("BMW", "X6", 2018);
        Car mini = new Car("Mini", "Cooper", 1986);

        carService.add(audi);
        carService.add(bmw);
        carService.add(mini);
    }

    @GetMapping
    public String startCar(@RequestParam(name = "locale", defaultValue = "en", required = false) String locale,
                           ModelMap modelMap) {
      
        if (locale.equals("ru")) {
            modelMap.addAttribute("headline", "Таблица машин");
            modelMap.addAttribute("helloText", "Привет, это список машин");
            modelMap.addAttribute("returnText", "На главную");

        } else {
            modelMap.addAttribute("headline", "Cars table");
            modelMap.addAttribute("helloText", "It's a Car table");
            modelMap.addAttribute("returnText","Home page");
        }
        List<Car> listCars = carService.listCars();
        modelMap.addAttribute("listCars", listCars);
        return "views/car-view";
    }
}
