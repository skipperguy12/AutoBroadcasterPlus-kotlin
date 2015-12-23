package me.skipperguy12.AutoBroadcasterPlus

import org.bukkit.World
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

class Config(val plugin: Plugin, val fileName: String) {
    val config: FileConfiguration
    val dataFolder: File

    init {
        dataFolder = plugin.dataFolder;
        config = YamlConfiguration.loadConfiguration(File(dataFolder, fileName))
    }

    fun <T> getWorldSetting(world: World?, setting: String, def: Any): T  {
        if(world != null)
            return config.get("broadcaster." + world.getName() + "." + setting, def) as T
        else
            return config.get("broadcaster.global." + setting, def) as T
    }

    fun <T> get(path: String, def: Any): T {
        return config.get(path, def) as T
    }

    fun set(path: String, value: Any) : Unit {
        config.set(path, value)
        config.save(File(dataFolder, config.name))
    }

    object General {
        val debugging: Boolean = AutoBroadcasterPlus.config!!.get("general.debugging", false)
    }

    object Broadcaster {
        object Global {
            val announcerName: String = AutoBroadcasterPlus.config!!.get("broadcaster.global.announcerName", "[&4AutoBroadcaster&f]: ")
            val interval: Int = AutoBroadcasterPlus.config!!.get("broadcaster.global.interval", 60)
            val delimiter: String = AutoBroadcasterPlus.config!!.get("broadcaster.global.delimeter", "\n")
            val broadcastToConsole: Boolean = AutoBroadcasterPlus.config!!.get("broadcaster.global.broadcast-to-console", false)
            val minPlayers: Int = AutoBroadcasterPlus.config!!.get("broadcaster.global.min-players", 1)
        }
    }




}