import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class DemoLoginCaro {
    protected   JFrame frame;
    protected  JButton buttonLogin, buttonLogout, buttonCreate;
    protected  JTextField textAccountName;
    protected JPasswordField passwordField;
    protected  JLabel labelAccountName,labelPass;
    protected  JPanel panelUser, panelFunction,panelIntro;

    public JLabel getLabelAccountName() {
        return labelAccountName;
    }

    public  DemoLoginCaro(){
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 300);

        frame.setLayout(new GridLayout(3,1));
        panelUser = new JPanel();
        panelIntro = new JPanel();
        panelFunction = new JPanel(new GridLayout(1,3));
        frame.add(panelIntro);
        frame.add(panelUser);
        frame.add(panelFunction);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
  public void demoLogin(){
          JLabel labelIntro = new JLabel("Caro");

      try {
          // Tải ảnh từ URL
          URL url = new URL("https://play-lh.googleusercontent.com/0bLqDdtCbtiD88aSuTLND1-sevjGGKqBVbyNbXu0JFRdephAtwYKDcHxlkmjRdtIKhGs");
          ImageIcon icon = new ImageIcon(url);

          // Thiết lập kích thước cho ImageIcon
          Image image = icon.getImage();
          Image newImage = image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
          icon = new ImageIcon(newImage);

          // Đặt ImageIcon cho JLabel
          labelIntro.setIcon(icon);
      } catch (Exception e) {
          e.printStackTrace();
      }
          panelIntro.add(labelIntro);
      JPanel panelSum = new JPanel(new GridLayout(2,1));
      panelUser.add(panelSum);
        JPanel panelTen = new JPanel(new GridLayout(1,2));
        JPanel panelMatKhau = new JPanel(new GridLayout(1,2));
        panelSum.add(panelTen);
        panelSum.add(panelMatKhau);
        panelUser.add(panelSum);
        labelAccountName = new JLabel("Tên đăng nhập: " );
        labelPass = new JLabel("Mật khẩu: ");
        textAccountName  = new JTextField(15);
        passwordField = new JPasswordField(15);
        panelTen.add(labelAccountName);
        panelTen.add(textAccountName);
        panelMatKhau.add(labelPass);
        panelMatKhau.add(passwordField);
        buttonLogin = new JButton("Đăng nhập");
        buttonCreate = new JButton("Đăng kí");
        buttonLogout = new JButton("Đăng xuất");
        panelFunction.add(buttonLogin);
      panelFunction.add(buttonCreate);
      panelFunction.add(buttonLogout);
      buttonLogin.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String temp = textAccountName.getText();
              String pass = passwordField.getText();
              if(temp.equals("admin") && pass.equals("admin")){
                  JOptionPane.showMessageDialog(frame, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                  DemoSwingCaro s = new DemoSwingCaro();
                  s.demoCaro(temp);
                  closeLogin();

              }else{
                  JOptionPane.showMessageDialog(frame, "Tài khoản hoặc mật khẩu không đúng.", "Thông báo", JOptionPane.ERROR_MESSAGE);
              }
          }
      });
      buttonCreate.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              CreateLogin cre   = new CreateLogin();
              cre.demoCreateLogin();
              closeLogin();
          }
      });
      frame.revalidate();

  }
  public void closeLogin(){
        frame.setVisible(false);
  }
    public static void main(String[] args) {
        DemoLoginCaro demo = new DemoLoginCaro();
        demo.demoLogin();
    }

}
