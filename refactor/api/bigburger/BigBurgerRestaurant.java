package td1.refactor.api.bigburger;

import td1.refactor.api.general.BurgerRestaurant;
import td1.refactor.api.general.Size;
import td1.refactor.api.general.Meat.MeatType;
import td1.refactor.api.general.MenuType;
import td1.refactor.api.general.Burger.BurgerBuilder;

import static td1.refactor.api.general.Size.*;
import static td1.refactor.api.general.Meat.MeatType.*;
import static td1.refactor.api.general.Sauce.SauceType.*;

public class BigBurgerRestaurant implements BurgerRestaurant {

    private static BigBurgerRestaurant instance = null;

    private BigBurgerRestaurant() {
    }

    public static BurgerRestaurant queue() {
        if (instance == null) {
            instance = new BigBurgerRestaurant();
        }
        return instance;
    }

    @Override
    public BurgerBuilder order_menu(MenuType menu) {
        BurgerBuilder b = null;
        switch (menu) {
            case MEAT_MENU:
                b = new BigBurgerBuilder("BigMarcel", BIG, BEEF).with_sauce(BURGER).with_onions().with_tomato();
                break;
            case FISH_MENU:
                b = new BigBurgerBuilder("FiletO'Poisson", MEDIUM, WHITEFISH).with_sauce(BEARNAISE);
                break;
            case CHEESE_MENU:
            default:
                b = new BigBurgerBuilder("MaxeeCheesee", MEDIUM, BEEF).with_cheese().with_onions();
        }
        return b;
    }

    @Override
    public BurgerBuilder order_personal(Size size, MeatType type) {
        return new BigBurgerBuilder("Own style", size, type);
    }

}
