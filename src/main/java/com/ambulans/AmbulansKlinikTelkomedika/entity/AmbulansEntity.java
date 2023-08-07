package com.ambulans.AmbulansKlinikTelkomedika.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "ambulans")
public class AmbulansEntity {
    @Id
    //@JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "platnomor")
    private String platnomor;
    @Column(name = "tipe")
    private String tipe;
    @Column(name = "supir")
    private String supir;
    @Column(name = "status")
    private boolean status;

    public AmbulansEntity() {
    }

    public AmbulansEntity(Long id,String platnomor, String tipe, String supir, boolean status) {
        this.id = id;
        this.platnomor = platnomor;
        this.tipe = tipe;
        this.supir = supir;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatnomor() {
        return platnomor;
    }

    public void setPlatnomor(String platnomor) {
        this.platnomor = platnomor;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getSupir() {
        return supir;
    }

    public void setSupir(String supir) {
        this.supir = supir;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
