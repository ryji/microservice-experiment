package com.example.order.client;

import com.example.order.model.Repertory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepertoryFeignClientFallback implements RepertoryFeignClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepertoryFeignClientFallback.class);

    @Override
    public Repertory getRepertory(Long id) {
        LOGGER.error("fail to getRepertory");
        Repertory repertory = new Repertory();
        repertory.setGoodsId(Long.MIN_VALUE);
        return repertory;
    }

    @Override
    public List<Repertory> getRepertoryList(List<Long> ids) {
        LOGGER.error("fail to getRepertoryList");
        return ids.stream().map(id -> {
            Repertory repertory = new Repertory();
            repertory.setGoodsId(Long.MIN_VALUE);
            return repertory;
        }).collect(Collectors.toList());
    }
}
