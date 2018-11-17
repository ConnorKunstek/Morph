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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Class: FrameController()
 * @Description: Creates program
 */

public class FrameController implements ActionListener {

    private FrameModel model;
    private FrameView view;

    private Timer timer, timer2;

    int frames, framesPerSec, seconds, secondsCounter, framesCounter, dim;

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
                model.getGridPreController().getView(),
                model.getGridPostController().getView(),
                model.getSettingsController().getView()
        );

        model.getSettingsController().getModel().getPreviewBut().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preview();
            }
        });

        model.getSettingsController().getModel().getFramesSli().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setFrames(model.getSettingsController().getModel().getFrames());
            }
        });

        model.getSettingsController().getModel().getSecondsSli().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setSeconds(model.getSettingsController().getModel().getSeconds());
            }
        });

    }

    public void stopTimers(boolean flag){
        System.out.println("Stopped");
        model.getSettingsController().getModel().getPreviewBut().setEnabled(true);
        if(flag) {
            timer.stop();
            timer2.stop();
        }
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                model.getGridPreController().getModel().getPoint(row, col).getModel().setX(
                        model.getGridPostController().getModel().getPoint(row, col).getModel().getX()
                );
                model.getGridPreController().getModel().getPoint(row, col).getModel().setY(
                        model.getGridPostController().getModel().getPoint(row, col).getModel().getY()
                );
                model.getGridPreController().getModel().getPoint(row, col).getView().repaint();
            }
        }
    }

    public void preview() {

        if (model.getSettingsController().getModel().isPreviewFlag()) {

            model.getSettingsController().getModel().getPreviewBut().setText("Reset Pre-Image");
            model.getSettingsController().getModel().setPreviewFlag(false);
            model.getSettingsController().getModel().getPreviewBut().setEnabled(false);

            dim = model.getDim();
            frames = model.getFrames();
            seconds = model.getSeconds();

            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {

                    //save old coordinates
                    model.getGridPreController().getModel().getPoint(row, col).getModel().setOldX(
                            model.getGridPreController().getModel().getPoint(row, col).getModel().getX()
                    );
                    model.getGridPreController().getModel().getPoint(row, col).getModel().setOldY(
                            model.getGridPreController().getModel().getPoint(row, col).getModel().getY()
                    );
                }
            }

            framesCounter = 0;
            secondsCounter = 0;
            if(seconds == 0) {
                stopTimers(false);
            }else {
                framesPerSec = frames / seconds;
                timer = new Timer(model.getOneSec() / framesPerSec, this);
                timer2 = new Timer(model.getOneSec(), new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
//                        System.out.println("Seconds Counter: " + model.getSecondsCounter());
//                        System.out.println("Seconds to Count: " + model.getSettingsController().getModel().getSeconds());
                        if (secondsCounter == seconds) {
                            stopTimers(true);
                        }
                        secondsCounter++;
                    }
                });
                timer.start();
                timer2.start();
            }
        }else{

            model.getSettingsController().getModel().getPreviewBut().setText("Preview");
            model.getSettingsController().getModel().setPreviewFlag(true);

            for (int row = 0; row < dim; row++) {
                for (int col = 0; col < dim; col++) {

                    //reset to old coordinates
                    model.getGridPreController().getModel().getPoint(row, col).getModel().setX(
                            model.getGridPreController().getModel().getPoint(row, col).getModel().getOldX()
                    );
                    model.getGridPreController().getModel().getPoint(row, col).getModel().setY(
                            model.getGridPreController().getModel().getPoint(row, col).getModel().getOldY()
                    );
                }
            }
            model.getGridPreController().getView().repaint();
        }


    }

    public void movePoint(int row, int col, int frameCounter, int frames){

        int preX = model.getGridPreController().getModel().getPoint(row, col).getModel().getOldX();
        int preY = model.getGridPreController().getModel().getPoint(row, col).getModel().getOldY();

        int postX = model.getGridPostController().getModel().getPoint(row, col).getModel().getX();
        int postY = model.getGridPostController().getModel().getPoint(row, col).getModel().getY();

        int xd = postX - preX;
        int yd = postY - preY;

        int xb = xd/frames;
        int yb = yd/frames;

        model.getGridPreController().getModel().getPoint(row, col).getModel().setX(preX + (xb * frameCounter));
        model.getGridPreController().getModel().getPoint(row, col).getModel().setY(preY + (yb * frameCounter));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        framesCounter++;
        System.out.println("Frame Counter: " + model.getFrameCounter());
        for (int row = 0; row < dim; row++) {
            for (int col = 0; col < dim; col++) {
                movePoint(row, col, framesCounter, frames);
                //model.getGridPreController().getModel().getPoint(row, col).getView().repaint();
            }
        }
        model.getGridPreController().getView().repaint();
    }

}
