package mx.iteso;

import mx.iteso.singleton.Dish;
import mx.iteso.singleton.Drink;
import mx.iteso.singleton.TableOrder;
import mx.iteso.singleton.tables.Table1;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Edmundo on 20/10/2016.
 */
public class Table1Test {
    TableOrder T1;
    Drink coke;
    Dish alitas;
    @Before
    public void setUp()
    {
         T1 = Table1.getInstance();
         coke = new Drink();
        coke.setPrice(11);
        coke.setDescription("COCA COLA FRIA");
        coke.setName("COCA COLA");
        coke.setWaiter("Betzi");
        alitas = new Dish();
        alitas.setPrice(50);
        alitas.setDescription("Xtra Hot");
        alitas.setName("Alitas Especiales");
        alitas.setWaiter("Betzi");
    }
    @Test
    public void addDrink_Dish()
    {

        T1.addDrink(coke);
        T1.addDish(alitas);
        assertEquals (61,T1.printCheck(),0);
        assertEquals("COCA COLA FRIA",coke.getDescription());
        assertEquals("COCA COLA",coke.getName());
        assertEquals("Betzi",coke.getWaiter());
        assertEquals("Xtra Hot",alitas.getDescription());
        assertEquals("Alitas Especiales",alitas.getName());
        assertEquals("Betzi",alitas.getWaiter());

    }
    @Test
    public void doubleInstance()
    {
        TableOrder T1_dos;
        T1_dos = Table1.getInstance(); // se forzo una concurrencia
        assertEquals(T1,T1_dos);


    }
    @Test
    public void clearDrink()
    {
        T1.addDrink(coke);
        T1.clearDrinks();
        T1.clearDishes();
        assertEquals (0,T1.printCheck(),0);

    }
    @Test
    public void clearDish()
    {
        T1.addDish(alitas);
        T1.clearDishes();
        T1.clearDrinks();
        assertEquals (0,T1.printCheck(),0);

    }
    @Test
    public void clearOrder()
    {
        T1.addDish(alitas);
        T1.clearDishes();
        T1.clearDrinks();
        Table1.clearOrder();
        assertEquals (0,T1.printCheck(),0);

    }
}
