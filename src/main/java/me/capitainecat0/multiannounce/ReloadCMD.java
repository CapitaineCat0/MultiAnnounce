package me.capitainecat0.multiannounce;

import me.capitainecat0.multiannounce.utils.Messenger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!sender.hasPermission("multiannounce.reload")) {
                sender.sendMessage(Messenger.CMD_NO_PERM.getMessage().replace("%cmd%", cmd.getName()));
            }else{
                if (args[0].equalsIgnoreCase("reload")) {
                    MultiAnnounce.getInstance().reloadConfig();
                    sender.sendMessage(Messenger.RELOAD_SUCCES.getMessage());
                    }
            }
        return false;
    }
}
