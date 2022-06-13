package collection;

import java.util.ArrayList;

public class listImpl extends ArrayList {

    @Override
    public boolean add(Object o) {
        if (this.contains(o))
            return true;
        else
            return super.add(o);
    }

    public static void main(String ar[]){
        listImpl list = new listImpl();
        list.add(10);
        list.add(10);
        System.out.println(list);
    }
}
