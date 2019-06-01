package dongyiying;
import java.util.Scanner;
import java.util.TreeSet;
public class CollectionTest {
    public static void main(String[] args) {
        TreeSet<Student> al = new TreeSet<Student>();
        StuMsg sm = new StuMsg();
        sm.initialization(6);
        sm.disPlay(sm.stu_map);
        System.out.println("++++++++++++++++++++++++++++++++++");
        // 根据生日排序演示。
        System.out.println("请输入一个数");
        Scanner num = new Scanner(System.in);
         //读取整型输入
        al = sm.sort(sm.stu_map);
        if(num.nextInt()==1){
        for (Student s : al) {
            System.out.println(s);
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        }

        // 检索演示。
        System.out.println("请输入一个数");
        Scanner num1 = new Scanner(System.in);
        System.out.println(sm.getId(num1.nextInt()));

    }
}

