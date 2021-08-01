class Robot(var gridPosition: GridPosition = GridPosition(0,0), var orientation: Orientation = Orientation.NORTH) {

    fun simulate(instructions: String) {
        val orientationArr: List<Orientation> = listOf(Orientation.NORTH, Orientation.EAST, Orientation.SOUTH, Orientation.WEST)
        for (char in instructions) {
            when (char) {
                'R' -> orientation = orientationArr[Math.floorMod((orientationArr.indexOf(orientation) + 1), 4)]
                'L' -> orientation = orientationArr[Math.floorMod((orientationArr.indexOf(orientation) - 1), 4)]
                'A' -> gridPosition = when (orientation) {
                    Orientation.NORTH -> GridPosition(gridPosition.x,gridPosition.y + 1)
                    Orientation.EAST -> GridPosition(gridPosition.x + 1,gridPosition.y)
                    Orientation.SOUTH -> GridPosition(gridPosition.x,gridPosition.y - 1)
                    Orientation.WEST -> GridPosition(gridPosition.x - 1,gridPosition.y)
                }
            }
        }
    }
}
