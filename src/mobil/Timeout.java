/*--------------------------------------//
 * AUTOR: PETR PYSZKO (xpyszk02)*       
 * PROJEKT:
 *
 */
 //-------------------------------------//

package mobil;

import java.util.TimerTask;

/**
 *
 * @author Petr Pyszko (xpyszk02)
 */
public class Timeout extends TimerTask {

    @Override
  public void run()
  {
     StaticVars.isTimeoff(true);
     
  }
    
}
