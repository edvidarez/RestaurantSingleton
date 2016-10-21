package mx.iteso.singleton.tables;

import mx.iteso.singleton.TableOrder;

import java.util.ArrayList;

public class Table4 extends TableOrder{

    private static TableOrder uniqueInstance;

    private Table4(){
        tableName = "Table 4";
        drinks = new ArrayList();
        dishes = new ArrayList();
    }

    public static TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table4();
        }
        return uniqueInstance;
    }
    public static void clearOrder(){
        uniqueInstance = null;
    }

}
