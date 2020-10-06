package td1.refactor.api;

import td1.refactor.api.bigburger.BigBurgerRestaurant;
import td1.refactor.api.general.BurgerRestaurant;
import td1.refactor.api.general.Tariff;
import td1.refactor.api.macdeau.MacDeauRestaurant;

public class BurgerBuilderFactory {
    public BurgerBuilderFactory() {
        // empty
    }

    public BurgerRestaurant select(Tariff tariff) {
        switch (tariff) {
            case CHEAP:
                return MacDeauRestaurant.queue();
            case EXPENSIVE:
            default:
                return BigBurgerRestaurant.queue();
        }
    }
}
