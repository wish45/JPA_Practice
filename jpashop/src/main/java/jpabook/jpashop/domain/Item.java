package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue()
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int prices;
    private int stckQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public int getStckQuantity() {
        return stckQuantity;
    }

    public void setStckQuantity(int stckQuantity) {
        this.stckQuantity = stckQuantity;
    }
}
