package hello.servlet.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello",20);
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(saveMember).isSameAs(findMember);
    }
    @Test
    void findAll(){
        Member memberA = new Member("kim",20);
        Member memberB = new Member("lee",30);
        memberRepository.save(memberA);
        memberRepository.save(memberB);
        List<Member> findByAll = memberRepository.findByAll();
        Assertions.assertThat(findByAll.size()).isEqualTo(2);
        Assertions.assertThat(findByAll).contains(memberA,memberB);
    }
}