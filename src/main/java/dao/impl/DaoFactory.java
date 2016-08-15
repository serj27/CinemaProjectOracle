package dao.impl;

import dao.api.Dao;
import helpers.PropertyHolder;
import model.*;


/**
 * Created by serj27 on 02.06.2016.
 */
public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Movie> movieDao;
    private Dao<Integer, Hall> hallDao;
    private Dao<Integer, Row> rowDao;
    private Dao<Integer, Session> sessionDao;
    private Dao<Integer, Tickets> ticketsDao;
    private Dao<Integer, Users> usersDao;

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
            movieDao = new MovieDaoImpl(Movie.class);
            hallDao = new HallDaoImpl(Hall.class);
            rowDao = new RowDaoImpl(Row.class);
            sessionDao = new SessionDaoImpl(Session.class);
            ticketsDao = new TicketsDaoImpl(Tickets.class);
            usersDao = new UserDaoImpl(Users.class);
        }
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }

    public Dao<Integer, Hall> getHallDao() {
        return hallDao;
    }

    public void setHallDao(Dao<Integer, Hall> hallDao) {
        this.hallDao = hallDao;
    }

    public Dao<Integer, Row> getRowDao() {
        return rowDao;
    }

    public void setRowDao(Dao<Integer, Row> rowsDao) {
        this.rowDao = rowsDao;
    }

    public Dao<Integer, Session> getSessionDao() {
        return sessionDao;
    }

    public void setSessionDao(Dao<Integer, Session> sessionDao) {
        this.sessionDao = sessionDao;
    }

    public Dao<Integer, Tickets> getTicketsDao() {
        return ticketsDao;
    }

    public void setTicketsDao(Dao<Integer, Tickets> ticketsDao) {
        this.ticketsDao = ticketsDao;
    }

    public Dao<Integer, Users> getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(Dao<Integer, Users> usersDao) {
        this.usersDao = usersDao;
    }


}

