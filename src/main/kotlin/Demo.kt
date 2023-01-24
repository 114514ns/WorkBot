package cn.pprocket

import cn.pprocket.bot.WorkClient
import cn.pprocket.bot.listener.FriendRequestListener
import cn.pprocket.bot.listener.MessageListener
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.enable
import net.mamoe.mirai.console.plugin.PluginManager.INSTANCE.load
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.console.terminal.MiraiConsoleTerminalLoader
import net.mamoe.mirai.utils.info

object Demo : KotlinPlugin(
        JvmPluginDescription(
                id = "cn.pprocket.workbot",
                name = "Demo",
                version = "0.1.0",
        ) {
            author("zhang")
        }
) {
    override fun onEnable() {
        logger.info { "插件加载" }
        WorkClient.main(null) //这里登录每日交作业的账号密码并设置toke
        MessageListener().start()
        FriendRequestListener().start()

    }
}

suspend fun main() {
    WorkClient.main(null) //这里登录每日交作业的账号密码并设置token
    MiraiConsoleTerminalLoader.startAsDaemon()
    var bot = BotFactory.newBot(2317679144,"Zyh060813") //登录qq
    bot.login()
    Demo.load()
    Demo.enable()
    Thread {
        System.gc()
        Thread.sleep(10000)
    }

}