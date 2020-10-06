package td1.refactor.api.bigburger;

import td1.refactor.api.general.Size;
import td1.refactor.api.general.Meat;
import td1.refactor.api.general.Sauce;
import td1.refactor.api.general.Burger;
import td1.refactor.api.general.Tomato;
import td1.refactor.api.general.Cheddar;
import td1.refactor.api.general.FoodProduct;
import td1.refactor.api.general.DeepFriedOnions;
import td1.refactor.api.general.Sauce.SauceType;

import java.util.ArrayList;
import java.util.List;

public class BigBurgerBuilder implements Burger.BurgerBuilder {

    String name;
    Size size;
    Meat meat;
    List<FoodProduct> products;

    BigBurgerBuilder(String name, Size size, Meat.MeatType type) {
        this.name = name;
        this.size = size;
        double weight_for_size;
        switch (size) {
            case SMALL:
                weight_for_size = 100;
                break;
            case MEDIUM:
                weight_for_size = 200;
                break;
            case BIG:
            default:
                weight_for_size = 400;
        }
        this.meat = new Meat(type, weight_for_size);
        this.products = new ArrayList<>();
    }

    public BigBurgerBuilder with_sauce(SauceType sauce) {
        this.products.add(new Sauce(sauce, 20));
        return this;
    }

    public BigBurgerBuilder with_onions() {
        this.products.add(new DeepFriedOnions(20));
        return this;
    }

    public BigBurgerBuilder with_tomato() {
        this.products.add(new Tomato(10));
        return this;
    }

    public BigBurgerBuilder with_cheese() {
        this.products.add(new Cheddar(30));
        return this;
    }

    public Burger cook() {
        return new BigBurgerBurger(this);
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