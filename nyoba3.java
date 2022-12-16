import java.util.Scanner;

public class nyoba3 {
    static Scanner dela8 = new Scanner(System.in);

    static String[] jenis = { "1. Appetizer", "2. Main Course", "3. Dessert", "4. Minuman" };

    static String[][] menu = {
            { "1. Salad", "2. Chicken Soup", "3. Apple Pie" },
            { "4. Nasi Goreng", "5. Spagetti", "6. Ayam Goreng" },
            { "7. Pudding", "8. Brownies", "9. Cheese Cake" },
            { "10. Americano", "11. Thai Tea", "12. Matcha" }
    };
    static int[][] harga = {
            { 20000, 30000, 45000 },
            { 30000, 50000, 25000 },
            { 20000, 25000, 35000 },
            { 20000, 25000, 30000 }
    };

    static int[] pesanan = new int[dela8.nextInt()];
    static int[] njumlah = new int[pesanan.length];
    static int[] nharga = new int[pesanan.length];

    static int jumlah, totalakhir, total = 0, diskon;
    static String pMenu, pilih, jawaban, kode;

    public static void main(String args[]) {
        String akun[] = { "Dela", "09876" };
        String username, password;
        System.out.println("LOGIN");
        System.out.println("Masukkan Username : ");
        username = dela8.nextLine();
        System.out.println("Masukkan Paswword : ");
        password = dela8.nextLine();
        if (username.equals(akun[0]) && password.equals(akun[1])) {
            System.out.println("Selamat Datang");
            home();
        } else {
            System.out.println("Username dan Password yang Anda masukkan salah");
        }
    }

    static void home() {
        int tempat;
        System.out.println("1. Makan di tempat \n2. Reservasi tempat");
        System.out.print("Pilih : ");
        tempat = dela8.nextInt();
        switch (tempat) {
            case 1:
                pilihMenu();
                break;
            case 2:
                reservasi();
                break;
            default:
                System.out.println("Mohon maaf, hanya tersedia dua pilihan");

        }
    }

    static void reservasi() {
        // jenis();
        System.out.println("Blom dicoding");
    }

    static int hitungKembalian(int bayar) {
        int kembalian;

        kembalian = bayar - total;
        return kembalian;
    }

    static void pilihMenu() {

        for (int i = 0; i < jenis.length; i++) {
            System.out.println(jenis[i]);
            for (int j = 0; j < menu[0].length; j++) {
                System.out.println(menu[i][j] + "\t" + harga[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < pesanan.length; i++) {
            totalakhir = total;
            System.out.println("\nMasukkan nomer dari menu :" + (i + 1));
            pesanan[i] = dela8.nextInt();
            while (i > 12 || i < 1) {
                System.out.println("Mohon masukkan angka sesuai Menu Paket yang tersedia!");
                System.out.println("\nMasukkan nomer dari menu :");
                pesanan[i] = dela8.nextInt();
    
            }
            for (int j = 0; j < pesanan.length; j++) {
                System.out.println("Berapa jumlah yang ingin dipesan?");
                jumlah = dela8.nextInt();
                total = totalakhir + (harga[i][j] * jumlah);
            }

            System.out.println("\nApakah anda ingin memesan lagi? \"y\" atau \"n\"");
            jawaban = dela8.next();

            while (jawaban.equalsIgnoreCase("y"));
            if (jawaban.equalsIgnoreCase("n")) {

                System.out.println("Masukkan code untuk klaim diskon : ");
                kode = dela8.next();
                String check;
    
                if (kode.equalsIgnoreCase("POLINEMA")) {
                    System.out.println("\n=======================================");
                    // System.out.println("Daftar Pesanan :\n" + (String)pMenu);
                    System.out.println("Selamat anda mendapat diskon 20%");
                    diskon = total * 20 / 100;
                    total -= diskon;
                    System.out.println("Total pembayaran anda menjadi = Rp. " + (int) total + ",-");
                    System.out.println("=======================================");
                    // return total;
                } else {
                    System.out.println("\n=======================================");
                    System.out.println("Total pembayaran anda menjadi = Rp. " + (int) total + ",-");
                    System.out.println("=======================================");
                    // return total;
                }
    
                int pTransaksi, bayar, kembalian, tampil;
    
                System.out.println("1. Cash \n2. QRIS");
                System.out.print("Pilih transaksi : ");
                pTransaksi = dela8.nextInt();
                if (pTransaksi == 1) {
                    System.out.println("Uang pembeli : ");
                    bayar = dela8.nextInt();
                    kembalian = hitungKembalian(bayar);
                    System.out.println("Kembalian : " + kembalian);
                } else if (pTransaksi == 2) {
                    tampil = diskon(total);
                    System.out.println("Bayar : " + tampil);
    
                }
    
            } else {
                System.out.println("Terima Kasih");
            }
        }

        
        
        
        

        // do {
        //     totalakhir = total;
        //     pMenu = pilih;
        //     int pesanan;
                 
        //     switch (pesanan) {
        //         case 1:
        //             total = totalakhir + (harga[0][0] * jumlah);
        //             pilih = pMenu + (menu[0][0]);
        //             break;
        //         case 2:
        //             total = totalakhir + (harga[0][1] * jumlah);
        //             pilih = menu[0][1];
        //             break;
        //         case 3:
        //             total = totalakhir + (harga[0][2] * jumlah);
        //             pilih = menu[0][2];
        //             break;
        //         case 4:
        //             total = totalakhir + (harga[1][0] * jumlah);
        //             pilih = menu[1][0];
        //             break;
        //         case 5:
        //             total = totalakhir + (harga[1][1] * jumlah);
        //             pilih = menu[1][1];
        //             break;
        //         case 6:
        //             total = totalakhir + (harga[1][2] * jumlah);
        //             pilih = menu[1][2];
        //             break;
        //         case 7:
        //             total = totalakhir + (harga[2][0] * jumlah);
        //             pilih = menu[2][0];
        //             break;
        //         case 8:
        //             total = totalakhir + (harga[2][1] * jumlah);
        //             pilih = menu[2][1];
        //             break;
        //         case 9:
        //             total = totalakhir + (harga[2][2] * jumlah);
        //             pilih = menu[2][2];
        //             break;
        //         case 10:
        //             total = totalakhir + (harga[3][0] * jumlah);
        //             pilih = menu[3][0];
        //             break;
        //         case 11:
        //             total = totalakhir + (harga[3][1] * jumlah);
        //             pilih = menu[3][1];
        //             break;
        //         case 12:
        //             total = totalakhir + (harga[3][2] * jumlah);
        //             pilih = menu[3][2];
        //             break;
        //         default:
        //             System.out.println("Mohon maaf, hanya tersedia 3 jenis menu");
        //     }

            
         

        
    }

    static int diskon(int total) {
        if (kode.equalsIgnoreCase("POLINEMA")) {
            System.out.println("\n=======================================");
            System.out.println("Selamat anda mendapat diskon 20%");
            diskon = total * 20 / 100;
            total -= diskon;
            System.out.println("Total pembayaran anda menjadi = Rp. " + (int) total + ",-");
            System.out.println("=======================================");
            return total;
        } else {
            System.out.println("\n=======================================");
            System.out.println("Total pembayaran anda menjadi = Rp. " + (int) total + ",-");
            System.out.println("=======================================");
            return total;
        }

    }
}
