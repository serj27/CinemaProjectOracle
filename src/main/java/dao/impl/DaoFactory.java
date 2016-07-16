package dao.impl;

import dao.api.Dao;
import helpers.PropertyHolder;
import model.Movie;

/**
 * Created by serj27 on 02.06.2016.
 */
public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Movie> movieDao;

    private DaoFactory(){
        loadDaos();
    }



    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDaos() {
        if(PropertyHolder.getInstance().isInMemoryDB()){

        }else{
            movieDao = new MovieDaoImpl();
        }
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }
}

