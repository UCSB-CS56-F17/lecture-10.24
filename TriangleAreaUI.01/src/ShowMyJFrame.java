import javax.swing.JFrame;

/**
   A main program to show a simple JFrame---similar to the one presented in the
   YouTube video "Java Programming Tutorial-54 GUI with JFrame
   by YouTube user "thenewboston"

   (http://www.youtube.com/watch?v=M1_-sigEPtE)

   This class is similar to the "apple" class in the video.

   @author Youtube user "thenewboston"
   @author Phill Conrad
   @see <a href="http://www.youtube.com/watch?v=M1_-sigEPtE">Youtube Link</a>


 */

public class ShowMyJFrame {
    public static void main(String[] args) {
	MyJFrame mjf = new MyJFrame();
	mjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mjf.setSize(400,400);
	mjf.setVisible(true);
    }
}