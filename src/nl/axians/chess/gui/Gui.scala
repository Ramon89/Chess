package nl.axians.chess.gui

import swing._
import scala.collection.immutable.RedBlack
import java.awt.Color
import javax.swing.ImageIcon
import scala.collection.mutable.HashMap
import nl.axians.chess.Location
import nl.axians.chess.AbstractPiece
import nl.axians.chess.Pawn
import nl.axians.chess.Black
import nl.axians.chess.White
import nl.axians.chess.game.Board
import nl.axians.chess.game.DefaultBoard
import scala.swing.event.MouseClicked
import nl.axians.chess.GameListener
import nl.axians.chess.game.Game
import nl.axians.chess.movement.MoveFactory
import java.nio.InvalidMarkException
import nl.axians.chess.game.InvalidMoveException

/**
 * This is the GUI of the Chess application.
 */
class Gui(game: Game, player: nl.axians.chess.Color) extends SimpleSwingApplication with GameListener {
  class FlowPanelContainer(val panel: FlowPanel, val background: Color, val location: Location)
  
  private val board: HashMap[Location, FlowPanelContainer] = new HashMap
  private val highlightColor = new Color(255, 255, 200)
  private val lightColor = new Color(240, 240, 240)
  private val darkColor = new Color(170, 170, 170)
  private var firstClick: Option[Location] = None
  
  private val gridPanel = new GridPanel(8, 8) {
    val rangeY = if(player == White) (1 to 8).reverse else 1 to 8
    val rangeX = if(player == White) 'A' to 'H' else ('A' to 'H').reverse
    for(y <- rangeY; x <- rangeX) {
        val b = if((x + (y % 2)) % 2 == 0) darkColor else lightColor
        val p = new FlowPanel() {
          preferredSize_=(new Dimension(70, 70))
          background = b
          listenTo(mouse.clicks)
          reactions += {
            case e: MouseClicked => onClick(Location(x, y))
          }
        }
        
        board.put(Location(x, y), new FlowPanelContainer(p, b, Location(x, y)))
        contents += p
      }
    }
  
  /**
   * Creates all necessary gui components.
   */
  def top = new MainFrame {
    title = "Chess"
    contents = gridPanel

    setBoard(new DefaultBoard)
  }
  
  /**
   * This method is invoked when the user clicks on a location.
   */
  private def onClick(l: Location) = {
    val clickedPiece = game.getBoard.getPieceAt(l)
    if(firstClick == None && clickedPiece != None && clickedPiece.get.color == game.getCurrentTurn) {
      firstClick = Some(l)
      board.values.foreach(panelContainer => resetBackground(panelContainer.location))
      highlight(l)
    } else if(firstClick != None) {
      try {
        val move = MoveFactory.get(game, firstClick.get, l)
        game.execute(move)
        highlight(l)
        firstClick = None
      } catch {
        case e: InvalidMoveException => {
          resetBackground(firstClick.get)
          resetBackground(l)
          firstClick = None
        }
      }
    }
  }
  
  private def getFlowPanel(l: Location) = board.get(l).get.panel
  
  private def resetBackground(l: Location) = getFlowPanel(l).background = board.get(l).get.background
  
  private def highlight(l: Location) = getFlowPanel(l).background = highlightColor
  
  /**
   * Clears the given location of the chess board, removing any chess piece on it.
   */
  def clearLocation(l: Location) = getFlowPanel(l).contents.clear
  
  
  /**
   * Sets a piece at the given location on the chess board.
   */
  def setPiece(l: Location, p: AbstractPiece) = {
    val boardLocation = board.get(l).get
    clearLocation(l)
    getFlowPanel(l).contents += new Label { icon = new ImageIcon("resources/img/" + p + ".png") }
  }
  
  /**
   * Sets an entire board on the GUI.
   */
  def setBoard(b: Board) = {
    b.getLocations.foreach(l => 
      if(b.isEmpty(l))
        clearLocation(l)
      else
        setPiece(l, b.getPieceAt(l).get)
    )
   
    gridPanel.repaint
    gridPanel.revalidate
  }
  
  override def boardChanged(newBoard: Board) = setBoard(newBoard)
  
  override def turnChanged(currentTurn: nl.axians.chess.Color) = { }
  
  override def check(checkedPlayer: nl.axians.chess.Color) = println("CHECK!")
  
  override def checkMate(winner: nl.axians.chess.Color) = println("CHECK MATE!")
}