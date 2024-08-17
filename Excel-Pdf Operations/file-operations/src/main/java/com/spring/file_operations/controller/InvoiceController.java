package com.spring.file_operations.controller;

import com.spring.file_operations.entity.Invoice;
import com.spring.file_operations.service.ExcelDataService;
import com.spring.file_operations.service.IFileUploaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class InvoiceController {

    private final IFileUploaderService fileUploaderService;

    private final ExcelDataService excelDataService;
    public InvoiceController(IFileUploaderService fileUploaderService, ExcelDataService excelDataService) {
        this.fileUploaderService = fileUploaderService;
        this.excelDataService = excelDataService;
    }


    @GetMapping("/")
    public String index(){
        return "uploadPage";
    }


    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file , RedirectAttributes redirectAttributes){

        fileUploaderService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message",
                "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "redirect:/";

    }


    @GetMapping("/saveData")
    public String saveExcelData(Model model) {

        List<Invoice> excelDataAsList = excelDataService.getExcelDataAsList();
        int noOfRecords = excelDataService.saveExcelData(excelDataAsList);
        model.addAttribute("noOfRecords",noOfRecords);

        return "success";
    }



}
