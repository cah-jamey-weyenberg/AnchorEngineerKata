package com.cah.pace.anchorengineerkata;

import ch.qos.logback.core.subst.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnchorEngineerVendingMachineTests {

    double[][] quarter = {{0.955}, {5.67}};

    @Test
    void testCoinsAreStored() {
        //something to store the coins
        VendingMachine vendingMachine = new VendingMachine();
        double coinValue = 0.25;
        vendingMachine.acceptCoins(quarter);
        Assertions.assertEquals(coinValue, vendingMachine.getValueOfCoins());
    }

    private class VendingMachine{
        private double valueOfCoins = 0;

        public void acceptCoins(double[][] coin){
//            valueOfCoins += coin;
            if (isValidCoin(coin)){
//                valueOfCoins += coin;
            }

        }

        private boolean isValidCoin(double[][] coin){
            return false;
        }

        public double getValueOfCoins(){
            return valueOfCoins;
        }

    }
}


