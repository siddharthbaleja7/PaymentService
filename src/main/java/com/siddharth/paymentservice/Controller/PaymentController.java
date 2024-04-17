package com.siddharth.paymentservice.Controller;

import com.razorpay.RazorpayException;
import com.siddharth.paymentservice.Service.PaymentService;
import com.siddharth.paymentservice.dtos.InitiatePaymentDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }


    @PostMapping("/initiate")
    public String initiatePayment(@RequestBody InitiatePaymentDto initiatePaymentRequestDto) throws RazorpayException {
        return  paymentService.initiatePayment(
                initiatePaymentRequestDto.getOrderId(),
                initiatePaymentRequestDto.getEmail(),
                initiatePaymentRequestDto.getAmount()
        );


    }

}
