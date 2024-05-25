package org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] nazwy = {"Pomidor","Ogorek","Sałata","Ziemniaki","Kapusta","Burak","Seler","Marchew"};
        Magazyn magazyn = new Magazyn(20,nazwy);
        Zmienna zmienna = new Zmienna();
        Scanner scanner = new Scanner(System.in);
        int threads = 5;
        final ExecutorService ex = Executors.newFixedThreadPool(threads);
        final ExecutorService ex1 = Executors.newFixedThreadPool(threads);
        for (int i=0; i<threads;i++)
        {
            ex.submit(new Producent(zmienna,magazyn));
            ex1.submit(new Konsument(zmienna,magazyn));
        }
        while (!zmienna.getKoniec())
        {

            String linia = scanner.nextLine();
            if(linia.equals(""))
            {
                zmienna.setKoniec(true);
            }
        }
        System.out.println("Koniec");
        ex.shutdown();
        ex.awaitTermination (10 , TimeUnit. SECONDS ) ;
        ex1.shutdown();
        ex1.awaitTermination(10, TimeUnit. SECONDS);
        scanner.close();

    }
}