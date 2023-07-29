//package SimpleClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class SimpleClock extends JFrame implements ActionListener {
    
        Calendar calendar;
        SimpleDateFormat timeFormat;
        SimpleDateFormat dayFormat;
        SimpleDateFormat dateFormat;
    
        JLabel timeLabel;
        JLabel dayLabel;
        JLabel dateLabel;
        JButton militaryTime;
        ActionListener listener;
        String time;
        String day;
        String date;


        SimpleClock() {
            militaryTime = new JButton("12 / 24");
            militaryTime.setBounds(100, 50, 50, 25);
            militaryTime.addActionListener(this);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("Digital Clock");
            this.setLayout(new FlowLayout());
            this.setSize(400, 250);
            this.setResizable(false);
    
            timeFormat = new SimpleDateFormat("hh:mm:ss a");
            dayFormat=new SimpleDateFormat("EEEE");
            dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
            timeLabel = new JLabel();
            timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
            timeLabel.setBackground(Color.BLACK);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setOpaque(true);
            dayLabel=new JLabel();
            dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
            dateLabel=new JLabel();
            dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));
    
    
            this.add(timeLabel);
            this.add(dayLabel);
            this.add(dateLabel);
            this.setVisible(true);
            this.add(militaryTime);

    
            setTimer();
        }
    
        public void setTimer() {
            while (Thread.currentThread().isAlive()) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time);
    
                day = dayFormat.format(Calendar.getInstance().getTime());
                dayLabel.setText(day);
    
                date = dateFormat.format(Calendar.getInstance().getTime());
                dateLabel.setText(date);
    
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new SimpleClock();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == militaryTime) {
                if (this.timeFormat.toPattern() == "hh:mm:ss a" ) {
                    this.timeFormat.applyPattern("HH:mm:ss a");
                } else if (this.timeFormat.toPattern() == "HH:mm:ss a" ) {
                    this.timeFormat.applyPattern("hh:mm:ss a");
                }
            }
    }
}
