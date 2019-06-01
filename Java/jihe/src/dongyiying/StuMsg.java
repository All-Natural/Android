package dongyiying;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

public class StuMsg {
    TreeMap<Integer, Student> stu_map = new TreeMap<Integer, Student>();
    private Random r = new Random();

    // 定义学号集合。

    // 初始化 学生集合。
    public void initialization(int stuNum) {
        for (int i = 0; i < stuNum; i++) {
            Student p = new Student();
            p.setId(i);
            p.setName("name" + i);
            p.setBrithday(new Date((long) (System.currentTimeMillis() - (long) (360 * 24 * 3600 * 1000)
                    * r.nextInt(1000))));
            p.setSex(r.nextInt(100) % 2 == 0 ? "女" : "男");

            stu_map.put(p.getId(), p);
        }
    }

    // 打印 学生集合。
    public void disPlay(TreeMap<Integer, Student> stu_map) {
        for (Map.Entry<Integer, Student> me : stu_map.entrySet()) {
            // Integer key = me.getKey();
            Student value = me.getValue();
            System.out.println(value);
        }

    }

    /**
     * 使用TreeSet存储返回的排好序的学生集合。因为TreeSet在添加对象时根据对象的Comparable方法会自动排好序。
     *
     * @param stuMap
     * @return
     */
    // 根据学生的生日，对学生进行排序。并存在TreeSet中。
    public TreeSet<Student> sort(TreeMap<Integer, Student> stuMap) {
        TreeSet<Student> temp = new TreeSet<Student>(new SortByBrithday());

        for (int i = 0; i < stuMap.size(); i++) {
            temp.add(stuMap.get(i));// 添加元素。
        }
        return temp;
    }

    // 根据学号进行检索函数。
    public Student getId(int key) {
        return this.stu_map.get(key);

    }
}
