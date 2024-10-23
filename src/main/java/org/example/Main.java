package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Kelime dizisini oluştur
        String[] kelimeDizisi = {"kalem", "elalem", "kelam", "kelime"};
        // String dizisi (kelimeDizisi) tanımlıyoruz. Bu dizide örnek kelimeler yer alıyor.

        List<String> tekrarlayanHarfliKelimeler = new ArrayList<>();
        // Boş bir Liste oluşturuyoruz (tekrarlayanHarfliKelimeler). Bu listeye, içinde tekrarlayan harf bulunan kelimeleri ekleyeceğiz.

        for (String kelime : kelimeDizisi) {  // Kelime dizisinin her bir elemanını (kelimeyi) tek tek dolaşan bir for döngüsü.
            if (tekrarEdenHarfVarMi(kelime)) {  // Eğer kelime tekrarlayan harf içeriyorsa fonsiyon
                tekrarlayanHarfliKelimeler.add(kelime);  // Kelimeyi, tekrarlayan harf içeren kelimeler listesine ekle.
            }
            if (tekrarlayanHarfliKelimeler.size() == 2) {  // Eğer listeye 2 kelime eklendiyse
                break;  // Döngüyü durdur (aramayı bitir).
            }
        }

        if (tekrarlayanHarfliKelimeler.size() == 2) {  // Eğer iki kelime bulduysak, harfleri birleştirmeye başla.
            List<Character> harfListesi = new ArrayList<>();  // Harfleri depolamak için bir karakter listesi oluşturuyoruz.

            for (char c : tekrarlayanHarfliKelimeler.get(0).toCharArray()) {  // İlk kelimenin harflerini listeye ekle.
                harfListesi.add(c);
            }
            for (char c : tekrarlayanHarfliKelimeler.get(1).toCharArray()) {  // İkinci kelimenin harflerini de listeye ekle.
                harfListesi.add(c);
            }

            // Harfleri karıştır
            Collections.shuffle(harfListesi);  // Harf listesini karıştırarak rastgele bir sıra elde ediyoruz.

            // Harfleri birleştir ve metin oluştur
            StringBuilder yeniMetin = new StringBuilder();  // Karakterleri birleştirip bir metin oluşturmak için StringBuilder kullanıyoruz.
            for (char c : harfListesi) {  // Karışık harf listesini dolaşıyoruz.
                yeniMetin.append(c);  // Her karakteri yeni oluşturduğumuz metine ekliyoruz.
            }

            System.out.println("Rastgele oluşturulan metin: " + yeniMetin);  // Sonucu ekrana yazdırıyoruz.
        } else {  // Eğer iki kelime bulamazsak, yani yeterli kelime bulunmazsa:
            System.out.println("Yeterli kelime bulunamadı.");  // Uyarı mesajı basıyoruz.
        }
    }

    // Tekrar eden harf olup olmadığını kontrol eden fonksiyon
    public static boolean tekrarEdenHarfVarMi(String kelime) {  // Bu fonksiyon, bir kelimenin tekrarlayan harf içerip içermediğini kontrol eder.
        Set<Character> harfSeti = new HashSet<>();  // Bir Set oluşturuyoruz. Set, aynı elemanı birden fazla içermez, bu yüzden tekrarlayan harfleri bulmak için kullanıyoruz.
        for (char c : kelime.toCharArray()) {  // Kelimenin her harfini dolaşmak için toCharArray() ile bir karakter dizisine dönüşüyor.
            if (!harfSeti.add(c)) {  // Eğer harf Set'e zaten eklenmişse (add() fonksiyonu false döner),
                return true;  // Bu kelimenin tekrarlayan harf içerdiğini anlıyoruz ve true döndürüyoruz.
            }
        }
        return false;  // Eğer döngü sonunda hiç tekrarlayan harf bulamazsak, false döndürüyoruz.
    }

}