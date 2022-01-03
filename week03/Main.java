package OOP.week03;

import java.text.ParsePosition;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    String[] names = { "CompareModifiedDate", "CompareFileType", "CompareFileName", "Main", "CompareSize"  };
    String[] types = { "java", "java", "class", "java", "Class" };
    int[] sizes = { 120, 80, 150, 85, 100 };
    String[] dateStrings = { "2020-09-13T21:59:00", "2020-09-12T21:59:00",
                             "2020-09-13T16:54:00", "2020-09-12T21:54:00", "2020-09-13T11:59:00" };

    public FileInfo[] createFileInfoArrays() {
        FileInfo[] fileLists = new FileInfo[names.length];
        SimpleDateFormat dateTimeInstance = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (int i = 0; i < fileLists.length; i++) {
            Date date = dateTimeInstance.parse(dateStrings[i], new ParsePosition(0));
            fileLists[i] = new FileInfo(names[i], types[i], sizes[i], date);
        }
        return fileLists;
    }

    public void printFileLists(FileInfo[] fileLists) {
        for (FileInfo fi : fileLists) {
            System.out.println(fi);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        FileInfo[] fileLists = m.createFileInfoArrays();
        
        System.out.println("���� ����Ʈ");
        m.printFileLists(fileLists);

        Sorter sorter = new Sorter(new CompareFileName());
        System.out.println("\n\n���� �̸����� ���ĵ� ����Ʈ");
        sorter.bubbleSort(fileLists);
        m.printFileLists(fileLists);

        System.out.println("\n\n���� ������ ���ĵ� ����Ʈ");
        sorter.setComparable(new CompareFileType());
        sorter.bubbleSort(fileLists);
        m.printFileLists(fileLists);

        System.out.println("\n\n���� ũ��� ���ĵ� ����Ʈ");
        sorter.setComparable(new CompareSize());
        sorter.bubbleSort(fileLists);
        m.printFileLists(fileLists);

        System.out.println("\n\n���� ���� �ð����� ���ĵ� ����Ʈ");
        sorter.setComparable(new CompareModifiedDate());
        sorter.bubbleSort(fileLists);
        m.printFileLists(fileLists);
    }
}

