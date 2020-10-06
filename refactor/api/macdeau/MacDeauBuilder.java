package td1.refactor.api.macdeau;

import td1.refactor.api.general.*;
import td1.refactor.api.general.Sauce.SauceType;

import java.util.ArrayList;
import java.util.List;

public class MacDeauBuilder implements Burger.BurgerBuilder {

    String name;
    Size size;
    Meat meat;
    List<FoodProduct> products;

    MacDeauBuilder(String name, Size size, Meat.MeatType type) {
        this.name = name;
        this.size = size;
        double weight_for_size;
        switch (size) {
            case SMALL:
                weight_for_size = 50;
                break;
            case MEDIUM:
                weight_for_size = 100;
                break;
            case BIG:
            default:
                weight_for_size = 200;
        }
        this.meat = new Meat(type, weight_for_size);
        this.products = new ArrayList<>();
    }

    public MacDeauBuilder with_sauce(SauceType sauce) {
        this.products.add(new Sauce(sauce, 40));
        return this;
    }

    public MacDeauBuilder with_onions() {
        this.products.add(new DeepFriedOnions(10));
        return this;
    }

    public MacDeauBuilder with_tomato() {
        this.products.add(new Tomato(10));
        return this;
    }

    public MacDeauBuilder with_cheese() {
        this.products.add(new Cheddar(15));
        return this;
    }

    public Burger cook() {
        return new MacDeauBurger(this);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public List<FoodProduct> items() {
        List<FoodProduct> rtr = new ArrayList<>();
        rtr.add(meat);
        rtr.addAll(products);
        return rtr;
    }
}