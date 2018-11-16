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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class FrameController implements ActionListener {

    public final static int ONE_SECOND = 1000;

    private FrameModel model;
    private FrameView view;
    private int dim, framesPerSec, secondsCounter, frameCounter;

    private boolean previewing, previewed;

    private Timer timer, timer2;

    /**
     * @Function: constructor()
     * @Parameters: dimmension of grid Type: int
     * @Returns: N/A
     * @Description: Creates FrameModel and FrameView
     *
     */

    public FrameController(int dim){

        setDim(dim);

        model = new FrameModel(dim);
        view = new FrameView(
                model.getGridPreContoller().getView(),
                model.getGridPostContoller().getView(),
                model.getSettingsController().getView()
        );

        model.getSettingsController().getModel().getPreviewBut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preview();
            }
        });

//        FrameView view = new FrameView(model.getGrid().getView(), model.getImage().getView());
//        FrameView view = new FrameView(model.getGrid().getView());
//        FrameView view = new FrameView(model.getImageController().getView());

    }

    public void stopTimers(){
        timer.stop();
        timer2.stop();
    }

    public void preview() {

        if (model.getSettingsController().getModel().isPreviewFlag()) {

            model.getSettingsController().getModel().getPreviewBut().setText("Reset Pre-Image");
            model.getSettingsController().getModel().setPreviewFlag(false);

            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {

                    //save old coordinates
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setOldX(
                            model.getGridPreContoller().getModel().getPoint(row, col).getModel().getX()
                    );
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setOldY(
                            model.getGridPreContoller().getModel().getPoint(row, col).getModel().getY()
                    );
                }
            }
            frameCounter = 0;
            secondsCounter = 0;
            framesPerSec = model.getSettingsController().getModel().getFrames() /
                    model.getSettingsController().getModel().getSpeed();
            timer = new Timer(ONE_SECOND/ framesPerSec, this);
            timer2 = new Timer(ONE_SECOND, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Secs: " + secondsCounter);
                    secondsCounter++;
                    if(secondsCounter == model.getSettingsController().getModel().getSpeed()) {
                        stopTimers();
                    }
                }
            });
            timer.start();
            timer2.start();
//            while(true){
//                if(secondsCounter == model.getSettingsController().getModel().getSpeed()){
//                    timer.stop();
//                    timer2.stop();
//                    break;
//                }
//            }
            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setX(
                            model.getGridPostContoller().getModel().getPoint(row, col).getModel().getX()
                    );
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setY(
                            model.getGridPostContoller().getModel().getPoint(row, col).getModel().getY()
                    );
                    model.getGridPreContoller().getModel().getPoint(row, col).getView().repaint();
                }
            }

        }else{

            model.getSettingsController().getModel().getPreviewBut().setText("Preview");
            model.getSettingsController().getModel().setPreviewFlag(true);

            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {

                    //reset to old coordinates
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setX(
                            model.getGridPreContoller().getModel().getPoint(row, col).getModel().getOldX()
                    );
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setY(
                            model.getGridPreContoller().getModel().getPoint(row, col).getModel().getOldY()
                    );
                }
            }
        }

        model.getGridPreContoller().getView().repaint();
    }

    public void movePoint(int row, int col, int frameCounter, int framesPerSec){

        int preX = model.getGridPreContoller().getModel().getPoint(row, col).getModel().getOldX();
        int preY = model.getGridPreContoller().getModel().getPoint(row, col).getModel().getOldY();

        int postX = model.getGridPostContoller().getModel().getPoint(row, col).getModel().getX();
        int postY = model.getGridPostContoller().getModel().getPoint(row, col).getModel().getY();

        int xd = postX - preX;
        int yd = postY - preY;

        int xb = xd/framesPerSec;
        int yb = yd/framesPerSec;

        model.getGridPreContoller().getModel().getPoint(row, col).getModel().setX(preX + (xb * frameCounter));
        model.getGridPreContoller().getModel().getPoint(row, col).getModel().setY(preY + (yb * frameCounter));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        frameCounter++;
        System.out.println(frameCounter);
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                movePoint(row, col, frameCounter, framesPerSec);
                model.getGridPreContoller().getModel().getPoint(row, col).getView().repaint();
            }
        }
    }

    public void setDim(int dim) {
        this.dim = dim;
    }

    public int getDim() {
        return dim;
    }
}
