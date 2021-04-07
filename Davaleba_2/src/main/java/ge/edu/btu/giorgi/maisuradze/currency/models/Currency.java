package ge.edu.btu.giorgi.maisuradze.currency.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Currency {

    private String title;

    private double buy;

    private double sell;

    public Currency(String tittle, double buy, double sell) {
        this.title = tittle;
        this.buy = buy;
        this.sell = sell;
    }

    public String getTitle() {
        return title;
    }

    public double getBuy() {
        return buy;
    }

    public double getSell() {
        return sell;
    }

    public double getSellAmount(double amount){
        return 5;
    }

    public double getBuyAmount(double amount){
        return 10;
    }
}
