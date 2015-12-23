package me.skipperguy12.AutoBroadcasterPlus

import org.bukkit.plugin.java.JavaPlugin

class AutoBroadcasterPlusPlugin : JavaPlugin() {
    override fun onEnable() {
        saveDefaultConfig()

        AutoBroadcasterPlus.initialize(this)

        println(Config.Broadcaster.Global.delimiter)
    }

}