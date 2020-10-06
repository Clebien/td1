package td1.refactor.client;

import td1.refactor.api.general.Burger;
import static td1.refactor.api.general.Size.*;
import static td1.refactor.api.general.MenuType.*;
import static td1.refactor.api.general.Meat.MeatType.*;
import static td1.refactor.api.general.Sauce.SauceType.*;
import static td1.refactor.api.general.Tariff.CHEAP;
import static td1.refactor.api.general.Tariff.EXPENSIVE;

import td1.refactor.api.BurgerBuilderFactory;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String args[]) {
        BurgerBuilderFactory advisor = new BurgerBuilderFactory();
        // A regular burger
        Burger alice_dinner = advisor
                .select(CHEAP)
                .order_menu(FISH_MENU)
                .cook();
        // A burger with extra onions and cheese
        Burger bob_dinner = advisor
                .select(CHEAP)
                .order_menu(MEAT_MENU)
                .with_onions()
                .with_cheese()
                .cook();
        // Cholesterol Burger
        Burger charles_dinner = advisor
                .select(EXPENSIVE)
                .order_personal(BIG, BEEF)
                .with_onions()
                .with_cheese()
                .with_sauce(BARBECUE)
                .with_sauce(BEARNAISE)
                .with_sauce(BURGER)
                .with_cheese()
                .cook();
        List<Burger> dinners = Arrays.asList(
                alice_dinner,
                bob_dinner,
                charles_dinner
        );
        for (Burger dinner : dinners) {
            System.out.println(dinner);
        }
    }
}