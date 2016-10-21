package mx.iteso;

import mx.iteso.singleton.Dish;
import mx.iteso.singleton.Drink;
import mx.iteso.singleton.TableOrder;

import mx.iteso.singleton.tables.Table3;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Edmundo on 20/10/2016.
 */
public class Table3Test {
    TableOrder T3;
    Drink coke;
    Dish alitas;
    @Before
    public void setUp()
    {
        T3 = Table3.getInstance();
        coke = new Drink();
        coke.setPrice(11);
        alitas = new Dish();
        alitas.setPrice(50);
    }
    @Test
    public void addDrink_Dish()
    {

        T3.addDrink(coke);
        T3.addDish(alitas);
        assertEquals (61,T3.printCheck(),0);

    }
    @Test
    public void doubleInstance()
    {
        TableOrder T3_dos;
        T3_dos = Table3.getInstance(); // se forzo una concurrencia
        assertEquals(T3,T3_dos);


    }
    @Test
    public void clearDrink()
    {
        T3.addDrink(coke);
        T3.clearDrinks();
        T3.clearDishes();
        assertEquals (0,T3.printCheck(),0);

    }
    @Test
    public void clearDish()
    {
        T3.addDish(alitas);
        T3.clearDishes();
        T3.clearDrinks();
        assertEquals (0,T3.printCheck(),0);

    }
    @Test
    public void clearOrder()
    {
        T3.addDish(alitas);
        T3.clearDishes();
        T3.clearDrinks();
        Table3.clearOrder();
        assertEquals (0,T3.printCheck(),0);

    }
}
