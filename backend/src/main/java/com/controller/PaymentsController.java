package com.hotelhub.controller;
import java.util.HashMap;
import java.util.Map;

import com.hotelhub.model.Payments;
import com.hotelhub.service.PaymentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    private final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    // ✅ Get all payments
    @GetMapping
    public List<Payments> getAllPayments() {
        return paymentsService.getAllPayments();
    }

    // ✅ Get a payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable int id) {
        Payments payment = paymentsService.getPaymentById(id);
        return payment != null ? ResponseEntity.ok(payment) : ResponseEntity.notFound().build();
    }

    // ✅ Add a new payment
    @PostMapping
    public ResponseEntity<Map<String, String>> addPayment(@RequestBody Payments payment) {
        System.out.println("👉 Received Payment: " + payment.getAmount() + ", Method: " + payment.getPaymentMethod());
    
        int result = paymentsService.addPayment(payment);
        
        Map<String, String> response = new HashMap<>();
        if (result > 0) {
            response.put("message", "Payment added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Failed to add payment");
            return ResponseEntity.badRequest().body(response);
        }
    }
    

    // ✅ Update payment details
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable int id, @RequestBody Payments payment) {
        payment.setPaymentId(id);
        int result = paymentsService.updatePayment(payment);
        return result > 0 ? ResponseEntity.ok("Payment updated successfully") : ResponseEntity.notFound().build();
    }

    // ✅ Delete a payment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        int result = paymentsService.deletePayment(id);
        return result > 0 ? ResponseEntity.ok("Payment deleted successfully") : ResponseEntity.notFound().build();
    }
}

