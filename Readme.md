# Ders Programı Çakışması · Portfolyo

YMT1101 Algoritma ve Programlama I · Doç. Dr. Ferhat Uçar

Bu depo K09 numaralı ders programı çakışması ve Kural 9 ayırt edici kuralına ait dönem portfolyosudur.

## Konu

- Konu kodu ve adı: K09 Ders Programı Çakışması
- Ayırt edici kural: Kural 9, Üç ihlal kuralı. Belirli bir hatalı davranış (geçersiz giriş, geç iade, kural dışı talep) üç kez tekrarlanınca uygulama o kullanıcıyı geçici olarak engeller ve nedenini söyler.
- Uygulama tek cümleyle ne yapıyor: Kullanıcının girdiği ders saatlerinin mevcut programla çakışmasını tespit eder, uygun boş saatleri önerir ve kural dışı girişlerde 3 ihlal kuralını (Kural 9) uygular.

## Kilometre taşları

| KT | Son teslim | Bu sürümde ne var | Durum |
|---|---|---|---|
| KT1 | 6 Kasım 2026 Cuma 23.59 | Scanner ile girdi, en az bir if/else, ayırt edici kuralın (Kural 9) en basit hali, 0 ile çıkış | Hazır; do-while menü ve çakışma kontrolü eklendi |
| KT2 | 27 Kasım 2026 Cuma 23.59 | Gözcü değerle biten menü döngüsü, girdi doğrulama döngüsü | Planlandı |
| KT3 | 11 Aralık 2026 Cuma 23.59 | Metotlar, dizi alıp tek değer döndüren metot, girdi doğrulayan metot; veriler dizide | Planlandı |
| KT4 | 25 Aralık 2026 Cuma 23.59 | Çalışan son sürüm, README tam, AI-BEYANI.md dolu, üç dil karşılaştırması | Planlandı |

## Nasıl çalıştırılır

```bash
javac Uygulama.java
java Uygulama
```

Ana sınıf her zaman `Uygulama`, menüde `0` her zaman çıkıştır. Otomatik kontrol bu iki kurala güvenir.

## Kullandığım yapılar (KT1)

- Değişkenler ve tipler: `int secim`, `int baslangic`, `int bitis`, `int ihlalSayaci`, `final int` sabit mesai saatleri
- Karar yapıları: `switch` (menü seçimi), `if/else` (çakışma kontrolü, kural 9 ihlal kontrolü), `&&` ve `||` mantıksal operatörleri
- Döngüler: `do-while` (0 gözcü değeri ile menü tekrarı)
- Metotlar: henüz yok (KT3)
- Diziler: henüz yok (KT3)

## Üç dil karşılaştırması (KT4)

Henüz yok. 