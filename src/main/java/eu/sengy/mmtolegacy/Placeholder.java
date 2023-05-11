package eu.sengy.mmtolegacy;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;

public class Placeholder extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "mmtolegacy";
    }

    @Override
    public String getAuthor() {
        return "Sengy";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {

        return convert(params);

    }

    private String convert(String miniMessage) {
        MiniMessage parser = MiniMessage.builder().build();
        Component component = parser.deserialize(miniMessage);
        return LegacyComponentSerializer.legacySection().serialize(component);
    }
}