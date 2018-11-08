package custom; 
 import robocode.util.Utils; 
import robocode.*; 
import java.awt.Color;
public class JoselitoBot extends Robot {
int foo = (int)373.76722971622684;

 public void run() {

setAdjustGunForRobotTurn(true);
setAdjustRadarForGunTurn(true);

		setColors(Color.red,Color.blue,Color.green);
     while(true) { turnRadarLeft(Double.POSITIVE_INFINITY);}

	}
	public void onScannedRobot(ScannedRobotEvent e) {


		ahead(146.08024966557687);


		turnRight(278.01873631774106);

 
		turnGunRight(117.75078446841177);

 
		turnRadarRight(644.142826934345);


		fire(373.76722971622684);

		turnLeft(168.00268888507728);

 
		turnGunLeft(39.59697385750808);
		fire(373.76722971622684);}
public void onHitWall(HitWallEvent e) {
    back(146.08024966557687);
    ahead(146.08024966557687);
}
public void onHitByBullet(HitByBulletEvent e) {
    turnRight(278.01873631774106);
    ahead(146.08024966557687 * -1);
}
}