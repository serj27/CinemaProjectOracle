package service.impl;

import dao.api.Dao;
import dao.impl.DaoFactory;
import dto.HallDTO;
import mapper.BeanMapper;
import model.Hall;
import service.api.Service;

import java.util.List;

/**
 * Created by serj27 on 18.07.2016.
 */
public class HallServiceImpl implements Service<Integer, HallDTO> {
    private static HallServiceImpl service;
    private Dao<Integer, Hall> hallDao;
    private BeanMapper beanMapper;

    private HallServiceImpl() {
        hallDao = DaoFactory.getInstance().getHallDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized HallServiceImpl getInstance() {
        if (service == null) {
            service = new HallServiceImpl();
        }
        return service;
    }

    @Override
    public List<HallDTO> getAll() {
        List<Hall> hallList = hallDao.findAll();
        List<HallDTO> hallDTOs = beanMapper.listMapToList(hallList, HallDTO.class);
        return hallDTOs;
    }

    @Override
    public HallDTO getById(Integer id) {
        Hall hall = hallDao.findOne(id);
        HallDTO hallDTO = beanMapper.singleMapper(hall, HallDTO.class);
        return null;
    }

    @Override
    public void save(HallDTO entity) {
        Hall hall = beanMapper.singleMapper(entity, Hall.class);
        hallDao.save(hall);
    }

    @Override
    public void delete(Integer key) {
        hallDao.deleteOne(key);
    }

    @Override
    public void update(HallDTO entity) {
        Hall hall = beanMapper.singleMapper(entity, Hall.class);
        hallDao.update(hall);
    }
}
