package me.orangemonkey68.givebacktoggledownfall;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;

public class GiveBackToggledownfall implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->
                dispatcher.register(CommandManager.literal("toggledownfall").executes(GiveBackToggledownfall::toggledownfall)));
    }

    public static int toggledownfall(CommandContext<ServerCommandSource> ctx){
        final ServerWorld world = ctx.getSource().getWorld();
        if(world.isRaining()){
            world.setWeather(24000, 0, false, false);
            ctx.getSource().sendFeedback(new LiteralText("Toggled downfall"), true);
            return 24000;
        }else if (world.isThundering()){
            world.setWeather(24000, 0, false, false);
            ctx.getSource().sendFeedback(new LiteralText("Toggled downfall"), true);
            return 24000;
        }else {
            world.setWeather(0, 24000, true, false);
            ctx.getSource().sendFeedback(new LiteralText("Toggled downfall"), true);
            return 24000;
        }
    }
}
