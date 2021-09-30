class Node1{
    data:number;
    next:Node1;
    constructor(data:number){this.data = data;this.next = null}
}
class NodeList1{
    private start:Node1 = null;
    public add(data:number){
        let temp:Node1 = new Node1(data)
        if(!this.start)this.start = temp;
        else {
            let curr:Node1 = this.start;
            while(curr.next)curr=curr.next;
            curr.next = temp
        }
    }
  getRoot():Node1{return this.start}
    public display(curr:Node1){
//        let curr:Node1 = this.start;
        while(curr){
            console.log(curr.data)
            curr = curr.next;
        }
    }
    public merge(p:Node1,q:Node1):Node1{
        let l3:Node1= null;
        let curr:Node1=null;
        if(!p)return q;
        if(!q)return p;
        if(p.data>q.data){
            l3 = q;
            q=q.next;
        }else {
            l3 =p;
            p = p.next
        }
        curr = l3;
        while(p && q){
            if(p.data>q.data){
                l3.next = q;
                l3 = q;
                q= q.next;
            }else {
                l3.next =p;
                l3 = p;
                p = p.next;
            }
        }
        if(p)l3.next = p
        if(q)l3.next = q
        return curr;
    }
}
let p:NodeList1 = new NodeList1()
let q:NodeList1 = new NodeList1();

p.add(10)
p.add(30)
p.add(50)
p.add(70)
p.add(90)
q.add(20)
q.add(40)
q.add(60)
q.add(80)
q.add(100)
q.display(q.getRoot())
p.display(p.getRoot())
console.log('break')
p.display(p.merge(p.getRoot(),q.getRoot()))