package mx.iteso.singleton.tables;

import mx.iteso.singleton.TableOrder;

import java.util.ArrayList;

public class Table2 extends TableOrder {

    private static TableOrder uniqueInstance;

    private Table2(){
        tableName = "Table 2";
        drinks = new ArrayList();
        dishes = new ArrayList();
    }

    public static TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table2();
        }
        return uniqueInstance;
    }

    public static void clearOrder(){
        uniqueInstance = null;
    }

}
