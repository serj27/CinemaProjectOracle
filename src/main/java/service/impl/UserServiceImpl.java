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
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        usersDao = DaoFactory.getInstance().getUsersDao();
        beanMapper = BeanMapper.getInstance();
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
        List<UserDTO> usersDTOs = beanMapper.listMapToList(usersList, UserDTO.class);
        return usersDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        Users users = usersDao.findOne(id);
        UserDTO usersDTO = beanMapper.singleMapper(users, UserDTO.class);
        return usersDTO;
    }

    @Override
    public void save(UserDTO entity) {
        Users users = beanMapper.singleMapper(entity, Users.class);
        usersDao.save(users);
    }

    public UserDTO getByLogin(String value){
        Users users = usersDao.getBy("login", value);
        UserDTO usersDTO = beanMapper.singleMapper(users, UserDTO.class);
        return usersDTO;
    }

    @Override
    public void delete(Integer key) {
        usersDao.deleteOne(key);
    }

    @Override
    public void update(UserDTO entity) {
        Users users = beanMapper.singleMapper(entity, Users.class);
        usersDao.update(users);
    }
}
