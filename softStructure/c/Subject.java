package softStructure.c;

import java.util.LinkedList;
import java.util.List;

public class Subject {

    //观察者数组
    private List<Observer> vector = new LinkedList<>();

    //增加一个观察者
    public void addObserver(Observer observer) {
        vector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        vector.remove(observer);
    }


    //通知所有观察者
    public void notifyAllObserver() {
        for(Observer observer : vector) {
            observer.toDo();
        }
    }
    //获取链表vector的长度
    public int getSize(){
        return this.vector.size();
    }
    // 通知特定观察者
    public void notifyOneObserver(int i) {
        vector.get(i).toDo();
    }

}

