package main.currency;

import main.beans.Discount;
import main.exceptions.EmptyFieldException;
import main.exceptions.ExceptionMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyManager {

    public static BigDecimal getPriceAfterDiscount(double price, int discount) {
        if (discount <= 0) {
            return new BigDecimal(price);
        }
        double disAmount = price * discount / 100;
        price = price - disAmount;

        return new BigDecimal(price).setScale(2, RoundingMode.UP);

    }

    /**
     * takes in price and discount objects and returns BigDecimal <br>
     * representing price after discount calculation.
     *
     * @param price
     * @param discount
     * @return
     * @throws EmptyFieldException if price is null
     */
    public static BigDecimal getPriceAfterDiscount(BigDecimal price, Discount discount) throws EmptyFieldException {
        if (discount == null) {
            discount = new Discount();
        }
        if (price == null) {
            throw new EmptyFieldException(ExceptionMessage.GENERALEMPTYFIELD.getValue());
        }
        BigDecimal toSubtract = price.multiply(new BigDecimal(discount.getDiscountRate())).divide(new BigDecimal(100),
                2, RoundingMode.UP);

        return price.subtract(toSubtract).setScale(2, RoundingMode.UP);
    }

    public static BigDecimal getDiscountAmount(BigDecimal price, Discount discount) throws EmptyFieldException {
        if (price == null) {
            throw new EmptyFieldException(ExceptionMessage.GENERALEMPTYFIELD.getValue());
        }
        if (discount == null) {
            discount = new Discount();
        }

        return price.multiply(new BigDecimal(discount.getDiscountRate())).divide(new BigDecimal(100), 2,
                RoundingMode.UP);
    }

    public static BigDecimal getVendorProfitAfterCommission(BigDecimal price, Integer commission) {

        return price.subtract(price.multiply(new BigDecimal(commission)).divide(new BigDecimal(100))).setScale(2,
                RoundingMode.UP);

    }

    public static BigDecimal getStoreCommisionProfit(BigDecimal price, Integer commission) {

        return price.multiply(new BigDecimal(commission)).divide(new BigDecimal(100)).setScale(2, RoundingMode.DOWN);

    }
}
