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
public class Skill {
    Stat linkedStat;
    String name;
    Boolean proficiency;
    int proficiencyBon;
    
    public Skill(Stat givenStat,String nameOfStat,Boolean isProficient, int proficiency2){
        this.linkedStat = givenStat;
        this.name = nameOfStat;
        this.proficiency = isProficient;
        this.proficiencyBon = proficiency2;
    }
    
    public int getBonus(){
        if (this.proficiency == true) {
            return linkedStat.getMod() + proficiencyBon;
        } else {
            return linkedStat.getMod();
        }
    }
}
