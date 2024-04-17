package com.siddharth.paymentservice.PaymentGateWay;

import com.razorpay.RazorpayException;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface PaymentGateway {
    public String generatePaymentLink(Long orderId, String email, Integer amount) throws RazorpayException, JSONException ;

}
