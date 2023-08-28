package com.cah.pace.anchorengineerkata;

import ch.qos.logback.core.subst.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class AnchorEngineerVendingMachineTests {

    double[][] quarter = {{0.955}, {5.67}};
    double[][] penny = {{0.750}, {2.5}};

    @Test
    void testCoinsAreStored() throws Exception {
        //something to store the coins
        VendingMachine vendingMachine = new VendingMachine();
        double coinValue = 0.25;
//        vendingMachine.acceptCoins(quarter);
        Assertions.assertDoesNotThrow(() -> vendingMachine.acceptCoins(quarter));
//        Assertions.assertEquals(coinValue, vendingMachine.getValueOfCoins());
    }

    private class VendingMachine{
        private double valueOfCoins = 0;
        private CoinProcessor coinProcessor = new CoinProcessor();
        public void acceptCoins(double[][] coin) throws Exception {
//            valueOfCoins += coin;
            if (coinProcessor.isValidCoin(coin)){
//                valueOfCoins += coin;
            } else {
                //invalid coin
                throw new Exception("Invalid coin");
            }

        }


        public double getValueOfCoins(){
            return valueOfCoins;
        }

    }

    private class CoinProcessor{
        //coin collection/processor

        //Allows for configuration in the future
//        private Dictionary<double[][], Double> Coins = new
//        {0.955}, {5.67}}
        private Map<double[][], Double> Coins = new HashMap<double[][], Double>() {{
            put(new double[][] {{0.955}, {5.67}}, 0.25);
            put(new double[][] {{0.705}, {2.268}}, 0.10);
            put(new double[][] {{0.835}, {5.0}}, 0.05);
        }};

        public boolean isValidCoin(double[][] coin){
            double[][] debugQuarter = {{0.955}, {5.67}};
            System.out.printf("Value of .equals: %b", coin.equals(debugQuarter));
            return Coins.containsKey(coin);
            //containsKey uses .equal method, which is shallow. We need to use .deepEquals unfortunately
        }



    }

}


