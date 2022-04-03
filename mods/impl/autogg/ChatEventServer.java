package apeclient.mods.impl.autogg;

import apeclient.Event.Event;

public class  ChatEventServer extends Event
{
	public String message;

	public ChatEventServer(String msg)
	{
		this.message = msg;
	}
}