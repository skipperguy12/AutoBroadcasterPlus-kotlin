package me.skipperguy12.AutoBroadcasterPlus

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

object AutoBroadcasterPlus {
    var plugin: JavaPlugin? = null

    var config: Config? = null

    fun initialize(plugin: JavaPlugin) {
        this.plugin = plugin
        config = Config(plugin, "config.yml")
    }


}