package pers.nico.models.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "sell")
public class Sell {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "item")
    private Item item;

    @OneToOne
    @JoinColumn(name = "shop")
    private Shop shop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
