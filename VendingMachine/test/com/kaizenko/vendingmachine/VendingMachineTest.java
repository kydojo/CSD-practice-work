package com.kaizenko.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class VendingMachineTest {
	
	VendingMachine vendingMachine; 
	
	// Use this test fixture to create a fresh state before each test case
	@BeforeEach
	public void setup() {
		//injected this to remove coupling
		PaymentProcessor paymentProcessor = new CoinPaymentProcessor();
		vendingMachine = new VendingMachine(paymentProcessor);
	}

	
	
	@Test
	void displayMessage_WhenPurchaseExceedInventoryWithQuickShipment_ExpectCheckBackMessage() {
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();
		
		String msg = vendingMachine.displayMessage();
		
		assertEquals("Please check back soon", msg);
	}
	

	@Test
	void releaseChange_WhenNoMoneyIsInserted_Expect0() {
		//arrange
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(0, change);
	}
	
	@Test
	void releaseChange_When25cIsInserted_Expect25c() {
		//arrange
		vendingMachine.insertCoin();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(25, change);
	}
	
	@Test
	void releaseChange_When50cIsInserted_Expect50c() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(50, change);
	}
	
	@Test
	void buyProduct_WhenNoMoneyInserted_ExpectNoProduct() {
		//arrange
		//act
		Product product = vendingMachine.buyProduct();
		//assert
		assertNull(product);
	}
	
	//updated with Mockito mock
	@Test
	void buyProduct_WhenCorrectAmountInserted_ExpectProduct() {
		when(mockedList.get(0)).thenReturn("first");
		
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		//act
		Product product = vendingMachine.buyProduct();
		//assert
		assertNotNull(product);
	}
	
	@Test
	void buyProduct_WhenNotEnoughAmountInserted_ExpectNoProduct() {
		vendingMachine.insertCoin();
		Product product = vendingMachine.buyProduct();
		assertNull(product);
	}
	
	@Test
	void buyProduct_WhenMoreThanEnoughAmountInserted_ExpectProduct() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		//act
		Product product = vendingMachine.buyProduct();
		//assert
		assertNotNull(product);
	}
	
	@Test
	void releaseChange_WhenProductPurchasedWithMoreThanEnoughAmount_ExpectChange() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(25, change);
	}
	
	@Test
	void releaseChange_WhenProductPurchasedWithExactAmount_ExpectNoChange() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(0, change);
	}
	
	@Test
	void releaseChange_WhenProductPurchasedWithLessThanEnoughAmount_ExpectChange() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(25, change);
	}
	
	@Test
	void releaseChange_WhenProductPurchasedNoAmount_ExpectNoChange() {
		//arrange
		vendingMachine.buyProduct();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(0, change);
	}
	
	@Test
	void releaseChange_WhenChangeIsAlreadyReleased_ExpectNoChange() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.releaseChange();
		//act
		int change = vendingMachine.releaseChange();
		//assert
		assertEquals(0, change);
	}
	
	@Test
	void buyProduct_WhenProductAlreadyPurchasedWithExactAmount_ExpectNoProduct() {
		//arrange
		vendingMachine.insertCoin();
		vendingMachine.insertCoin();
		vendingMachine.buyProduct();
		//act
		Product product = vendingMachine.buyProduct();
		//assert
		assertNull(product);
	}
	
	

}
