package pers.nico.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pers.nico.models.entities.Item;
import pers.nico.models.repositories.ItemRepository;

@ApplicationScoped
public class ItemService {

    @Inject
    ItemRepository itemRepository;

    @Transactional
    public void addItem(Item item) {
        itemRepository.persist(item);
    }

}
