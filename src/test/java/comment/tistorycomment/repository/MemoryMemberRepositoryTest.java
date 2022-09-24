package comment.tistorycomment.repository;

import comment.tistorycomment.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("comment");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("user1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("user2");
        repository.save(member2);

        //when
        Member result = repository.findByName("user1").get();

        //then
        assertThat(result).isEqualTo(member1);
    }
}
