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

//        this.setLayout(new GridLayout(1,2, 10, 10));
        this.setLayout(new GridLayout(1,3));

//        this.setLayout(new GridBagLayout());
//        this.setLayout(new FlowLayout());
//        GridBagConstraints d = new GridBagConstraints();

        pre.setOpaque(true);
        pre.setBackground(Color.ORANGE);
        post.setOpaque(true);
        post.setBackground(Color.BLUE);

        this.buildMenu();
        post.setMaximumSize(new Dimension(500, 500));
        pre.setMaximumSize(new Dimension(500, 500));
<<<<<<< HEAD

//        c.add(pre);
//        c.add(post);
//        this.setSize(1000, 500);

        settings.setMaximumSize(new Dimension(100, 500));

=======
        settings.setMaximumSize(new Dimension(200, 500));
>>>>>>> 1c2f0406c01dd0d9645b240b8f7971c8b234aa0b
        Border border = settings.getBorder();
        Border margin = new EmptyBorder(100,100,100,100);
        settings.setBorder(new CompoundBorder(border,margin));

        c.add(post);
        c.add(pre);
        c.add(settings);
<<<<<<< HEAD

        this.setSize(1500, 550);
=======
        this.setSize(1450, 500);
>>>>>>> 1c2f0406c01dd0d9645b240b8f7971c8b234aa0b
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
