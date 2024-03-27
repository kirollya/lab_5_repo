package pers.nico;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pers.nico.models.entities.Item;
import pers.nico.models.entities.Sell;
import pers.nico.models.entities.Shop;
import pers.nico.models.repositories.ItemRepository;
import pers.nico.models.repositories.ShopRepository;
import pers.nico.services.ItemService;
import pers.nico.services.SellService;
import pers.nico.services.ShopService;

@Path("/main_page")
public class MainFacade {

    @Inject
    EntityManager entityManager;

    @Inject
    ShopService shopService;

    @Inject
    ItemService itemService;

    @Inject
    SellService sellService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @POST
    @Path("/addShop")
    public String addShop(Shop shop) {
        shopService.addShop(shop);
        return "Shop was added!";
    }

    @POST
    @Path("/addItem")
    public String addItem(Item item) {
        itemService.addItem(item);
        return "Item was added!";
    }

    @POST
    @Path("/addSell")
    public String addSell(Sell sell) {
        sellService.addSell(sell);
        return "Sell was added!";
    }

    @GET
    @Path("/getShop/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShop(@PathParam("id") Long id) {
        return Response.accepted(shopService.getShopRepository().findById(id)).build();
    }

    @POST
    @Path("/editShopName")
    @Transactional
    public Response editShopName(@QueryParam("id") Long id, @QueryParam("name") String name) {
        Query query = entityManager.createQuery("UPDATE Shop set name = :shopName WHERE id = :shopId");
        query.setParameter("shopName", name);
        query.setParameter("shopId", id);
        return Response.accepted(query.executeUpdate()).build();
    }

    @POST
    @Path("/deleteSellById/{id}")
    @Transactional
    public Response deleteSellById(@PathParam("id") Long id) {
        sellService.getSellRepository().deleteById(id);
        return Response.accepted().build();
    }

}
