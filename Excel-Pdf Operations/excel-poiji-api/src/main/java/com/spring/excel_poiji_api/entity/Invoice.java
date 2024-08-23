package com.spring.excel_poiji_api.entity;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelCellName;
import jakarta.persistence.*;


@Entity
public class Invoice {
    @Id
    @SequenceGenerator(
            name = "invoice_id_seq",
            sequenceName = "invoice_id_seq",
            allocationSize = 1, initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_id_seq")
    private Long id;

    @ExcelCellName("Name")
    private String name;
    @ExcelCell(1)
    private Double amount;

    @ExcelCell(2)
    private String number;

    @ExcelCell(3)
    private String receivedDate;

}
