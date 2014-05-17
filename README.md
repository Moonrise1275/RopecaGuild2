RopecaGuild2
============

API for mod developers. Feel free to use my API!!
And also for bug tracker

#####Newest API version : 1.2

#####[Download deobfuscated Ropeca Guild 2](https://mods.io/mods/1062-ropeca-guild-2-deobfuscated)


***

### Using this API

##### if you want to use my api, you should register your IGuildRequester by RegisterGuildRequesterEvent

 * You can access RG2's guild system by IGuildRequester. 
 * To do this, you should make a forge event listener method like below in your event listener
 * RegisterGuildRequestEvent is fired only once on RopecaGuild2's post initialization phase. 
 * So you MUST register your event listener until initialization phase or before.
```
    @SubscribeEvent 
    public void registerGuildRequester(RegisterGuildRequesterEvent e) {
      this.guilds = e.getGuildRequester();
    }
```

1. Do everything with IGuildRequester!
 * IGuildRequester has lots of methods, and they are easy to use.
 * But please don't forget null/false check. All methods return null/false when it's function is not successed.

1. Make it easier to send colorful and functional message with ChatUtil!
 * Currently ChatUtil has 4 methods. 3 get(), and sendInfo()
 * sendInfo(String message) is simple message sender. it returns a instance of IChatComponent
 * get() is overloaded by 3 types.
 * get(String message, EnumColor color, String command) returns a instance of IChatComponent with given message and color.
 * And also given command is fired when player click the message.
 * Other 2 types of get is get(String message), get(String message, EnumColor color). 

1. Sheeeee~ Listen guild's private chatting with GuildChatEvent!
 * With RG2, guild members can talk each other privately.
 * You can listen it by listen forge event GuildChatEvent.
 * And also you can tell guild's private message by fire GuildChatEvent.

***

#####Want to contact me? 

1. You can talk with me at IRC channel #Moonrise at esper.net
 * If you found me, feel free to ping me!
 * As i'm human, I can't talking in irc forever. If you can't found me, try below.
2. You can add issues to this GitHub
3. You can send me a email.
 * My emain address is nemo1275@gmail.com
 * please do not advertising! :P
