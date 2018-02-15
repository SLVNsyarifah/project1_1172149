package com.selvina.entity;
// Generated Feb 15, 2018 8:40:48 AM by Hibernate Tools 4.3.1



/**
 * DetailPenjualan generated by hbm2java
 */
public class DetailPenjualan  implements java.io.Serializable {


     private String idDetailPenjualan;
     private Barang barang;
     private Penjualan penjualan;
     private float hargaSatuan;
     private int qty;
     private float subtotal;

    public DetailPenjualan() {
    }

    public DetailPenjualan(String idDetailPenjualan, Barang barang, Penjualan penjualan, float hargaSatuan, int qty, float subtotal) {
       this.idDetailPenjualan = idDetailPenjualan;
       this.barang = barang;
       this.penjualan = penjualan;
       this.hargaSatuan = hargaSatuan;
       this.qty = qty;
       this.subtotal = subtotal;
    }
   
    public String getIdDetailPenjualan() {
        return this.idDetailPenjualan;
    }
    
    public void setIdDetailPenjualan(String idDetailPenjualan) {
        this.idDetailPenjualan = idDetailPenjualan;
    }
    public Barang getBarang() {
        return this.barang;
    }
    
    public void setBarang(Barang barang) {
        this.barang = barang;
    }
    public Penjualan getPenjualan() {
        return this.penjualan;
    }
    
    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }
    public float getHargaSatuan() {
        return this.hargaSatuan;
    }
    
    public void setHargaSatuan(float hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
    public int getQty() {
        return this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    public float getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }




}


