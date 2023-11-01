package softStructure.c;

public class KWICSubject extends Subject{
    public void startKWIC(){
        for (int i = 0; i < getSize() ;i++){
            super.notifyOneObserver(i);
        }
    }
}
