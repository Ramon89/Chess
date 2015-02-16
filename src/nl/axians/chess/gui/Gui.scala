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
object Gui extends SimpleSwingApplication with GameListener {
  class FlowPanelContainer(val panel: FlowPanel, val background: Color, val location: Location)
  
//  private val board: HashMap[Location, FlowPanel] = new HashMap
  private val board: HashMap[Location, FlowPanelContainer] = new HashMap
  private val highlightColor = new Color(255, 255, 200)
  private val lightColor = new Color(240, 240, 240)
  private val darkColor = new Color(170, 170, 170)
  private var game: Game = null
  private var firstClick: Location = null
  
  private val gridPanel = new GridPanel(8, 8) {
      for(y <- (1 to 8).reverse; x <- 'A' to 'H') {
        val b = if((x + (y % 2)) % 2 == 0) lightColor else darkColor
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
  
  def setGame(game: Game) = this.game = game
  
  /**
   * Creates all necessary gui components.
   */
  def top = new MainFrame {
    title = "Hello, World!"
    contents = gridPanel

    setBoard(new DefaultBoard)
  }
  
  /**
   * This method is invoked when the user clicks on a location.
   */
  private def onClick(l: Location) = {
    val clickedPiece = game.getBoard.getPieceAt(l)
    if(firstClick == null && clickedPiece != None && clickedPiece.get.color == game.getCurrentTurn) {
      firstClick = l
      board.values.foreach(panelContainer => resetBackground(panelContainer.location))
      highlight(l)
    } else if(firstClick != null) {
      try {
        val move = MoveFactory.get(game, firstClick, l)
        game.execute(move)
        highlight(l)
        firstClick = null
      } catch {
        case e: InvalidMoveException => {
          resetBackground(firstClick)
          resetBackground(l)
          firstClick = null
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