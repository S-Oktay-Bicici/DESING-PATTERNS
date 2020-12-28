public class Pide{

    private String malzeme = "";
    private String hamur = "";
    private String baharat = "";

    public void malzemeKoy(final String malzeme){
        this.malzeme = malzeme;
    }

    public void hamurKoy(final String hamur){
        this.hamur = hamur;
    }

    public void baharatKoy(final String baharat){
        this.baharat = baharat;
    }

    @Override
    public String toString(){
        return "Pide [malzeme = "+ malzeme +", hamur = "+ hamur +", baharat = "+baharat + "]";
    }
}

public abstract class PideKurucu{
    protected Pide pide;

    public void pideYarat(){
        pide = new Pide();
    }

    public Pide pideAl(){
        return pide;
    }

    public abstract void malzemeKur();
    public abstract void hamurKur();
    public abstract void baharatKur();
}

public class LahmacunPideKurucu extends PideKurucu{
    
    @Override 
    public void baharatKur(){
        pide.baharatKoy("acı biber");
    }
    
    @Override 
    public void hamurKut(){
        pide.hamurKoy("ince hamur");
    }
    
    @Override 
    public void malzemeKur(){
        pide.malzemeKoy("kıyma");
    }
}

public class KuşbaşılıPideKurucu extends  PideKurucu{
    
    @Override 
    public void baharatKur(){
        pide.baharatKoy("kimyon");
    }
    
    @Override 
    public void hamurKur(){
        pide.hamurKoy("kalın hamur");
    }
    
    @Override 
    public void malzemeKur(){
        pide.malzemeKoy("kuşbaşı et");
    }
}

public class Aşcı{
    private PideKurucu pideKurucu;
    
    public void setPideKurucu(final PideKurucu pideKurucu){
        this.pideKurucu = pideKurucu;
    }
    
    public Pide pideAl(){
        return pideKurucu.pideAl();
    }
    
    public void pideyiKur(){
        //pideui aşama aşama kur
        pideKurucu.pideYarat();
        pideKurucu.hamurKur();
        pideKurucu.malzemeKur();
        pideKurucu.baharatKur();
    }
}

public class PideSalonu{
    public static void main(final String[] args){
        
        //yönetici sınıfını yarat 
        final Aşcı aşcı = new Aşcı();
        
        //kurulum nesnesini yarat
        final LahmacunPideKurucu lahmacunPideKurucu = new LahmacunPideKurucu();
        
        //yönetici sınıfa kurulum nesnesini ver
        aşcı.setPideKurucu(lahmacunPideKurucu);
        
        //ürün nesnesini kur
        aşcı.pideyiKur();
        
        //pide kuruldu ve ürün hazır
        final Pide pide = aşcı.pideAl();
        
        System.out.println("Pide kuruldu: "+ pide);
    }
}