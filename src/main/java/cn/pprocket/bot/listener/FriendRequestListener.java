package cn.pprocket.bot.listener;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendAddEvent;
import net.mamoe.mirai.event.events.NewFriendRequestEvent;

public class FriendRequestListener {
    public void start() {
        Listener listener= GlobalEventChannel.INSTANCE.subscribeAlways(NewFriendRequestEvent.class, event->{
            event.accept();
        });
        listener.start();
        Listener listener1 = GlobalEventChannel.INSTANCE.subscribeAlways(FriendAddEvent.class, event -> {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        event.getFriend().sendMessage("使用方法：\r\n" +
                                "先输入 获取作业列表 然后把作业前面的序号加上你要看的人的名字的缩写,然后等待数秒即可\r\n " +
                                "例如 3 yjj");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
            t.start();
        });
        listener1.start();
    }
}
