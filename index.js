var Node1 = /** @class */ (function () {
    function Node1(data) {
        this.data = data;
        this.next = null;
    }
    return Node1;
}());
var NodeList1 = /** @class */ (function () {
    function NodeList1() {
        this.start = null;
    }
    NodeList1.prototype.add = function (data) {
        var temp = new Node1(data);
        if (!this.start)
            this.start = temp;
        else {
            var curr = this.start;
            while (curr.next)
                curr = curr.next;
            curr.next = temp;
        }
    };
    NodeList1.prototype.getRoot = function () { return this.start; };
    NodeList1.prototype.display = function (curr) {
        //        let curr:Node1 = this.start;
        while (curr) {
            console.log(curr.data);
            curr = curr.next;
        }
    };
    NodeList1.prototype.merge = function (p, q) {
        var l3 = null;
        var curr = null;
        if (!p)
            return q;
        if (!q)
            return p;
        if (p.data > q.data) {
            l3 = q;
            q = q.next;
        }
        else {
            l3 = p;
            p = p.next;
        }
        curr = l3;
        while (p && q) {
            if (p.data > q.data) {
                l3.next = q;
                l3 = q;
                q = q.next;
            }
            else {
                l3.next = p;
                l3 = p;
                p = p.next;
            }
        }
        if (p)
            l3.next = p;
        if (q)
            l3.next = q;
        return curr;
    };
    return NodeList1;
}());
var p = new NodeList1();
var q = new NodeList1();
p.add(10);
p.add(30);
p.add(50);
p.add(70);
p.add(90);
q.add(20);
q.add(40);
q.add(60);
q.add(80);
q.add(100);
q.display(q.getRoot());
p.display(p.getRoot());
console.log('break');
p.display(p.merge(p.getRoot(), q.getRoot()));
