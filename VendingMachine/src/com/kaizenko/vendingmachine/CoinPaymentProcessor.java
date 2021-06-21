package com.kaizenko.vendingmachine;

//import static org.mockito.Mockito.*;

public class CoinPaymentProcessor implements PaymentProcessor {
	//void makePayment(int amount)
	//void processPayment(int price)
	//void cleanPayment()
	//boolean isPaymentMade(int price)
	//int getPayment()
	
	private int balance = 0;
	
	public CoinPaymentProcessor() {
		
	}
	
	@Override
	public void makePayment(int amount) {
		this.balance = balance + amount;
	}
	
	@Override
	public void processPayment(int amount) {
		balance = balance - amount;
	}
	
	@Override
	public void clearPayment() {
		//make a call to a paymentWebService
		//get back days that a refill for change is going to happen
		balance = 0;
		
	}
	
	@Override
	public boolean isPaymentMade(int amount) {
		return balance >= amount;
	}
	
	@Override
	public int getPayment() {
		return balance;
	}
}
