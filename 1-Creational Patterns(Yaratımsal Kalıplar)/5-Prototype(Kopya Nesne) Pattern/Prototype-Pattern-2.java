public class Resim implements Cloneable{
    
    private final String renk;
    private final Integer boy,en;
    
    public Resim(final String renk, final Integer boy, final Integer en){
        this.renk = renk;
        this.boy = boy;
        this.en = en;
    }
    
    protected Resim kopyaAl(){
        
        try{
            //resim nesnesi kopyalanıyor
            return (Resim) super.clone();
        }
        catch (final CloneNotSupportedException e){
            e.printStackTrace();
            
            return null;
        }
    }
    
    public String renkAl() {return renk;}
    
    public Integer boyAl() {return boy;}
    
    public Integer enAl() {return en;}
    
    @Override 
    public String toString() {return "Resim [renk ="+ renk +",boy ="+ boy +",en ="+ en +"]";}
}

public class ResimÜreteci{
    public static void main(final String[] args){
        
        //resim nesnesi üretiliyor
        final Resim resim1 = new Resim("mavi",25,15);
        
        //yeniden resim nesnesi üretmek yerine,
        //var olan resim nesnesinden kopyalama yapılıyot
        final Resim resim2 = resim1.kopyaAl();
        
        //kopyalanan resim nesnesinin özellikleri yazdırılıyor
        System.out.println("Kopyalanan resim nesnesi: "+resim2);
    }
}