package com.imaginnovate.dpe.data.response;

import lombok.Data;

@Data
public class ShipperSellPriceRateInfo {

        private RateTypeRateInfo shipperSellRateMaxRate = new RateTypeRateInfo(0d,0d);

        private RateTypeRateInfo shipperSellRateTargetRate = new RateTypeRateInfo(0d,0d);

        public ShipperSellPriceRateInfo(RateTypeRateInfo shipperSellRateMaxRate, RateTypeRateInfo shipperSellRateTargetRate) {
            super();
            this.shipperSellRateMaxRate = shipperSellRateMaxRate;
            this.shipperSellRateTargetRate = shipperSellRateTargetRate;
        }
    }

