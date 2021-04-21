package ge.edu.btu.maisuradze.services;

import ge.edu.btu.maisuradze.models.Covid;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class CovidService {

    private final CovidDatabase DB = CovidDatabase.getInstance();

    @WebMethod
    public List<Covid> getStatistics() {
        return DB.getCovids();
    }

    @WebMethod
    public Covid getStatisticsByCountry(String country) {
        return DB.getCovidByCountry(country);
    }

    @WebMethod
    public Integer getTotalConfirmed() {
        return DB.getTotalConfirmed();
    }

    @WebMethod
    public Integer getTotalDeaths() {
        return DB.getTotalDeaths();
    }

    @WebMethod
    public Integer getTotalRecoveries() {
        return DB.getTotalRecoveries();
    }

}
