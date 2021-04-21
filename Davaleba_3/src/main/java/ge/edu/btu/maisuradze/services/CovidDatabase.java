package ge.edu.btu.maisuradze.services;

import ge.edu.btu.maisuradze.models.Covid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CovidDatabase {

    // singleton pattern
    private static CovidDatabase INSTANCE = null;

    private List<Covid> covids;

    public static CovidDatabase getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new CovidDatabase();

            List<Covid> initCovids = new ArrayList<>();

            initCovids.add(new Covid("Spain", 673, 15,255));
            initCovids.add(new Covid("UK", 1673, 155,1255));
            initCovids.add(new Covid("USA", 65273, 25115,55251));
            initCovids.add(new Covid("Russia", 51673, 15255,1255));
            initCovids.add(new Covid("Germany", 21673, 1615,27555));

            INSTANCE.covids = initCovids;
        }

        return INSTANCE;
    }


    public List<Covid> getCovids() {

        return covids;
    }

    public Covid getCovidByCountry(String country) {

        return covids.stream().filter(
                c -> c.getCountry().equals(country)).collect(Collectors.toList()
        ).stream().findAny().orElse(null);
    }


    public Integer getTotalConfirmed(){

        return covids.stream().mapToInt(Covid::getConfirmed).sum();
    }

    public Integer getTotalDeaths(){

        return covids.stream().mapToInt(Covid::getDeaths).sum();
    }

    public Integer getTotalRecoveries(){

        return covids.stream().mapToInt(Covid::getRecovered).sum();
    }

}
