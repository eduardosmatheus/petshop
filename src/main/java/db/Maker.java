package db;

@FunctionalInterface
public interface Maker<T> {
    
    T make(ConnectionApi conexao);
    
}
