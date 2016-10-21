package mx.iteso.singleton.tables;

import mx.iteso.singleton.TableOrder;

import java.util.ArrayList;

public class Table1 extends TableOrder {

    private static TableOrder uniqueInstance;

    private Table1(){
        tableName = "Table 1";
        drinks = new ArrayList();
        dishes = new ArrayList();
    }

    public static TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table1();
        }
        return uniqueInstance;
    }

    public static void clearOrder(){
        uniqueInstance = null;
    }

}

