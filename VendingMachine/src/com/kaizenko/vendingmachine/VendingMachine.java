package com.kaizenko.vendingmachine;

public class VendingMachine {
	//this is tightly coupled to a specific implementation - want to code to an abstraction
	//	PaymentProcessor paymentProcessor = new CoinPaymentProcessor();
	PaymentProcessor paymentProcessor;
	InventoryWebService inventoryWebService = new InventoryWebService();
	int inventory = 5;
	String msg;
	
	public VendingMachine(PaymentProcessor paymentProcessor) {
		this.paymentProcessor = paymentProcessor;
	}
	
	public int releaseChange() {
		int change = paymentProcessor.getPayment();
		paymentProcessor.clearPayment();
		return change;
	}

	public void insertCoin() {
//		balance += 25;
		paymentProcessor.makePayment(25);
	}

	public Product buyProduct() {
		if(paymentProcessor.isPaymentMade(50)) {
			if(inventory > 0) {
				paymentProcessor.processPayment(50);
				inventory = inventory - 1;
				if(inventory < 5) {
//					inventoryWebService.refullRequest();
				}
				return new Product();
			}
			else {
				int days = inventoryWebService.getDeliveryDateInDays();
				if(days < 2) {
					msg = "Please check back soon";
				}
				else {
					msg = "Sorry, out of stock";
				}
			}
		}

		return null;

	}
	
	public String displayMessage() {
		return msg;
	}
}


