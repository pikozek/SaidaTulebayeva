package com.example.projectOneJDBC;

import com.example.projectOneJDBC.dto.Order;
import com.example.projectOneJDBC.dto.Product;
import com.example.projectOneJDBC.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ProjectOneJdbcApplication{

	private static final Logger logger = LoggerFactory.getLogger(ProjectOneJdbcApplication.class.getName());

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProjectOneJdbcApplication.class, args);

		AppService appService = context.getBean(AppService.class);

		List<User> users = appService.findAllUsers();
		List<Order> orders = appService.findAllOrders();
		List<Product> products = appService.findAllProducts();

		printOrders(orders);
		printProducts(products);
		printUsers(users);


	}

	public static void printUsers(List<User> users){
		if (!users.isEmpty()) {
			String tableFormat = "%-5s | %-20s | %-20s%n";

			logger.info(String.format(tableFormat, "ID", "Name", "Order List"));

			users.forEach(u ->{
				logger.info(String.format(tableFormat, u.getId(), u.getName(), u.getOrders()));
			});
		} else {
			logger.info("No users found.");
		}
	}
	public static void printOrders(List<Order> orders){
		if(!orders.isEmpty()){
			String tableFormat = "%-5s | %-20s | %-20s%n";

			logger.info(String.format(tableFormat, "ID", "UserID", "Product List"));

			orders.forEach(o ->{
				logger.info(String.format(tableFormat, o.getId(), o.getUserID(), o.getProductList()));
			});
		}else {
			logger.info("No orders found.");
		}
	}
	public static void printProducts(List<Product> products){
		if(!products.isEmpty()){
			String tableFormat = "%-5s | %-20s | %-20s%n";

			logger.info(String.format(tableFormat, "ID", "name", "price"));

			products.forEach(p ->{
				logger.info(String.format(tableFormat, p.getId(), p.getProductName(), p.getPrice()));
			});
		}else {
			logger.info("No products found.");
		}
	}
}
