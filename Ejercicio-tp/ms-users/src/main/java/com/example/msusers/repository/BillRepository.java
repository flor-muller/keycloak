package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillRepository {
    private IFeignBillRepository iFeignBillRepository;

    public BillRepository(IFeignBillRepository iFeignBillRepository) {
        this.iFeignBillRepository= iFeignBillRepository;
    }

    public List<Bill> findByUserId(String userId) {
        ResponseEntity<List<Bill>> response = iFeignBillRepository.getBillByUserId(userId);
        return response.getBody();
    }
}
