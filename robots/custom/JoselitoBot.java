package custom; 
 import robocode.util.Utils; 
import robocode.*; 
import java.awt.Color;
public class JoselitoBot extends Robot {
int foo = (int)625.7329889201851;

 public void run() {

setAdjustGunForRobotTurn(true);
setAdjustRadarForGunTurn(true);

		setColors(Color.red,Color.blue,Color.green);
     while(true) { turnRadarLeft(Double.POSITIVE_INFINITY);}

	}
	public void onScannedRobot(ScannedRobotEvent e) {


		ahead(537.1596165395937);


		turnRight(458.0421354551803);

 
		turnGunRight(490.23462807709933);

 
		turnRadarRight(317.69833104397446);


		fire(625.7329889201851);

		turnLeft(307.8937706214041);

 
		turnGunLeft(475.8893288462546);
		fire(625.7329889201851);}
public void onHitWall(HitWallEvent e) {
    back(537.1596165395937);
		turnLeft(307.8937706214041);
    ahead(475.8893288462546);
}
public void onHitByBullet(HitByBulletEvent e) {
    turnRight(458.0421354551803);
    ahead(537.1596165395937 * -1);
}
}