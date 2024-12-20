package by.tatevik.threads.model;

public class MyThread extends  Thread{
    public void run(){
        int c=0;
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" : " + c);
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            c+=1;
        }
    }
}
