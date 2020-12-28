public interface Adres{
	String alAcikAdres();
	String alSemt();
	String alSehir();
	String alUlke();
}

public class IsAdres implements Adres{
	
	@Override
	public String alAcikAdres(){
		return "Gül Mah. Osman Sok. No:15";
	}
	
	@Override 
	public String alSemt(){
		return "Beşiktaş";
	}
	
	@Override 
	public String alSehir(){
		return "İstanbul";
	}
	
	@Override
	public String alUlke(){
		return "Türkiye";
	}
}

public class Musteri{
	
	private final String numara;
	private final String aciklama;
	private final String acikAdres;
	private final String semt;
	private final String sehir;
	private final String ulke;
	
	public Müsteri(final String numara, final String aciklama, final String acikAdres, final String semt, final String sehir, final String ulke){
		this.numara = numara;
		this.aciklama = aciklama;
		this.acikAdres = acikAdres; 
		this.semt = semt;
		this.sehir = sehir;
		this.ulke = ulke;
	}
	
	public String alNumara(){
		return numara;
	}
	
	public String alAciklama(){
		return aciklama;
	}
	
	public String alAcikAdres(){
		return acikAdres;
	}
	
	public String alSemt(){
		return semt;
	}
	
	public String alSehir(){
		return sehir;
	}
	
	public String alUlke(){
		return ulke;
	}
}


public class MusteriFaturaAdresiAdaptörü implements Adres{
	
	private final Musteri musteri;
	
	public MüsteriFaturaAdresiAdaptörü(final Musteri musteri){
		this.musteri = musteri;
	}
	
	@Override
	public String alAcikAdres(){
		return musteri.alAcikAdres();
	}
	
	@Override 
	public String alSemt(){
		return musteri.alSemt();
	}
	
	@Override 
	public String alSehir(){
		return musteri.alSehir();
	}
	
	@Override 
	public String alUlke(){
		return musteri.alUlke();
	}
}

public class Satici{
	public static void main(String[] args){
		
		//örnek bir müşteri nesenesi yarat 
		final Musteri musteri = new Musteri("105", "açıklama", "Atatürk Mah. Gazi Sok. No:15", "Sancaktepe", "İstanbul", "Türkiye");
		
		//Müşteri sınıfının adaptörünü yarat
		final MusteriFaturaAdresiAdaptörü adaptor = new MusteriFaturaAdresiAdaptörü(musteri);
		
		//artık müşteri sınıfı da adaptör sayesinde bir
		//"Adres" sinifıdır.
		final Adres adres = adaptor;
		
		//"Adres" sınıfının içeriğini yazdir
		System.out.println("Adres: " + adres.alAcikAdres());
		System.out.println("Semt: " + adres.alSemt());
		System.out.println("Şehir: " + adres.alSehir();
		System.out.println("Ulke: " + adres.alUlke();
	}
}