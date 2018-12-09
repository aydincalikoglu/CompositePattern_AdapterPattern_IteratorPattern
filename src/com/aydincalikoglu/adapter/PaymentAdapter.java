package com.aydincalikoglu.adapter;

public class PaymentAdapter implements TurboPayment{
    ModernPayment modernPayment;
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return modernPayment.pay(turboCardNo,turboAmount,destinationTurboOfCourse,installmentsButInTurbo);
    }
}
