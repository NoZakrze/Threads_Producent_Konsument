package org.example;

import java.util.Random;

public class Producent implements Runnable {

    private Zmienna zmienna;
    private final Magazyn magazyn;
    public Producent(Zmienna zmienna, Magazyn mag)
    {
        this.zmienna = zmienna;
        this.magazyn = mag;
    }
    @Override
    public void run()
    {
        Random rn = new Random();
        while(!zmienna.getKoniec())
        {
            int indeks = rn.nextInt(magazyn.getProdukty().length);
            int ilosc = rn.nextInt(magazyn.getProdukty().length) + 1;
            String odp = magazyn.dodajProdukt(ilosc,indeks);
            System.out.println(Thread.currentThread().getName() + " "+ odp);
            int sleep = rn.nextInt(3)+1;
            try {
                Thread.sleep(sleep*1000);
            } catch (InterruptedException e) {
               return;
            }

        }
    }
}
