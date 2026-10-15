package accounting.patterns;

import java.math.BigDecimal;
import java.util.Objects;

/*
This implementation calculates a fixed annual service fee and 
creates an accounting entry with the specified EntryType
*/

public record AnnualServiceFeeRule(
        EntryType entryType,
        long annualFee) implements PostingRule {

    public AnnualServiceFeeRule {
        Objects.requireNonNull(entryType, "Entry type must not be null");

        if (annualFee < 0) {
            throw new IllegalArgumentException(
                    "Annual fee cannot be negative: " + annualFee);
        }
    }

    @Override
    public MonetaryAmount calculateAmount(
            Quantity quantity,
            BigDecimal rate) {

        Objects.requireNonNull(quantity, "Quantity must not be null");
        Objects.requireNonNull(rate, "Rate must not be null");

        return MonetaryAmount.of("USD", annualFee);
    }
}