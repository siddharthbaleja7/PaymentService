package com.siddharth.paymentservice.Service;

import com.razorpay.RazorpayException;
import com.siddharth.paymentservice.PaymentGateWay.PaymentGateway;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    PaymentService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    public String initiatePayment(Long orderId, String email, Integer amount) throws RazorpayException, JSONException {

        System.out.println("Initiating payment");
        return paymentGateway.generatePaymentLink(orderId, email, amount);
    }



}
