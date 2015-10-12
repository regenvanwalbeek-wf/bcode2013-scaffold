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
				robotAI.run();

				// TODO - is it worth always deferring this to the AI? _might_ give tighter control of turns in certain situations, especially around yieling for multiple turns? maybe not, need to think about this some more.
				// Yield if the AI can't do anything
				rc.yield();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
