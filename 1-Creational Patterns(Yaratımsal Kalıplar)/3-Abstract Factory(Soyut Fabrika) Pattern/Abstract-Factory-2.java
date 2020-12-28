public interface Bildirim{
    void mesajGönder(String metin){
    }
}

public class Eposta implements Bildirim{
    @Override
    public void mesajGönder(final String metin){
        System.out.println("E-posta ile '"+ metin + "'içeriği gönderilmiştir.");
    }
}

public class Sms implements Bildirim{
    @Override
    public void mesajGönder(final String metin){
        System.out.println("Sms ile '"+ metin + "'içeriği gönderilmiştir.");
    }
}

public interface ÖdemeTipi{
    void paraGönder(Integer miktar);
}

public class PostaÇeki implements ÖdemeTipi{
    @Override
    public void paraGönder(final Integer miktar){
        System.out.println("Posta çeki ile "+ miktar+ "TL para gönderilmiştir.");
    }
}

public class Havale implements ÖdemeTipi{
    @Override
    public void paraGönder(final Integer miktar){
        System.out.println("Havale ile"+ miktar +"TL para gönderilmiştir.");
    }
}

public interface ISiparişNesneFabrikası{
    ÖdemeTipi ödemeTipiYarat();
    Bildirim bildirimYarat();
}

public class NormalSiparişNesenseFabrikası implements ISiparişNesneFabrikası{
    @Override
    public ÖdemeTipi ödemeTipiYarat(){
        return new PostaÇeki();
    }
    @Override
    public Bildirim bildirimYarat(){
        return new Eposta();
    }
}

public class HızlıSiparişNeseneFabrikası implements ISiparişNesneFabrikası{
    @Override
    public ÖdemeTipi ödemeTipiYarat(){
        return new Havale;
    }
    @Override
    public ÖdemeTipi ödemeTipiYarat(){
        return new Sms();
    }
}

public class SiparişGönderici{
    public static void main(final String[] args){

        ISiparişNesneFabrikası siparişNesneFabrikası = null;

        if(args[0].equals("hızlı")){
            siparişNesneFabrikası = new HızlıSiparişNeseneFabrikası();
        }
        else{
            siparişNesneFabrikası = new NormalSiparişNesenseFabrikası();
        }

        final ÖdemeTipi ödemeTipi = siparişNesneFabrikası.ödemeTipiYarat();
        final Bildirim bildirim = siparişNesneFabrikası.bildirimYarat();

        ödemeTipi.paraGönder(Integer.valueOf(args[1]));
        bildirim.mesajGönder("Siparişiniz gönderilmiştir.");
    }
}