package dao.impl;


import datasource.DataSource;
import model.Row;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.*;


/**
 * Created by serj27 on 17.07.2016.
 */
public class RowDaoImpl extends CrudDAO<Row> {

    private static RowDaoImpl crudDAO;

    public RowDaoImpl(Class type) {
        super(type);
    }

    public static synchronized RowDaoImpl getInstance(){
        if (crudDAO == null) {
            crudDAO = new RowDaoImpl(Row.class);
        }return  crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Row entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROWS);
        preparedStatement.setInt(1, entity.getRowNumber());
        preparedStatement.setInt(2, entity.getAmountSeats());
        preparedStatement.setInt(3, entity.getHallID());
        preparedStatement.setInt(4, entity.getId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Row entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROWS, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getRowNumber());
        preparedStatement.setInt(2, entity.getAmountSeats());
        preparedStatement.setInt(3, entity.getHallID());
        return preparedStatement;
    }

    @Override
    protected List<Row> readAll(ResultSet resultSet) throws SQLException {
        List<Row> rowList = new LinkedList<>();
        Row row = null;
        while (resultSet.next()) {
            row = new Row();
            row.setId(resultSet.getInt("id"));
            row.setHallID(resultSet.getInt("hall_id"));
            row.setRowNumber(resultSet.getInt("row_number"));
            row.setAmountSeats(resultSet.getInt("seat_quantity"));
            rowList.add(row);
        }
        return rowList;
    }

    public  Row getRowByRowNumber (int rowNumber){
        Connection connection = DataSource.getInstance().getConnection();
        List<Row> rowList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROW_BY_ROW_NUMBER);
            preparedStatement.setInt(1,rowNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            rowList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList.get(0);
    }

    public List<Row> getRowBySeatNumber (int seatNumber){
        Connection connection = DataSource.getInstance().getConnection();
        List<Row> rowList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROW_BY_SEAT_NUMBER);
            preparedStatement.setInt(1,seatNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            rowList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public List<Row> getRowByHallId (int hallId){
        Connection connection = DataSource.getInstance().getConnection();
        List<Row> rowList = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ROW_BY_HALL);
            preparedStatement.setInt(1,hallId);
            ResultSet resultSet = preparedStatement.executeQuery();
            rowList = readAll(resultSet);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public void updateRowSeatNumber (int seatNumber, Integer id){
        Connection connection = DataSource.getInstance().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROWS_SEATS_NUMBER);
            preparedStatement.setInt(1,seatNumber);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Row> findAll() {
        return null;
    }

    @Override
    public Row findOne(Integer id) {
        return null;
    }

    @Override
    public void deleteOne(Integer key) {

    }

    @Override
    public Row getBy(String login, String value) {
        return null;
    }
}
