package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import problem.medium.resources.Product;

public class Problem59 {

    /**
     * 주어진 제품(Product) 리스트에서 각 카테고리별로 제품의 가격 합계를 계산합니다.
     * 이때, 카테고리는 제품 이름의 첫 글자로 결정됩니다. 예를 들어, 'Milk'는 'M' 카테고리에 속합니다.
     *
     * @param products 제품 리스트
     * @return 카테고리별 제품 가격 합계를 나타내는 Map
     */
    public static Map<Character, Double> getTotalPriceByCategory(List<Product> products) {
       return products.stream().collect(Collectors.groupingBy(
                s -> s.getName().charAt(0),
                Collectors.summingDouble(Product::getPrice)
        ));
    }
}
