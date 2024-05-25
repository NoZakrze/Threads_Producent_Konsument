package org.example;

public class Zmienna
{
    private volatile boolean koniec;
    public Zmienna()
    {
        this.koniec = false;
    }

    public void setKoniec(boolean koniec)
    {
        this.koniec = koniec;
    }

    public boolean getKoniec()
    {
        return koniec;
    }
}
