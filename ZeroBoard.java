package BC_1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ZeroBoard extends JFrame implements WindowListener{

 private JPanel contentPane;
 private JPanel panel;
 private Button wribtn;
 private Button delbtn;
 private Button clobtn;
 private TextField txtcon;
 private TextField txtpw;
 
 
 
 
 private List list_n;
 public ZeroBoard() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 20, 700, 700);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(255, 255, 204));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);
  
  panel = new JPanel();
  panel.setBackground(new Color(250, 128, 114));
  panel.setForeground(Color.WHITE);
  panel.setBounds(0, 0, 684, 56);
  contentPane.add(panel);
  panel.setLayout(null);
  
  Label label = new Label("노트");
  label.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
  label.setBounds(10, 10, 249, 36);
  panel.add(label);
  
  delbtn = new Button("삭제");
  delbtn.setBackground(new Color(147, 112, 219));
  delbtn.setBounds(10, 608, 125, 43);
  contentPane.add(delbtn);
  delbtn.addActionListener(new btnact());
  
  clobtn = new Button("닫기");
  clobtn.setBackground(new Color(255, 215, 0));
  clobtn.setBounds(549, 608, 125, 43);
  contentPane.add(clobtn);
  clobtn.addActionListener(new btnact());
  
  list_n = new List();
  list_n.setBounds(10, 63, 664, 384);
  contentPane.add(list_n);
  
  Panel panel_1 = new Panel();
  panel_1.setBackground(new Color(224, 255, 255));
  panel_1.setBounds(10, 453, 664, 147);
  contentPane.add(panel_1);
  panel_1.setLayout(null);
  
  txtcon = new TextField();
  txtcon.setBounds(125, 10, 509, 23);
  panel_1.add(txtcon);
  
  txtpw = new TextField();
  txtpw.setBounds(125, 66, 174, 23);
  txtpw.setEchoChar('*');
  panel_1.add(txtpw);
  
  Label label_1 = new Label("내용");
  label_1.setBounds(10, 10, 69, 23);
  panel_1.add(label_1);
  
  Label label_2 = new Label("비밀번호");
  label_2.setBounds(10, 66, 69, 23);
  panel_1.add(label_2);
  
  wribtn = new Button("작성");
  wribtn.setBounds(529, 94, 125, 43);
  panel_1.add(wribtn);
  wribtn.setBackground(new Color(147, 112, 219));
  wribtn.addActionListener(new btnact());
  
  
  this.addWindowListener(this);
  setVisible(true);
 }

 class btnact implements ActionListener
 {
  Dialog d1 = new Dialog(ZeroBoard.this, "비밀번호를입력해주세요", true);
  Label lblwn = new Label();
  TextField intxtpw = new TextField();
  Button cnfbtn = new Button();
  
  TextField textField = new TextField();
  
  @Override
  public void actionPerformed(ActionEvent e) {
   // TODO Auto-generated method stub
   if(e.getSource()==wribtn)
   {
    String title = txtcon.getText();
    String passw = txtpw.getText();
    if (title == null || title.trim().length() == 0
     ||passw == null || passw.trim().length() == 0
      ) {
      return;
     }
    title = title.trim();
    passw = passw.trim();
    File dir = new File("Noteinfo");
    if (!dir.exists()) {
     dir.mkdir();
    }
    File file = new File(dir, title);
    
    try {
     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
     
     out.println(txtpw.getText().trim());
     out.println(txtcon.getText().trim());
     out.close();
    } catch (IOException ee) {
    }
       
      txtcon.setText("");
      txtpw.setText("");
    dispose();
    setVisible(true);
    
   }
   else if(e.getSource()==delbtn)
   {
    
    
    d1.setBounds(400,20,200,200);
    d1.setLayout(null);
    
    Panel panel = new Panel();
    panel.setBackground(new Color(255, 102, 102));
    panel.setBounds(10, 30, 184, 47);
    d1.add(panel);
    panel.setLayout(null);
    
    Label label = new Label("비밀번호를 쓰세요");
    label.setFont(new Font("새굴림", Font.BOLD, 15));
    label.setBounds(10, 10, 164, 27);
    panel.add(label);
    
    textField = new TextField();
    textField.setBounds(10, 88, 164, 39);
    textField.setEchoChar('*');
    d1.add(textField);
    
    Button button = new Button("확인");
    button.setBounds(10, 133, 164, 40);
    d1.add(button);
    button.addActionListener(new ActionListener() {
     
     @Override
     public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      String data = list_n.getSelectedItem();
      String inputpass = textField.getText();
      data = data.substring(data.indexOf(":") + 1).trim();
      File dir = new File("Noteinfo");
      File file = new File(dir, data);
      String password = "";
      
      try {
       BufferedReader in = new BufferedReader(new FileReader(file));
       password = in.readLine();
       
       in.close();
      } catch (IOException ee) {  
      }
      
      if(inputpass.equals(password)){
       
       
       data = data.substring(data.indexOf(":") + 1).trim();
        dir = new File("Noteinfo");
       file = new File(dir, data);
          file.delete();
        
          JOptionPane.showMessageDialog(null,"삭제완료","삭제완료",JOptionPane.INFORMATION_MESSAGE);
          
          d1.dispose();
          textField.setText("");
      }
      else if(!inputpass.equals(password)){
       
       JOptionPane.showMessageDialog(null,"비밀번호 오류","비밀번호오류",JOptionPane.ERROR_MESSAGE);
       textField.setText("");
      }
      
     
      
          
           
          
           
     }
     
    });
    textField.setText("");
    d1.addWindowListener(new Close_c());
    d1.setVisible(true);
    
   
        
         
         
   }
   else if(e.getSource()==clobtn)
   {
    d1.dispose();
   }
   
   
   
   
   
  }
 }
 @Override
 public void windowActivated(WindowEvent e) {
  // TODO Auto-generated method stub
  if (e.getSource() == this) {
   File dir = new File("Noteinfo");
   String[] list = dir.list();
   list_n.clear();
   if (list != null) {
    for (int i = 0; i < list.length; i++) {
     list_n.add(i + 1 + " : " + list[i]);
    }
   }
  }
 }@Override
 public void windowClosed(WindowEvent e) {
  // TODO Auto-generated method stub
  
 }@Override
 public void windowClosing(WindowEvent e) {
  // TODO Auto-generated method stub
  
 }@Override
 public void windowDeactivated(WindowEvent e) {
  // TODO Auto-generated method stub
  
 }@Override
 public void windowDeiconified(WindowEvent e) {
  // TODO Auto-generated method stub
  
 }@Override
 public void windowIconified(WindowEvent e) {
  // TODO Auto-generated method stub
  
 }@Override
 public void windowOpened(WindowEvent e) {
  // TODO Auto-generated method stub
  
 }
  
 
 public static void main(String[] args) {
  
  new ZeroBoard();
 }
} 