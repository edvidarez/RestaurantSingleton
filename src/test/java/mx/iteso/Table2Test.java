package mx.iteso;

import mx.iteso.singleton.Dish;
import mx.iteso.singleton.Drink;
import mx.iteso.singleton.TableOrder;
import mx.iteso.singleton.tables.Table2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Edmundo on 20/10/2016.
 */
public class Table2Test {
    TableOrder T2;
    Drink coke;
    Dish alitas;
    @Before
    public void setUp()
    {
        T2 = Table2.getInstance();
        coke = new Drink();
        coke.setPrice(11);
        alitas = new Dish();
        alitas.setPrice(50);
    }
    @Test
    public void addDrink_Dish()
    {

        T2.addDrink(coke);
        T2.addDish(alitas);
        assertEquals (61,T2.printCheck(),0);

    }
    @Test
    public void doubleInstance()
    {
        TableOrder T2_dos;
        T2_dos = Table2.getInstance(); // se forzo una concurrencia
        assertEquals(T2,T2_dos);


    }
    @Test
    public void clearDrink()
    {
        T2.addDrink(coke);
        T2.clearDrinks();
        T2.clearDishes();
        assertEquals (0,T2.printCheck(),0);

    }
    @Test
    public void clearDish()
    {
        T2.addDish(alitas);
        T2.clearDishes();
        T2.clearDrinks();
        assertEquals (0,T2.printCheck(),0);

    }
    @Test
    public void clearOrder()
    {
        T2.addDish(alitas);
        T2.clearDishes();
        T2.clearDrinks();
        Table2.clearOrder();
        assertEquals (0,T2.printCheck(),0);

    }
}
