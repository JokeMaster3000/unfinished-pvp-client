package apeclient;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class discordrp {
	
	private boolean running = true;
	private long  created = 0;
public void start () {
	this.created = System.currentTimeMillis();
DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
	
	@Override
	public void apply(DiscordUser user) {
		System.out.println("Websome " + user.username + "#" + user.discriminator + ",");
		update("Booting up...","");
		
	}
}).build();

DiscordRPC.discordInitialize("899303832188747847", handlers, true);
new Thread("Discord Rpc Callback") {
	public void run() {
		while(running) {
			DiscordRPC.discordRunCallbacks();
		}
		
		
	};
	
	
	
}.start();
}


public void shutdown() {
	running = false;
			DiscordRPC.discordShutdown();
}	
public void update(String firstline, String secondline) {
	DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondline);
	b.setBigImage("large","");
	b.setDetails(firstline);
	b.setStartTimestamps(created);
	
	DiscordRPC.discordUpdatePresence(b.build());
	
}
}