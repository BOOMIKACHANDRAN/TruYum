package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void main(String[] args) {

		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
	}

	public static void testAddCartItem() {

		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, (long) 101);

		try {
			ArrayList<MenuItem> cartlist = cartDao.getAllCartItems(1);
			System.out.println("Items added to cart");
			System.out.println("Name  Price  Active  Date Of Launch  Category  Free Delivery");
			for (MenuItem x : cartlist) {
				System.out.println(x.getName() + " " + x.getPrice() + " " + x.isActive() + " " + x.getDateOfLaunch()
						+ " " + x.getCategory() + " " + x.isFreeDelivery());
			}

		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testGetAllCartItems() {

		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("");
		try {
			ArrayList<MenuItem> cartlist = cartDao.getAllCartItems(1);
			System.out.println("Name  Price  Active  Date Of Launch  Category  Free Delivery");
			for (MenuItem x : cartlist) {
				System.out.println(x.getName() + " " + x.getPrice() + " " + x.isActive() + " " + x.getDateOfLaunch()
						+ " " + x.getCategory() + " " + x.isFreeDelivery());
			}

		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem((long) 1, (long) 101);
		try {
			System.out.println("Cart Item Removed");
			ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems((long) 1);
			if (cartLefts.isEmpty()){
				throw new CartEmptyException();
			} else {
				for (MenuItem item : cartLefts) {
					System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n", item.getName(),
							item.getPrice(), item.isActive(), item.getDateOfLaunch(), item.getCategory(),
							item.isFreeDelivery()));
				}
			}
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

}
