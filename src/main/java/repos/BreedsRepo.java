package repos;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mocking.BaseRepo;
import model.Breed;

public class BreedsRepo implements Findable<Breed> {
    
    public final CopyOnWriteArrayList<Breed> BREEDS = BaseRepo.getRaces();

    @Override
    public Breed findOne(int id) {
        return BREEDS.stream()
                .filter(x -> x.getId() == id)
                .findFirst().get();
    }

    @Override
    public List<Breed> all() {
        return BREEDS;
    }

}
