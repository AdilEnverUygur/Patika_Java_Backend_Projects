package PatikaStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatikaStore {
    List<Brand> brands = new ArrayList<>();
    Map<String, List<Product>> productsByCategory = new HashMap<>();

    public PatikaStore() {
        brands.add(new Brand(1, "Samsung"));
        // ... Add other brands

        productsByCategory.put("Cep Telefonları", new ArrayList<>());
        productsByCategory.put("Notebook", new ArrayList<>());
        // ... Add other categories
    }

    public void listBrands() {
        System.out.println("Markalarımız");
        System.out.println("--------------");
        for (Brand brand : brands) {
            System.out.println("- " + brand.name);
        }
    }

    public void addProduct(int categoryId, double price, double discountRate, int stock, String name, int brandId) {
        Brand brand = null;
        for (Brand b : brands) {
            if (b.id == brandId) {
                brand = b;
                break;
            }
        }
        if (brand == null) {
            System.out.println("Geçersiz marka ID'si.");
            return;
        }

        List<Product> categoryProducts = productsByCategory.get(categoryId);
        if (categoryProducts == null) {
            System.out.println("Geçersiz kategori.");
            return;
        }

        int productId = categoryProducts.size() + 1;
        Product product = new Product(productId, price, discountRate, stock, name, brand);
        categoryProducts.add(product);
        System.out.println("Ürün eklendi.");
    }

    public void listProducts(int categoryId) {
        List<Product> categoryProducts = productsByCategory.get(categoryId);
        if (categoryProducts == null) {
            System.out.println("Geçersiz kategori.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.format("| %-3s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        for (Product product : categoryProducts) {
            System.out.format("| %-3d | %-30s | %-10.2f | %-10s | %-10s | %-10s | %-10s | %-10.1f | %-10d | %-10s |%n",
                    product.id, product.name, product.price, product.brand.name, "Depolama", "Ekran", "Kamera",
                    product.stock, "RAM", "Renk");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

    // Add other methods here...
}
