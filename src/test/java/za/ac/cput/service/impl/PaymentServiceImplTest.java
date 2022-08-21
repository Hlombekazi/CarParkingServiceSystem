package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PaymentServiceImplTest {
    public static PaymentServiceImpl paymentService ;
    Payment payment = PaymentFactory.createPayment(50.78 , "245016444");


    @Test
    void b_create() {
        Payment created = this.paymentService.create(payment);
        assertNotNull(created);
        System.out.println("Create : " + created);
    }

    @Test
    void d_read() {
        Payment save =this.paymentService.update(payment);
        String read = paymentService.findById(
                payment.getPaymentID());
        assertNotNull(read);
        System.out.println("Read reservation: " + read);
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment).build();
        assertNull(paymentService.create(updated));
        System.out.println("Update : " + updated);
    }

    @Test
    void e_delete() {
        Payment delete = this.paymentService.create(payment);

        paymentService.delete(String.valueOf(delete));

    }
}