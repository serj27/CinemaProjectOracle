package dao.impl;


import model.Row;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_ROWS;
import static dao.impl.SQLs.UPDATE_ROWS;


/**
 * Created by serj27 on 17.07.2016.
 */
public class RowDaoImpl extends CrudDAO<Row> {

    private static MovieDaoImpl crudDAO;

    public RowDaoImpl() {
        super(Row.class);
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
            row.setAmountSeats(resultSet.getInt("amount_seats"));
            rowList.add(row);
        }
        return rowList;
    }
}
