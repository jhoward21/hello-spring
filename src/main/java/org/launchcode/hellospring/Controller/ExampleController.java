package org.launchcode.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@ResponseBody
//@RequestMapping("hello")
public class ExampleController {

    //Handles request of the form hello?name=patrickMahomes
//    @GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language, Model model) {
        String greetingMessage = ExampleController.createMessage(name, language);
        model.addAttribute("greetingMessage", greetingMessage);
        return "hello";
    }

    // type hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    public static String createMessage(String name, String language){
        switch (language){
            case "Spanish":
                return "Hola, " + name;
            case "French":
                return "Bonjour, " + name;
            case "Italian":
                return "Ciao, " + name;
            case "German":
                return "Hallo, " + name;
            case "English":
            default:
                return "Hello, " + name;
        }
    }

    //type hello/add or anything after /
    @PostMapping("add")
    public String addThePlayer(@RequestParam String name){
        return "<html><body><h2>" + name + "was added!<h2></body></html>";
    }

    // type hello/{name}
    //Handles request of the form /hello/name
    @GetMapping("hello/{name}")
    public String Sup(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //Handler method
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Russell Wilson");
        names.add("Patrick Mahomes");
        names.add("Stehpen Curry");
        names.add("Jermell");
        names.add("LaunchCode");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
