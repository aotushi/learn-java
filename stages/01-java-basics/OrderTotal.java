import java.util.List;

public class OrderTotal {
    record LineItem(String sku, long unitPriceMinor, int quantity) {
        LineItem {
            if (sku == null || sku.isBlank()) {
                throw new IllegalArgumentException("SKU 不能为空。");
            }
            if (unitPriceMinor < 0 || quantity < 1) {
                throw new IllegalArgumentException("价格不能为负数，数量必须至少为 1。");
            }
        }

        long subtotalMinor() {
            return Math.multiplyExact(unitPriceMinor, quantity);
        }
    }

    static long subtotal(List<LineItem> items) {
        return items.stream()
                .mapToLong(LineItem::subtotalMinor)
                .reduce(0L, Math::addExact);
    }

    static String formatMoney(long amountMinor) {
        return "CNY %.2f".formatted(amountMinor / 100.0);
    }

    public static void main(String[] args) {
        var items = List.of(
                new LineItem("JAVA-BOOK", 9_900, 1),
                new LineItem("USB-CABLE", 2_500, 2)
        );

        long subtotal = subtotal(items);
        long discount = subtotal >= 10_000 ? subtotal / 10 : 0;
        long shipping = subtotal - discount >= 29_900 ? 0 : 2_000;
        long total = Math.addExact(subtotal - discount, shipping);

        System.out.println("商品小计：" + formatMoney(subtotal));
        System.out.println("优惠金额：" + formatMoney(discount));
        System.out.println("运费：" + formatMoney(shipping));
        System.out.println("应付总额：" + formatMoney(total));
    }
}
