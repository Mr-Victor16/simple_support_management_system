package com.projekt.services;

import com.projekt.models.Status;
import com.projekt.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("statusDetailsService")
public class StatusServiceImpl implements StatusService{
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TicketService ticketService;

    @Override
    public ArrayList<Status> loadAll() {
        return (ArrayList<Status>) statusRepository.findAll();
    }

    @Override
    public Status loadById(Integer id) {
        if(id == null || statusRepository.existsById(id) == false){
            return new Status();
        }

        return statusRepository.getById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return statusRepository.existsById(id);
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public ArrayList<Integer> statusUse() {
        ArrayList<Integer> list = new ArrayList<>();
        List<Status> statuses = statusRepository.findAll();

        for (int i=0; i<statuses.size(); i++){
            list.add(ticketService.countUseStatus(statuses.get(i).getStatusID()));
        }

        return list;
    }

    @Override
    public void delete(Integer id) {
        if(ticketService.countUseStatus(id) == 0 && statusRepository.existsById(id)){
            statusRepository.deleteById(id);
        }
    }


}
