import java.awt.Color;
import java.awt.Graphics;

public class DrawGraphics {
    BouncingBox box;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        box = new BouncingBox(200, 50, Color.RED);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);

        // 1. 绘制一个椭圆 (Oval)
        surface.drawOval(10, 25, 100, 120); // x坐标, y坐标, 宽度, 高度

        // 2. 绘制一个填充的矩形 (Filled Rectangle)
        surface.setColor(Color.RED); // 设置颜色为红色
        surface.fillRect(180, 50, 120, 80); // x坐标, y坐标, 宽度, 高度

        // 3. 绘制一段文本 (Text)
        surface.setColor(Color.BLUE); // 设置颜色为蓝色
        surface.drawString("Hello, MIT!", 100, 250); // 文本内容, x坐标, y坐标

        box.draw(surface);
    }
}