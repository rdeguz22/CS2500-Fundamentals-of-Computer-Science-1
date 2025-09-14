class TurtleSpawner : Spawner<Turtle>(
    spawnType = "Turtle",
    spawn = { Turtle() },
    spawnProbability = 0.5,
    hardness = 8
)