package com.example.order.client;

import com.example.order.model.Repertory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RepertoryRestTemplateClient {

    private static String getRepertoryByIdUrl = "http://repertory-srv/v1/repertory/{id}";

    private static String getRepertoryListByIdsUrl = "http://repertory-srv/v1/repertory/ids";

    @Autowired
    RestTemplate restTemplate;

    public Repertory getRepertory(@PathVariable(value = "id") Long id){
        ResponseEntity<Repertory> restExchange = restTemplate.getForEntity(
                getRepertoryByIdUrl,
                Repertory.class,
                id);
        return restExchange.getBody();
    }

    public List<Repertory> getRepertoryList(@RequestBody List<Long> ids){


        ResponseEntity<List<Repertory>> restExchange = restTemplate.exchange(
                getRepertoryListByIdsUrl,
                HttpMethod.POST,
                // httpEntity is used to store body and http headers
                new HttpEntity<>(ids),
                // result is list: should use ParameterizedTypeReference
                new ParameterizedTypeReference<List<Repertory>>(){}
                );
        return restExchange.getBody();
    }

}
