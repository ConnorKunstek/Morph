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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class FrameController extends JFrame implements ActionListener {


    private JMenuBar jMenuBar;
    private JMenu menu;
    private JMenuItem choosePre, choosePost;
    private JMenuItem _5, _10, _20;
    private FileNameExtensionFilter fileFilter;

    private boolean move;
    private int dim;
    private int[] point;
    private Polygon border;
    private Container c;
    private JFileChooser preFileChooser;
    private JFileChooser postFileChooser;
    private GridController preGridController;
    private GridController postGridController;
    private GridController morphGridController;
    private SettingsController settingsController;


//    private float li = 1, ri = 1;

    public FrameController(int dim){

        super("Morph");
        this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});


        this.setSettingsController(new SettingsController(false));
        this.setC(new Container());

        c = getContentPane();

        this.menu();

        init(dim);
    }


    public void init(int dim){

        this.setDim(dim);
        this.setPreGridController(new GridController(dim));
        this.setPostGridController(new GridController(dim));
        this.setMorphGridController(new GridController(dim));

        getPreGridController().setOpaque(true);
        getPreGridController().setBackground(Color.ORANGE);
        getPostGridController().setOpaque(true);
        getPostGridController().setBackground(Color.BLUE);


        this.setLayout(new GridBagLayout());
        GridBagConstraints d = new GridBagConstraints();

        //pre
        getPreGridController().setPreferredSize(new Dimension(500, 500));
        getPreGridController().setMinimumSize(new Dimension(500, 500));
        getPreGridController().setMaximumSize(new Dimension(500, 500));

        d.gridx = 0;
        d.gridy = 0;
        d.insets = new Insets(20, 20, 10, 10);
        d.gridwidth = 1;
        d.gridheight = 1;
        d.weightx = 0.5;
        d.weighty = 0.8;

        getC().add(getPreGridController(), d);

        //post
        getPostGridController().setPreferredSize(new Dimension(500, 500));
        getPostGridController().setMinimumSize(new Dimension(500, 500));
        getPostGridController().setMaximumSize(new Dimension(500, 500));

        d.gridx = 1;
        d.gridy = 0;
        d.insets = new Insets(20, 10, 10, 20);
        d.gridwidth = 1;
        d.gridheight = 1;
        d.weightx = 0.5;
        d.weighty = 0.8;

        getC().add(getPostGridController(), d);

        //settings
        getSettingsController().setPreferredSize(new Dimension(1000, 200));
        getSettingsController().setMinimumSize(new Dimension(1000, 200));
        getSettingsController().setMaximumSize(new Dimension(1000, 200));

        getSettingsController().getPreSlider().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                settingsController.setPreInt(settingsController.getPreSlider().getValue());
                getPreGridController().changeIntensity((float)settingsController.getPreInt());
            }
        });

        getSettingsController().getPostSlider().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                settingsController.setPostInt(settingsController.getPostSlider().getValue());
                getPostGridController().changeIntensity((float)settingsController.getPostInt());
            }
        });

        d.gridx = 0;
        d.gridy = 1;
        d.insets = new Insets(10, 20, 20, 20);
        d.gridwidth = 2;
        d.gridheight = 1;
        d.weightx = 1;
        d.weighty = 0.2;

        getC().add(getSettingsController(), d);

        this.setSize(1060, 760);
        this.setVisible(true);

        createMouseListeners();
    }

    private void menu(){

        setPreFileChooser(new JFileChooser());
        setPostFileChooser(new JFileChooser());

        setFileFilter(new FileNameExtensionFilter("JPG", "jpeg", "jpg"));
        getPreFileChooser().setFileFilter(getFileFilter());
        getPostFileChooser().setFileFilter(getFileFilter());

        setJMenuBar(new JMenuBar());
        setMenu(new JMenu("Options"));

        setChoosePre(new JMenuItem("Select Pre-Image"));
        getChoosePre().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int temp = getPreFileChooser().showOpenDialog(null);
                if(temp == JFileChooser.APPROVE_OPTION) {
                    getPreGridController().getImage(getPreFileChooser().getSelectedFile().getPath());
                }
            }
        });

        setChoosePost(new JMenuItem("Select Post-Image"));
        getChoosePost().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int returnVal = getPostFileChooser().showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    getPostGridController().getImage(getPostFileChooser().getSelectedFile().getPath());
                }
            }
        });

        getSettingsController().getStartBut().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        getSettingsController().getPreviewBut().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                preview();
            }
        });

        set_5(new JMenuItem("5x5"));

        get_5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getC().removeAll();
                init(5);
            }
        });

        set_10(new JMenuItem("10x10"));

        get_10().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getC().removeAll();
                init(10);
            }
        });

        set_20(new JMenuItem("20x20"));

        get_20().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getC().removeAll();
                init(20);
            }
        });

        getMenu().add(getChoosePre());
        getMenu().add(getChoosePost());
        getMenu().add(get_5());
        getMenu().add(get_10());
        getMenu().add(get_20());
        getJMenuBar().add(getMenu());

        super.setJMenuBar(getJMenuBar());
    }

    public void preview(){

    }

    public void start(){
        setMorphGridController(new GridController(getDim()));

        getMorphGridController().setImages(getPreFileChooser().getSelectedFile().getPath(), getPostFileChooser().getSelectedFile().getPath());
        getMorphGridController().createAnimation(getPreGridController(), getPostGridController(), false);

        JFrame animateFrame = new JFrame("Morphing");

        animateFrame.add(getMorphGridController());
        animateFrame.setSize(getMorphGridController().pre.getWidth() + 20, getMorphGridController().pre.getHeight() + 20);
        animateFrame.setVisible(true);
    }

    public void createMouseListeners() {

        getPreGridController().addMouseListener(new MouseListener(){
            public void mouseExited(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseReleased(MouseEvent e){
                if(getPoint() != null) {
                    getPreGridController().updatePolygons();
                    getPostGridController().p[getPoint()[0]][getPoint()[1]].getModel().setColor(Color.BLACK);
                    getPostGridController().repaint();
                }
                setMove(false);
                setPoint(null);
            }

            public void mousePressed(MouseEvent e){
                setPoint(getPreGridController().getCurrentPoint(e.getPoint()));
                if(getPoint() != null) {
                    setMove(true);
                    setBorder(getPreGridController().createPolygon(getPoint()[0], getPoint()[1]));
                    getPostGridController().p[getPoint()[0]][getPoint()[1]].getModel().setColor(Color.RED);
                    getPostGridController().revalidate();
                    getPostGridController().repaint();
                }
            }
            public void mouseClicked(MouseEvent e){}
        });

        getPreGridController().addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                if(isMove() && getBorder().contains(e.getPoint())){
                    getPreGridController().p[getPoint()[0]][getPoint()[1]] = new PointController(e.getX(), e.getY());
                    getPostGridController().p[getPoint()[0]][getPoint()[1]].getModel().setColor(Color.RED);
                    getPreGridController().repaint();
                    getPostGridController().repaint();
                }
            }

            public void mouseMoved(MouseEvent e) { }
        });
    }

    public void actionPerformed(ActionEvent e){}

    public GridController getPreGridController() {return preGridController;}
    public void setPreGridController(GridController preGridController) { this.preGridController = preGridController; }

    public GridController getPostGridController() {
        return postGridController;
    }
    public void setPostGridController(GridController postGridController) { this.postGridController = postGridController; }

    public GridController getMorphGridController() {
        return morphGridController;
    }
    public void setMorphGridController(GridController morphGridController) { this.morphGridController = morphGridController; }

    public SettingsController getSettingsController() { return settingsController; }
    public void setSettingsController(SettingsController settingsController) { this.settingsController = settingsController; }

    public Container getC(){return c;}
    public void setC(Container c){this.c = c;}

    public int[] getPoint(){return point;}
    public void setPoint(int[] point){this.point = point;}

    public Polygon getBorder() { return border; }
    public void setBorder(Polygon border) { this.border = border; }

    public int getDim() { return dim; }
    public void setDim(int dim) { this.dim = dim; }

    public boolean isMove() { return move; }
    public void setMove(boolean move) { this.move = move; }

    public JFileChooser getPreFileChooser() { return preFileChooser; }
    public void setPreFileChooser(JFileChooser preFileChooser) { this.preFileChooser = preFileChooser; }

    public JFileChooser getPostFileChooser() { return postFileChooser; }
    public void setPostFileChooser(JFileChooser postFileChooser) { this.postFileChooser = postFileChooser; }

    public JMenuBar getJMenuBar() { return jMenuBar; }
    public void setJMenuBar(JMenuBar jMenuBar) { this.jMenuBar = jMenuBar; }

    public JMenu getMenu() { return menu; }
    public void setMenu(JMenu menu) { this.menu = menu; }

    public JMenuItem getChoosePre() { return choosePre; }
    public void setChoosePre(JMenuItem choosePre) { this.choosePre = choosePre; }

    public JMenuItem getChoosePost() { return choosePost; }
    public void setChoosePost(JMenuItem choosePost) { this.choosePost = choosePost; }

    public JMenuItem get_5() { return _5;}
    public void set_5(JMenuItem _5) { this._5 = _5; }

    public JMenuItem get_10() { return _10; }
    public void set_10(JMenuItem _10) { this._10 = _10; }

    public JMenuItem get_20() { return _20; }
    public void set_20(JMenuItem _20) { this._20 = _20; }

    public FileNameExtensionFilter getFileFilter() { return fileFilter; }
    public void setFileFilter(FileNameExtensionFilter fileFilter) { this.fileFilter = fileFilter; }
}
