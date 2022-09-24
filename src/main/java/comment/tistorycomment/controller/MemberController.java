package comment.tistorycomment.controller;

import comment.tistorycomment.domain.Member;
import comment.tistorycomment.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    public final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/comments/write")
    public String createForm(){
        return "comments/createCommentsForm";
    }

    @PostMapping("/comments/write")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        member.setPw(form.getPw());
        member.setComment(form.getComment());

        return "redirect:/";
    }

    @GetMapping(value = "/comments/list")
    public String list(Model model) {
        List<Member> comments = memberService.findComments();
        model.addAttribute("comments", comments);
        return "comments/list";
    }


}
