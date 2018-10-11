
package blacjack;


public class Kortti {

   private Maa maa;
   private Arvo arvo;
   private int oikeaArvo;

   public Kortti(Maa maa, Arvo arvo) {
       this.maa = maa;
       this.arvo = arvo;
   }

   @Override
   public String toString() {
       return this.maa.toString() + "-" + this.arvo.toString();
   }

   public Arvo getArvo() {
       return this.arvo;
   }

   public int getOikeaArvo() {
       return this.oikeaArvo;
   }

   public void setOikeaArvo(int arvo) {
       this.oikeaArvo = arvo;
   }
}