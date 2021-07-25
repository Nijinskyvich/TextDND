/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textdnd;
import java.lang.Math;
import java.util.*;

/**
 *
 * @author timot
 */
public class Stat {
    int base;
    int bonus;
    String name;
    //private List<Array> bonuses = new ArrayList<String>();
    
    
    public Stat(String statName, int statBase,int statBonus){
        this.name = statName;
        this.base = statBase;
        this.bonus = statBonus;
    }
    
    public void addBonus(int value, String Description) {
        
    }
    
    //To do add method of bonuses where bonuses indexed by why they are there
    
    
    public int getMod() {
        return (int) Math.floor((base + bonus - 10) / 2);
    }
    
}
