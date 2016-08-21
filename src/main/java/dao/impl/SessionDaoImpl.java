package dao.impl;

import datasource.DataSource;
import model.Session;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.*;

/**
 * Created by serj27 on 17.07.2016.
 */
public class SessionDaoImpl extends CrudDAO<Session> {

    private static SessionDaoImpl crudDAO;

    public SessionDaoImpl(Class type) {
        super(type);
    }

    public static synchronized SessionDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new SessionDaoImpl(Session.class);
        }return  crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Session entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SESSION);
        preparedStatement.setInt(1, entity.getMovieID());
        preparedStatement.setDate(2, Date.valueOf(entity.getStartSession()));
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.setInt(4, entity.getHallID());
        preparedStatement.setInt(5, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Session entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SESSION, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getMovieID());
        preparedStatement.setDate(2, Date.valueOf(entity.getStartSession()));
        preparedStatement.setDouble(3, entity.getPrice());
        preparedStatement.setInt(4, entity.getHallID());
        return preparedStatement;
    }

    @Override
    protected List<Session> readAll(ResultSet resultSet) throws SQLException {
        List<Session> sessionList = new LinkedList<>();
        Session session = null;
        while (resultSet.next()){
            session = new Session();
            session.setMovieID(resultSet.getInt("movie_id"));
            session.setStartSession(resultSet.getDate("startSession").toLocalDate());
            session.setPrice(resultSet.getDouble("price"));
            session.setHallID(resultSet.getInt("hall_id"));
            session.setId(resultSet.getInt("id"));
            sessionList.add(session);
        }
        return sessionList;
    }

    public  void updateSessionTime(Time time, Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SESSION_TIME);
            preparedStatement.setTime(1, time);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSessionDate(LocalDate date, Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SESSION_DATE);
            preparedStatement.setDate(1, Date.valueOf(date));
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Session updateSessionPrice (double price, Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        List<Session> sessionList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SESSION_PRICE);
            preparedStatement.setDouble(1,price);
            preparedStatement.setInt(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            sessionList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList.get(0);
    }

    public List<Session> getSessionByTime (Time time){
        Connection connection = DataSource.getInstance().getConnection();
        List<Session> sessionList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SESSION_BY_TIME);
            preparedStatement.setTime(1,time);
            ResultSet resultSet = preparedStatement.executeQuery();
            sessionList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList;
    }

    public List<Session> getSessionByDate (String date){
        Connection connection = DataSource.getInstance().getConnection();
        List<Session> sessionList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SESSION_BY_DATE);
            preparedStatement.setString(1,date);
            ResultSet resultSet = preparedStatement.executeQuery();
            sessionList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList;
    }

    public List<Session> getSessionByPrice (double price){
    Connection connection = DataSource.getInstance().getConnection();
        List<Session> sessionList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SESSION_BY_PRICE);
            preparedStatement.setDouble(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            sessionList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList;
    }

    public List<Session> getSessionByHallId (int id){
        Connection connection = DataSource.getInstance().getConnection();
        List<Session> sessionList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SESSION_BY_HALL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            sessionList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return sessionList;
    }

    public List<Session> getSessionByMovieId (int id){
        Connection connection = DataSource.getInstance().getConnection();
        List<Session> sessionList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SESSION_BY_MOVIE_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            sessionList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessionList;
    }

    @Override
    public List<Session> findAll() {
        return null;
    }

    @Override
    public Session findOne(Integer id) {
        return null;
    }

    @Override
    public void deleteOne(Integer key) {

    }

    @Override
    public Session getBy(String login, String value) {
        return null;
    }
}
