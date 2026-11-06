# Yapay Zeka Beyanı

## KT1
- Hangi aracı kullandım: Antigravity (Gemini)
- Ne için kullandım: İki dersin saat aralığı kesişim formülünü (`baslangic1 < bitis2 && baslangic2 < bitis1`) ve Kural 9 (üç ihlal kuralı) sayaç mantığının menü döngüsüne entegrasyonunu sormak için kullandım.
- Hangi kısmı tamamen kendim yazdım: Menü akışı, kullanıcıya gösterilen mesajlar ve switch-case kontrol yapısını kendim düzenledim.
- Yapay zekanın hangi hatasını yakaladım: İlk başta saat girişini ondalıklı `double` olarak önerdi; ders saatleri tam saat blokları (09:00, 11:00 gibi) üzerinden modellendiği için değişken tipini `int` olarak düzelttim.