package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberSimpleExRepositoryTest {

    @Autowired
    MemberSimpleExRepository memberSimpleExRepository;

    @Test
    @Transactional
    @Commit
    public void testMember() {

        MemberSimpleEx memberSimpleEx = new MemberSimpleEx();
        memberSimpleEx.setUsername("memberA");

        Long savedId = memberSimpleExRepository.save(memberSimpleEx);
        MemberSimpleEx findMemberSimpleEx = memberSimpleExRepository.find(savedId);

        Assertions.assertThat(findMemberSimpleEx.getId()).isEqualTo(memberSimpleEx.getId());
        Assertions.assertThat(findMemberSimpleEx.getUsername()).isEqualTo(memberSimpleEx.getUsername());
        Assertions.assertThat(findMemberSimpleEx).isEqualTo(memberSimpleEx); //JPA 엔티티 동일성 보장
    }

}