package mx.iteso.singleton.tables;

import mx.iteso.singleton.TableOrder;

import java.util.ArrayList;

public class Table3 extends TableOrder{

    private static TableOrder uniqueInstance;

    private Table3(){
        tableName = "Table 3";
        drinks = new ArrayList();
        dishes = new ArrayList();
    }

    public static TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table3();
        }
        return uniqueInstance;
    }

    public static void clearOrder(){
        uniqueInstance = null;
    }

}
