package model;

public class Race {

    private final int id;
    public final String descricao;

    public Race(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %s\tDescricao: %s", id, descricao);
    }
}
