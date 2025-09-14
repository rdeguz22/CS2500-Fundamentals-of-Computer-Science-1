/**
 * Spawns Zombies
 */
class ZombieSpawner : Spawner<Zombie>(
    spawnType = "Zombie",
    spawn = { Zombie() },
    spawnProbability = 0.5,
    hardness = 4
)