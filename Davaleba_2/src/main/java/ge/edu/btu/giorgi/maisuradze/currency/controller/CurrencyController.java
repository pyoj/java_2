package ge.edu.btu.giorgi.maisuradze.currency.controller;

import ge.edu.btu.giorgi.maisuradze.currency.models.Currency;
import ge.edu.btu.giorgi.maisuradze.currency.models.Request;
import ge.edu.btu.giorgi.maisuradze.currency.services.CurrenciesDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/currency")
public class CurrencyController {

    private final CurrenciesDB DB = CurrenciesDB.getInstance();

    @GET
    @Path("/currencies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Currency> getCurrencies(){
        return DB.getCurrencies();
    }

    @POST
    @Path("/sell")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public double sellCurrency(Request request){
        Currency currency = DB.getCurrencyByTitle(request.getTo());
        if(currency != null){
            return currency.getSellAmount(request.getAmount());
        }

        return 0;
    }

    @POST
    @Path("/buy")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public double buyCurrency(Request request){
        Currency currency = DB.getCurrencyByTitle(request.getTo());
        if(currency != null){
            return currency.getSellAmount(request.getAmount());
        }

        return 0;
    }
}
