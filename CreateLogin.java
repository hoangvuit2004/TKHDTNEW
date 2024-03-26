import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class CreateLogin {
    protected JFrame frame;
    protected  JButton  buttonCreate, buttonLogin, buttonSupport;
    protected  JTextField textAccountName, textEmail;
    protected JPasswordField passwordField, passwordField1;
    protected  JLabel labelAccountName,labelPass,labelPass1, labelIntro, labelEmail;
    protected  JPanel panelIntroCreate, panelInfor,panelButton;
    public CreateLogin(){
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 400);

        frame.setLayout(new GridLayout(2,1));
        panelIntroCreate = new JPanel();
        panelInfor = new JPanel();
        panelInfor.setLayout(new GridLayout(2,1));
        panelButton = new JPanel(new GridLayout(3,3));
        panelInfor.add(panelIntroCreate);
        frame.add(panelInfor);
        frame.add(panelButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void demoCreateLogin(){
        labelIntro = new JLabel("Đăng Kí Tài Khoản");
        try {
            URL url = new URL("https://cdn-icons-png.flaticon.com/512/3658/3658756.png");

            // Tải ảnh từ URL
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
        labelEmail = new JLabel("Email");
        labelAccountName = new JLabel("Tên tài khoản: ");
        labelPass = new JLabel("Mật khẩu: ");
        labelPass1 = new JLabel("Nhập lại mật khẩu: ");
        textAccountName = new JTextField(15);
        textEmail = new JTextField(15);
        passwordField = new JPasswordField(15);
        passwordField1 = new JPasswordField(15);
        panelIntroCreate.add(labelIntro);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        panel.add(labelAccountName);
        panel.add(textAccountName);
        panel.add(labelPass);
        panel.add(passwordField);
        panel.add(labelPass1);
        panel.add(passwordField1);
        panel.add(labelEmail);
        panel.add(textEmail);
        panelInfor.add(panel);
        buttonCreate = new JButton("Đăng kí");
        buttonCreate.setPreferredSize(new Dimension(10, 30));
        panelButton.add(buttonCreate);
   buttonLogin = new JButton("Đăng nhập");
   buttonSupport = new JButton("Hỗ trợ");
   panelButton.add(buttonLogin);
   panelButton.add(buttonSupport);
   buttonLogin.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           DemoLoginCaro demo  = new DemoLoginCaro();
           demo.demoLogin();
           closeLogin();
       }
   });
   buttonCreate.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           String accountName = textAccountName.getText();
           String email = textEmail.getText();
           String pass = new String(passwordField.getPassword());
           String pass1 = new String(passwordField1.getPassword());
           if(pass.length() < 5){
               JOptionPane.showMessageDialog(frame, "Vui lòng nhập mật khẩu mạnh hơn.", "Thông báo", JOptionPane.WARNING_MESSAGE);
           }else{
               if(accountName.isEmpty() || email.isEmpty() || pass.isEmpty() || pass1.isEmpty()) {
                   JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
               } else if(!pass.equals(pass1)) {
                   JOptionPane.showMessageDialog(frame, "Mật khẩu nhập lại không khớp.", "Thông báo", JOptionPane.ERROR_MESSAGE);
               } else {
                   JOptionPane.showMessageDialog(frame, "Đăng kí thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                   DemoLoginCaro demo  = new DemoLoginCaro();
                   demo.demoLogin();
                   closeLogin();

               }
           }



       }
   });
        frame.revalidate();
    }
    public void closeLogin(){
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        CreateLogin s = new CreateLogin();
s.demoCreateLogin();
    }
}
