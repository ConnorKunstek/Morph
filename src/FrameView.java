/**
 * Connor Kunstek (@ConnorKunstek) and Nick Sladic (@Nickadiemus)
 * CS335 Project 3 - Image Morphing Part 1
 *
 *
 * Take a pre-image, morph into post-image using triangulated mesh overlay
 *
 * to run
 *         $ javac *.class
 *         $ java Morph
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Set;
import javax.imageio.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

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

    public FrameView(GridView pre, GridView post, SettingsView settings){

        super("Morph");

        Container c = getContentPane();

        pre.setOpaque(true);
        pre.setBackground(Color.ORANGE);
        post.setOpaque(true);
        post.setBackground(Color.BLUE);

        this.buildMenu();

        this.setLayout(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();

        //pre
        pre.setPreferredSize(new Dimension(500, 500));
        pre.setMinimumSize(new Dimension(500, 500));
        pre.setMaximumSize(new Dimension(500, 500));

        d.gridx = 0;
        d.gridy = 0;
        d.insets = new Insets(20, 20, 10, 10);
        d.gridwidth = 1;
        d.gridheight = 1;
        d.weightx = 0.5;
        d.weighty = 0.8;

        c.add(pre, d);

        //post
        post.setPreferredSize(new Dimension(500, 500));
        post.setMinimumSize(new Dimension(500, 500));
        post.setMaximumSize(new Dimension(500, 500));

        d.gridx = 1;
        d.gridy = 0;
        d.insets = new Insets(20, 10, 10, 20);
        d.gridwidth = 1;
        d.gridheight = 1;
        d.weightx = 0.5;
        d.weighty = 0.8;

        c.add(post, d);

        //settings
        settings.setPreferredSize(new Dimension(1000, 200));
        settings.setMinimumSize(new Dimension(1000, 200));
        settings.setMaximumSize(new Dimension(1000, 200));

        d.gridx = 0;
        d.gridy = 1;
        d.insets = new Insets(10, 20, 20, 20);
        d.gridwidth = 2;
        d.gridheight = 1;
        d.weightx = 1;
        d.weighty = 0.2;

        c.add(settings, d);

        this.setSize(1060, 760);
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
