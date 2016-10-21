package mx.iteso;

import mx.iteso.singleton.Dish;
import mx.iteso.singleton.Drink;
import mx.iteso.singleton.TableOrder;

import mx.iteso.singleton.tables.Table4;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Edmundo on 20/10/2016.
 */
public class Table4Test {
    TableOrder T4;
    Drink coke;
    Dish alitas;
    @Before
    public void setUp()
    {
        T4 = Table4.getInstance();
        coke = new Drink();
        coke.setPrice(11);
        alitas = new Dish();
        alitas.setPrice(50);
    }
    @Test
    public void addDrink_Dish()
    {

        T4.addDrink(coke);
        T4.addDish(alitas);
        assertEquals (61,T4.printCheck(),0);

    }
    @Test
    public void doubleInstance()
    {
        TableOrder T4_dos;
        T4_dos = Table4.getInstance(); // se forzo una concurrencia
        assertEquals(T4,T4_dos);


    }
    @Test
    public void clearDrink()
    {
        T4.addDrink(coke);
        T4.clearDrinks();
        T4.clearDishes();
        assertEquals (0,T4.printCheck(),0);

    }
    @Test
    public void clearDish()
    {
        T4.addDish(alitas);
        T4.clearDishes();
        T4.clearDrinks();
        assertEquals (0,T4.printCheck(),0);

    }
    @Test
    public void clearOrder()
    {
        T4.addDish(alitas);
        T4.clearDishes();
        T4.clearDrinks();
        Table4.clearOrder();
        assertEquals (0,T4.printCheck(),0);

    }
}
