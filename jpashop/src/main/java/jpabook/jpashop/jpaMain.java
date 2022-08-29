package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String args[]) {
        //디비당 하나만 생성
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("hello");

        //요청이 생길때마다 생성, 스레드마다 공유하면 안됨(디비 커넥션처럼).
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //code

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();   //데이터베이스의 모든 변경은 트랜잭션 안에서만 처리해야함.

        try {
            Order order = new Order();
            order.addOrderItem(new OrderItem());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}

