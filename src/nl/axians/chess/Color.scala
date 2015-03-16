package nl.axians.chess

/**
 * Represents the color of a player.
 */
abstract class Color {
  
  /**
   * Returns the opposing color.
   */
  def opponent: Color
  
  /**
   * Returns the code that corresponds to this color.
   */
  def colorCode: String
  
  override def toString = colorCode
}

object White extends Color {
  override def opponent = Black
  override def colorCode = "w"
}

object Black extends Color {
  override def opponent = White
  override def colorCode = "b"
}
