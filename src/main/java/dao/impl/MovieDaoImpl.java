package dao.impl;

import model.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_MOVIE;
import static dao.impl.SQLs.UPDATE_MOVIE;

/**
 * Created by serj27 on 02.06.2016.
 */
public final class MovieDaoImpl extends CrudDAO<Movie> {

    private static MovieDaoImpl crudDAO;

    public MovieDaoImpl() {
        super(Movie.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MOVIE);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setInt(3, entity.getDuration());
        preparedStatement.setDate(4, new java.sql.Date(entity.getRentStart().getTime()));
        preparedStatement.setDate(4, new java.sql.Date(entity.getRentEnd().getTime()));
        preparedStatement.setString(5, entity.getGenre());
        preparedStatement.setInt(6, entity.getRating());
        preparedStatement.setInt(7, entity.getId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setInt(3, entity.getDuration());
        preparedStatement.setDate(4, new java.sql.Date(entity.getRentStart().getTime()));
        preparedStatement.setDate(5, new java.sql.Date(entity.getRentEnd().getTime()));
        preparedStatement.setString(6, entity.getGenre());
        preparedStatement.setInt(7, entity.getRating());
        return preparedStatement;
    }

    @Override
    public List<Movie> readAll(ResultSet resultSet) throws SQLException {
        List<Movie> result = new LinkedList<>();
        Movie movie = null;
        while (resultSet.next()) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDescription(resultSet.getString("description"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setRentStart(resultSet.getDate("rent_start"));
            movie.setRentEnd(resultSet.getDate("rent_end"));
            movie.setGenre(resultSet.getString("genre"));
            movie.setRating(resultSet.getInt("rating"));
            result.add(movie);
        }
        return result;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Movie findOne(Integer key) {
        return null;
    }

    @Override
    public Movie getBy(String fieldName, String value) {
        return null;
    }

    @Override
    public void deleteOne(Integer key) {

    }
}
