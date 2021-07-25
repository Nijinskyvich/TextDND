/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textdnd;

/**
 *
 * @author timot
 */
public class Health {
    Stat constitution;
    int hitDiceValue;
    int noConHealth;
    int level;
    
    public Health (Stat conStat, int hitDice, int baseHealth, int playerLevel) {
        this.constitution = conStat;
        this.hitDiceValue = hitDice;
        this.noConHealth = baseHealth;
        this.level = playerLevel;
    }
    
    public String getHealth() {
        int bonus = constitution.getMod()*level;
        return "Health: " + noConHealth + " (+" + bonus + ") = " + (noConHealth + bonus);
    }
    
}
