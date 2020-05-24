package com.momolela.thread;

/**
 * 共同的资源
 */
class Res {
    String name;
    String sex;
    boolean flag = false; // 当为false的时候Input执行，当为true的时候Output执行，保证输入和输出均匀
}

/**
 * Input线程操作写数据
 */
class Input implements Runnable {
    private Res s;

    Input(Res s) {
        this.s = s;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (s) { // 相同的s锁，解决安全问题
                if (s.flag) {
                    try {
                        s.wait(); // 当s.flag为true，当前Input线程wait
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    s.name = "szj";
                    s.sex = "male";
                } else {
                    s.name = "hfy";
                    s.sex = "female";
                }
                x = (x + 1) % 2;
                s.flag = true; // 如果执行完了，就把s.flag设置为true，为了就是下次wait
                s.notify(); // 将s对象锁的其他线程唤醒
            }
        }
    }
}

/**
 * Output线程操作读数据
 */
class Output implements Runnable {
    private Res s;

    Output(Res s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (s) { // 相同的s锁，解决安全问题
                if (!s.flag) {
                    try {
                        s.wait(); // 当s.flag为false，当前Output线程wait
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(s.name + " === " + s.sex);
                s.flag = false; // 如果执行完了，就把s.flag设置为false，为了就是下次wait
                s.notify(); // 将s对象锁的其他线程唤醒
            }
        }
    }
}

/**
 * wait()
 * notify()
 * notifyAll()
 * 都使用在同步中，因为要对锁的线程操作，只有同步才有锁
 *
 * 为什么这些操作方法都定义在Object类中呢？
 * 这些方法在操作同步中线程时，都必须要标识他们所操作线程的锁，
 * 只有同一个锁上被等待的线程能被同一个锁上的notify()唤醒，不可以对不同锁中的线程进行唤醒，
 * 等待和唤醒必须是同一个锁，而锁的对象可是任意对象，所以定义在Object类中。
 */
public class Thread06ThreadCommunication {
    public static void main(String[] args) {
        Res res = new Res();
        Input input = new Input(res);
        Output output = new Output(res);
        new Thread(input).start();
        new Thread(output).start();
    }
}
