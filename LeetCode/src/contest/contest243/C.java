package contest.contest243;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/30
 */
public class C {

    class Server {
        int idx;
        int weight;
        int emptyTime;
        Server(int idx, int weight, int emptyTime) {
            this.idx = idx;
            this.weight = weight;
            this.emptyTime = emptyTime;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int serverLen = servers.length;
        Server[] serverArr = new Server[serverLen];
        for (int i = 0; i < serverLen; i++) {
            serverArr[i] = new Server(i, servers[i], 0);
        }

        PriorityQueue<Server> emptyHeap = new PriorityQueue<>(new Comparator<Server>() {
            @Override
            public int compare(Server o1, Server o2) {
                return o1.weight == o2.weight ? o1.idx - o2.idx : o1.weight - o2.weight;
            }
        });

        PriorityQueue<Server> busyHeap = new PriorityQueue<>(new Comparator<Server>() {
            @Override
            public int compare(Server o1, Server o2) {
                return o1.emptyTime == o2.emptyTime ? (o1.weight == o2.weight ? o1.idx - o2.idx : o1.weight - o2.weight) : o1.emptyTime - o2.emptyTime;
            }
        });

        for (int i = 0; i < serverLen; i++) {
            emptyHeap.add(serverArr[i]);
        }

        int[] ansArr = new int[tasks.length];
        LinkedList<Integer> taskList = new LinkedList<>();
        int curIdx = -1;
        for (int i = 0; i < tasks.length; i++) {
            taskList.addLast(i);
            while (!busyHeap.isEmpty()) {
                Server top = busyHeap.peek();
                if (top.emptyTime <= i) {
                    busyHeap.poll();
                    emptyHeap.add(top);
                } else {
                    break;
                }
            }

            if (emptyHeap.isEmpty()) {
                // 没有空闲的服务器
                continue;
            } else {
                while (!taskList.isEmpty() && !emptyHeap.isEmpty()) {
                    int taskIdx = taskList.pollFirst();
                    Server top = emptyHeap.poll();
                    ansArr[taskIdx] = top.idx;
                    curIdx = taskIdx;
                    top.emptyTime = i + tasks[taskIdx];
                    busyHeap.add(top);
                }
            }
        }

        while (curIdx != tasks.length - 1) {
            Server top = busyHeap.poll();
            emptyHeap.add(top);
            int minEmptyTime = top.emptyTime;
            while (!busyHeap.isEmpty() && busyHeap.peek().emptyTime == minEmptyTime) {
                emptyHeap.add(busyHeap.poll());
            }

            while (!taskList.isEmpty() && !emptyHeap.isEmpty()) {
                int taskIdx = taskList.pollFirst();
                Server top1 = emptyHeap.poll();
                ansArr[taskIdx] = top1.idx;
                curIdx = taskIdx;
                if (curIdx == tasks.length - 1) {
                    break;
                }
                top1.emptyTime = minEmptyTime + tasks[taskIdx];
                busyHeap.add(top1);
            }
        }

        return ansArr;
    }

}
