package problem.medium;

import java.util.List;
import problem.medium.resources.Product;

public class Problem52 {

    /**
     * 주어진 제품(Product) 리스트에서 가격이 20달러 이하인 제품들의 이름을 반환합니다.
     *
     * @param products 제품 리스트
     * @return 가격이 20달러 이하인 제품들의 이름 리스트
     */
    public static List<String> getProductNamesUnder20Dollars(List<Product> products) {
        return products.stream().filter(p -> p.getPrice() <= 20)
                .map(Product::getName).toList();
    }
}
