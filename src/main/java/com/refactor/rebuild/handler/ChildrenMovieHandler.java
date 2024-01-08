package com.refactor.rebuild.handler;

import com.refactor.rebuild.vo.RentalVo;
import com.lux.movie.thinking.entity.BaseUnit;

public class ChildrenMovieHandler extends BaseUnit implements BaseHandler {
    static {
        baseCost = 1.5;

        baseDay = 3;

        extraDayBase = 1.5;

        eranPoint = 1;
    }

    @Override
    public double getTotalAmount(RentalVo.RentalInfo rentalInfo) {
        double amount = baseCost;
        if (rentalInfo.getRentDay() > baseDay) {
            amount += (rentalInfo.getRentDay() - baseDay) * extraDayBase;
        }
        return amount;
    }

    @Override
    public int getFrequentPoints(RentalVo.RentalInfo rentalInfo) {
        return eranPoint;
    }
}
