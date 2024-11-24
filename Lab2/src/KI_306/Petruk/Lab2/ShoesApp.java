package KI_306.Petruk.Lab2;

import java.io.*;
public class ShoesApp {
    public static void main(String[] args) throws FileNotFoundException {
        KI_306.Petruk.Lab2.Shoes shoes = new KI_306.Petruk.Lab2.Shoes("black", "white", true, "fabric", "white", 42);
        shoes.shoeInfo();
        shoes.unlaceShoes();
        shoes.repairShoes();
        shoes.cleanShoes();
        shoes.changeColor("red");
        shoes.changeLaces("red");
        shoes.changeSoleColor("black");
        shoes.putOnShoes();
        shoes.expandShoes(4);
        shoes.shrinkShoes(2);
        shoes.laceShoes();
        shoes.shoeInfo();
        shoes.takeOffShoes();
        shoes.dispose();
    }
}
