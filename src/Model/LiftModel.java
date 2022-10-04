package Model;

import java.util.HashMap;
import java.time.LocalDate;

public abstract class LiftModel {
    protected String name;
    protected double measure;
    protected double personalBest;
    protected HashMap history;

    public LiftModel(String name){
        this.name = name;
    }

    public void addRecord(double measure){
        history.put(LocalDate.now(), measure);
        this.personalBest = Math.max(personalBest, measure);
    }

    public HashMap getHistory(){
        return this.history;
    }

    public String getName(){
        return this.name;
    }

    public double getPersonalBest(){
        return this.personalBest;
    }
}
