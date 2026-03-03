package Session16.Thuc_hanh;

import java.util.*;

public class ProductRepository implements IRepository<Product> {

    private List<Product> productList = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || productMap.containsKey(item.getId())) {
            return false;
        }
        productList.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null || !productMap.containsKey(id)) {
            return false;
        }
        Product p = productMap.remove(id);
        productList.remove(p);
        return true;
    }

    @Override
    public Product findById(String id) {
        if (id == null) return null;
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    public Map<String, Integer> statisticsByType() {
        Map<String, Integer> result = new HashMap<>();

        for (Product p : productList) {
            String type = p.getClass().getSimpleName();
            result.put(type, result.getOrDefault(type, 0) + 1);
        }
        return result;
    }
}