package bruh;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class Main{
    public static void main(String [] args){
    JFrame f = new JFrame();
    panel p = new panel();
    f.setSize(360, 640);
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    f.add(p);
    f.setVisible(true);
    f.setResizable(false);
    f.setLocationRelativeTo(null);
    }
}
class panel extends JPanel{
    api a = new api();
    JTextField f = new JTextField();
    JButton b = new JButton();
    JPanel resultPanel = new JPanel();
    static String city;
    panel(){
        this.setPreferredSize(new Dimension(360,640));
        this.setBackground(Color.gray);
        setLayout(null);
        f.setBounds(15,15,250,50);
        f.setFont(new Font("Dialog", Font.PLAIN, 24));
        b.setBounds(270, 15, 50, 50); 
        b.setBackground(Color.white);
        b.addActionListener(e-> button());
        resultPanel.setBounds(15, 80, 230, 400);
        resultPanel.setBackground(Color.lightGray);
        resultPanel.setLayout(new GridLayout(8, 1));

        add(b);
        add(f);
        add(resultPanel);
    }
    void button(){
        city=f.getText();
        a.get(city);
        a.nigg();
        resultPanel.add(new JLabel("City: " + a.name + " (" + a.country + ")"));
        resultPanel.add(new JLabel("Temperature: " + a.temp + "°C"));
        resultPanel.add(new JLabel("Min Temp: " + a.tempMin + "°C"));
        resultPanel.add(new JLabel("Weather: " + a.main + " - " + a.description));
        resultPanel.add(new JLabel("Humidity: " + a.humidity + "%"));
        resultPanel.add(new JLabel("Sea Level: " + (a.seaLevel != -1 ? a.seaLevel + " hPa" : "N/A")));
        resultPanel.add(new JLabel("Wind Speed: " + a.speed + " m/s"));
        resultPanel.add(new JLabel("Wind Direction: " + a.deg + "°"));
        resultPanel.revalidate();
        resultPanel.repaint();
    }
}