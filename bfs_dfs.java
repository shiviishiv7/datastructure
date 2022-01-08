/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyGraph {

    public static void main(String[] args) {
            Graph g = new Graph(7);
            for(int i=0;i<7;i++)
            g.insertVertices(i);
            g.insertEdge(0, 1);
            g.insertEdge(0, 1);
            g.insertEdge(0, 6);
            g.insertEdge(1, 2);
            g.insertEdge(1, 0);
            g.insertEdge(1, 5);
            g.insertEdge(2, 5);
            g.insertEdge(2, 1);
          
            g.insertEdge(2, 4);
            g.insertEdge(2, 3);
            g.insertEdge(3, 2);
            g.insertEdge(3, 4);
            g.insertEdge(3, 6);
            g.insertEdge(3, 6);
            g.insertEdge(4, 2);
            g.insertEdge(4, 3);
            g.insertEdge(4, 5);
            g.insertEdge(4, 6);
            g.insertEdge(5, 1);
            g.insertEdge(5, 2);
            g.insertEdge(5, 4);
            g.insertEdge(5, 6);
            g.insertEdge(6, 0);
            g.insertEdge(6, 5);
            g.insertEdge(6, 4);
            g.insertEdge(6, 3);
//            g.bfs();
            g.dfs();
            
    }

    private static class Graph {

        Node root[];
        int size;

        public Graph(int size) {
            this.root = new Node[size];
            this.size = size;
        }

        public void insertVertices(int v) {
            if (root[v] == null) {
                root[v] = new Node(v);
            }
        }

        public void insertEdge(int v, int edge) {
            if (root[v] != null) {
                if(root[v].next==null){
                    root[v].next = new Node(edge);
                }else {
                    Node curr = root[v].next;
                    while(curr.next!=null)curr=curr.next;
                    curr.next = new Node(edge);
                }
            }
        }
        public void dfs(){
            Stack<Node> stack = new Stack<>();
            stack.add(root[0]);
            boolean visited[] = new boolean[size];
            visited[0] =true;
            while(stack.size()>0){
                Node pop = stack.pop();
                System.out.print(pop.data+"\t");
                Node curr = pop.next;
                while(curr!=null){
                    int value = curr.data;
                    if(!visited[value]){
                        stack.add(root[value]);
                        visited[value]=true;
                        curr = curr.next;
                    }else curr=curr.next;
                    System.out.print(value+"\t");
                }
                System.out.println("");
            }
        }
        public void bfs(){
             Queue<Node> queue = new LinkedList<>();
             boolean visited[]  = new boolean[size];
             queue.add(root[0]);
             visited[0] = true;
             while(queue.size()>0){
                 Node remove = queue.remove();
                 System.out.print(remove.data+"\t");
                 Node curr = remove.next;
                 while(curr!=null){
                     int value = curr.data;
                     if(!visited[value]){
                         queue.add(root[value]);
                         visited[value]=true;
                     }
                     System.out.print("\t"+curr.data);
                     curr = curr.next;
                 }
                 System.out.println("");
             }
             
        }

    }

    private static class Node {

        int data;
        Node next;

        private Node(int v) {
            this.data = v;
        }

    }
}
