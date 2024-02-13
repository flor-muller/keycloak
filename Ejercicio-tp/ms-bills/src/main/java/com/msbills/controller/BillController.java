package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/byuserid/{userId}")
    public ResponseEntity<List<Bill>> getBillByUserId(@PathVariable String userId) {
        return ResponseEntity.ok().body(service.findBillByUserId(userId));
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('GROUP_providers')")
    ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        return ResponseEntity.ok().body(service.saveBill(bill));
    }

}
