package comment.tistorycomment.service;

import comment.tistorycomment.domain.Member;
import comment.tistorycomment.repository.MemberRepository;
import comment.tistorycomment.repository.MemoryMemberRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 전체 댓글 조회
     */
    public List<Member> findComments(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);

    }
}
