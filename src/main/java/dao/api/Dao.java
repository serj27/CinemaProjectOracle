package dao.api;

import model.Entity;

import java.util.List;

/**
 * Created by serj27 on 02.06.2016.
 */
public interface Dao<K, T extends Entity<K>> {

    List<T> getAll();

    T getById(K key);

    void save(T entity);

    void delete(K key);

    void update(T entity);

}
