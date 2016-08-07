package service.impl;

import dao.api.Dao;
import dao.impl.DaoFactory;
import dto.RowDTO;
import mapper.BeanMapper;
import model.Row;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serj27 on 18.07.2016.
 */
public class RowServiceImpl implements Service<Integer, RowDTO> {
    private static RowServiceImpl service;
    private Dao<Integer, Row> rowDao;

    private RowServiceImpl(){
        rowDao = DaoFactory.getInstance().getRowDao();
    }

    public static synchronized RowServiceImpl getInstance() {
        if (service == null) {
            service = new RowServiceImpl();
        }
        return service;
    }

    @Override
    public List<RowDTO> getAll() {
        List<Row> rowsList = rowDao.findAll();
        return BeanMapper.listMapToList(rowsList, RowDTO.class);
    }

    @Override
    public RowDTO getById(Integer id) {
        Row row = rowDao.findOne(id);
        return BeanMapper.singleMapper(row, RowDTO.class);
    }

    public List<RowDTO> getByHallID (String value){
        List<RowDTO> rowsList = new ArrayList<>();
        Integer intValue = Integer.parseInt(value);
        for (RowDTO rowDTO : getAll()) {
            if(rowDTO.getHallID() == intValue){
                rowsList.add(rowDTO);
            }
        }
        return rowsList;
    }

    @Override
    public void save(RowDTO entity) {
        Row row = BeanMapper.singleMapper(entity, Row.class);
        rowDao.save(row);
    }

    @Override
    public void delete(Integer key) {
        rowDao.deleteOne(key);
    }

    @Override
    public void update(RowDTO entity) {
        Row row = BeanMapper.singleMapper(entity, Row.class);
        rowDao.update(row);
    }
}
