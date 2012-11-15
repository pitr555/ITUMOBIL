/*--------------------------------------//
 * AUTOR: PETR PYSZKO (xpyszk02)*       
 * PROJEKT:
 *
 */
 //-------------------------------------//

package mobil;

import java.awt.Polygon;

/**
 *
 * @author Petr Pyszko (xpyszk02)
 */
public class StaticVars {
    
    static int startX=0;
    static int startY=0;
    static boolean isShift=false;
    
    private static boolean timeoff=false;
    
    public static synchronized boolean isTimeoff() {
        return timeoff;
    }
    public static synchronized void isTimeoff(boolean s) {
        timeoff=s;
    }
    
    
    static int wX=400;
    static int wY=100;

    
    static public Polygon getMobilShape()
    {
        Polygon p=new Polygon() ;             
        p.addPoint(0,37);
        p.addPoint(0,632);
        p.addPoint(15,653);
        p.addPoint(39,666);
        p.addPoint(335,666);
        p.addPoint(361,654);
        p.addPoint(376,628);
        p.addPoint(375,35);
        p.addPoint(362,13);
        p.addPoint(344,0);
        p.addPoint(35,0);
        p.addPoint(18,8);
        p.addPoint(12,15);
        return p;
    }
}
