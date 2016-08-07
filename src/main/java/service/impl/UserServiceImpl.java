package service.impl;

import dao.api.Dao;
import dao.impl.DaoFactory;
import dto.UserDTO;
import mapper.BeanMapper;
import model.Users;
import service.api.Service;

import java.util.List;

/**
 * Created by serj27 on 18.07.2016.
 */
public class UserServiceImpl implements Service<Integer, UserDTO> {

    private static UserServiceImpl service;
    private Dao<Integer, Users> usersDao;

    private UserServiceImpl() {
        usersDao = DaoFactory.getInstance().getUsersDao();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDTO> getAll() {
        List<Users> usersList = usersDao.findAll();
        return BeanMapper.listMapToList(usersList, UserDTO.class);
    }

    @Override
    public UserDTO getById(Integer id) {
        Users users = usersDao.findOne(id);
        return BeanMapper.singleMapper(users, UserDTO.class);
    }

    @Override
    public void save(UserDTO entity) {
        Users users = BeanMapper.singleMapper(entity, Users.class);
        usersDao.save(users);
    }

    public UserDTO getByLogin(String value){
        Users users = usersDao.getBy("login", value);
        return BeanMapper.singleMapper(users, UserDTO.class);
    }

    @Override
    public void delete(Integer key) {
        usersDao.deleteOne(key);
    }

    @Override
    public void update(UserDTO entity) {
        Users users = BeanMapper.singleMapper(entity, Users.class);
        usersDao.update(users);
    }
}
