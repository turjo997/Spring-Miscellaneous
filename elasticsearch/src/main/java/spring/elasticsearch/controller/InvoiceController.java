package spring.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.elasticsearch.model.Invoice;
import spring.elasticsearch.repo.InvoiceRepo;


import java.io.IOException;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceRepo repo;

    @GetMapping("/")
    public String viewHomePage(Model model){
        return "home";
    }

    @GetMapping("/listInvoice")
    public String viewListInvoicePage(Model model) throws IOException {
        model.addAttribute("listInvoiceDocuments" , repo.getAllInvoices());
        return "listInvoice";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) throws IOException {
        repo.createOrUpdateInvoice(invoice);
        return "redirect:/listInvoice";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) throws IOException {
        Invoice invoice = repo.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "updateInvoice";
    }

    @GetMapping("/showNewInvoiceForm")
    public String showNewInvoiceForm(Model model) throws IOException {
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "addInvoice";
    }

    @GetMapping("/deleteInvoice/{id}")
    public String deleteInvoiceById(@PathVariable(value = "id")  String id) throws IOException {
        this.repo.deleteInvoiceById(id);
        return "redirect:/listInvoice";
    }
}
