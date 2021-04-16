package application.minigame.spaceshooter.entity;

import application.minigame.spaceshooter.info.InfoGame;
import application.minigame.spaceshooter.mainGame.SpaceShooter;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Player {

    /**
     * Gestisco le posizioni con un vettore 2D
     */
    public Point2D position_player;

    /**
     * Dimensione del player
     */
    public final int size;

    /**
     * Variabili booleane che dicono che:
     * destroyed: il nemico è distrutto
     * exploding: se la variabile sta esplodendo
     */
    public boolean destroyed;
    public boolean exploding;

    /**
     * L'animazione dell'esplosione è una imamgine che ha 14 sotto_immagini
     * Questa variabile tiene conto a quale sotto_immagine mi sto riferendo
     */
    public int steps_img = 0;

    /**
     * Immagine del player
     */
    private Image image;

    /**
     * Graphic context preso in maniera statica dalla classa SpaceShooter
     */
    private GraphicsContext gc;

    public Player(final int posX,final  int posY,final  int size, Image player) {
        position_player = new Point2D(posX, posY);
        this.size = size;
        this.image = player;
        this.gc = SpaceShooter.gc;
    }

    /**
     * Aggiorno il player
     * Se sta esplodendo, prendo la sotto_immagine successiva finche non finiscono.
     *
     * La variabile destroyed diventa true quando sono sicuro che le sotto_immagini sono terminate.
     */
    public void update(){
        if(exploding){
            this.steps_img++;
        }
        destroyed = this.steps_img > InfoGame.EXPLOSION_IMG_NUM;
    }

    /**
     * SE NON sta esplodendo, disegno il player (this.image) nella posizione in cui si trova. (Gestito dal Point2D)
     * SE STA esplodendo:
     * 1) Prendo l'immagine contenente le sotto_immagini
     * 2) Poiche l'immagine è 512x512 e ci sono 4 sotto_immagini ogni riga, prendo 128px per volta, this.steps_img e WIDTH/HEGHT
     * 3) Poi disegno questa immagine nella posizione presa con getX/Y e di grandezza size
     */
    public void draw(){
        if(!exploding) {
            gc.drawImage(this.image,position_player.getX(), position_player.getY(), this.size, this.size);
        } else{
            gc.drawImage(InfoGame.EXPLOSION_IMG, this.steps_img  * InfoGame.EXPLOSION_WIDTH,
                    this.steps_img  * InfoGame.EXPLOSION_HEIGHT + 1 ,
                    InfoGame.EXPLOSION_WIDTH, InfoGame.EXPLOSION_HEIGHT,
                    position_player.getX(),position_player.getY(), size, size);
        }
    }

    /**
     * Creo un nuovo colpo
     * @return Shot
     */
    public Shot shot(){
        return new Shot((int)position_player.getX() + 5, (int)position_player.getY() + 5, InfoGame.SIZE_SHOT);
    }

    /**
     * @param enemy con la quale ci puo essere una collisione
     * @return true se si toccan
     */
    public boolean touch(final Enemy enemy){
        var distance_enemy_player = InfoGame.distance(this.position_player.getX() + size / (double)3, this.position_player.getY() + size ,
                enemy.position_player.getX() + enemy.size / (double)3, enemy.position_player.getY() + enemy.size );
        return distance_enemy_player < enemy.size / (double)3 + this.size / (double)3;
    }

    /**
     * Setto l'esplosione a true
     * E riinizializzo gli steps
     */
    public void explode(){
        this.exploding = true;
        this.steps_img = -1;
    }

}
