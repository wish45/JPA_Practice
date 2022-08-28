package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String args[]){
        //디비당 하나만 생성
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hello");

        //요청이 생길때마다 생성, 스레드마다 공유하면 안됨(디비 커넥션처럼).
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //code

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();   //데이터베이스의 모든 변경은 트랜잭션 안에서만 처리해야함.

        try{

            /* insert
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            entityManager.persist(member);
            tx.commit();*/

            /* select
            Member findMember = entityManager.find(Member.class, 1L);
            7System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            tx.commit();*/

            /* update
            Member findMember = entityManager.find(Member.class, 1L);
            findMember.setName("hellooo"); //jpa에서 데이터 변경시 커밋전에 업데이트를 날림.
            tx.commit();
            */

            /*JPQL 조회*/
            /*List<Member> result = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)  //pagenation
                    .setMaxResults(8)
                    .getResultList();
                for(Member member : result){
                    System.out.println("member.name = " + member.getName());
                }*/

            Member member = entityManager.find(Member.class, 150L);
            member.setName("AAAA");

            entityManager.detach(member); //특정 엔티티를 준영속 상태로 전환
            entityManager.clear(); //영속성 컨텍스트를 초기화
            entityManager.close(); //영속성 컨텍스트를 닫기. 데이터를 변경해도 저장이 되지않음

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();

    }
}
