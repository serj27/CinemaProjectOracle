package dao.impl;

import datasource.DataSource;
import model.Hall;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.GET_HALL_BY_NAME;
import static dao.impl.SQLs.INSERT_HALL;
import static dao.impl.SQLs.UPDATE_HALL;
/**
 * Created by serj27 on 17.07.2016.
 */
public final class HallDaoImpl extends CrudDAO<Hall>{


    private static HallDaoImpl crudDAO;

    public HallDaoImpl(Class type){super(type);}

    private static synchronized HallDaoImpl getInstance(){
        if (crudDAO == null) {
            crudDAO = new HallDaoImpl(Hall.class);
        }
        return crudDAO;
    }

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

    public Hall getHallByName (String name){
        Connection connection = DataSource.getInstance().getConnection();
        List<Hall> hallList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_HALL_BY_NAME);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            hallList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hallList.get(0);
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
