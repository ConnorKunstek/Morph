

//act as overall program driver

/**
 * proposed file/class hierarchy
 *
 * MVC:
 *   C      C       V
 * Morph->Frame->FrameView
 *                  M          C       V
 *             ->FrameModel->Image->ImageView
 *                                      M
 *                                ->ImageModel
 *                             C      V
 *                         ->Grid->GridView
 *                                      M       C       V
 *                               ->GridModel->Point->PointView
 *                                                      M
 *                                                 ->PointModel
 */

/**
 * @Function: ()
 * @Parameters: Type:
 * @Returns: N/A
 * @Description:
 *
 */


public class Morph {

    public Morph(){
        Frame frame = new Frame(10);
    }

    public Morph(String num){
        Frame frame = new Frame(Integer.parseInt(num));
    }

    public static void main(String[] args) {

        if(args.length != 0) {
            Morph M = new Morph(args[0]);
        }else{
            Morph m = new Morph();
        }
    }
}
