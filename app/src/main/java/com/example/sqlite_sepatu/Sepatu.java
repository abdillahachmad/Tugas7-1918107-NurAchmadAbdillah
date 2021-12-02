package com.example.sqlite_sepatu;

public class Sepatu{
    private String _id, _nama, _kelas;
    public Sepatu (String id, String nama, String ukuran) {
        this._id = id;
        this._nama = nama;
        this._kelas = ukuran;
    }
    public Sepatu() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_ukuran() {
        return _kelas;
    }
    public void set_ukuran(String _ukuran) {
        this._kelas = _ukuran;
    }
}
