package com.aydincalikoglu.adapter;

/**
 * Adapter
 * Ara bir sınıf yazılarak gerekli değişim sağlanır
 */
public class PaymentAdapter implements TurboPayment{
    ModernPayment modernPayment;
    @Override
    public int payInTurbo(String turboCardNo, float turboAmount, String destinationTurboOfCourse, String installmentsButInTurbo) {
        return modernPayment.pay(turboCardNo,turboAmount,destinationTurboOfCourse,installmentsButInTurbo);
    }
}
