package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.Random;

public class Duel extends ListenerAdapter {
    static final HashMap<Integer, String> SELECT = new HashMap<>() ;
    static {
        SELECT.put(1, "scissors");
        SELECT.put(2, "rock");
        SELECT.put(3, "paper");
        SELECT.put(4, "tails");
        SELECT.put(5, "heads");
        SELECT.put(6, "north");
        SELECT.put(7, "west");
        SELECT.put(8, "south");
        SELECT.put(9, "east");
        SELECT.put(10, "sham");
        SELECT.put(11, "ro");
        SELECT.put(12, "beaux");

    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent m){
        String messageSent = m.getMessage().getContentRaw();
        Random random = new Random();
        String sit;

        int rps = getRandomNumberInRange(1,3);
        sit = SELECT.get(rps);
        if (messageSent.equalsIgnoreCase(">rps")
                || messageSent.equalsIgnoreCase(">rock")
                || messageSent.equalsIgnoreCase(">paper")
                || messageSent.equalsIgnoreCase(">scissors")){
            m.getChannel().sendMessage(sit).queue();
        }

        int hot = getRandomNumberInRange(4,5);
        sit = SELECT.get(hot);
        if(messageSent.equalsIgnoreCase(">hot")
                || messageSent.equalsIgnoreCase(">heads")
                || messageSent.equalsIgnoreCase(">tails")){
            m.getChannel().sendMessage(sit+"").queue();
        }

        int nsew = getRandomNumberInRange(6,9);
        sit = SELECT.get(nsew);;
        if (messageSent.equalsIgnoreCase(">nsew")
                || messageSent.equalsIgnoreCase(">north")
                || messageSent.equalsIgnoreCase(">south")
                || messageSent.equalsIgnoreCase(">east")
                || messageSent.equalsIgnoreCase(">west")){
            m.getChannel().sendMessage(sit).queue();
        }

        int rsb = getRandomNumberInRange(10,12);
        sit = SELECT.get(rsb);
        if (messageSent.equalsIgnoreCase("<rsb")
                || messageSent.equalsIgnoreCase("<ro")
                || messageSent.equalsIgnoreCase("<sham")
                || messageSent.equalsIgnoreCase("<bo")
                || messageSent.equalsIgnoreCase("<beaux")){
            m.getChannel().sendMessage(sit).queue();
        }

        int guide = getRandomNumberInRange(1,12);
        sit = SELECT.get(guide);
        if (messageSent.equalsIgnoreCase(">guide")){
            m.getChannel().sendMessage(sit).queue();
        }

        if (messageSent.equalsIgnoreCase(">irock")){
            m.getChannel().sendMessage("you rule!").queue();
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

}
