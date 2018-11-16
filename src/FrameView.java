
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;

/**
 * @Class: FrameView()
 * @Description: Creates JFrame
 */

public class FrameView extends JFrame {


    /**
     * @Function: constructor()
     * @Parameters: pre and post grids Type: GridController(s)
     * @Returns: N/A
     * @Description:
     *
     */

    public FrameView(GridView pre, GridView post){

        super("Morph");
        Container c = getContentPane();
        this.setLayout(new GridLayout(1,2));
        pre.setOpaque(true);
        pre.setBackground(Color.BLUE);
        post.setOpaque(true);
        post.setBackground(Color.ORANGE);
        this.buildMenu();
        post.setMaximumSize(new Dimension(500, 500));
        pre.setMaximumSize(new Dimension(500, 500));
        c.add(post);
        c.add(pre);
        this.setSize(1000, 500);
        this.setVisible(true);
    }


    /**
     * @Function: ()
     * @Parameters: Type:
     * @Returns: N/A
     * @Description:
     *
     */

    public void buildMenu(){

        final JFileChooser fc = new JFileChooser(".");
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar (bar);
        JMenu fileMenu = new JMenu ("File");
        JMenuItem fileopenPre = new JMenuItem ("Open PreImage");
        JMenuItem fileopenPost = new JMenuItem ("Open PreImage");
        JMenuItem fileexit = new JMenuItem ("Exit");

        fileopenPre.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e) {
                        //need to add file path
//                        int returnVal = fc.showOpenDialog(this.image);
//                        if (returnVal == JFileChooser.APPROVE_OPTION) {
//                            File file = fc.getSelectedFile();
//                            try {
//                                image = ImageIO.read(file);
//                            } catch (IOException e1){};
//
//                            view.setImage(image);
//                            view.showImage();
//                        }
                    }
                });

        fileopenPost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //need to add file path
//                        int returnVal = fc.showOpenDialog(this.image);
//                        if (returnVal == JFileChooser.APPROVE_OPTION) {
//                            File file = fc.getSelectedFile();
//                            try {
//                                image = ImageIO.read(file);
//                            } catch (IOException e1){};
//
//                            view.setImage(image);
//                            view.showImage();
//                        }
            }

        });
        fileexit.addActionListener(
                new ActionListener () {
                    public void actionPerformed (ActionEvent e) {
                        System.exit(0);
                    }
                }
        );

        fileMenu.add(fileopenPre);
        fileMenu.add(fileopenPost);
        fileMenu.add(fileexit);
        bar.add(fileMenu);
    }


    /**
     * @Function: ()
     * @Parameters: Type:
     * @Returns: N/A
     * @Description:
     *
     */
    public void setupMenu(){}

}
