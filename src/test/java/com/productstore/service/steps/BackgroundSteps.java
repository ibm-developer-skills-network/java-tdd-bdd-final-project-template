package com.productstore.service.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.productstore.service.model.Product;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class BackgroundSteps {
    private final String baseUrl = "http://localhost:8080";
    private final RestTemplate restTemplate = new RestTemplate();

    @Given("the following products")
    public void theFollowingProducts(DataTable dataTable) {
        // Delete all existing products first
        restTemplate.delete(baseUrl + "/products");
        
        // Extract rows from data table
        List<Map<String, String>> rows = dataTable.asMaps();
        
        // For each row, create a product and send POST request
        for (Map<String, String> row : rows) {
            // Create product object from row data
            Product product = new Product();
            product.setName(row.get("name"));
            product.setDescription(row.get("description"));
            product.setPrice(new BigDecimal(row.get("price")));
            product.setAvailable(Boolean.parseBoolean(row.get("available")));
            product.setCategory(Product.Category.valueOf(row.get("category")));
            
            // Send POST request
            ResponseEntity<Product> response = restTemplate.postForEntity(
                    baseUrl + "/products", 
                    product, 
                    Product.class);
            
            // Verify response
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        }
    }
}
