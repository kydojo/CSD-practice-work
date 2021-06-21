package com.kaizenko.vendingmachine;

public interface PaymentProcessor {

	void makePayment(int amount);

	void processPayment(int amount);

	void clearPayment();

	boolean isPaymentMade(int amount);

	int getPayment();

}