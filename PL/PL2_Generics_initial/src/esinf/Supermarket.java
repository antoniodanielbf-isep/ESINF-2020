/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 * @author DEI-ISEP
 */
public class Supermarket {
    Map<Invoice, Set<Product>> m;

    Supermarket() {
        m = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception {
        Invoice i = null;
        Product p = null;
        Set<Product> sp = null;
        for (String s : l) {
            String[] it = s.split(",");
            switch (it[0]) {
                case "I":
                    i = new Invoice(it[1], it[2]);
                    sp = new TreeSet<>();
                    m.put(i, sp);
                    break;
                case "P":
                    p = new Product(it[1], Integer.parseInt(it[2]), Long.parseLong(it[3]));
                    sp.add(p);
                    break;
                default:
                    throw new Exception("Invoice Line Unrecognized");
            }
        }
    }

    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> result = new HashMap<>();
        for (Map.Entry<Invoice, Set<Product>> encomenda : m.entrySet()) {
            result.put(encomenda.getKey(), encomenda.getValue().size());
        }
        return result;
    }


    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> invoices = new HashSet<>();
        for (Map.Entry<Invoice, Set<Product>> encomenda : m.entrySet()) {
            if (encomenda.getKey().getDate().compareTo(d2) < 0 && encomenda.getKey().getDate().compareTo(d1) > 0) {
                invoices.add(encomenda.getKey());
            }
        }
        return invoices;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long result = 0;
        for (Map.Entry<Invoice, Set<Product>> encomenda : m.entrySet()) {
            for (Product produto : encomenda.getValue()) {
                if (produto.getIdentification().equalsIgnoreCase(productId)) {
                    result += (produto.getPrice() * produto.getQuantity());
                }
            }
        }
        return result;
    }

    // converts a map of invoices and products to a map which key is a product
    // identification and the values are a set of the invoice references 
    // in which it appearss
    Map<String, Set<Invoice>> convertInvoices() {
        Map<String, Set<Invoice>> result = new HashMap<>();
        Set<Invoice> invoices = null;
        for (Invoice i : m.keySet()) {
            for (Product p : m.get(i)) {
                if (!result.containsKey(p.getIdentification())) {
                    invoices = new TreeSet<>();
                    result.put(p.getIdentification(), invoices);
                } else {
                    invoices = result.get(p.getIdentification());
                }
                invoices.add(i);
            }
        }
        return result;
    }
}
