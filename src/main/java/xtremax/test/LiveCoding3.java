//package xtremax.test;
//
//import com.sun.org.apache.xml.internal.security.Init;
//import javafx.scene.control.TreeItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LiveCoding3 {
//    /**
//     * Your task here is to implement 2 extension method ToTreeItem and GetMap.
//     * <p>
//     * ToTreeItem
//     * this method will transform list to tree
//     * - tree save reference to children in form of object while list save reference to parent Id.
//     * <p>
//     * GetMap
//     * this method will return string representation of tree item
//     * <p>
//     * Expected output for GetMap()
//     * Id : 1, Name : Alpha
//     * --Id : 11, Name : Alpha-01
//     * --Id : 12, Name : Alpha-02
//     * ----Id : 121, Name : Alpha-02-Ace
//     * Id : 2, Name : Beta
//     * --Id : 21, Name : Beta-01
//     * ----Id : 211, Name : Beta-01-One
//     * ----Id : 212, Name : Beta-01-Two
//     * ----Id : 213, Name : Beta-01-Three
//     * --Id : 22, Name : Beta-02
//     * ----Id : 221, Name : Beta-02-One
//     * ----Id : 222, Name : Beta-02-Two
//     * ----Id : 223, Name : Beta-02-Three
//     * <p>
//     * <p>
//     * Your scope is limited to this file except class Program and Main method, so you are free to :
//     * - Change CollectionExtensions class
//     * - Add new method in CollectionExtensions class
//     * - Add new class in this file
//     * <p>
//     * You're NOT allowed to :
//     * - Change class Program
//     * - Change Main method
//     * - Change any file other than this file
//     *
//     * @param args
//     */
//    public static void main(String[] args) {
//        List<ListItem> listItems = Init.initListItems();
//        List<TreeItem> treeItems = toTreeItem(listItems);
//
//        System.out.println();
//        System.out.println("=========================================================================================");
//        System.out.println();
//
//        System.out.println(getMap(treeItems));
//    }
//
//    public static List<TreeItem> toTreeItem(List<ListItem> listItems) {
//        return new ArrayList<>();
//    }
//
//    public static String getMap(List<TreeItem> treeItems) {
//        return "";
//    }
//}
