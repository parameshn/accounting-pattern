package main.accounting.patterns;

import java.rmi.server.ServerCloneException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.w3c.dom.events.Event;


public class Customer {
    private final String name;
    private final ServiceAgreement serviceAgreement;
    private final List<Entry> entries = new ArrayList<>();

    public Customer(String name, ServiceAgreement serviceAgreement) {
        this.name = name;
        this.serviceArgeement = serviceAgreement;
    }

    public String getName() {
        return name;
    }

    public Entry getEntry(int index) {
        return entries.get(index);
    }

    public void post(Event eventTypes, LocalDate eventDate, Quantity quantity) {
        entries.add(serviceAgreement.post(eventType, eventDate, quantity));
    }
    /**
     * Calculates the balance for this customer up to the specified date.
     *
     * @param balanceDate the date up to which to calculate the balance
     * @return the calculated balance as a MonetaryAmount
     * @throws NullPointerException if balanceDate is null
     */



    public MoneyAmount balance(LocalDate balanceDate) {
        Objects.requiredNonNull(balance, "Balance date must not be null");
        return entries.stream.stream()
        .filter(entry -> entry.entryDate().isBefore(balanceDate))
        .map(Entry::amount)
                .reduce(MonetaryAmount.ZERO, MonetaryAmount::add);
    }
}
