package com.iwl.multi_tenant_mvc.masterDomain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tenant_master")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "db_url")
    private String dbUrl;

    @Column(name = "db_username")
    private String dbUsername;

    @Column(name = "db_password")
    private String dbPassword;

}
