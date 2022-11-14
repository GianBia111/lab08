package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import it.unibo.mvc.Controller;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller _controller=new Controller();

    public SimpleGUI(){
        JPanel main_panel=new JPanel(new BorderLayout());
        JPanel container=new JPanel();
        JTextArea txt=new JTextArea();
        JButton save=new JButton("Save");

        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                _controller.writeString(txt.getText());
            }
        });

        container.setLayout(new BoxLayout(container, 0));
        container.add(txt);
        container.add(save);
        main_panel.add(container, BorderLayout.NORTH);
        frame.setContentPane(main_panel);


    }

    public void start(){ 
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SimpleGUI gui=new SimpleGUI();
        gui.start();
    }

}
