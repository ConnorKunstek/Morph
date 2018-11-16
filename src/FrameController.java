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

    private FrameModel model;
    private FrameView view;

    /**
     * @Function: constructor()
     * @Parameters: dimmension of grid Type: int
     * @Returns: N/A
     * @Description: Creates FrameModel and FrameView
     *
     */

    public FrameController(int dim){

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
        System.out.println("Stopped");
        model.getTimer().stop();
        model.getTimer2().stop();
        for (int row = 0; row < model.getDim(); row++) {
            for (int col = 0; col < model.getDim(); col++) {
                model.getGridPreContoller().getModel().getPoint(row, col).getModel().setX(
                        model.getGridPostContoller().getModel().getPoint(row, col).getModel().getX()
                );
                model.getGridPreContoller().getModel().getPoint(row, col).getModel().setY(
                        model.getGridPostContoller().getModel().getPoint(row, col).getModel().getY()
                );
                model.getGridPreContoller().getModel().getPoint(row, col).getView().repaint();
            }
        }
    }

    public void preview() {

        if (model.getSettingsController().getModel().isPreviewFlag()) {

            model.getSettingsController().getModel().getPreviewBut().setText("Reset Pre-Image");
            model.getSettingsController().getModel().setPreviewFlag(false);

            for (int row = 0; row < model.getDim(); row++) {
                for (int col = 0; col < model.getDim(); col++) {

                    //save old coordinates
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setOldX(
                            model.getGridPreContoller().getModel().getPoint(row, col).getModel().getX()
                    );
                    model.getGridPreContoller().getModel().getPoint(row, col).getModel().setOldY(
                            model.getGridPreContoller().getModel().getPoint(row, col).getModel().getY()
                    );
                }
            }
            model.setFrameCounter(0);
            model.setSecondsCounter(0);
            model.setFramesPerSec(model.getSettingsController().getModel().getFrames() /
                    model.getSettingsController().getModel().getSeconds());
            model.setTimer(new Timer(model.getOneSec()/ model.getFramesPerSec(), this));
            model.setTimer2(new Timer(model.getOneSec(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Seconds Counter: " + model.getSecondsCounter());
                    System.out.println("Seconds to Count: " + model.getSettingsController().getModel().getSeconds());
                    model.setSecondsCounter(model.getSecondsCounter() + 1);
                    if(model.getSecondsCounter() == model.getSettingsController().getModel().getSeconds()) {
                        stopTimers();
                    }
                }
            }));
            model.getTimer().start();
            model.getTimer2().start();
            model.setPreviewed(true);
            model.setPreviewing(false);

        }else{

            model.getSettingsController().getModel().getPreviewBut().setText("Preview");
            model.getSettingsController().getModel().setPreviewFlag(true);

            for (int row = 0; row < model.getDim(); row++) {
                for (int col = 0; col < model.getDim(); col++) {

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
        model.setFrameCounter(model.getFrameCounter()+1);
        System.out.println("Frame Counter: " + model.getFrameCounter());
        for (int row = 0; row < model.getDim(); row++) {
            for (int col = 0; col < model.getDim(); col++) {
                movePoint(row, col, model.getFrameCounter(), model.getFramesPerSec());
                model.getGridPreContoller().getModel().getPoint(row, col).getView().repaint();
            }
        }
    }
}
