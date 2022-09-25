package comment.tistorycomment.repository;

import comment.tistorycomment.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByPw(String pw);
    Optional<Member> findByComment(String comment);
    List<Member> findAll();
}
