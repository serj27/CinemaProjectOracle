package service.impl;

import dao.api.Dao;
import dao.impl.DaoFactory;
import dto.TicketsDTO;
import mapper.BeanMapper;
import model.Tickets;
import service.api.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serj27 on 18.07.2016.
 */
public class TicketsServiceImpl implements Service<Integer, TicketsDTO> {

    private static TicketsServiceImpl service;
    private Dao<Integer, Tickets> ticketsDao;

    private TicketsServiceImpl() {
        ticketsDao = DaoFactory.getInstance().getTicketsDao();
    }

    public static synchronized TicketsServiceImpl getInstance() {
        if (service == null) {
            service = new TicketsServiceImpl();
        }
        return service;
    }

    @Override
    public List<TicketsDTO> getAll() {
        List<Tickets> ticketsList = ticketsDao.findAll();
        return BeanMapper.listMapToList(ticketsList, TicketsDTO.class);
    }

    @Override
    public TicketsDTO getById(Integer id) {
        Tickets tickets = ticketsDao.findOne(id);
        return BeanMapper.singleMapper(tickets, TicketsDTO.class);
    }

    @Override
    public void save(TicketsDTO entity) {
        Tickets tickets = BeanMapper.singleMapper(entity, Tickets.class);
        ticketsDao.save(tickets);
    }

    public List<TicketsDTO> getByUserID (String value){
        List<TicketsDTO> ticketsDTOs = new ArrayList<>();
        Integer intValue = Integer.parseInt(value);
        for (TicketsDTO ticketsDTO : getAll()) {
            if(ticketsDTO.getUserID() == intValue){
                ticketsDTOs.add(ticketsDTO);
            }
        }
        return ticketsDTOs;
    }

    @Override
    public void delete(Integer key) {
        ticketsDao.deleteOne(key);
    }

    @Override
    public void update(TicketsDTO entity) {
        Tickets tickets = BeanMapper.singleMapper(entity, Tickets.class);
        ticketsDao.update(tickets);
    }
}
