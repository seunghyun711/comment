package comment.tistorycomment.service;

import comment.tistorycomment.domain.Member;
import comment.tistorycomment.repository.MemberRepository;
//import comment.tistorycomment.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

//    Date today = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private final MemberRepository memberRepository;

    // 댓글 작성
    public void write(Member member){
        memberRepository.save(member);
    }

    // 댓글 목록
    public List<Member> commentList(){
        return memberRepository.findAll();
    }

    // 특정 댓글 불러오기
    public Member memberComment(Long id){
        return memberRepository.findById(id).get();
    }

    // 댓글 삭제
    public void memberDelete(Long id) {
        memberRepository.deleteById(id);
    }

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

//    /**
//     * 전체 댓글 조회
//     */
//    public List<Member> findComments(){
//        return memberRepository.findAll();
//    }
//
//    public Optional<Member> findOne(Long memberId){
//        return memberRepository.findById(memberId);
//    }
}
