/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengguna;

/**
 *
 * @author USER
 */
public class ManajemenPengguna implements Pengguna {
    private String nama;

    public ManajemenPengguna(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void aturAkses() {
        System.out.println("Akses pengguna telah diatur.");
    }
}