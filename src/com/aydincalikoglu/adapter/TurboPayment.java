package com.aydincalikoglu.adapter;

public interface TurboPayment {
    int payInTurbo(String turboCardNo, float turboAmount,
                   String destinationTurboOfCourse, String installmentsButInTurbo);
}
