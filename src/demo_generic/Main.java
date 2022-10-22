package demo_generic;

public class Main {
    public static void main(String[]args){
        Generic<String,Integer> g = new Generic<>();// thằng thì String thằng thì Integer  đỡ phải viết hàm nhiều (kiểu dữ liệu phụ thuộc vào khi khai báo đối tượng mới )
        g.setDataX("hello");

        Generic<Integer,String> g2 = new Generic<>();
        g2.setDataX(10);

        g.run("xin chào! hello bebe");
        g2.run(100);
    }
}
