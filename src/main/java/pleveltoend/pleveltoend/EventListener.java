package pleveltoend.pleveltoend;

import com.destroystokyo.paper.event.player.PlayerAdvancementCriterionGrantEvent;
import io.papermc.paper.advancement.AdvancementDisplay;
import jdk.jfr.Enabled;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onExplosion(PlayerInteractEvent e){
        //if(start.ss == false) return;
        Player p = e.getPlayer();
        World w = Bukkit.getWorld("world_the_end");
        Location l = w.getSpawnLocation();

        if(p.getInventory().getItemInMainHand().getType() == Material.STICK){

            if(p.getLevel() >= 100){
                    p.teleport(l);
            }
        }
    }
    static int level = 0;

    @EventHandler
    public void on(PlayerAdvancementDoneEvent event) {
        Advancement advancement = event.getAdvancement();
        AdvancementDisplay display = advancement.getDisplay();
        if (display == null) {
            return;
        }
        level += 4;
        // give exp here
        Bukkit.getOnlinePlayers().forEach(all -> all .setLevel(level));
    }

    @EventHandler
    public void onExp(PlayerMoveEvent e){
        Player p = e.getPlayer();
        p.setLevel(level);
    }

    /*
    @EventHandler
    public void on(PlayerAdvancementCriterionGrantEvent event) {
        Bukkit.getOnlinePlayers().forEach(all -> all .setLevel(all .getLevel() + 1));
        Bukkit.broadcastMessage("ts");

    }

     */

/*
    private static void addAdvancementExp(Player player) {
        //final int exp = 5; // or whatever
        //player.setTotalExperience(player.getTotalExperience() + exp);
        player.setLevel(player.getLevel() + 1);
    }

 */

}
