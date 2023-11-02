package org.loopz.sealegends.champions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.loopz.sealegends.Main;
import org.loopz.sealegends.managers.Champions;

public class Argo extends Champions {

    // Developer Configs
    private boolean debugm = Main.getPlugin().

    // Others Configs
    private int task;
    private double delayF; // Tempo para poder utilizar novamente a habilidade
    private double durationF; // Duração da habilidade

    public Argo() {
        super("Argo");
        delayF = 4;
        durationF = 7;
    }



    public void firstAbility(Player p, Location target) {
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            int counter = 0;

            @Override
            public void run() {
                if (!(counter > durationF)) {
                    Bukkit.getScheduler().cancelTask(task);
                    p.sendMessage("§cSua habilidade §e§nChuva De Flechas§c acabou.");
                    return;
                }
                int startX = target.getBlockX() - 2;
                int startZ = target.getBlockZ() - 2;

                for (int x = startX; x <= startX + 4; x++) {
                    for (int z = startZ; z <= startZ + 4; z++) {
                        Location spawnLocation = new Location(target.getWorld(), x + 0.5, target.getY(), z + 0.5);
                        Arrow arrow = target.getWorld().spawnArrow(spawnLocation, target.getDirection(), 1.0f, 0.0f);
                        arrow.setFireTicks(0); // Remove o fogo das flechas, se estiver ativo

                        // Opcionalmente, você pode aplicar outras configurações às flechas, como velocidade ou dano
                        // arrow.setVelocity(new Vector(xVel, yVel, zVel));
                        // arrow.setDamage(damage);
                    }
                }
                p.sendMessage("§");
                counter++;
            }
        }, 0, 10L); // Executa a cada meio segundo (10 ticks)
    }


}
