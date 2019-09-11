public class CalabashBrother {
    /* Class used to represent Calabash Brothers */
    private int rank;
    private String color;
    private String name;

    public CalabashBrother(int rank) {
        String[] names = {"老大", "老二", "老三", "老四", "老五", "老六", "老七"};
        String[] colorArray = {"红色", "橙色", "黄色", "绿色", "青色", "蓝色", "紫色"};
        this.rank = rank;
        color = colorArray[rank];
        name = names[rank];
    }

    public int getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
