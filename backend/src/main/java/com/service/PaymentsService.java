package com.hotelhub.service;
import java.sql.Timestamp;


import com.hotelhub.dao.PaymentsDAO;
import com.hotelhub.model.Payments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {
    private final PaymentsDAO paymentsDAO;

    public PaymentsService(PaymentsDAO paymentsDAO) {
        this.paymentsDAO = paymentsDAO;
    }

    public int addPayment(Payments payment) {
        payment.setPaymentDate(new Timestamp(System.currentTimeMillis())); // 👈 set current time
        return paymentsDAO.savePayment(payment);
    }
    

    public List<Payments> getAllPayments() {
        return paymentsDAO.getAllPayments();
    }

    public Payments getPaymentById(int paymentId) {
        return paymentsDAO.getPaymentById(paymentId);
    }

    public int updatePayment(Payments payment) {
        return paymentsDAO.updatePayment(payment);
    }

    public int deletePayment(int paymentId) {
        return paymentsDAO.deletePayment(paymentId);
    }
}

