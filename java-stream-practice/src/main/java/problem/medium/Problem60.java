package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import problem.medium.resources.Customer2;
import problem.medium.resources.Employee;
import problem.medium.resources.Product;

public class Problem60 {

    /**
     * 주어진 고객(Customer) 리스트와 직원(Employee) 리스트를 사용하여,
     * 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격을 계산합니다.
     * 이때, 고객 이름과 직원 이름이 일치하는 경우에만 해당 고객의 주문을 고려합니다.
     *
     * @param customers 고객 리스트
     * @param employees 직원 리스트
     * @param products 제품 리스트 (제품 이름과 가격 정보 포함)
     * @return 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격
     */
    //최고 어려운 문제 ;;
    public static double calculateTotalPriceOfElectronicsOrderedByITEmployees(List<Customer2> customers,
                                                                              List<Employee> employees,
                                                                              List<Product> products) {
        // 여기에 코드 작성

        //IT부서 직원들 리스트
        Set<String> itName = employees.stream()
                .filter(s -> s.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toSet());
        //맵
        Map<String, Double> productMap = products.stream()
                .collect(Collectors.toMap(
                        Product::getName,
                        Product::getPrice
                ));

        return customers.stream()
                .filter(c -> itName.contains(c.getName()))
                .mapToDouble(c -> {
                    return c.getOrders().stream()
                            .mapToDouble(o -> {
                                double price = productMap.getOrDefault(o.getProduct(),0.0);
                                return price * o.getQuantity();
                            }).sum();
                }).sum();
    }
}
