import kotlin.math.sqrt
import kotlin.math.pow

/**
 * Representation of a point in an orthogonal plane (x,y)
 */
data class Point(val x: Int, val y:Int)

/**
 * Shifts a point with an offset (dx,dy).
 * @receiver Original point
 * @param dx Displacement on the x-axis
 * @param dy Displacement on the y-axis
 * @return The shifted point
 */
fun Point.move(dx:Int, dy:Int) = Point(x+dx, y+dy)

/**
 * Distance between two points.
 * @receiver Original point
 * @param p The other point
 * @return The distance between the points
 */
fun Point.distanceTo(p: Point): Double {
    val dx = p.x-x
    val dy = p.y-y
    return sqrt( dx.toDouble().pow(2) + dy*dy )
}

/**
 * Checks if a point is contained in a bounded area.
 * @receiver the point to check
 * @param w Width of the area
 * @param h Height of the area
 * @return true only if the point is inside the area
 */
fun Point.inside(w: Int, h:Int): Boolean = x in 0..w && y in 0..h
