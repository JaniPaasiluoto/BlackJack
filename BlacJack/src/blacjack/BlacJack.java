
package blacjack;

import java.util.Scanner;


public class BlacJack {

    public static void main(String[] args) throws InterruptedException {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan Venttiä!\n");

        KorttiPakka peliPakka = new KorttiPakka();

        System.out.println("SÄÄNNÖT\n Pelissä on normaali, 52:n kortin pakka ilman jokereita."
                + " Blackjackissa yrität saada korteillasi suuremman pistesumman kuin jakaja. "
                + " Pistesumman tulee olla mahdollisimman lähelle 21, mutta ei kuitenkaan yli."
                + " Menit yli 21: Häviät automaattisesti.\n" 
                + " Jakaja meni yli 21: Sinä voitat automaattisesti.\n" 
                + " Kumpikaan ei mene yli ja sinulla on suurempi summa kuin jakajalla: Voitat.\n" 
                + " Kumpikaan ei mene yli ja sinulla on pienempi summa kuin jakajalla: Häviät.\n" 
                + " Sinulla ja jakajalla on tasatilanne: Tasapeli, saat panoksen takaisin..\n");

        boolean lopetaVuoro = false;

        KorttiPakka pelaajanPakka = new KorttiPakka();
        KorttiPakka emannanPakka = new KorttiPakka();

        while (true) {
            System.out.println("Valitse:  \n 1. Uusi peli \n 2. Lopeta peli");
            int valinta = lukija.nextInt();
            if (valinta == 1) {
                System.out.println("Aloitetaan peli!");
                peliPakka.tyhjennaPakka();
                pelaajanPakka.tyhjennaPakka();
                emannanPakka.tyhjennaPakka();
                
                peliPakka.luoPakka();
                peliPakka.Sekoita();
            } else if (valinta == 2) {
                break;
            }

            while (true) {

                System.out.println("Haluatko: 1. Ottaa kortin / 2. Lopettaa");
                int vastaus = lukija.nextInt();
                if (vastaus == 1) {
                    pelaajanPakka.jaa(peliPakka, false);
                    System.out.println("Sait: ");
                    System.out.println(pelaajanPakka.otaKortti(pelaajanPakka.pakanKoko() - 1).toString());
                    System.out.println("Korttiesi yhteisarvo on: " + pelaajanPakka.kortinArvo());

                    if (pelaajanPakka.kortinArvo() > 21) {
                        System.out.println("Yli meni. Korttiesi yhteisarvo on: " + pelaajanPakka.kortinArvo());
                        lopetaVuoro = true;
                        break;
                    }
                }

                if (vastaus == 2) {
                    break;
                }

            }
            System.out.println("Emännän vuoro!");
            while (emannanPakka.kortinArvo() < pelaajanPakka.kortinArvo() && emannanPakka.kortinArvo() < 22 && pelaajanPakka.kortinArvo() < 22) {
                emannanPakka.jaa(peliPakka, true);
                Thread.sleep(1500);
                System.out.println("Emäntä sai: ");
                System.out.println(emannanPakka.otaKortti(emannanPakka.pakanKoko() - 1).toString());
                System.out.println("Emännän korttien yhteisarvo on: " + emannanPakka.kortinArvo());
            }
            if (emannanPakka.kortinArvo() > pelaajanPakka.kortinArvo() && emannanPakka.kortinArvo() <= 21) {
                System.out.println("Emäntä voittaa!");
            } else if (emannanPakka.kortinArvo() == 20 || emannanPakka.kortinArvo() == 21) {
                System.out.println("Emäntä voittaa!");
            } else if (pelaajanPakka.kortinArvo() > 21 && emannanPakka.kortinArvo() < 22) {
                System.out.println("Emäntä voittaa!");
            } else if (emannanPakka.kortinArvo() > 21 && lopetaVuoro == false) {
                System.out.println("Emäntä menee yli, sinä voitat!");
                lopetaVuoro = true;

            } else if (emannanPakka.kortinArvo() == pelaajanPakka.kortinArvo() && lopetaVuoro == false) {
                System.out.println("Tasapeli!");
                lopetaVuoro = true;
            } else if (pelaajanPakka.kortinArvo() > emannanPakka.kortinArvo() && lopetaVuoro == false) {
                System.out.println("Sinä voitat!");
            }

        }
    }

}
