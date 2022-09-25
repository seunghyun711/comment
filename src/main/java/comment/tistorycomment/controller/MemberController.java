package comment.tistorycomment.controller;

import comment.tistorycomment.domain.Member;
import comment.tistorycomment.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    public MemberService memberService;


    @GetMapping(value = "/comments/write")
    public String createForm(){
        return "comments/createCommentsForm";
    }

    @PostMapping("/comments/writego")
    public String create(Member member) {
        memberService.write(member);
        return "redirect:/";
    }

    @GetMapping(value = "/comments/list")
    public String list(Model model) {
        model.addAttribute("list", memberService.commentList());
        return "comments/commentList";
    }

    @GetMapping(value = "/comments/delete")
    public String commentDelete(Model model){

        model.addAttribute("delete", memberService.commentList());
        return "comments/commentDelete";
    }

    @GetMapping(value = "/comments/view")
    public String commentView(Model model, Long id){
        model.addAttribute("member", memberService.memberComment(id));
        return "comments/commentView";
    }

    @GetMapping(value = "/comments/commentDelete")
    public String delete(Long id) {
        memberService.memberDelete(id);
        return "redirect:/comments/list";
    }

    @GetMapping(value = "/comments/change")
    public String commentChange(Model model) {
        model.addAttribute("change",memberService.commentList());
        return "comments/commentChange";
    }

    @GetMapping("/comments/change/{id}")
    public String memberChange(@PathVariable("id") Long id){

        return "comments/commentModify";
    }

}
