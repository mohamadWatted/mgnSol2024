package prog;

import java.util.Scanner;

public class Prog {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node<Details> lst = new Node<Details>(new Details(3, 20));
        Node<Details> pos = lst;
        pos.setNext(new Node<Details>(new Details(5, 2)));
        pos = pos.getNext();
        pos.setNext(new Node<Details>(new Details(9, 1)));
        pos = pos.getNext();
        pos.setNext(new Node<Details>(new Details(6, 3)));
        pos = pos.getNext();
        pos.setNext(new Node<Details>(new Details(4, 1)));
        //pos = pos.getNext();
        Node<Integer> newLst = numLst(lst, 5);

        Node<Integer> lstNum = new Node<Integer>(987, new Node<Integer>(4026, new Node<Integer>(219, new Node<Integer>(571, new Node<Integer>(13)))));
        //printList1(newLst);
        // System.out.println(lst.getNext().getValue());
//        int len = size(lst);
//        Details[] arr = new Details[len];
//        int j=0;
//        pos=lst;
//         while (pos != null) {
//            arr[j] = pos.getValue();
//            j++;
//            pos = pos.getNext();
//        }
//        Details[] arr2 = sortArray(arr);
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.print(arr2[i].toString() + " ");
//
//        }
        System.out.println(check(359171));
        System.out.println(find(lstNum));
    }

    public static int find(Node<Integer> lst) {
        if (lst == null) {
            return 0;
        }
        int x = lst.getValue();
        if (check(x) > 0) {
            return Math.max(x, find(lst.getNext()));
        }
        return find(lst.getNext());
    }

    public static int check(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 2 != num / 10 % 2) {
            return -999;
        }
        return check(num / 10) + 1;
    }

    public static int size(Node<Details> lst) {
        int count = 0;
        Node<Details> pos = lst;
        while (pos != null) {
            count++;
            pos = pos.getNext();
        }
        return count;
    }

    public static Node<Integer> numLst(Node<Details> lst, int numDig) {
        int len = size(lst);
        Details[] arr = new Details[len];
        Node<Integer> newLst = null;
        Node<Integer> pos2 = null;
        Node<Details> pos = lst;

        int i = 0;

        while (pos != null) {
            arr[i] = pos.getValue();
            i++;
            pos = pos.getNext();
        }
        Details[] details = sortArray(arr);

        i = arr.length - 1;
        while (i >= 0 && numDig > 0) {
            if (details[i].getAppears() > 0) {
                if (newLst == null) {
                    newLst = new Node<Integer>(details[i].getDigit());
                    pos2 = newLst;
                } else {
                    pos2.setNext(new Node<Integer>(details[i].getDigit()));
                    pos2 = pos2.getNext();
                }
                details[i].setAppears(details[i].getAppears() - 1);
            }
            if (details[i].getAppears() == 0) {
                i--;
            }
            numDig--;

        }
        return newLst;

    }

    public static int sod1(int x) {
        if (x < 10) {
            return x;
        }
        return sod1(x / 10);
    }

    public static Details[] sortArray(Details[] arr) {
        int n = arr.length;
        Details temp = null;
        for (int i = 1; i <= arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].getDigit() > arr[j + 1].getDigit()) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int sod3(int x, int y) {
        if (y == 0) {
            return x;
        }
        int tmp1 = (x * 10) + sod1(y);
        int tmp2 = sod2(y);
        return sod3(tmp1, tmp2);
    }

    public static int sod2(int x) {
        if (x < 10) {
            return 0;
        }
        return sod2(x / 10) * 10 + (x % 10);
    }

    //سؤال 5 صيف 2019
    //البند أ
    public static int toNumber(Queue<Integer> q) {
        int mult = 1, sum = 0;

        while (!q.isEmpty()) {
            sum = sum + (mult * q.remove());
            mult = mult * 10;
        }
        return sum;
    }
//سؤال 5 صيف 2019
    //البند ب

    public static int bigNumber(Node<Queue<Integer>> lst) {
        int max = Integer.MIN_VALUE;//max=0
        Node<Queue<Integer>> pos = lst;
        int num;
        while (pos != null) {
            num = toNumber(pos.getValue());
            if (num > max) {
                max = num;
            }
            pos = pos.getNext();
        }
        return max;
    }

    //السؤال الثالث ورقة  عمل  
    //5
    public static Queue<Integer> ex3(Queue<Integer> q) {
        Node<Integer> lst;
        if (!q.isEmpty()) {
            lst = new Node<Integer>(q.remove());
            while (!q.isEmpty()) {
                lst = new Node<Integer>(q.remove(), lst);
            }
            while (lst != null) {
                q.insert(lst.getValue());
                lst = lst.getNext();
            }
        }
        return q;
    }

    //السؤال الثاني ورقة  عمل  
    //5
    public static void ex2(Queue<Integer> q, int n) {
        int i = 1;
        Queue<Integer> temp1 = new Queue<Integer>();
        Queue<Integer> temp2 = new Queue<Integer>();

        while (i < n) {
            temp1.insert(q.remove());
            i++;
        }
        q.remove();
        while (!q.isEmpty()) {
            temp2.insert(q.remove());
        }

        while (!temp1.isEmpty()) {
            q.insert(temp1.remove());
        }
        while (!temp2.isEmpty()) {
            q.insert(temp2.remove());
        }

    }

    //السؤال الأول ورقة  عمل  
    //5
    public static void ex1(Queue<Integer> q) {
        Queue<Integer> temp1 = new Queue<Integer>();
        Queue<Integer> temp2 = new Queue<Integer>();
        temp1.insert(q.remove());
        temp1.insert(q.remove());
        q.remove();
        while (!q.isEmpty()) {
            temp2.insert(q.remove());
        }
        q.insert(temp1.remove());
        q.insert(temp1.remove());
        while (!temp2.isEmpty()) {
            q.insert(temp2.remove());
        }
    }

    public static int maxNum(Queue<Integer> q) {
        Queue<Integer> cloneQ = cloneQueue2(q);

        int max = cloneQ.head();

        while (!cloneQ.isEmpty()) {
            if (cloneQ.head() > max) {
                max = cloneQ.head();
            }
            cloneQ.remove();
        }
        return max;

    }

    public static boolean isSymmetrical(Queue<Integer> q) {
        Queue<Integer> cloneQ = cloneQueue2(q);
        cloneQ.reverse();

        while (!q.isEmpty()) {
            if (q.remove() != cloneQ.remove()) {
                return false;
            }
        }
        return true;
    }

    public static Queue<Integer> cloneQueue2(Queue<Integer> q) {
        Queue<Integer> cloneQ = new Queue<Integer>();
        q.insert(null);

        while (q.head() != null) {
            int x = q.remove();
            cloneQ.insert(x);
            q.insert(x);
        }
        q.remove();

        return cloneQ;
    }

    public static Queue<Character> cloneQueue(Queue<Character> q) {
        Queue<Character> helpQ = new Queue<Character>();
        Queue<Character> cloneQ = new Queue<Character>();

        while (!q.isEmpty()) {
            helpQ.insert(q.head());
            cloneQ.insert(q.remove());
        }

        while (!helpQ.isEmpty()) {
            q.insert(helpQ.remove());
        }

        return cloneQ;

    }

    //بدون دور مساعد
    //البند ج
    public static int size2(Queue<Integer> q) {
        int count = 0;
        q.insert(null);

        while (q.head() != null) {
            count++;
            q.insert(q.remove());
        }
        q.remove();
        return count;
    }

    public static int size(Queue<Integer> q) {
        Queue<Integer> temp = new Queue<Integer>();
        int count = 0;

        while (!q.isEmpty()) {
            int x = q.remove();
            temp.insert(x);
            count++;
        }

        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }

        return count;
    }

    public static Node<Integer> sumList(Node<Integer> lst1, Node<Integer> lst2) {

        Node<Integer> lst3 = new Node<Integer>(lst1.getValue() + lst2.getValue());

        Node<Integer> pos3 = lst3;
        Node<Integer> pos1 = lst1;
        Node<Integer> pos2 = lst2;
        pos1 = pos1.getNext();
        pos2 = pos2.getNext();

        while (pos1 != null && pos2 != null) {
            pos3.setNext(new Node<Integer>(pos1.getValue() + pos2.getValue()));
            pos1 = pos1.getNext();
            pos2 = pos2.getNext();
            pos3 = pos3.getNext();
        }
        while (pos1 != null) {
            pos3.setNext(new Node<Integer>(pos1.getValue()));
            pos1 = pos1.getNext();
            pos3 = pos3.getNext();
        }
        while (pos2 != null) {
            pos3.setNext(new Node<Integer>(pos2.getValue()));
            pos2 = pos2.getNext();
            pos3 = pos3.getNext();
        }

        return lst3;
    }

    public static Point maxY(Node<Point> lst) {
        Node<Point> pos = lst;
        Point maxPoint = lst.getValue();
        while (pos != null) {
            if (maxPoint.getY() < pos.getValue().getY()) {
                maxPoint = pos.getValue();
            }
            pos = pos.getNext();
        }
        return maxPoint;
    }

    public static int sumEven(Node<Integer> lst) {
        int sum = 0;
        Node<Integer> pos = lst;
        pos = pos.getNext();

        while (pos != null) {
            int x = pos.getValue();
            sum = sum + x;
            pos = pos.getNext();
            if (pos.hasNext()) {
                pos = pos.getNext();
            } else {
                return sum;
            }
        }
        return sum;

    }

    //ex12 pg 41
    public static void disconnect(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> pos1 = lst2;
        Node<Integer> pos2 = pos1.getNext();

        while (pos2 != null) {
            pos1.setNext(new Node<Integer>(pos2.getValue()));
            pos1 = pos1.getNext();
            pos2 = pos2.getNext();
        }
    }

    public static Node<Integer> merge2(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> pos1 = lst1;
        Node<Integer> pos2 = lst2;
        Node<Integer> lst3;

        if (pos1.getValue() < pos2.getValue()) {
            lst3 = pos1;
            pos1 = pos1.getNext();
        } else {
            lst3 = pos2;
            pos2 = pos2.getNext();
        }
        Node<Integer> pos3 = lst3;

        while (pos1 != null && pos2 != null) {
            if (pos1.getValue() < pos2.getValue()) {
                pos3.setNext(pos1);
                pos1 = pos1.getNext();
            } else {
                pos3.setNext(pos2);
                pos2 = pos2.getNext();
            }
            pos3 = pos3.getNext();
        }
        while (pos1 != null) {
            pos3.setNext(pos1);
            pos1 = pos1.getNext();
            pos3 = pos3.getNext();
        }

        while (pos2 != null) {
            pos3.setNext(pos2);
            pos2 = pos2.getNext();
            pos3 = pos3.getNext();
        }
        return lst3;
    }

    public static String mystery(Node<Character> lst) {
        Node<Character> revLst = new Node<Character>(lst.getValue());
        lst = lst.getNext();
        while (lst != null) {
            revLst = new Node<Character>(lst.getValue(), revLst);
            lst = lst.getNext();
        }
        String str = "";
        str = str + revLst.getValue();

        while (revLst.hasNext()) {
            revLst = revLst.getNext();
            str = str + "," + revLst.getValue();
        }

        return str;

    }

    public static void compressSequences(Node<Character> list) {
        while (list.hasNext()) {
            if (list.getValue() == list.getNext().getValue()) {
                list.setNext(list.getNext().getNext());
            } else {
                list = list.getNext();
            }
        }
    }

    public static Node<Integer> merge1(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> lst3;
        Node<Integer> pos1 = lst1;
        Node<Integer> pos2 = lst2;
        if (lst1.getValue() < lst2.getValue()) {
            lst3 = new Node<Integer>(lst1.getValue());
            pos1 = pos1.getNext();
        } else {
            lst3 = new Node<Integer>(lst2.getValue());
            pos2 = pos2.getNext();
        }
        Node<Integer> pos3 = lst3;
        while (pos1 != null && pos2 != null) {
            int smallNum;
            if (pos1.getValue() < pos2.getValue()) {
                smallNum = pos1.getValue();
                pos1 = pos1.getNext();
            } else {
                smallNum = pos2.getValue();
                pos2 = pos2.getNext();
            }
            pos3.setNext(new Node<Integer>(smallNum));
            pos3 = pos3.getNext();
        }

        while (pos1 != null) {
            pos3.setNext(new Node<Integer>(pos1.getValue()));
            pos3 = pos3.getNext();
            pos1 = pos1.getNext();
        }

        while (pos2 != null) {
            pos3.setNext(new Node<Integer>(pos2.getValue()));
            pos3 = pos3.getNext();
            pos2 = pos2.getNext();
        }

        return lst3;

    }

    public static Node<Integer> buildDigit(Node<Integer> lst) {
        Node<Integer> newLst = new Node<Integer>(-1);
        Node<Integer> pos = newLst;
        int num, digit;

        while (lst != null) {
            num = lst.getValue();

            while (num > 0) {
                digit = num % 10;
                pos.setNext(new Node<Integer>(digit));
                pos = pos.getNext();
                num = num / 10;
            }
            pos.setNext(new Node<Integer>(-9));
            pos = pos.getNext();
            lst = lst.getNext();
        }
        newLst = newLst.getNext();

        return newLst;
    }

    public static int numOddNodes(Node<Integer> lst) {
        if (lst == null) {
            return 0;
        }
        if (lst.getValue() % 2 == 1) {
            return 1 + numOddNodes(lst.getNext());
        }
        return numOddNodes(lst.getNext());
    }

    public static boolean isEven(Node<Integer> lst) {
        if (lst == null) {
            return true;
        }
        if (lst.getValue() % 2 == 1) {
            return false;
        }
        return isEven(lst.getNext());
    }

    public static boolean check(Node<Integer> lst) {
        if (!lst.hasNext()) {
            return true;
        }
        if (lst.getValue() > lst.getNext().getValue()) {
            return false;
        }
        return check(lst.getNext());
    }

    public static Node<Integer> getPosition(Node<Integer> lst, int x) {
        if (lst.getValue() == x) {
            return lst;
        }
        if (!lst.hasNext()) {
            return null;
        }
        return getPosition(lst.getNext(), x);
    }

    //2->4->5
//عملية تراجعية
    public static boolean isExist2(Node<Integer> lst, int x) {
        if (lst.getValue() == x) {
            return true;
        }
        if (!lst.hasNext()) {
            return false;
        }
        return isExist2(lst.getNext(), x);
    }

    public static boolean isExist(Node<Integer> lst, int x) {
        while (lst != null) {
            if (lst.getValue() == x) {
                return true;
            }
            lst = lst.getNext();
        }
        return false;
    }

//العملية تطبع قائمة الاعداد
    public static void printList2(Node<Integer> lst) {
        if (lst.hasNext()) {
            System.out.print(lst.getValue() + "->");
            printList2(lst.getNext());
        } else {
            System.out.println(lst.getValue());
        }
    }

    public static void printList3(Node<Character> lst) {
        if (lst.hasNext()) {
            System.out.print(lst.getValue() + "->");
            printList3(lst.getNext());
        } else {
            System.out.println(lst.getValue());
        }
    }

//العملية تعيد اكبر عدد في القائمة
    public static int getMaxNum(Node<Integer> lst) {
        if (lst == null) {
            return 0;
        }
        int x = lst.getValue();
        int y = getMaxNum(lst.getNext());
        if (x > y) {
            return x;
        }
        return y;
        // return Math.max(lst.getValue(), getMaxNum(lst.getNext()));
    }

//العملية تعيد مجموع الاعداد في القائمة
    public static int getListSum(Node<Integer> lst) {
        if (lst == null) {
            return 0;
        }
        return lst.getValue() + getListSum(lst.getNext());
    }
//العملية تعيد طول القائمة

    public static int getListCount(Node<Integer> lst) {
        if (lst == null) {
            return 0;
        }
        return 1 + getListCount(lst.getNext());
    }

    public static Node<Integer> createRandomList2() {
        int n = (int) (Math.random() * (99) + 2);
        Node<Integer> list = new Node<Integer>(n);

        for (int i = n - 1; i >= 1; i--) {
            list = new Node<Integer>(i, list);
        }

        return list;
    }

    public static Node<Integer> createRandomList1() {
        int n = (int) (Math.random() * (99) + 2);
        Node<Integer> list = new Node<Integer>(1);
        Node<Integer> pos = list;

        for (int i = 2; i <= n; i++) {
            pos.setNext(new Node<Integer>(i));
            pos = pos.getNext();
        }
        return list;
    }

    public static Node<Integer> createList(int n) {
        Node<Integer> list = new Node<Integer>((int) (Math.random() * (10) + 1));
        Node<Integer> pos = list;
        Node<Integer> temp;
        for (int i = 2; i <= n; i++) {
            temp = new Node<Integer>((int) (Math.random() * (10) + 1));
            pos.setNext(temp);
            pos = pos.getNext();
        }
        return list;
    }

    public static void printList1(Node<Integer> lst) {
        Node<Integer> pos = lst;

        while (pos.hasNext()) {
            System.out.print(pos.getValue() + "->");
            pos = pos.getNext();
        }
        System.out.print(pos.getValue());
    }

//    public static int getSumList(Node<Integer> list) {
//        int sum = 0;
//        while (list != null) {
//            sum += list.getValue();
//            list = list.getNext();
//        }
//        return sum;
//    }
    public static Node<Integer> createRandomList(int n) {
        Node<Integer> list = new Node<Integer>(-1);
        Node<Integer> pos = list;

        for (int i = 1; i <= n; i++) {
            pos.setNext(new Node<Integer>((int) (Math.random() * (100) + 1)));
            pos = pos.getNext();
        }

        return list.getNext();
    }
}
