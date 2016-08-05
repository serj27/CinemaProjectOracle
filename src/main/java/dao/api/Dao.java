package dao.api;

import model.Entity;

import java.util.List;

/**
 * Created by serj27 on 02.06.2016.
 */
public interface Dao<K, T extends Entity<K>> {


    List<T> getAll();

    T getById(Integer id);

    void save(T entity);

    void delete(Integer key);

    void update(T entity);

    List<T> findAll();

    T findOne(K id);

    void deleteOne(K key);

    T getBy(String login, String value);
}
