class TekNesne{
    //private static tek bir nesne oluşturulur
    private static TekNesne tekNesne = new TekNesne();

    /*
    yapıcı yordam (constructor) private olduğu için dışarıdan ulaşılamaz ve
    sınıfın nesnesi oluşturulmaz.
     */
    private TekNesne(){
        System.out.println("'TekNesne' sınıfından nesnesi bellekte oluşturuluyor");
    }

    //get the only object available
    public static TekNesne nesneAl(){
        return tekNesne;
    }
    public String getKullaniciIsmi(){
        return "oktay";
    }
    public String getsifre(){
        return "1234";
    }
    public void showMessage(){
        System.out.println("Hello World");
    }
}


public class Main {

    public static void main(String[] args) {

        //TekNesne sınıfından bir tane bulabilir ve nesne üzerindeki
        //"public" yordam ve değişkenlre, "TekNesne.nesneAl()" ile ulaşılabilir
        //"nesenAl" yordamı, "TekNesne" sınıfının oluşturulan tek nesnesine ulaşır
        final String kullaniciIsmi = TekNesne.nesneAl().getKullaniciIsmi();

        //Get the only object available
        TekNesne object = TekNesne.nesneAl();

        System.out.println("Kullanıcı ismi: "+kullaniciIsmi);
        System.out.println("Şifre: "+TekNesne.nesneAl().getsifre());

        //show the messege
        object.showMessage();
    }
}
