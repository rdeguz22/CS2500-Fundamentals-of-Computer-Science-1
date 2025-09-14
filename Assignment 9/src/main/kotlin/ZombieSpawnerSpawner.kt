class ZombieSpawnerSpawner : Spawner<ZombieSpawner>(
    spawnType = "Zombie Spawner",
    spawn = { ZombieSpawner() },
    spawnProbability = 0.5,
    hardness = 4
)