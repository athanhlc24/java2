package demo_generic;

public class Generic<X,Y>{//tham số hoá kiểu dữ liệu
    X dataX;
    Y dataY;

    public Generic() {
    }

    public X getDataX() {
        return dataX;
    }

    public void setDataX(X dataX) {
        this.dataX = dataX;
    }

    public Y getDataY() {
        return dataY;
    }

    public void setDataY(Y dataY) {
        this.dataY = dataY;
    }
    public <A> void  run(A msg){// generic in method, tham số hoá, ít dùng
        System.out.println(msg);
    }
}
