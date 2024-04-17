package com.siddharth.paymentservice.PaymentGateWay;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorPayPayaymentGateway implements PaymentGateway {
    @Value("${razorpay.keyId}")
    private String razorpayKeyId;
    @Value("${razorpay.keySecret}")
    private String razorpayKeySecret;
    @Override
    public String generatePaymentLink(Long orderId, String email, Integer amount) throws RazorpayException, JSONException {

        RazorpayClient razorpay = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
//        paymentLinkRequest.put("accept_partial",true);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1714133480);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Sample Payment Testing");
        JSONObject customer = new JSONObject();
        customer.put("contact","Siddharth");
        customer.put("email",email);
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Payment Testing");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.linkedin.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);


        return payment.toString();

    }
}
