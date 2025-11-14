package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/springmvc/v3/members")
@Controller
public class SpringMemberControllerV3 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        //  return new ModelAndView("new-form");
        return "new-form"; //이렇게 하면 스프링에서 자체적으로 view 이름으로 해석한다.
    }

    @PostMapping("/save")
    public String save(@RequestParam("username") String username,
                       @RequestParam("age") int age,
                       Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        // ModelAndView mv = new ModelAndView("save-result");
        // mv.addObject("member", member);
        // return mv; 이게 사라짐
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findByAll();
        model.addAttribute("members", members);
        //  ModelAndView mv = new ModelAndView("members");
        //  mv.addObject("members", members);
        //  return mv; 이게 사라짐
        return "members";
    }
}
