package com.spring.file_operations.repository;

import com.spring.file_operations.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
public class CustomInvoiceRepositoryImpl {

    //implements InvoiceRepositor
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Invoice> saveAll(List<Invoice> invoices) {
//        String sql = "INSERT INTO invoice (name, amount, number, received_date) VALUES ";
//        StringBuilder values = new StringBuilder();
//
//        for (int i = 0; i < invoices.size(); i++) {
//            values.append("(:name").append(i).append(", :amount").append(i).append(", :number").append(i).append(", :receivedDate").append(i).append(")");
//
//            if (i < invoices.size() - 1) {
//                values.append(", ");
//            }
//        }
//
//        Query query = entityManager.createNativeQuery(sql + values);
//
//        for (int i = 0; i < invoices.size(); i++) {
//            Invoice invoice = invoices.get(i);
//            query.setParameter("name" + i, invoice.getName());
//            query.setParameter("amount" + i, invoice.getAmount());
//            query.setParameter("number" + i, invoice.getNumber());
//            query.setParameter("receivedDate" + i, invoice.getReceivedDate());
//        }
//
//        query.executeUpdate();
//        return invoices;
//    }
}
