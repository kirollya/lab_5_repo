package pers.nico.models.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import pers.nico.models.entities.Sell;

@ApplicationScoped
public class SellRepository implements PanacheRepository<Sell> {
}
