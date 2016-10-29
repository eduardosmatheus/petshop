package services;

import java.util.concurrent.CopyOnWriteArrayList;
import model.Race;

public class RaceList {

    private RaceList() {}
    
    private static final CopyOnWriteArrayList<Race> RACES = new CopyOnWriteArrayList<>();
    static {
        RACES.add(new Race(1, "Chiuaua"));
        RACES.add(new Race(2, "Labrador"));
        RACES.add(new Race(3, "Golden Retriever"));
        RACES.add(new Race(4, "Bullterrier"));
    }

    public static CopyOnWriteArrayList<Race> getInstance() {
        return RACES;
    }
}
