/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textdnd;
import java.util.*;
import java.util.Arrays;

        
/**
 *
 * @author timot
 */
public class IO {
    
    public static String[][] aliases = {
        {"exit","quit","close"},
        {"stats","ability scores"},
        {"skills","skill scores"},
        {"load"},
        {"health","hp"},
        {"level up"}       
    };
    
    static Scanner scan = new Scanner(System.in);
    
    //Initialize stats unless otherwise specified
    
    
    
    public static String baseCommand(String command) {
        
        for (String[] alias : aliases) {
            if (Arrays.asList(alias).contains(command)) {
                return alias[0];
            }
        }    
        return "Command not found";
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        String suffix;
        
        int proficiencyBon = 2;
        Stat Str = new Stat("Strength",14,0);
        Stat Dex = new Stat("Dexterity",16,0);
        Stat Con = new Stat("Constitution",12,0);
        
        
        Stat[] stats = {Str,Dex,Con};
        
        Skill Acrobatics = new Skill(Dex,"Acrobatics",true,proficiencyBon);
        Skill Athletics = new Skill(Str,"Athletics",false,proficiencyBon);
        Skill Stealth = new Skill(Dex,"Stealth",false,proficiencyBon);

        Skill[] skills = {Acrobatics,Athletics,Stealth};

        Health playerHealth = new Health(Con,8,20,5);
        
        
        System.out.println("####################");
        System.out.println("#DND companion v1.0#");
        System.out.println("####################");

        while (true) {
            System.out.println(">What do you want to do");
            String UserInput = scan.nextLine();
            
            UserInput = baseCommand(UserInput.toLowerCase());
            
            //System.out.println(UserInput);
            if (UserInput.equals("exit")) {
                System.out.println("Leaving Program");
                System.exit(0);
            } else if (UserInput.equals("health")) {
                System.out.println(playerHealth.getHealth());
            } else if  (UserInput.equals("level up")) {
                System.out.println("Roll a d" + playerHealth.hitDiceValue +" to determine new level bonus health");
                while (true) { 
                    UserInput = scan.nextLine();
                    if (isNumeric(UserInput)){
                        int d = Integer.parseInt(UserInput);
                        if (d > 0 && d <= playerHealth.hitDiceValue) {
                            playerHealth.level += 1;
                            playerHealth.noConHealth += d;
                            System.out.println(playerHealth.getHealth());
                            break;
                        }
                    }
                }
            } else if (UserInput.equals("stats")) {
                for (Stat element : stats) {
                    System.out.println(element.name + ": " + element.base + ", Modifier: +" + element.getMod());
                }
            } else if (UserInput.equals("skills")) {
                for (Skill element : skills) {
                    if (element.proficiency == true) {
                        suffix = " (Proficient)";
                    } else {
                        suffix = "";
                    }
                    System.out.println(element.name + " (" + element.linkedStat.name +"): +" + element.getBonus() + suffix);
                }
    
            }
        }
    }
    
}


