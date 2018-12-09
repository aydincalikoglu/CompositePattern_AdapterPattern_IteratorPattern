package com.aydincalikoglu.adapter.impl;

import com.aydincalikoglu.adapter.ModernPayment;

public class ModernPaymentImpl implements ModernPayment {
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("Modern Paid");
        return 0;
    }
}
