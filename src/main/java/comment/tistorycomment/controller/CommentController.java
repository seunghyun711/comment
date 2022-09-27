package comment.tistorycomment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {

    @GetMapping("main")
    public String hello(Model model){
        model.addAttribute("data","main page");
        return "main";
    }

}
