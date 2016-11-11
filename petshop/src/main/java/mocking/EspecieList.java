package mocking;

import java.util.concurrent.CopyOnWriteArraySet;
import model.Especie;

public class EspecieList {

    private static final CopyOnWriteArraySet<Especie> ESPECIES = new CopyOnWriteArraySet<>();
    static {
        ESPECIES.add(new Especie(1, "Canis Lupus"));
        ESPECIES.add(new Especie(2, "Tigre"));
        ESPECIES.add(new Especie(3, "Baleia Franca"));
        ESPECIES.add(new Especie(4, "Canis Lupus Familiaris"));
    }
    
    public static CopyOnWriteArraySet<Especie> getInstance() {
        return ESPECIES;
    }
}
