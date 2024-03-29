package org.designpattern.structure.proxy._03_java;


import org.designpattern.structure.proxy._02_after.DefaultGameService;
import org.designpattern.structure.proxy._02_after.GameService;

import java.lang.reflect.Proxy;

public class ProxyInJava {

    public static void main(String[] args) {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }

    private void dynamicProxy() {
        var gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.startGame();
    }

    private GameService getGameServiceProxy(GameService target) {
        return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{GameService.class}, (proxy, method, args) -> {
                    System.out.println("panda");
                    Object result = method.invoke(target, args);
                    System.out.println("bear");
                    return result;
                });
    }
}
