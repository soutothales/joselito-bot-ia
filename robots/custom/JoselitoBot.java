package custom; 
 import robocode.util.Utils; 
import robocode.*; 
import java.awt.Color;
public class JoselitoBot extends Robot {
int foo = (int)292.6336918311049;

 public void run() {

setAdjustGunForRobotTurn(true);
setAdjustRadarForGunTurn(true);

		setColors(Color.red,Color.blue,Color.green);
		while(true) {
			turnGunRight(Double.POSITIVE_INFINITY);
		}

	}
	public void onScannedRobot(ScannedRobotEvent e) {


		ahead(466.6526370710613);


		turnRight(292.6336918311049);

 
		turnGunRight(410.6638575005446);

 
		turnRadarRight(466.6526370710613);


		fire(417.40613594143116);

		turnLeft(466.6526370710613);

 
		turnGunLeft(417.40613594143116);
		fire(277.4787836215928);}
public void onHitWall(HitWallEvent e) {
    back(277.4787836215928);
    ahead(277.4787836215928 * -1);
}
}