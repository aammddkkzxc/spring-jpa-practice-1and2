package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberSimpleExRepository {

    private final EntityManager em;

    //엔티티 아닌 id 반환
    public Long save(MemberSimpleEx memberSimpleEx) {
        em.persist(memberSimpleEx);
        return memberSimpleEx.getId();
    }

    public MemberSimpleEx find(Long id) {
        return em.find(MemberSimpleEx.class, id);
    }

}
