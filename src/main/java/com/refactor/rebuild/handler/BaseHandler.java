package com.refactor.rebuild.handler;

import com.refactor.rebuild.vo.RentalVo;

public interface BaseHandler {
    double getTotalAmount(RentalVo.RentalInfo rentalInfo);

    int getFrequentPoints(RentalVo.RentalInfo rentalInfo);
}
