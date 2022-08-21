package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.PaymentService;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private IPaymentRepository repository;

    private PaymentServiceImpl(IPaymentRepository repository){
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String s) {
        return (Payment) this.repository.findById(s).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        if(this.repository.existsById(payment.getPaymentID())){
            return this.repository.save(payment);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    public String findById(String paymentID) {
        return paymentID;
    }

    @Override
    public List<Payment> findAll() {
        return null;
    }
}
