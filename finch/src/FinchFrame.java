import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

public class FinchFrame implements KeyListener, MouseInputListener, WindowListener {

    private JFrame frame;
    private JLabel label;
    private Finch finch;

    private int shift = 0;
    private boolean[] directions = new boolean[4]; // up, left, down, right
    private int[] motorSpeed = {0, 0}; //left motor, right motor
    private int driveSpeed = 50; // precent of motor power
    private int turnSpeed = driveSpeed / 2;

    public FinchFrame(Finch finch, int width, int height) {
        this.finch = finch;
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.addKeyListener(this);
        frame.addWindowListener(this);
         

        label = new JLabel();
        label.setBounds(width / 2 - 10, height / 2 - 10, 20, 20);
        label.setBackground(Color.CYAN);
        label.setOpaque(true);

        frame.add(label);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 16:
                shift = 1;
                break;
            case 87:
                directions[0] = true;
                label.setLocation(label.getX(), label.getY() - 10);
                break;
            case 65:
                directions[1] = true;
                label.setLocation(label.getX() - 10, label.getY());
                break;
            case 83:
                directions[2] = true;
                label.setLocation(label.getX(), label.getY() + 10);
                break;
            case 68:
                directions[3] = true;
                label.setLocation(label.getX() + 10, label.getY());
                break;
        }
        if(directions[0] && directions[1]){
            motorSpeed[0] = driveSpeed - turnSpeed;
            motorSpeed[1] = driveSpeed + turnSpeed;
        } else if(directions[0] && directions[3]){
            motorSpeed[0] = driveSpeed + turnSpeed;
            motorSpeed[1] = driveSpeed - turnSpeed;
        } else if(directions[2] && directions[1]){
            motorSpeed[0] = -driveSpeed + turnSpeed;
            motorSpeed[1] = -driveSpeed - turnSpeed;
        } else if(directions[2] && directions[3]){
            motorSpeed[0] = -driveSpeed - turnSpeed;
            motorSpeed[1] = -driveSpeed + turnSpeed;
        } else if(directions[0]){
            motorSpeed[0] = driveSpeed;
            motorSpeed[1] = driveSpeed;
        } else if(directions[1]){
            motorSpeed[0] = -turnSpeed;
            motorSpeed[1] = turnSpeed;
        } else if(directions[2]){
            motorSpeed[0] = -driveSpeed;
            motorSpeed[1] = -driveSpeed;
        } else if(directions[3]){
            motorSpeed[0] = turnSpeed;
            motorSpeed[1] = -turnSpeed;
        }
        System.out.println("Left Speed: " + motorSpeed[0] + " Right Speed: " + motorSpeed[1]);
        finch.setMotors((double) motorSpeed[0], (double) motorSpeed[1]);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // System.out.println("You released key char: " + e.getKeyChar());
        // System.out.println("You released key code: " + e.getKeyCode());
        switch(e.getKeyCode()) {
            case 16:
                shift = 0;
                break;
            case 87:
                directions[0] = false;
                motorSpeed[0] -= driveSpeed;
                motorSpeed[1] -= driveSpeed;
                break;
            case 65:
                directions[1] = false;
                motorSpeed[0] -= -driveSpeed / 2;
                motorSpeed[1] -= driveSpeed / 2;
                break;
            case 83:
                directions[2] = false;
                motorSpeed[0] -= -driveSpeed;
                motorSpeed[1] -= -driveSpeed;
                break;
            case 68:
                directions[3] = false;
                motorSpeed[0] -= driveSpeed / 2;
                motorSpeed[1] -= -driveSpeed / 2;
                break;
        }
        finch.setMotors((double) motorSpeed[0], (double) motorSpeed[1]);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Deactivating 1");
        finch.stopAll();
        finch.disconnect();
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

}