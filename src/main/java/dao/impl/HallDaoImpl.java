package dao.impl;

import model.Hall;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_HALL;
import static dao.impl.SQLs.UPDATE_HALL;

/**
 * Created by serj27 on 17.07.2016.
 */
public class HallDaoImpl extends CrudDAO<Hall>{

    private static HallDaoImpl crudDAO;

    public HallDaoImpl(Class<Hall> hallClass){super(Hall.class);}

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Hall entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HALL);
        preparedStatement.setString(1, entity.getHallName());
        preparedStatement.setInt(2, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Hall entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HALL, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getHallName());
        return preparedStatement;
    }

    @Override
    protected List<Hall> readAll(ResultSet resultSet) throws SQLException {
        List<Hall> hallList = new LinkedList<>();
        Hall hall = null;
        while (resultSet.next()){
            hall = new Hall();
            hall.setHallName(resultSet.getString("hall_name"));
            hall.setId(resultSet.getInt("id"));
            hallList.add(hall);
        }
        return hallList;
    }


    @Override
    public List<Hall> findAll() {
        return null;
    }

    @Override
    public Hall findOne(Integer id) {
        return null;
    }

    @Override
    public void deleteOne(Integer key) {

    }

    @Override
    public Hall getBy(String login, String value) {
        return null;
    }
}
