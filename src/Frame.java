import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame implements ActionListener {

    public Frame(){
        FrameModel model = new FrameModel();
        FrameView view = new FrameView();
    }

    public void actionPerformed(ActionEvent e){}
}
