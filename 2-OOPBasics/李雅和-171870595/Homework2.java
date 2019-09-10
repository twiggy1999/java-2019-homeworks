public class Homework2
{
    public static void main(String[] args)
    {
        Queue queue = new Queue(7);

        randomInit(queue);
        bubbleSort(queue);
        randomInit(queue);
        binaryInsertSort(queue);
    }

    public static void randomInit(Queue queue)
    {
        int[] rank = {1, 2, 3, 4, 5, 6, 7};
        String[] name = {"dawa", "erwa", "sanwa", "siwa", "wuwa", "liuwa", "qiwa"};
        String[] color = {"red", "orange", "yellow", "green", "cyan", "blue", "purple"};
        int p1, p2, temp;
        for (int i = 0; i < 10; i++)
        {
            p1 = (int) (Math.random() * 7);
            p2 = (int) (Math.random() * 7);
            temp = rank[p1];
            rank[p1] = rank[p2];
            rank[p2] = temp;
        }
        queue.clear();
        int j = 0;
        for (int i : rank)
        {
            j++;
            queue.add(new CalabashBrothers(i, name[i - 1], j, color[i - 1]));
        }
    }

    public static void bubbleSort(Queue queue)
    {
        System.out.println("Bubble Sort:");
        for (int i = 0; i < queue.size; i++)
            for (int j = 0; j < queue.size - i - 1; j++)
            {
                if (queue.at(j).getRank() > queue.at(j + 1).getRank())
                    queue.exchange(j, j + 1);
            }
        for (int i = 0; i < queue.size; i++)
            System.out.println(queue.at(i).getName() + ":" + queue.at(i).getName());
        System.out.println("Bubble Sort Finished!");
    }

    public static int binarySearch(Queue queue, int i)
    {
        int start = 0, end = i, mid = -1;
        while (start < end)
        {
            mid = (start + end) / 2;
            if (queue.at(mid).getRank() > queue.at(i).getRank())
                end = mid;
            else if(queue.at(mid).getRank() < queue.at(i).getRank())
                start = mid + 1;
        }
        return start;
    }

    public static void binaryInsertSort(Queue queue)
    {
        System.out.println("Binary Insert Sort:");
        for (int i = 0; i < queue.size; i++)
        {
            int key = binarySearch(queue, i);
            for (int j = i; j > key; j--)
                queue.exchange(j, j - 1);
        }
        for (int i = 0; i < queue.size; i++)
            System.out.println(queue.at(i).getName() + ":" + queue.at(i).getColor());
        System.out.println("Binary Insert Sort Finished");
    }
}

class CalabashBrothers
{
    private int rank;
    private String name;
    private String color;
    public int position;

    public CalabashBrothers(int rank, String name, int position, String color)
    {
        this.rank = rank;
        this.name = name;
        this.position = position;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public int getRank()
    {
        return rank;
    }

    public String getColor()
    {
        return color;
    }

    public void report(String sentence)
    {
        System.out.println(sentence);
    }

    public void exchangePositionWith(CalabashBrothers bro)
    {
        if (bro.rank == this.rank)
            report(this.name + ": Can not exchange position with myself!");
        else
        {
            int temp = this.position;
            this.position = bro.position;
            bro.position = temp;
            report(this.name + ": " + this.rank + " -> " + bro.rank);
            bro.report(bro.name + ": " + bro.rank + " -> " + this.rank);
        }
    }
}

class Queue
{
    public int size;
    CalabashBrothers[] queue;

    Queue(int size)
    {
        this.size = size;
        this.queue = new CalabashBrothers[size];
    }

    public boolean add(CalabashBrothers element)
    {
        for (int i = 0; i < size; i++)
        {
            if (queue[i] == null)
            {
                queue[i] = element;
                return true;
            }
        }
        return false;
    }

    public void clear()
    {
        for (int i = 0;i<size;i++)
            queue[i] = null;
    }

    public CalabashBrothers at(int i)
    {
        return queue[i];
    }

    public void exchange(int i, int j)
    {
        queue[i].exchangePositionWith(queue[j]);
        CalabashBrothers temp = queue[j];
        queue[j] = queue[i];
        queue[i] = temp;
    }
}
