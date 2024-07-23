package Abas;

public class Orders {
	int siparisNo;
    int malNo;
    int miktar;
    double birimFiyat;

    public Orders(int siparisNo, int malNo, int miktar, double birimFiyat) {
        this.siparisNo = siparisNo;
        this.malNo = malNo;
        this.miktar = miktar;
        this.birimFiyat = birimFiyat;
    }

    public double ToplamFiyat() {
        return this.miktar * this.birimFiyat;
    }
}

