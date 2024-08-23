package com.spring.excel_poiji_api.service;

import com.spring.excel_poiji_api.entity.Invoice;

import java.util.List;

public interface ExcelPoijiService {

    List<Invoice> getListfromExcelData();
}
