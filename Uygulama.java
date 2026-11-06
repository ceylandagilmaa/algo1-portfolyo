import java.util.Scanner;

/*
 * Ders Programi Cakismasi · Portfolyo (KT1 Surumu)
 * Ders: YMT1101 Algoritma ve Programlama I
 * 
 * Konu: K09 Ders Programi Cakismasi (Ders saatleri, cakisma bulma, bos saat onerisi)
 * Ayirt edici kural: Kural 9 (Uc ihlal kurali: 3 hatali davranista gecici engelleme)
 * Ana sinif her zaman Uygulama, menude 0 her zaman cikis.
 */
public class Uygulama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Mesai ve ornek mevcut ders saatleri (Pazartesi gunu ornegi)
        final int GUN_BASLANGIC = 8;   // 08:00
        final int GUN_BITIS = 17;      // 17:00

        // Sistemdeki mevcut kayitli ders (Ornek: Algoritma 1)
        String mevcutDersAdi = "Algoritma ve Programlama I";
        int mevcutBaslangic = 9;   // 09:00
        int mevcutBitis = 11;      // 11:00

        // KURAL 9: Uc ihlal kurali degiskenleri
        int ihlalSayaci = 0;
        final int MAX_IHLAL = 3;

        int secim;

        do {
            System.out.println();
            System.out.println("=== K09: Ders Programi ve Cakisma Sistemi ===");
            System.out.println("1) Mevcut Ders Programini Goruntule");
            System.out.println("2) Yeni Ders Saati Ekle (Cakisma Kontrollu)");
            System.out.println("3) Bos Saat Onerisi Al");
            System.out.println("0) Cikis");
            System.out.print("Seciminiz: ");
            secim = input.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("\n--- MEVCUT DERS PROGRAMI ---");
                    System.out.printf("Ders: %s%n", mevcutDersAdi);
                    System.out.printf("Saat: %02d:00 - %02d:00%n", mevcutBaslangic, mevcutBitis);
                    break;

                case 2:
                    System.out.println("\n--- YENI DERS EKLEME VE CAKISMA KONTROLU ---");
                    System.out.printf("Ders baslangic saati (%d - %d arasi): ", GUN_BASLANGIC, GUN_BITIS - 1);
                    int yeniBaslangic = input.nextInt();

                    System.out.printf("Ders bitis saati (%d - %d arasi): ", GUN_BASLANGIC + 1, GUN_BITIS);
                    int yeniBitis = input.nextInt();

                    // Girdi Dogrulama: Gecersiz saat kontrolu
                    if (yeniBaslangic >= yeniBitis || yeniBaslangic < GUN_BASLANGIC || yeniBitis > GUN_BITIS) {
                        ihlalSayaci++;
                        System.out.printf("[HATA] Gecersiz saat araligi girdiniz! (Ihlal %d/%d)%n", ihlalSayaci, MAX_IHLAL);
                    } else {
                        // Cakisma Kontrol Algoritmasi: (Baslangic1 < Bitis2) && (Baslangic2 < Bitis1)
                        boolean cakismaVar = (yeniBaslangic < mevcutBitis) && (mevcutBaslangic < yeniBitis);

                        if (cakismaVar) {
                            ihlalSayaci++;
                            System.out.println("\n[CAKISMA TESPIT EDILDI!]");
                            System.out.printf("Girdiginiz saat (%02d:00 - %02d:00), '%s' (%02d:00 - %02d:00) ile cakismaktadir!%n",
                                    yeniBaslangic, yeniBitis, mevcutDersAdi, mevcutBaslangic, mevcutBitis);
                            System.out.printf("[KURAL DIŞI TALEP] Cakisan saate ders eklenemez. (Ihlal %d/%d)%n", ihlalSayaci, MAX_IHLAL);
                        } else {
                            System.out.println("[BASARILI] Saat araliginda cakisma yok, ders programa uygun.");
                        }
                    }

                    // KURAL 9 KONTROLU: 3 ihlal tekrarlaninca gecici engelleme
                    if (ihlalSayaci >= MAX_IHLAL) {
                        System.out.println("\n**************************************************************");
                        System.out.println("[KURAL 9 DEVREYE GIRDI - KULLANICI GECICI OLARAK ENGELLENDI]");
                        System.out.println("Neden: 3 kez ust uste hatali giris veya cakisan saat talebinde bulunuldu.");
                        System.out.println("Sistem 5 saniye kilitleniyor, lutfen bekleyiniz...");
                        System.out.println("**************************************************************");
                        try {
                            Thread.sleep(5000); // 5 saniye bekletme / engelleme
                        } catch (InterruptedException e) {
                            System.out.println("Bekleme kesintiye ugradi.");
                        }
                        ihlalSayaci = 0; // Ceza sonrasi sayaci sifirla
                        System.out.println("[BILGI] Engelleme kaldirildi. Lutfen kurallara uygun islem yapiniz.\n");
                    }
                    break;

                case 3:
                    System.out.println("\n--- BOS SAAT ONERISI ---");
                    System.out.println("Mesai saatleri (08:00 - 17:00) icerisindeki musait saatler:");
                    if (GUN_BASLANGIC < mevcutBaslangic) {
                        System.out.printf(" -> Sabah Araligi: %02d:00 - %02d:00 arasi musait.%n", GUN_BASLANGIC, mevcutBaslangic);
                    }
                    if (mevcutBitis < GUN_BITIS) {
                        System.out.printf(" -> Ogle/Ogleden Sonra: %02d:00 - %02d:00 arasi musait.%n", mevcutBitis, GUN_BITIS);
                    }
                    break;

                case 0:
                    System.out.println("Iyi gunler!");
                    break;

                default:
                    ihlalSayaci++;
                    System.out.printf("[HATA] Gecersiz secim yaptiniz! (Ihlal %d/%d)%n", ihlalSayaci, MAX_IHLAL);
                    if (ihlalSayaci >= MAX_IHLAL) {
                        System.out.println("[KURAL 9] 3 hatali islem nedeniyle gecici engellendiniz. Neden: Menude olmayan secenekler girildi.");
                        ihlalSayaci = 0;
                    }
            }
        } while (secim != 0); // 0 gozcu degeri: 0 girilene kadar menuden cikmaz

        input.close();
    }
}