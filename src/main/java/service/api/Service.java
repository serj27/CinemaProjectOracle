package service.api;

import java.util.List;

/**
 * Created by serj27 on 02.06.2016.
 */
public interface Service<K, T>{

    List<T> getAll();

    T getById(K id);

    void save(T entity);

    void delete(K key);

    void update(T entity);

}
