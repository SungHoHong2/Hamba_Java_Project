package BC_1;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import javax.swing.SwingConstants;
public class Register extends JFrame {
 JLabel ja1, ja2, ja3, ja4, ja5, ja6, ja7, ja8, ja9, ja10;
 private JPanel contentPane;
 private Window win;
 static JTextField tf1;
 static JTextField tf2;
 static TextField tf3;
 static JTextField tf4;
 static JTextField tf5;
 static JTextField tf6;
 static JTextField tf7;
 private Choice cb;
 private Choice cb2;
 private JButton btn1;
 private JButton btn2;
 private JLabel jla1;
 static TextField tfp1;
 static TextField tfp2;
 private JLabel lbl3;
 static JTextField tfn1;
 private JSlider slider;
 private JSlider slider_1;
 static JLabel lbl4;
 static JLabel lbl5;
  FileDialog fd1;
   ImageIcon ImageFilebuf;
   static String imagefilename="btn.png";
   static String name;
 String tel = "";
 String mail = "";
 String regi = "";
 String jobb = "";
 int resx;
 int resy;
 static Choice region;
 static Label regionl;
 static Choice job;
 static Label jobl;
 static JPanel panel;
 static Label label_3;
 Dialog dd = new Dialog(this, "Infomation", true);
 Label la = new Label();
 Label errorMessage = new Label();
 Button btncf = new Button("Confirm");
 public Register() {
   fd1 = new FileDialog(this,"Select file to Open");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(250, 35, 635, 700);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(255, 255, 153));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  ja1 = new JLabel("ID");
  ja1.setBounds(10, 93, 11, 15);
  tf1 = new JTextField();
  tf1.setBounds(72, 90, 101, 21);
  ja2 = new JLabel("PW");
  ja2.setBounds(10, 122, 55, 15);
  ja3 = new JLabel("PW2");
  ja3.setBounds(10, 160, 79, 15);
  ja4 = new JLabel("e-mail");
  ja4.setBounds(12, 328, 55, 15);
  ja5 = new JLabel("Tel");
  ja5.setBounds(10, 271, 29, 15);
  ja6 = new JLabel("Address");
  ja6.setBounds(10, 364, 55, 15);
  ja7 = new JLabel("Jumin");
  ja7.setBounds(10, 234, 55, 15);
  ja8 = new JLabel("Prefer Bar Mood");
  ja8.setBounds(143, 392, 107, 15);
  ja9 = new JLabel("Prefer Bar Price");
  ja9.setBounds(143, 493, 107, 15);
  contentPane.setLayout(null);
  getContentPane().add(ja1);
  getContentPane().add(ja2);
  getContentPane().add(ja3);
  getContentPane().add(ja4);
  getContentPane().add(ja5);
  getContentPane().add(ja6);
  getContentPane().add(ja7);
  getContentPane().add(ja8);
  getContentPane().add(ja9);
  getContentPane().add(tf1);
  tf2 = new JTextField(6);
  tf2.setBounds(68, 228, 79, 21);
  contentPane.add(tf2);
  tf3 = new TextField(7);
  tf3.setBounds(183, 228, 79, 21);
  tf3.setEchoChar('*');
  contentPane.add(tf3);
  cb = new Choice();
  cb.setBounds(72, 271, 55, 21);
  cb.add("Select");
  cb.add("02");
  cb.add("031");
  cb.add("032");
  cb.add("033");
  cb.add("044");
  contentPane.add(cb);
  cb.addItemListener(new choicelis());
  tf4 = new JTextField();
  tf4.setBounds(143, 268, 74, 21);
  contentPane.add(tf4);
  tf4.setColumns(10);
  tf5 = new JTextField();
  tf5.setBounds(229, 268, 79, 21);
  contentPane.add(tf5);
  tf5.setColumns(10);
  JLabel label = new JLabel("-");
  label.setBounds(133, 271, 55, 15);
  contentPane.add(label);
  JLabel label_1 = new JLabel("-");
  label_1.setBounds(221, 271, 22, 15);
  contentPane.add(label_1);
  tf6 = new JTextField();
  tf6.setBounds(72, 325, 116, 21);
  contentPane.add(tf6);
  tf6.setColumns(10);
  cb2 = new Choice();
  cb2.setBounds(207, 325, 101, 21);
  cb2.add("Select");
  cb2.add("gmail.com"); // ������������������ ���������
  cb2.add("naver.com");
  cb2.add("daum.net");
  cb2.add("nate.com");
  cb2.add("yahoo.co.kr");
  contentPane.add(cb2);
  cb2.addItemListener(new choicelis());
  JLabel label_2 = new JLabel("@");
  label_2.setBounds(195, 328, 22, 15);
  contentPane.add(label_2);
  tf7 = new JTextField();
  tf7.setBounds(72, 361, 312, 21);
  contentPane.add(tf7);
  tf7.setColumns(10);
  slider = new JSlider();
  slider.setForeground(new Color(255, 255, 255));
  slider.setBackground(new Color(204, 255, 153));
  slider.setValue(1);
  slider.setToolTipText("");
  slider.setMaximum(2);
  slider.setBounds(84, 417, 200, 59);
  contentPane.add(slider);
  slider.addChangeListener(new slideraction());
  slider_1 = new JSlider();
  slider_1.setBackground(new Color(204, 255, 102));
  slider_1.setMaximum(2);
  slider_1.setValue(1);
  slider_1.setBounds(84, 518, 200, 51);
  contentPane.add(slider_1);
  slider_1.setMajorTickSpacing(5);
  slider_1.addChangeListener(new slideraction());
  /*
   * slider.setPaintLabels(true); // slider��� ������ ������
   * slider.setPaintTicks(true); // ������������ slider.setPaintTrack(true); //
   * slider box ������
   * 
   * slider.setMajorTickSpacing(10); // ��� ������ ������
   * slider.setMajorTickSpacing(5); // ������ ������ ������
   */
  JLabel lblNewLabel = new JLabel("silence");
  lblNewLabel.setBounds(28, 434, 44, 15);
  contentPane.add(lblNewLabel);
  JLabel lblNewLabel_1 = new JLabel("noisy");
  lblNewLabel_1.setBounds(306, 434, 57, 15);
  contentPane.add(lblNewLabel_1);
  JLabel lblNewLabel_2 = new JLabel("Low");
  lblNewLabel_2.setBounds(28, 536, 29, 15);
  contentPane.add(lblNewLabel_2);
  JLabel lblNewLabel_3 = new JLabel("High");
  lblNewLabel_3.setBounds(306, 536, 57, 15);
  contentPane.add(lblNewLabel_3);
  btn1 = new JButton("confirm");
  btn1.setBounds(415, 609, 152, 42);
  contentPane.add(btn1);
  btn1.addActionListener(new btnaction());
  btn2 = new JButton("cancle");
  btn2.setBounds(69, 609, 152, 42);
  contentPane.add(btn2);
  btn2.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    dispose();
   }
  });
  jla1 = new JLabel("-");
  jla1.setBounds(159, 231, 57, 15);
  contentPane.add(jla1);
  tfp1 = new TextField();
  tfp1.setBounds(71, 122, 91, 21);
  tfp1.setEchoChar('*');
  contentPane.add(tfp1);
  tfp2 = new TextField();
  tfp2.setBounds(96, 156, 101, 21);
  tfp2.setEchoChar('*');
  contentPane.add(tfp2);
  lbl3 = new JLabel("Name");
  lbl3.setBounds(10, 192, 37, 15);
  contentPane.add(lbl3);
  tfn1 = new JTextField();
  tfn1.setBounds(68, 189, 116, 21);
  contentPane.add(tfn1);
  tfn1.setColumns(10);
  lbl4 = new JLabel("Common");
  lbl4.setBounds(375, 434, 70, 15);
  contentPane.add(lbl4);
  lbl5 = new JLabel("Common");
  lbl5.setBounds(375, 536, 70, 15);
  contentPane.add(lbl5);
  region = new Choice();
  region.setBounds(373, 90, 83, 21);
  region.add("Select");
  region.add("Seoul");
  region.add("Gyunggi");
  region.add("Incheon");
  region.add("Gwangju");
  region.add("DaeGu");
  region.add("BuSan");
  region.add("UlSan");
  contentPane.add(region);
  region.addItemListener(new choicelis());
  regionl = new Label("Region");
  regionl.setBounds(314, 93, 43, 23);
  contentPane.add(regionl);
  job = new Choice();
  job.setBounds(373, 152, 83, 21);
  job.add("Select");
  job.add("worker");
  job.add("College Student");
  job.add("unemployed");
  job.add("other.");
  contentPane.add(job);
  job.addItemListener(new choicelis());
  jobl = new Label("Work");
  jobl.setBounds(314, 152, 37, 23);
  contentPane.add(jobl);
  panel = new JPanel();
  panel.setBackground(new Color(255, 153, 102));
  panel.setBounds(0, 0, 619, 66);
  contentPane.add(panel);
  panel.setLayout(null);
  label_3 = new Label("Sign Up");
  label_3.setFont(new Font("Segoe UI Symbol", Font.BOLD, 23));
  label_3.setBounds(0, 0, 335, 66);
  panel.add(label_3);
  Panel panel_1 = new Panel();
    ImageFilebuf= new ImageIcon(imagefilename);
    panel_1.setBackground(new Color(255, 255, 204));
    panel_1.setBounds(391, 189, 218, 224);
    panel_1.add(new JLabel(ImageFilebuf));
    add(panel_1);
    
    Button imgbtn = new Button("Image");
    imgbtn.setBackground(new Color(255, 255, 102));
    imgbtn.setBounds(434, 426, 175, 42);
    imgbtn.addActionListener(new PhotoInput());
    add(imgbtn);
    
  setVisible(true);
 }
 class slideraction implements ChangeListener {
  @Override
  public void stateChanged(ChangeEvent e) {
   // TODO Auto-generated method stub
   if (e.getSource() == slider) {
    int x = slider.getValue();
    resx = x;
    if (slider.getValue() == 0) {
     lbl4.setText("Slience");
    } else if (slider.getValue() == 1) {
     lbl4.setText("Common");
    } else if (slider.getValue() == 2) {
     lbl4.setText("Noisy");
    }
   }
   if (e.getSource() == slider_1) {
    int y = slider_1.getValue();
    resy = y;
    if (slider_1.getValue() == 0) {
     lbl5.setText("cheap");
    } else if (slider_1.getValue() == 1) {
     lbl5.setText("Common");
    } else if (slider_1.getValue() == 2) {
     lbl5.setText("High-Price");
    }
   }
  }
 }
 class PhotoInput implements ActionListener
 {
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   
   fd1.setVisible(true);
   System.out.println(fd1.getDirectory()+fd1.getFile());
   try {
    
    FileInputStream fis = new FileInputStream(fd1.getDirectory()+fd1.getFile());
    FileOutputStream fout = new FileOutputStream("BC_1_image/"+tf1.getText()+"_1.png");
    
    int data = 0;
    try {
     while((data=fis.read())!=-1)
     {
      char ch = (char) data;
      System.out.print(ch);
      fout.write(data);
     }
     } catch (IOException e1) {
     // TODO Auto-generated catch block
     e1.printStackTrace();
     }
    
    imagefilename= "BC_1_image/"+"test"+"_1.png";      
    dispose();
    new Register();
     
   } catch (FileNotFoundException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }   
  }
 }
   
    
    
    
   
   
 
 class choicelis implements ItemListener {
  String item;
  String item2;
  String item3;
  String item4;
  @Override
  public void itemStateChanged(ItemEvent e) {
   // TODO Auto-generated method stub
   if (e.getSource() == cb) {
    Choice cb = (Choice) e.getSource();
    item = cb.getSelectedItem();
    tel = item;
   } else if (e.getSource() == cb2) {
    Choice cb2 = (Choice) e.getSource();
    item2 = cb2.getSelectedItem();
    mail = item2;
   } else if (e.getSource() == region) {
    Choice region = (Choice) e.getSource();
    item3 = region.getSelectedItem();
    regi = item3;
   } else if (e.getSource() == job) {
    Choice job = (Choice) e.getSource();
    item4 = job.getSelectedItem();
    jobb = item4;
   }
   /*
    * if(e.getStateChange() == ItemEvent.SELECTED) tel =
    * (String)e.getItem();
    */
   /*
    * tel = (String)e.getItem();
    * 
    * mail = (String)e.getItem();
    */
   /*
    * Choice cb = (Choice)e.getItem(); str
    * =str+(String)cb.getItem()+" ";
    */
  }
 }
 class btnaction extends Frame implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   if (e.getSource() == btn1) {
    dd.setBounds(100, 100, 300, 200);
    dd.setLayout(null);
    la.setText("Error");
    la.setBounds(100, 40, 100, 40);
    dd.add(la);
    errorMessage.setText("");
    errorMessage.setBounds(100, 90, 200, 20);
    dd.add(errorMessage);
    btncf.setBounds(100, 120, 100, 60);
    dd.add(btncf);
    btncf.addActionListener(new errorbtn());
    int age = 0;
    try {
     String jumin = tf2.getText().substring(0, 1);
     String frojumin = tf2.getText().substring(0, 2);
     int biry = Integer.parseInt(jumin);
     int froju = Integer.parseInt(frojumin);
     if (biry == 9)
      age = 2014 - (1900 + froju) + 1;
     else if (biry == 0)
      age = 2014 - (2000 + froju) + 1;
    } catch (Exception e2) {
     System.out.println("Error");
    }
    if (tf1.getText().isEmpty())
     errorMessage.setText("ID is null");
    else if (tfp1.getText().isEmpty())
     errorMessage.setText("password is null");
    else if (tfp2.getText().isEmpty())
     errorMessage.setText("passwordConfirm is null");
    else if (!tfp1.getText().equals(tfp2.getText()))
     errorMessage.setText("password not maching");
    else if (tfn1.getText().isEmpty())
     errorMessage.setText("name is null");
    else if (!(regi.equals("Seoul") || regi.equals("Gyunggi")
      || regi.equals("Incheon") || regi.equals("Gwangju")
      || regi.equals("DaeGu") || regi.equals("BuSan") || regi.equals("UlSan")))
    
    
     
     errorMessage.setText("Select Region");
    else if (tf2.getText().isEmpty())
     errorMessage.setText("Sign Number is null");
    else if (age < 20)
     errorMessage.setText("Minor is not Join");
    else if (!(tf2.getText().length() == 6))
     errorMessage.setText("Front Sign Number is 6space ");
    else if (tf3.getText().isEmpty())
     errorMessage.setText("Front Sign Number is null.");
    else if (!(tf3.getText().length() == 7))
     errorMessage.setText("Back Sign Number is 7space");
    else if (!(jobb.equals("worker") || (jobb.equals("College Student") || (jobb
      .equals("unemployed") || (jobb.equals("other."))))))
     
     errorMessage.setText("SelectWork");
    else if (!(tel.equals("02") || (tel.equals("031") || (tel
      .equals("032") || (tel.equals("033") || (tel
      .equals("044")))))))
     errorMessage.setText("Select TelNumber");
    else if (tf6.getText().isEmpty())
     errorMessage.setText("mail is null");
    else if (!(mail.equals("gmail.com") || (mail
      .equals("naver.com") || (mail.equals("daum.net") || (mail
      .equals("nate.com") || (mail.equals("yahoo.co.kr")))))))
     errorMessage.setText("Select Mail");
    else if (tf7.getText().isEmpty())
     errorMessage.setText("Address is null");
    else if (!(slider.getValue() == 0 || slider.getValue() == 1 || slider
      .getValue() == 2))
     errorMessage.setText("Select Mood");
    else if (!(slider_1.getValue() == 0 || slider_1.getValue() == 1 || slider_1
      .getValue() == 2))
     errorMessage.setText("Select Price");
    else {
     la.setText("No Problem.");
     errorMessage.setText("Welcome!");
     btncf.addActionListener(new truebtn());
    String smail = tf6.getText()+"@"+mail;  
     
     new client1(tf1.getText(), tfp1.getText(), tfn1.getText(),
       regi, tf2.getText(), tf3.getText(), jobb, tel,
       tf4.getText(), tf5.getText(), smail, tf7.getText(),
       resx, resy, 0);
     
     setVisible(false);
     
     
    }
    dd.addWindowListener(new Close_c());
   } else if (e.getSource() == btn2) {
   }
   dd.setVisible(true);
  }
 }
 class errorbtn implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   dd.setVisible(false);
  }
 }
 class truebtn implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
  
   dispose();
   
   new Main_Users(tf1.getText());

  }
 }
 public static void main(String[] args) {
  new Register();
 }
}
 