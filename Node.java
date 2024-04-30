/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog;

/**
 *
 * @author User
 */
public class Node<T> {//המחלקה הגנרית

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node< T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public Node< T> getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return (this.next != null);
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node< T> next) {
        this.next = next;
    }

    public String toString() {
        return this.value.toString();
    }
}
