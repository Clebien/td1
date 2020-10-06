package td1.refactor.api.macdeau;

import td1.refactor.api.general.Burger.BurgerBuilder;
import td1.refactor.api.general.BurgerRestaurant;
import td1.refactor.api.general.Meat.MeatType;
import td1.refactor.api.general.MenuType;
import td1.refactor.api.general.Size;

import static td1.refactor.api.general.Meat.MeatType.BEEF;
import static td1.refactor.api.general.Meat.MeatType.WHITEFISH;
import static td1.refactor.api.general.Sauce.SauceType.BEARNAISE;
import static td1.refactor.api.general.Sauce.SauceType.BURGER;
import static td1.refactor.api.general.Size.*;

public class MacDeauRestaurant implements BurgerRestaurant {

    private static MacDeauRestaurant instance = null;

    private MacDeauRestaurant() {
    }

    public static BurgerRestaurant queue() {
        if (instance == null) {
            instance = new MacDeauRestaurant();
        }
        return instance;
    }

    @Override
    public BurgerBuilder order_menu(MenuType menu) {
        BurgerBuilder b = null;
        switch (menu) {
            case MEAT_MENU:
                b = new MacDeauBuilder("Beefy", MEDIUM, BEEF).with_sauce(BURGER).with_onions().with_cheese();
                break;
            case FISH_MENU:
                b = new MacDeauBuilder("Fishy", SMALL, WHITEFISH).with_sauce(BEARNAISE);
                break;
            case CHEESE_MENU:
            default:
                b = new MacDeauBuilder("Cheesy", SMALL, BEEF).with_cheese();
        }
        return b;
    }

    @Override
    public BurgerBuilder order_personal(Size size, MeatType type) {
        return new MacDeauBuilder("Own style", size, type);
    }

}
