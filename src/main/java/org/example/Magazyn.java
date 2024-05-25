package org.example;

public class Magazyn {
    private int[] Produkty;
    private String[] Nazwy;
    private int max_ilosc;

    public Magazyn(int ilosc,String[] nazwy)
    {
        int[] tab = new int[nazwy.length];
        this.Produkty = tab;
        this.max_ilosc = ilosc;
        this.Nazwy = nazwy;
    }

    public int getMax_ilosc() {
        return max_ilosc;
    }

    public int[] getProdukty() {
        return Produkty;
    }

    public void setMax_ilosc(int max_ilosc) {
        this.max_ilosc = max_ilosc;
    }

    public void setProdukty(int[] produkty) {
        Produkty = produkty;
    }

    public String[] getNazwy() {
        return Nazwy;
    }

    public void setNazwy(String[] nazwy) {
        Nazwy = nazwy;
    }

    public synchronized String dodajProdukt(int ilosc, int indeks)
    {
        int dodano = 0;
        if(Produkty[indeks]+ilosc > max_ilosc) {
            dodano = max_ilosc-Produkty[indeks];
            Produkty[indeks] = max_ilosc;
        }
        else {
            Produkty[indeks] += ilosc;
            dodano = ilosc;
        }
        String odp = "Dodano " + Integer.toString(dodano) +" produktu " + Nazwy[indeks]+ "\n";
        return odp;
    }
    public synchronized String pobierzProdukt(int ilosc, int indeks)
    {
        int pobrano = 0;
        if(Produkty[indeks]-ilosc < 0) {
            pobrano = Produkty[indeks];
            Produkty[indeks] = 0;
        }
        else {
            Produkty[indeks] -= ilosc;
            pobrano = ilosc;
        }
        String odp = "Pobrano " + Integer.toString(pobrano) +" produktu " + Nazwy[indeks]+ "\n";
        return odp;
    }
}
