package comment.tistorycomment.repository;

import comment.tistorycomment.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByPw(String pw);
    Optional<Member> findByComment(String comment);
    List<Member> findAll();
}
