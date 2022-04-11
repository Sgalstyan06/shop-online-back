package com.fshop.fashionshop.validation.commons;

import com.fshop.fashionshop.model.commons.Stock;

public final class StockValidator {
    public static boolean validateStock(Stock stock) {
        if (stock.getCount() < 0) return false;
//        stock.setIsAvailable(stock.getCount() > 0);
        return true;
    }
}
