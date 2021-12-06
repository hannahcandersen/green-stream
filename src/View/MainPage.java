package View;

import javax.swing.*;
import java.awt.*;

public class MainPage extends View {
    private JPanel mainPanel;

    public MainPage(){
        menubarVisible = true;
        // for test
        //String[] genre = new String[1];
        //menubarClass = new Menubar(limeGreen, frame, genre, "Green");
    }

    public void main(){

        mainPanel = new JPanel();
    }
}

