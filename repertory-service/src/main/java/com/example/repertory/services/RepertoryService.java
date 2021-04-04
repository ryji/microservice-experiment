package com.example.repertory.services;

import com.example.repertory.model.Repertory;

import java.util.List;

public interface RepertoryService {

    Repertory getRepertoryById(Long repertoryId);

    List<Repertory> getRepertoryListByIds(List<Long> repertoryIds);

    Boolean deleteRepertoryById(Long repertoryId);

    Repertory updateRepertory(Repertory repertory);

    Repertory addRepertory(Repertory repertory);

    //public boolean subtractRepertory(List<Repertory> repertoryList);
}
