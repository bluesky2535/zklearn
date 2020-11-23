import java.util.Stack;

class CQueue {

    Stack<Integer> s1=new Stack();
    Stack<Integer> s2=new Stack();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        s1.push(value);
    }
    
    public int deleteHead() {
        if(s1.size()==0){
            return -1;
        }


        int s1size= s1.size();
        for(int i =0;i<s1size;i++){
            s2.push(s1.pop());
        }
        int res=s2.pop();
        s1.clear();
        if(s2.size()!=0){
            int s2size=s2.size();
            for(int i =0;i<s2size;i++){
                s1.push(s2.pop());
            }
        }
       s2.empty();
        
        return res ;
    }


    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.deleteHead();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        cQueue.deleteHead();
        cQueue.deleteHead();
    }
}