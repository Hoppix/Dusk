package GameState;

import Entity.Player;
import Entity.Enemy;
import Entity.InvulnerableTime;
import Handlers.KeyHandler;
import Handlers.Keys;
import Main.GamePanel;
import TileMap.*;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.util.Arrays;

public class Level1State extends GameState {
	
	private TileMap tileMap;
	private Player player;
	private Enemy slug;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	public void init() {
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tilesets/grasstileset.gif");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);

		player = new Player(tileMap);
		player.initPlayer(new Vector2(150, 100));
		slug = new Enemy(tileMap);
		slug.initEnemy(new Vector2(200, 100),"slugger.gif");
	}


	public void update() {
		player.update();
		slug.update();
		//handleInput();

		checkPlayerEnemyCollision();
	}

	private void checkPlayerEnemyCollision()
    {
	    if(player.getCollisionBox().overlaps(slug.getCollisionBox()) && !player.isInvulnerable())
        {
	        if(!player.isInvulnerable())
	        {
	            player.stepBack(); 
	        }
	        
	        player.setInvulnerable(true);
            player.setHealth(player.getHealth()-1);
  
            if(player.getHealth() == 0)
            {
                System.out.println("GAME OVER");
            }
	        new Thread(new InvulnerableTime(System.currentTimeMillis() / 1000, 5, player)).start();
        }
    }

    public void draw(Graphics2D g) {
		// clear screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		// draw tilemap
		tileMap.draw(g);
		player.draw(g);
		slug.draw(g);
	}

	public void handleInput() {
	}
	
}












