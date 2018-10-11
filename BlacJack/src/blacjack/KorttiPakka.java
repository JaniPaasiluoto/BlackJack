
package blacjack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class KorttiPakka {
    
    private ArrayList<Kortti> kortit;
    Scanner lukija = new Scanner(System.in);
    public KorttiPakka() {
        this.kortit = new ArrayList<>();
    }
    
    public void tyhjennaPakka() {
        this.kortit = new ArrayList<>();
    }
    public void luoPakka() {
        for (Maa kortinMaa : Maa.values()) {
            for (Arvo kortinArvo : Arvo.values()) {
                this.kortit.add(new Kortti(kortinMaa, kortinArvo));
            }
        }
    }
    public void Sekoita() {
        Collections.shuffle(kortit);
    }
    public void poistaKortti(int i) {
        this.kortit.remove(i);
    }
    public Kortti otaKortti(int i) {
        return this.kortit.get(i);
    }
    public void lisaaKortti(Kortti lisaaKortti) {
        this.kortit.add(lisaaKortti);
    }
    public void jaa(KorttiPakka mista, boolean kaytaTekoAlya) {
        Kortti kortti = mista.otaKortti(0);
        mista.poistaKortti(0);
        int assat = 0;
        switch (kortti.getArvo()) {
            case KAKSI:
                kortti.setOikeaArvo(2);
                break;
            case KOLME:
                kortti.setOikeaArvo(3);
                break;
            case NELJA:
                kortti.setOikeaArvo(4);
                break;
            case VIISI:
                kortti.setOikeaArvo(5);
                break;
            case KUUSI:
                kortti.setOikeaArvo(6);
                break;
            case SEITSEMAN:
                kortti.setOikeaArvo(7);
                break;
            case KAHDEKSAN:
                kortti.setOikeaArvo(8);
                break;
            case YHDEKSAN:
                kortti.setOikeaArvo(9);
                break;
            case KYMMENEN:
                kortti.setOikeaArvo(10);
                break;
            case JATKA:
                kortti.setOikeaArvo(11);
                break;
            case KUNINGATAR:
                kortti.setOikeaArvo(12);
                break;
            case KUNINGAS:
                kortti.setOikeaArvo(13);
                break;
            case ASSA: assat += 1;
                if (kaytaTekoAlya) {
                    if (kortti.getOikeaArvo() > 10) {
                       kortti.setOikeaArvo(1);
                    } else 
                    // TODO: tekoäly

                    
                    kortti.setOikeaArvo(11);
             

                kortti.setOikeaArvo(14);
                
                } else {
                    System.out.println("Sait ässän, haluatko sen olevan arvoltaan (1) 1 vai (2) 11?");
                    int vastaus = lukija.nextInt();
                    if (vastaus == 1) {
                        kortti.setOikeaArvo(1);
                    } else if (vastaus == 2){
                        kortti.setOikeaArvo(11);
                    }
                    
                    break;
                }
        }
        
        this.kortit.add(kortti);
    }
    @Override
    public String toString() {
        String korttiLista = "";
        for (Kortti kortti : this.kortit) {
            korttiLista += "\n" + kortti.toString();
        }
        return korttiLista;
    }
    public int pakanKoko() {
        return this.kortit.size();
    }
    public void siirraPakkaan(KorttiPakka siirra) {
        int tamanPakanKoko = this.kortit.size();
        for (int i = 0; i < this.pakanKoko(); i++) {
            siirra.lisaaKortti(this.otaKortti(i));
        }
        for (int i = 0; i < this.pakanKoko(); i++) {
            this.poistaKortti(0);
        }
    }
    public int kortinArvo() {
        int yht = 0;
        
        for (Kortti kortti : this.kortit) {
            yht += kortti.getOikeaArvo();
        }
        
        return yht;
        
    }
    void jaa(KorttiPakka peliPakka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
