import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


public class DemoSwingCaro {

  protected   JFrame frame,frame1;
    protected JButton buttonLogin, buttonExit;
    protected JLabel userName, password;
    protected JPanel panelIntro, panelProfile, panelFunction;
    protected  DemoLoginCaro a;
    public DemoSwingCaro() {

        frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));
        buttonExit = new JButton("Thoát");
        buttonLogin = new JButton("Đăng nhập");
        userName = new JLabel("Username");
        password = new JLabel("Mật khẩu");

        frame.setVisible(true);
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelIntro = new JPanel();
        panelProfile = new JPanel();
        panelFunction = new JPanel();
        frame.add(panelIntro);
        frame.add(panelProfile);
        panelFunction.setLayout(new GridLayout(3, 3));
        frame.add(panelFunction);
        frame.repaint();
        frame.setLocationRelativeTo(null);

    }

    public void demoCaro(String a) {
        JLabel labelIntro = new JLabel("Caro");
        labelIntro.setSize(20, 20);
        panelIntro.add(labelIntro);

        JPanel panelProfile1 = new JPanel();
        panelProfile1.setLayout(new GridLayout(1, 2));
        panelProfile.add(panelProfile1);

        JPanel panelProfile2 = new JPanel();
        JLabel labelAvatar = new JLabel();

        try {
            // Tải ảnh từ URL
            URL url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpqJaNx9RAW7hYiUKFyNcKgD_WM_9RQNklLA&usqp=CAU");
            ImageIcon icon = new ImageIcon(url);

            // Thiết lập kích thước cho ImageIcon
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);

            // Đặt ImageIcon cho JLabel
            labelAvatar.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }

        panelProfile2.add(labelAvatar);
        panelProfile1.add(panelProfile2);

        JPanel panelProfile3 = new JPanel();
        panelProfile1.add(panelProfile3);
        panelProfile3.setLayout(new GridLayout(4, 1));

        JLabel labelName = new JLabel("Tên tài khoản:  "  + a  );
        JLabel labelDiem = new JLabel("Điểm: 100");
        JLabel labelThuHang = new JLabel("Thứ hạng: 1");
        JLabel labelTiLe = new JLabel("Tỉ lệ thắng: 100%");

        panelProfile3.add(labelName);
        panelProfile3.add(labelDiem);
        panelProfile3.add(labelThuHang);
        panelProfile3.add(labelTiLe);

        JButton buttonChoiVoiMay = new JButton("Chơi với máy");
        JButton buttonDangXuat = new JButton("Đăng Xuất");
        JButton buttonBangXepHang = new JButton("Bảng Xếp Hạng");
buttonDangXuat.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
});
        panelFunction.add(buttonChoiVoiMay);
        panelFunction.add(buttonBangXepHang);
        panelFunction.add(buttonDangXuat);
        buttonBangXepHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // demoDelete();
                frame.setVisible(false);
            }
        });
    }

public void demoDelete(){
    frame1 = new JFrame();
    frame1.setLocationRelativeTo(null);
    frame1.setVisible(true);
    frame1.setSize(500, 700);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setVisible(true);
    frame1.add(new JLabel("Lên nè em"));
}
    public static void main(String[] args) {

    }
}
