package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static ArrayList<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() throws ParseException {
		super();
		if (menuItemList == null || menuItemList.isEmpty()) {
			menuItemList = new ArrayList<>();
			MenuItem mobj1 = new MenuItem(101, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true);
			menuItemList.add(mobj1);
			MenuItem mobj2 = new MenuItem(102, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false);
			menuItemList.add(mobj2);
			MenuItem mobj3 = new MenuItem(103, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false);
			menuItemList.add(mobj3);
			MenuItem mobj4 = new MenuItem(104, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true);
			menuItemList.add(mobj4);
			MenuItem mobj5 = new MenuItem(105, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true);
			menuItemList.add(mobj5);
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemcostomer = new ArrayList<>();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date1 = formatter.format(date);
		Date currentDate = null;
		try {
			currentDate = formatter.parse(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (MenuItem i : menuItemList) {
			if (((currentDate.compareTo(i.getDateOfLaunch()) == 0) || (currentDate.compareTo(i.getDateOfLaunch()) < 0))
					&& (i.isActive())) {
				menuItemcostomer.add(i);
			}
		}
		return menuItemcostomer;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem x : menuItemList) {
			if (x.equals(menuItem)) {
				x.setName(menuItem.getName());
				x.setActive(menuItem.isActive());
				x.setPrice(menuItem.getPrice());
				x.setDateOfLaunch(menuItem.getDateOfLaunch());
				x.setCategory(menuItem.getCategory());
				x.setFreeDelivery(menuItem.isFreeDelivery());

			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem x : menuItemList) {
			if (x.getId()==menuItemId) {
				return x;
			}
		}
			return null;		
	}
}

