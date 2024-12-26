/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pengguna;

class ManajemenPengguna implements Pengguna {
    private String nama;
    private String peran;

    public ManajemenPengguna(String nama, String peran) {
        this.nama = nama;
        this.peran = peran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    @Override
    public void aturAkses() {
        System.out.println("Akses diberikan berdasarkan peran: " + peran);
    }

    @Override
    public void logAktivitas() {
        System.out.println("Log aktivitas pengguna " + nama + " telah direkam.");
    }
}

