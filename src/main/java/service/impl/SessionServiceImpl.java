package service.impl;

import dao.api.Dao;
import dao.impl.DaoFactory;
import dto.SessionDTO;
import mapper.BeanMapper;
import model.Session;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serj27 on 18.07.2016.
 */
public class SessionServiceImpl implements Service<Integer, SessionDTO> {

    private static SessionServiceImpl service;
    private Dao<Integer , Session> sessionDao;
    private BeanMapper beanMapper;

    private SessionServiceImpl() {
        sessionDao = DaoFactory.getInstance().getSessionDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized SessionServiceImpl getInstance() {
        if (service == null) {
            service = new SessionServiceImpl();
        }
        return service;
    }

    @Override
    public List<SessionDTO> getAll() {
        List<Session> sessionList = sessionDao.findAll();
        return BeanMapper.listMapToList(sessionList, SessionDTO.class);
    }

    @Override
    public SessionDTO getById(Integer id) {
        Session session = sessionDao.findOne(id);
        return BeanMapper.singleMapper(session, SessionDTO.class);
    }

    @Override
    public void save(SessionDTO entity) {
        Session session = BeanMapper.singleMapper(entity, Session.class);
        sessionDao.save(session);
    }

    public List<SessionDTO> getByMovieID (String value){
        List<SessionDTO> sessionList = new ArrayList<>();
        Integer intValue = Integer.parseInt(value);
        for (SessionDTO sessionDTO : getAll()) {
            if(sessionDTO.getMovieID() == intValue){
                sessionList.add(sessionDTO);
            }
        }
        return sessionList;
    }

    @Override
    public void delete(Integer key) {
        sessionDao.deleteOne(key);
    }

    @Override
    public void update(SessionDTO entity) {
        Session session = BeanMapper.singleMapper(entity, Session.class);
        sessionDao.update(session);
    }
}
