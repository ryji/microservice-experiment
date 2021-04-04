package com.example.repertory.services;

import com.example.repertory.model.Repertory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepertoryServiceImpl implements RepertoryService {

    @Override
    public Repertory getRepertoryById(Long repertoryId) {
        Repertory repertory = new Repertory();
        repertory.setRepertoryId(repertoryId);
        return repertory;
    }

    @Override
    public List<Repertory> getRepertoryListByIds(List<Long> repertoryIds) {
        List<Repertory> repertoryList = new ArrayList<>();
        for (Long repertoryId : repertoryIds) {
            Repertory repertory = new Repertory();
            repertory.setRepertoryId(repertoryId);
            repertory.setGoodsId(repertoryId);
            repertoryList.add(repertory);
        }
        return repertoryList;
    }

    @Override
    public Boolean deleteRepertoryById(Long repertoryId) {
        return null;
    }

    @Override
    public Repertory updateRepertory(Repertory repertory) {
        return null;
    }

    @Override
    public Repertory addRepertory(Repertory repertory) {
        return null;
    }

}
