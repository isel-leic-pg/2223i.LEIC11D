import pt.isel.canvas.*

/**
 * Ball Representation.
 * @property x horizontal position of center
 * @property y vertical position of center
 */
data class Ball(val x: Int, val y: Int)

/**
 * Extension function of Ball to Move the ball to a new position.
 * @receiver ball representation
 * @param dx horizontal displacement
 * @param dy vertical displacement
 * @return the new ball in the final position.
 */
fun Ball.move(dx: Int, dy: Int) = Ball(x+dx, y+dy)

/**
 * Draw the ball, showing a circle of radius 10 with a blue line of thickness 6.
 * @receiver ball representation
 * @param canvas where to draw
 */
fun Ball.draw(canvas: Canvas) {
    canvas.drawCircle(x,y,10, BLUE,6)
}

/**
 * Program that draws a ball that moves each time a key is pressed
 */
fun main() {
    print("Begin ")
    onStart {
        val arena = Canvas(500, 500, YELLOW)
        println(arena.width)
        var myBall=Ball(50,50)
        myBall.draw(arena)
        print("Start ")
        arena.onKeyPressed { key ->
            myBall = myBall.move(15, 15)
            arena.erase()
            myBall.draw(arena)
        }
    }
    onFinish {
        print("Finish ")
    }
    print("End ")
}