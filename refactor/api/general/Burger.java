package td1.refactor.api.general;

import java.util.List;

import td1.refactor.api.general.Sauce.SauceType;

public abstract class Burger implements FoodProduct {

    String name;
    List<FoodProduct> items;

    public interface BurgerBuilder {
        String name();

        List<FoodProduct> items();

        BurgerBuilder with_cheese();

        BurgerBuilder with_onions();

        BurgerBuilder with_sauce(SauceType sauce);

        BurgerBuilder with_tomato();

        Burger cook();
    }

    protected Burger(BurgerBuilder builder) {
        this.name = builder.name();
        this.items = builder.items();
    }

    @Override
    public double calories() {
        return items.stream().map(FoodProduct::calories).reduce(0.0, Double::sum);
    }

    @Override
    public double weight() {
        return items.stream().map(Product::weight).reduce(0.0, Double::sum);
    }

    @Override
    public double price() {
        return items.stream().map(Product::price).reduce(0.0, Double::sum);
    }

    @Override
    public double calories_per_100g() {
        return calories() / weight() * 100;
    }

    @Override
    public String toString() {
        final String DELIM = "--------------------\n";
        StringBuilder buffer = new StringBuilder();
        buffer.append(String.format("*** Menu %s ***\n", name));
        for (FoodProduct item : items) {
            buffer.append(String.format("- %s\n", item));
        }
        buffer.append(DELIM);
        buffer.append(String.format("price:         %.2f\n", price()));
        buffer.append(DELIM);
        buffer.append(String.format("calories:      %.0f\n", calories()));
        buffer.append(String.format("calories/100g: %.0f\n", calories_per_100g()));
        buffer.append(DELIM);
        return buffer.toString();
    }
}
