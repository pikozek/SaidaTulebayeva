package org.example;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
        private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

        public static void printTable(List<String> data) {
                int maxLength = data.stream()
                                .mapToInt(String::length)
                                .max()
                                .orElse(0);

                String horizontalLine = "+-" + "-".repeat(maxLength) + "-+";

                logger.info(horizontalLine);
                data.forEach(row -> logger.info("| " + String.format("%-" + maxLength + "s", row) + " |"));
                logger.info(horizontalLine);
        }

        public static void main(String[] args) {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
                MyService myService = context.getBean(MyService.class);
                List<Order> orders = new ArrayList<>();
                List<Product> products = new ArrayList<>();

                User user = User.builder()
                                .id(1)
                                .name("Pikozek")
                                .build();
                Order order = Order.builder()
                                .id(1)
                                .orderId("Order-1")
                                .user(user)
                                .build();
                orders.add(order);
                user.setOrders(orders);
                Product product = Product.builder()
                                .id(1)
                                .name("Cake")
                                .price(8000)
                                .build();
                Product product1 = Product.builder()
                                .id(2)
                                .name("Cupcake")
                                .price(500)
                                .build();
                products.add(product);
                products.add(product1);
                order.setProducts(products);
                myService.saveUser(user);
                myService.saveProducts(products);
                myService.saveOrders(orders);

                List<String> tableOfUsers = retrieveDataFromDatabase("users");
                List<String> tableOfOrders = retrieveDataFromDatabase("orders");
                List<String> tableOfProducts = retrieveDataFromDatabase("products");

                printTable(tableOfUsers);
                printTable(tableOfOrders);
                printTable(tableOfProducts);

        }

        public static List<String> retrieveDataFromDatabase(String name) {
                List<String> tableData = new ArrayList<>();

                try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/firstDB",
                                "postgres", "12345");
                                Statement statement = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + name)) {

                        while (resultSet.next()) {
                                String data = resultSet.getString("name");
                                tableData.add(data);
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return tableData;
        }
}
