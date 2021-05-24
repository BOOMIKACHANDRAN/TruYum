package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

	static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = new ArrayList<>();
		menuItemList = menuItemDao.getMenuItemListAdmin();
		//System.out.println("Menu Items : ");
		/*for (MenuItem items : menuItemList) {
			System.out.println(items.getName() + " " + items.getPrice() + " " + items.isActive() + " "
					+ items.getDateOfLaunch() + " " + items.getCategory() + " " + items.isFreeDelivery());
		}*/
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));   
		for (MenuItem items : menuItemList) {

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),simple.format(items.getDateOfLaunch()),items.getCategory(),items.isFreeDelivery()));

		}	
	}

	static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemcostomer = new ArrayList<>();
		menuItemcostomer = menuItemDao.getMenuItemListCustomer();
		System.out.println("Menu Items for customer ");
		for (MenuItem i : menuItemcostomer) {
			System.out.println(i.getName());
		}
	}

	static void testModifyMenuItem() throws ParseException {
		try {

			MenuItem menuItem = new MenuItem(105, "Chocolate Brownie", 32.00f, true,
					DateUtil.convertToDate("02/11/2022"), "Dessert", true);

			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			menuItemDao.modifyMenuItem(menuItem);
			if (menuItemDao.getMenuItem(menuItem.getId()).equals(menuItem)) {
				System.out.println("Modification going on");
				/*System.out.println(menuItem.getName() + " " + menuItem.getPrice() + " " + menuItem.isActive() + " "
						+ menuItem.getDateOfLaunch() + " " + menuItem.getCategory() + " " + menuItem.isFreeDelivery());*/
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));   

					System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",menuItem.getName(),menuItem.getPrice(),menuItem.isActive(),simple.format(menuItem.getDateOfLaunch()),menuItem.getCategory(),menuItem.isFreeDelivery()));
				System.out.println("Modification Done");
			}

		} catch (Exception e) {
			
			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	static void testGetMenuItem() {

	}

}
