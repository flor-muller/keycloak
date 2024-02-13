package com.example.msusers.repository;

import com.example.msusers.configuration.feign.FeignInterceptor;
import com.example.msusers.domain.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name= "ms-bill",url = "http://localhost:8082", configuration = FeignInterceptor.class)
public interface IFeignBillRepository {
    @RequestMapping(method = RequestMethod.GET, value = "/bills/byuserid/{userId}")
    ResponseEntity<List<Bill>> getBillByUserId(@PathVariable String userId);
}
