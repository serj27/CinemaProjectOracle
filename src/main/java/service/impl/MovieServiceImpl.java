package service.impl;

import dao.api.Dao;
import dao.impl.DaoFactory;
import dto.MovieDTO;
import mapper.BeanMapper;
import model.Movie;
import service.api.Service;

import java.util.List;

/**
 * Created by serj27 on 02.06.2016.
 */
public class MovieServiceImpl implements Service<Integer, MovieDTO> {

    private static MovieServiceImpl service;
    private Dao<Integer, Movie> movieDao;

    private MovieServiceImpl() {
        movieDao = DaoFactory.getInstance().getMovieDao();
    }

    public static synchronized MovieServiceImpl getInstance() {
        if (service == null) {
            service = new MovieServiceImpl();
        }
        return service;
    }


    @Override
    public List<MovieDTO> getAll() {
        List<Movie> movies = movieDao.findAll();
        return BeanMapper.listMapToList(movies, MovieDTO.class);
    }

    @Override
    public void save(MovieDTO movieDto) {
        Movie movie = BeanMapper.singleMapper(movieDto, Movie.class);
        movieDao.save(movie);
    }

    @Override
    public MovieDTO getById(Integer id) {
        Movie movie = movieDao.findOne(id);
        return BeanMapper.singleMapper(movie, MovieDTO.class);
    }


    @Override
    public void delete(Integer key) {
        movieDao.deleteOne(key);
    }

    @Override
    public void update(MovieDTO entity) {
        Movie movie = BeanMapper.singleMapper(entity, Movie.class);
        movieDao.update(movie);
    }

}
