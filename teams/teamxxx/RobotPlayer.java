package teamxxx;

import battlecode.common.RobotController;
import teamxxx.factory.AIFactory;
import teamxxx.factory.IRobotAIFactory;
import teamxxx.robot.IRobotAI;

/** The example funcs player is a player meant to demonstrate basic usage of the most common commands.
 * Robots will move around randomly, occasionally mining and writing useless messages.
 * The HQ will spawn soldiers continuously. 
 */
public class RobotPlayer
{
	public static void run(RobotController rc)
	{
		IRobotAIFactory aiFactory = new AIFactory();
		IRobotAI robotAI = aiFactory.createAI(rc);

		while (true)
		{
			try
			{
				boolean success = robotAI.run();

				// Yield if the AI can't do anything
				if (!success)
				{
					rc.setIndicatorString(0, "I didn't do anything this turn :(");
					rc.yield();
				}
				rc.setIndicatorString(0, "");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
