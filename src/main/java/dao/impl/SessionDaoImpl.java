package dao.impl;

import model.Session;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_SESSION;
import static dao.impl.SQLs.UPDATE_SESSION;

/**
 * Created by serj27 on 17.07.2016.
 */
public class SessionDaoImpl extends CrudDAO<Session> {

    private static MovieDaoImpl crudDAO;

    public SessionDaoImpl() {
        super(Session.class);
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
            session.setStartSession(resultSet.getDate("time").toLocalDate());
            session.setPrice(resultSet.getDouble("price"));
            session.setHallID(resultSet.getInt("hall_id"));
            session.setId(resultSet.getInt("id"));
            sessionList.add(session);
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
