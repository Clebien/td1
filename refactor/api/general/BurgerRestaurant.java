package td1.refactor.api.general;

import td1.refactor.api.general.Burger.BurgerBuilder;

public interface BurgerRestaurant {
    BurgerBuilder order_menu(MenuType menu);

    BurgerBuilder order_personal(Size size, Meat.MeatType type);
}
