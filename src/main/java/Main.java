import events.Duel;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        Path fileName = Path.of("src/main/resources/rpsbot-token.txt");
        String content = Files.readString(fileName);
        JDA jda = JDABuilder.createDefault(content).build();
    jda.addEventListener(new Duel());
    }
}
