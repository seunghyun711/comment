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

    @GetMapping(value = "/comments/change")
    public String commentDelete(Model model){

        model.addAttribute("change", memberService.commentList());
        return "comments/commentChange";
    }

    @GetMapping(value = "/comments/view")
    public String commentView(Model model, Long id){
        model.addAttribute("member", memberService.memberComment(id));
        return "comments/commentView";
    }

//    @GetMapping(value = "/comments/commentDelete")
//    public String delete(Long id) {
//        memberService.memberDelete(id);
//        return "redirect:/comments/list";
//    }

    @GetMapping("/comments/commentModify/{id}")
    public String memberChange(@PathVariable("id") Long id, Model model){
        model.addAttribute("member",memberService.memberComment(id));

        return "comments/commentModify";
    }

    @PostMapping("/comments/commentModify/{id}")
    public String boardUpdate(@PathVariable("id") Long id, Member member){

        Member memberTmp = memberService.memberComment(id);
        // 수정 시 암호를 입력했읗 때 기존 암호와 같을 때만 글이 수정됨
        if(memberTmp.getPw().equals(member.getPw())){
            memberTmp.setName(member.getName());
            memberTmp.setPw(member.getPw());
            memberTmp.setComment(member.getComment());

            memberService.write(memberTmp);
            return "redirect:/comments/list";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping(value = "/comments/commentDelete/{id}")
    public String memberDelete(@PathVariable("id") Long id, Model model){
        model.addAttribute("member",memberService.memberComment(id));
        return "comments/commentDelete";
    }

    @PostMapping("/comments/commentDelete/{id}")
    public String boardDelete(@PathVariable("id") Long id, Member member){

        Member memberTmp = memberService.memberComment(id);
        // 수정 시 암호를 입력했읗 때 기존 암호와 같을 때만 글이 수정됨
        if(memberTmp.getPw().equals(member.getPw())){
            memberService.memberDelete(id);
            return "redirect:/comments/list";
        }else{
            return "redirect:/";
        }
    }

}