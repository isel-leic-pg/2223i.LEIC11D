import pt.isel.canvas.*

const val WIDTH=500
const val HEIGHT=500
const val BALLRADIUS=25
const val STEP=25
const val ORIGINALX=50
const val ORIGINALY=50
const val RECTHEIGHT=50

data class Game(val ball:Ball,val rectangle: Rectangle)

fun Game.draw(canvas:Canvas){
    canvas.erase()
    ball.draw(canvas)
    rectangle.draw(canvas)
}

data class Rectangle(val x:Int=ORIGINALX, val y:Int=ORIGINALY, val toShow:Boolean=true)

/**
 * It draws a square instead of a rectangle
 */
fun Rectangle.draw(canvas:Canvas){
    if(toShow)
        canvas.drawRect(x,y,
            RECTHEIGHT,RECTHEIGHT,GREEN)

}


enum class Dir(val d:Int){UP(-1),DOWN(1)}

/**
 * Ball Representation.
 * @property x horizontal position of center
 * @property y vertical position of center
 * @property dir direction
 */
data class Ball(val x:Int=ORIGINALX, val y:Int=ORIGINALY,
                val dir:Dir=Dir.DOWN)

/**
 * Extension function of Ball to Move the ball to a new position.
 * @receiver ball representation
 * @param dx horizontal displacement
 * @param dy vertical displacement
 * @param direction new direction
 * @return the new ball in the final position.
 */
fun Ball.move(dx:Int, dy:Int,direction:Dir)=
    Ball(this.x+dx*direction.d,
        this.y+dy*direction.d,
        direction)

fun Ball.reset()=Ball()
fun Ball.isInLimits()=
    if(this.dir==Dir.DOWN)
        x + BALLRADIUS + STEP < WIDTH &&
                y + BALLRADIUS + STEP <HEIGHT
    else
        x-BALLRADIUS-STEP>0 && y-BALLRADIUS-STEP>0

/**
 * Draw the ball, showing a circle of radius 10 with a blue line of thickness 6.
 * @receiver ball representation
 * @param canvas where to draw
 */
fun Ball.draw(canvas:Canvas){
    canvas.drawCircle(this.x,this.y,BALLRADIUS,BLUE,6)
}

/**
 * Program that draws a ball that moves each time a key is pressed, down or up, depending on the key. Also,
 * a rectangle appears/disappears periodically
 */
fun main() {
    print("Begin ")
    onStart {
        val arena = Canvas(WIDTH, HEIGHT, YELLOW)
        println(arena.width)
        //TODO change var to val
        var myBall = Ball()
        //TODO change var to val
        var myRectangle = Rectangle()
        var game = Game(myBall, myRectangle)
        game.draw(arena)
        print("Start ")
        arena.onKeyPressed { k ->
            val direction = if (k.code == DOWN_CODE) Dir.DOWN else Dir.UP
            if (myBall.isInLimits()) {
                myBall = myBall.move(STEP, STEP, direction)
            } else {
                myBall = myBall.reset()
            }
            game = Game(myBall, myRectangle)
            game.draw(arena)
        }
        arena.onTimeProgress(500)
        {
            myRectangle = Rectangle(toShow = !myRectangle.toShow)
            game = Game(myBall, myRectangle)
            game.draw(arena)
        }
    }
    onFinish {
        print("Finish ")
    }
    print("End ")
}
