package za.ac.cput.service;


import za.ac.cput.entity.Payment;

import java.util.List;

public interface PaymentService extends IService<Payment, String>{
    public List<Payment> findAll();

}
