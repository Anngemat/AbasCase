package Abas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<Orders> order = new ArrayList<Orders>();
		order.add(new Orders(1000,2000,12,100.51));
		order.add(new Orders(1000,2001,31,200.00));
		order.add(new Orders(1000,2002,22,150.86));
		order.add(new Orders(1000,2003,41,250.00));
		order.add(new Orders(1000,2004,55,244.00));
		order.add(new Orders(1001,2001,88,44.531));
		order.add(new Orders(1001,2002,121,88.11));
		order.add(new Orders(1001,2004,74,211.00));
		order.add(new Orders(1001,2002,128,88.11));
		order.add(new Orders(1002,2003,2,12.1));
		order.add(new Orders(1002,2004,3,22.3));
		order.add(new Orders(1002,2003,8,12.1));
		order.add(new Orders(1002,2002,16,94.0));
		order.add(new Orders(1002,2005,9,44.1));
		order.add(new Orders(1002,2006,19,90.0));
		
		double toplam = ToplamFiyat(order);
		System.out.println("Toplam Fiyat = " + toplam);
		
		double ortalama = OrtalamaFiyat(order);
        System.out.println("Ortalama Fiyat = " + ortalama);
        
        Map<Integer, Double> ürünOrtalamaFiyat = ÜrünOrtalamaFiyat(order);
        System.out.println("Ürün Ortalama Fiyatları = " +ürünOrtalamaFiyat);
		
	}
	
	public static double ToplamFiyat(List<Orders> order) {
		double toplam = 0;
		for (Orders orders : order) {
			toplam += orders.ToplamFiyat();
			
		}
		return toplam;
	}
	
	public static double OrtalamaFiyat(List<Orders> order) {
		double ortalama = 0;
		for (Orders orders : order) {
			ortalama += orders.birimFiyat;
		}
		return ortalama/order.size();
	}
	public static Map<Integer, Double> ÜrünOrtalamaFiyat(List<Orders> order) {
	    Map<Integer, Double> ürünFiyat = new HashMap<>();
	    Map<Integer, Integer> ürünSayısı = new HashMap<>();
	    
	    for (Orders orders : order) {
	    	ürünFiyat.put(orders.malNo, ürünFiyat.getOrDefault(orders.malNo, 0.0) + orders.birimFiyat);
	        ürünSayısı.put(orders.malNo, ürünSayısı.getOrDefault(orders.malNo, 0) + 1);
	    }
	    
	    Map<Integer, Double> ürünOrtalamaFiyat = new HashMap<>();
	    for (Integer malNo : ürünFiyat.keySet()) {
	        double toplam = ürünFiyat.get(malNo);
	        int sayı = ürünSayısı.get(malNo);
	        ürünOrtalamaFiyat.put(malNo, toplam / sayı);
	    }
	    
	    return ürünOrtalamaFiyat;
	}
	
}
