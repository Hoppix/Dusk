package Entity;

import Handlers.FontHandler;
import Helpers.Vector2;
import TileMap.TileMap;

import java.awt.*;

/** PTP 2017
 * The trigger for the dummy ending of the game.
 *
 * @author Ali Popa
 * @version 16.08.
 * @since 15.08.
 */
public class EndingTrigger extends MapObject
{
    public EndingTrigger(TileMap tm)
    {
        super(tm);
        init();
    }

    private void init()
    {
        setPosition(595, 1705);
        collisionBox = new CollisionBox();
        collisionBox.setCenter(position);
        collisionBox.setHalfSize(new Vector2(tileSize/2, tileSize/2));
        collisionOffset = Vector2.ZERO;
    }

    @Override
    public void draw(Graphics2D g)
    {
        // Collision Box
        g.setColor(Color.GREEN);
        int[] a = collisionBox.toXYWH();
        g.fillRect(a[0] + (int)tileMap.cameraPos.x, a[1] + (int)tileMap.cameraPos.y, a[2], a[3]);
        g.setColor(Color.BLACK);
        FontHandler.drawCenteredString(g, "> Goal! <", new Rectangle(a[0] + (int)tileMap.cameraPos.x, a[1] + (int)tileMap.cameraPos.y, a[2], a[3]), FontHandler.getHudFont());
        g.setColor(Color.WHITE);
    }


}
