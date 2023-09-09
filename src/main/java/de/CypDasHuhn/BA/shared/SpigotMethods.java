package de.CypDasHuhn.BA.shared;

import org.bukkit.Location;
import org.bukkit.World;

import static java.lang.Integer.parseInt;

public class SpigotMethods {
    public static Location getLocationFromInts(World world, int x, int y, int z) {
        return new Location(
          world,
          x,
          y,
          z
        );
    }
    public static Location getLocationFromInts(World world, String x, String y, String z) {
        return new Location(
                world,
                parseInt(x),
                parseInt(y),
                parseInt(z)
        );
    }

    public static Location[] getAllignedLocations(Location cornerA, Location cornerB) {
        return new Location[]{
                new Location(cornerA.getWorld(), // North West Bottom
                        Math.min(cornerA.getX(), cornerB.getX()),
                        Math.min(cornerA.getY(), cornerB.getY()),
                        Math.min(cornerA.getZ(), cornerB.getZ())),
                new Location(cornerA.getWorld(), // South East Top
                        Math.max(cornerA.getX(), cornerB.getX()),
                        Math.max(cornerA.getY(), cornerB.getY()),
                        Math.max(cornerA.getZ(), cornerB.getZ()))
        };
    }
}
