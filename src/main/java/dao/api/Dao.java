package dao.api;

import model.Entity;

import java.util.List;

/**
 * Created by serj27 on 02.06.2016.
 */
public interface Dao<K, T extends Entity<K>> {

    List<T> findAll();

    T findOne(K key);

    T getBy(String fieldName, String value);

    void save(T entity);

    void deleteOne(K key);

    void update(T entity);
}
