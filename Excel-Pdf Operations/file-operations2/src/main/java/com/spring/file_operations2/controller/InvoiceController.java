package com.spring.file_operations2.controller;

import com.spring.file_operations2.entity.Invoice;
import com.spring.file_operations2.excelservice.InvoiceDataExcelExport;
import com.spring.file_operations2.exception.InvoiceNotFoundException;
import com.spring.file_operations2.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    @GetMapping("/")
    public String showHomePage() {
        return "homePage";
    }

    @GetMapping("/register")
    public String showRegistration() {
        return "registerInvoicePage";
    }


    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice , Model model){
        Invoice inv = invoiceService.saveInvoice(invoice);
        Long id = inv.getId();

        String message = "Record with id : '"+id+"' is saved successfully !";
        model.addAttribute("message", message);

        return "registerInvoicePage";
    }


    @GetMapping("/getAllInvoices")
    public String getAllInvoices(@RequestParam(value = "message" , required = false) String message ,Model model){
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("list" , invoices);
        model.addAttribute("message" , message);
        return "allInvoicesPage";
    }


    @GetMapping("/edit")
    public String getEditPage(Model model , RedirectAttributes attributes , @RequestParam Long id){
      String page = null;

      try{
          Invoice inv = invoiceService.getInvoiceById(id);
          model.addAttribute("invoice" , inv);
          page="editInvoicePage";
      }catch(InvoiceNotFoundException e){
        e.printStackTrace();
        attributes.addAttribute("message" , e.getMessage());
        page="redirect:getAllInvoices";
      }

      return page;
    }

    @PostMapping("/update")
    public String updateInvoice(@ModelAttribute Invoice invoice , RedirectAttributes attributes){
       invoiceService.updateInvoice(invoice);
       Long id = invoice.getId();
       attributes.addAttribute("message", "Invoice with id: '"+id+"' is updated successfully !");
       return "redirect:getAllInvoices";
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id , RedirectAttributes attributes){
        try{

            invoiceService.deleteInvoiceById(id);
            attributes.addAttribute("message", "Invoice with Id : '"+id+"' is removed successfully!");

        }catch (InvoiceNotFoundException e){
            e.printStackTrace();
        }

        return "redirect:getAllInvoices";
    }


    @GetMapping("/excelExport")
    public ModelAndView exportToExcel(){
        ModelAndView mav = new ModelAndView();

        mav.setView(new InvoiceDataExcelExport());

        List<Invoice> list = invoiceService.getAllInvoices();

        mav.addObject("list" , list);
        return mav;
    }

}
