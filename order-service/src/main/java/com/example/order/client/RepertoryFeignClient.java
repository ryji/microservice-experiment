package com.example.order.client;

import com.example.order.model.Repertory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "repertory-srv", fallback = RepertoryFeignClientFallback.class)
public interface RepertoryFeignClient {

    @GetMapping("/v1/repertory/{id}")
    Repertory getRepertory(@PathVariable(value = "id") Long id);

    @PostMapping("/v1/repertory/ids")
    List<Repertory> getRepertoryList(@RequestBody List<Long> ids);

}
