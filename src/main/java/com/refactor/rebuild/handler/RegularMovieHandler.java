package com.refactor.rebuild.handler;


import com.refactor.rebuild.entity.BaseUnit;
import com.refactor.rebuild.vo.RentalVo;

public class RegularMovieHandler extends BaseUnit implements BaseHandler {
    static {
        baseCost = 2;

        baseDay = 2;

        extraDayBase = 1.5;

        eranPoint = 1;
    }

    @Override
    public double getTotalAmount(RentalVo.RentalInfo rentalInfo) {
        double amount = baseCost;
        if (rentalInfo.getRentDay() > baseDay) {
            amount += (rentalInfo.getRentDay() - 2) * extraDayBase;
        }
        return amount;
    }

    @Override
    public int getFrequentPoints(RentalVo.RentalInfo rentalInfo) {
        return eranPoint;
    }
}
