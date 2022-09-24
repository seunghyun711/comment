package comment.tistorycomment;

import comment.tistorycomment.repository.MemberRepository;
import comment.tistorycomment.repository.MemoryMemberRepository;
import comment.tistorycomment.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 빈 등록
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
