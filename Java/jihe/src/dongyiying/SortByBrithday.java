package dongyiying;
import java.util.Comparator;

/**
 * 根据生日的排序器。
 * @author Administrator
 *
 */
public class SortByBrithday implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        return o1.getBrithday().compareTo(o2.getBrithday());
    }

}