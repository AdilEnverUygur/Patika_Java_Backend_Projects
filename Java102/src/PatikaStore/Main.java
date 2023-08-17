package PatikaStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatikaStore patikaStore = new PatikaStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Tercihiniz : ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Çıkış yapılıyor...");
                break;
            } else if (choice == 1) {
                // Notebook işlemleri
                // ...
            } else if (choice == 2) {
                // Cep Telefonu işlemleri
                // ...
            } else if (choice == 3) {
                patikaStore.listBrands();
            } else {
                System.out.println("Geçersiz tercih.");
            }
        }
    }
}
