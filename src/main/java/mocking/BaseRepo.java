package mocking;

import java.util.concurrent.CopyOnWriteArrayList;
import model.Animal;
import model.Customer;
import model.Especie;
import model.Breed;

public class BaseRepo {

    private static final CopyOnWriteArrayList<Especie> ESPECIES = new CopyOnWriteArrayList<>();
    static {
        ESPECIES.add(new Especie(1, "Canis Lupus"));
        ESPECIES.add(new Especie(2, "Tigre"));
        ESPECIES.add(new Especie(3, "Baleia Franca"));
        ESPECIES.add(new Especie(4, "Canis Lupus Familiaris"));
    }
    
    private static final CopyOnWriteArrayList<Breed> RACES = new CopyOnWriteArrayList<>();
    static {
        RACES.add(new Breed(1, "Chiuaua"));
        RACES.add(new Breed(2, "Labrador"));
        RACES.add(new Breed(3, "Golden Retriever"));
        RACES.add(new Breed(4, "Bullterrier"));
    }
    
    private static final CopyOnWriteArrayList<Customer> CLIENTES = new CopyOnWriteArrayList<>();
    static {
        CLIENTES.add(new Customer("07650290905", "Matheus Eduardo", 19l, "Foo Foo", "9944-0095"));
        CLIENTES.add(new Customer("12345678911", "Lucas Kruger", 19l, "Foo Bar", "6969-2424"));
        CLIENTES.add(new Customer("45678912300", "Osnilda Sieves", 49l, "Foo", "6666-6666"));
        CLIENTES.add(new Customer("78945632147", "Márcio Eduardo", 45l, "FooBar", "4002-8922"));
    }
    
    private static final CopyOnWriteArrayList<Animal> ANIMALS = new CopyOnWriteArrayList<>();
    static {
        ANIMALS.add(new Animal(1, "Rex", CLIENTES.get(0), RACES.get(0), ESPECIES.get(1)));
        ANIMALS.add(new Animal(2, "Rex", CLIENTES.get(1), RACES.get(3), ESPECIES.get(2)));
        ANIMALS.add(new Animal(3, "Rex", CLIENTES.get(2), RACES.get(2), ESPECIES.get(3)));
    }
    
    public static CopyOnWriteArrayList<Especie> getEspecies() {
        return ESPECIES;
    }
    
    
    public static CopyOnWriteArrayList<Animal> getAnimals() {
        return ANIMALS;
    }
    

    public static CopyOnWriteArrayList<Breed> getRaces() {
        return RACES;
    }
}
