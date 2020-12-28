
public interface IResimFormat1i{
    void resimOlustur(Integer uzunluk, Integer genislik);
}

public class JpegResimFormati implements IResimFormat1i{

    @Override
    public void resimOlustur(Integer uzunluk, Integer genislik) {
        System.out.println("Resim Oluştu. Format: JPEG");
        System.out.println("Uzunluk: "+uzunluk+", Genişlik:"+genislik);
    }
}

public class GifResimFormati implements IResimFormat1i{

    @Override
    public void resimOlustur(Integer uzunluk, Integer genislik) {
        System.out.println(uzunluk+"uzunluğu, "+genislik+"genişliğinde GIF formatında bir resim.");
    }
}

public  class FormatSecici{
    public IResimFormati formatAl(final Integer uzunluk, final Integer genislik){
        final Integer resimAlanı = uzunluk * genislik;

        if(resimAlanı > 100){
            return new JpegResimFormati();
        }
        else{
            return new GifResimFormati();
        }
    }
}


public class Main {

    public static void main(String[] args) {

        //resim boyutları
        final Integer uzunluk = 20;
        final Integer genişlik = 8;

        //fabrika yordamını içeren sınıf oluşturuldu
        final FormarSecici formatSeçici = new FormatSecici();

        //fabrika yordamından resim boyutlarına göre bir format nesenesi yaratılıp, döndü.
        final IResimFormati resimFormatıNesenesi = formatSeçici.fortmatAl(uzunluk,genişlik);

        //formata göre resi çizildi
        resimFormatıNesenesi.resmiOlustur(uzunluk,genişlik);
    }
}
