package applqpak.Nukkit-Example;

// Some Nukkit imports that we will use

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.Command;

import java.io.File;

public class Main extends PluginBase
{

  //Create config variable for later use

  public Config config;

  //onEnable method

  @Override

  public void onEnable()
  {

    this.getDataFolder().mkdirs();

    if(!(new File(this.getDataFolder(), "config.yml").exists()))
    {

      saveResource("config.yml");

    }

    this.config = getConfig();

    this.getLogger().info(TextFormat.GREEN + "I'm enabled!");

  }

  //onCommand method

  @Override

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {

    switch(cmd.getName())
    {

      case "example":

        sender.sendMessage(this.config.getString("message"));

      break;

    }

    return true;

  }

}
