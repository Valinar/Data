package com.example.Dva.Controller;
import com.example.Dva.Rep.PostRepository;
import com.example.Dva.Rep.Postrep;
import com.example.Dva.models.Data;
import com.example.Dva.models.Data2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class MainController {
@Autowired
private PostRepository postRepository;
@Autowired
    private Postrep postRep;
    @GetMapping("/")
    public String blogMain(Model model ){

        return "Main";
    }
    @GetMapping("/add")
    public String aad(Model model){
        return "Adder";
    }
 @PostMapping("/add")
    public String Add(@RequestParam String name,
                      @RequestParam String fame,
                              @RequestParam String otch,
                              @RequestParam int place,
                              @RequestParam double zp,Model model
                      ){
         Data data =new Data(name,fame,otch,place,zp);

       postRepository.save(data);
        return "redirect:/show";
 }
    @GetMapping("/add2")
    public String aad2(Model model){
        return "Adder2";
    }
    @PostMapping("/add2")
    public String Add2(@RequestParam String name,
                      @RequestParam String avtor,
                      @RequestParam int year,
                      @RequestParam int count,
                      @RequestParam double price,Model model
    ){
        Data2 data =new Data2(name,avtor,year,count,price);

        postRep.save(data);
        return "redirect:/show2";
    }
    @GetMapping("/show")
    public String show(Model model){
        Iterable<Data> posts=postRepository.findAll();
        model.addAttribute("posts",posts);
        return "Show";
    }
    @GetMapping("/show2")
    public String show2(Model model){
        Iterable<Data2> postRepAll=postRep.findAll();
        model.addAttribute("post",postRepAll);
        return "Show2";
    }
    @GetMapping ("/search")  public String blogFiltre(Model model){return "Search";}

    @PostMapping("/search")
    public String blogResult(@RequestParam String title, Model model)
    {
        List<Data> result = postRepository.findByName(title);
        model.addAttribute("result", result);
        return "Search";
    }
    @GetMapping ("/search2")  public String blogFiltre2(Model model){return "Search2";}

    @PostMapping("/search2")
    public String blogResult2(@RequestParam String title, Model model)
    {
        List<Data2> result = postRep.findByNameContaining(title);
        model.addAttribute("result", result);
        return "Search2";
    }
}
